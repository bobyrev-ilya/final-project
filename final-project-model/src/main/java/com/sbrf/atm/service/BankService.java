package com.sbrf.atm.service;

import java.math.BigDecimal;

/**
 * Слой вспомогательных банковских методов
 */

public interface BankService {

    BigDecimal getCardBalance(String cardNumber, String pin);

    String getPinByNumber(String cardNumber);

    boolean authClient(String cardNumber, String pin);

}
