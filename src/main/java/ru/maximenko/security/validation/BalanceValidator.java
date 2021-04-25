package ru.maximenko.security.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.maximenko.dtos.UserDto;
import ru.maximenko.entity.Balance;

@Component
public class BalanceValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return UserDto.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Balance balance = (Balance) o;

        if (balance.getBalance() == null || balance.getBalance()<0 || balance.getBalance() > 2_147_483_647) {
            errors.rejectValue("balance", "Incorrect.balance.balance");
        }

        if (balance.getBalanceType() == null || (!balance.getBalanceType().equals("Free") & !balance.getBalanceType().equals("Fixed"))) {
            errors.rejectValue("balanceType", "Incorrect.balance.typeBalance");
        }

    }
}