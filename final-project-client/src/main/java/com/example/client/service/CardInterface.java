package com.example.client.service;

import com.example.atm.dto.Card;

/**
 * Интерфейс для получения номера карты странным образом
 */

public interface CardInterface {

    String readCardNumber(Card card);

}
