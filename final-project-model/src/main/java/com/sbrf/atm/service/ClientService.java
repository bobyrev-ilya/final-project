package com.sbrf.atm.service;

import com.sbrf.atm.dto.Card;

import java.math.BigDecimal;

/**
 * Слой клиентских операций
 */

public interface ClientService {

    BigDecimal getBalance(Card card, String pin);

}
