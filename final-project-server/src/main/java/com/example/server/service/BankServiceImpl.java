package com.example.server.service;

import com.example.server.exception.ExpiredCardException;
import com.example.server.exception.FailedPinAuthenticationException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@Component
public class BankServiceImpl implements BankService {

    private final CardService cardService;

    @Override
    public BigDecimal getCardBalance(String cardNumber, String pin) {
        if (!isCardExpired(cardNumber)) {
            if (isAuthClient(cardNumber, pin)) {
                return cardService.getAccount(cardNumber).getBalance();
            } else throw new FailedPinAuthenticationException("Введен некоректный пин-код");
        } else throw new ExpiredCardException("Срок действия карты истек");
    }

    private boolean isCardExpired(String cardNumber) {
        return LocalDate.now().isAfter(cardService.getExpireDate(cardNumber));
    }


    @Override
    public String getPinByNumber(String cardNumber) {
        return cardService.getPinCodeByNumber(cardNumber);
    }

    @Override
    public boolean isAuthClient(String cardNumber, String pin) {
        return pin.equals(getPinByNumber(cardNumber));
    }
}
