package com.example.server.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Слой вспомогательных банковских методов
 */

@Service
public interface BankService {

    BigDecimal getCardBalance(String cardNumber, String pin);

    String getPinByNumber(String cardNumber);

    boolean isAuthClient(String cardNumber, String pin);

}
