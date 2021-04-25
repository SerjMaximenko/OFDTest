package ru.maximenko.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.maximenko.dtos.UserDto;
import ru.maximenko.dtos.mappers.UserMapper;
import ru.maximenko.entity.Balance;
import ru.maximenko.security.validation.BalanceValidator;
import ru.maximenko.security.validation.UserValidator;
import ru.maximenko.services.BalanceService;
import ru.maximenko.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MainController {

    private final UserService userService;
    private final BalanceService balanceService;
    private final UserValidator userValidator;
    private final BalanceValidator balanceValidator;
    private final UserMapper userMapper;

    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String homePage() {
        return "homePage";
    }


    @RequestMapping(value = { "/balance" }, method = RequestMethod.GET)
    public String balacePage(Model model) {

        model.addAttribute("balanceAdd", new Balance());
        List<Balance> balances = balanceService.findUserBalances();
        model.addAttribute("username", userService.getCurrentUser().getUsername());
        model.addAttribute("objects", balances);

        return "balacePage";
    }

    @RequestMapping(value = { "/balance" }, method = RequestMethod.POST)
    public String balacePage(@ModelAttribute("balanceAdd") Balance balanceAdd, BindingResult bindingResult, Model model) {
        balanceValidator.validate(balanceAdd, bindingResult);

        if (bindingResult.hasErrors()) {
            List<Balance> balances = balanceService.findUserBalances();
            model.addAttribute("username", userService.getCurrentUser().getUsername());
            model.addAttribute("objects", balances);
            log.info("error");
            return "balacePage";
        }

        balanceService.saveBalance(balanceAdd);

        return "redirect:/balance";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new UserDto());
        return "registrationPage";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") UserDto userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            log.info("error");
            return "registrationPage";
        }

        userService.saveUser(userMapper.toEntity(userForm));
        return "redirect:/balance";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }
        return "loginPage";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }

}

