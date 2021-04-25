package ru.maximenko.repositorys;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.maximenko.entity.User;

import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public User findByUsername(String username){

        Optional<User> optionalUser = jdbcTemplate.query(
                "SELECT id, username, password FROM users WHERE username = ?", new Object[] { username },
                (rs, rowNum) -> new User(rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("password"))).stream().findFirst();

        return optionalUser.orElse(null);
    }

    public void save(User user){
        jdbcTemplate.update("INSERT INTO users(username, password) VALUES (?, ?)", user.getUsername(), user.getPassword());
    }

}
