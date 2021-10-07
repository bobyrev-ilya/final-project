package com.sbrf.atm.service;

import com.sbrf.atm.dto.Card;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class BankomatService implements ClientService {

    private final BankService bankService;
    private final CardInterface cardInterface;

    @Override
    public BigDecimal getBalance(Card card, String pin) {
        return bankService.getCardBalance(cardInterface.readCardNumber(card), pin);
    }
}
