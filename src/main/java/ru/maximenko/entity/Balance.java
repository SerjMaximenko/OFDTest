package ru.maximenko.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Balance {

    private Long id;

    private Long userId;

    private String balanceType;

    private Long balance;

    private LocalDateTime changed;
}
