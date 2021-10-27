package com.example.atm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Card {

    private String number;
    private String pin;
    private Account account;
    private LocalDate expireDate;

}