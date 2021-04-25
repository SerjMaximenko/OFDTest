package ru.maximenko.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.maximenko.entity.User;
import ru.maximenko.services.UserService;

@Slf4j
@Service
@ComponentScan("ru.maximenko")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) {

        User user = userService.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(username);
        } else {
            log.info("User = " + user.toString());
        }

        return new MyUserPrincipal(user);
    }

}
