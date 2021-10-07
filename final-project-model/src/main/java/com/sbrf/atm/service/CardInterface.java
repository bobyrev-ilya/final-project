package com.sbrf.atm.service;

import com.sbrf.atm.dto.Card;

/**
 * Интерфейс для получения номера карты странным образом
 */

public interface CardInterface {

    String readCardNumber(Card card);

}
