package com.sbrf.atm.service;


import com.sbrf.atm.repository.CardRepository;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    public String getPinCodeByNumber(String cardNumber) {
        return cardRepository.getCardByNumber(cardNumber).getPin();
    }

    public BigDecimal getBalance(String cardNumber) {
        return cardRepository.getCardByNumber(cardNumber).getAccount().getBalance();
    }

    public LocalDate getExpireDate(String cardNumber) {
        return cardRepository.getCardByNumber(cardNumber).getExpireDate();
    }

}
