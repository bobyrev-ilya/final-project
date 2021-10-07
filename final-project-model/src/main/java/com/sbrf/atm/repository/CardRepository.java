package com.sbrf.atm.repository;

import com.sbrf.atm.dto.Card;

public interface CardRepository {

    Card getCardByNumber(String cardNumber);

}
