package com.sbrf.atm.service;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import javax.naming.AuthenticationException;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
public class BankServiceImpl implements BankService {

    private final CardService cardService;

    @SneakyThrows
    @Override
    public BigDecimal getCardBalance(String cardNumber, String pin) {
        if(!isCardExpired(cardNumber)) {
            if (authClient(cardNumber, pin)) {
                return cardService.getBalance(cardNumber);
            }
            else throw new AuthenticationException();
        }
        else throw new IllegalAccessException();
    }

    private boolean isCardExpired(String cardNumber) {
        return LocalDate.now().isAfter(cardService.getExpireDate(cardNumber));
    }


    @Override
    public String getPinByNumber(String cardNumber) {
        return cardService.getPinCodeByNumber(cardNumber);
    }

    @Override
    public boolean authClient(String cardNumber, String pin) {
        return pin.equals(getPinByNumber(cardNumber));
    }
}
