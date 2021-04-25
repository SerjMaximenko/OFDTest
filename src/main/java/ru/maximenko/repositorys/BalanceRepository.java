package ru.maximenko.repositorys;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.maximenko.entity.Balance;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class BalanceRepository {


    private final JdbcTemplate jdbcTemplate;

    public List<Balance> findUserBalances(Long userId){

        return new ArrayList<>(jdbcTemplate.query(
                "SELECT id, user_id, balance_type, balance, changed FROM balances WHERE user_id = ?", new Object[]{userId},
                (rs, rowNum) -> new Balance(rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getString("balance_type"),
                        rs.getLong("balance"),
                        rs.getObject("changed", LocalDateTime.class))));
    }

    public void save(Balance balance){
        jdbcTemplate.update("INSERT INTO balances(user_id, balance, balance_type, changed) VALUES (?, ?, ?, ?)",
                balance.getUserId(), balance.getBalance(), balance.getBalanceType(), balance.getChanged());
    }

}
