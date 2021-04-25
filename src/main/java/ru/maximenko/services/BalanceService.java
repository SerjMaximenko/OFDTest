package ru.maximenko.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.maximenko.entity.Balance;
import ru.maximenko.entity.User;
import ru.maximenko.repositorys.BalanceRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class BalanceService {

    private final BalanceRepository balanceRepository;

    private final UserService userService;

    public List<Balance> findUserBalances(){

        User user = userService.getCurrentUser();

        if (user != null)
            return balanceRepository.findUserBalances(user.getId())
                    .stream()
                    .filter(o -> o.getBalanceType().equals("Fixed"))
                    .sorted((o1, o2) -> o2.getBalance().compareTo(o1.getBalance()))
                    .limit(5)
                    .collect(Collectors.toList());
        else return null;
    }

    public void saveBalance(Balance balance){

        LocalDateTime changedTime = LocalDateTime.now();
        log.info(changedTime.toString());
        balance.setChanged(changedTime);

        balance.setUserId(userService.getCurrentUser().getId());

        balanceRepository.save(balance);
    }

}
