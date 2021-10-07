package com.sbrf.atm.repository;

import com.sbrf.atm.dto.Account;
import com.sbrf.atm.dto.Card;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class CardRepositoryImpl implements CardRepository {

    private final List<Card> cardList = Arrays.asList(
            new Card("59263303996", "1234", new Account(1L, BigDecimal.valueOf(450.2)),LocalDate.now()),
            new Card("65623023251", "0000", new Account(2L, BigDecimal.valueOf(600000)), LocalDate.now().plusDays(10)),
            new Card("58965251551", "1663", new Account(1L, BigDecimal.valueOf(450.2)),LocalDate.now().minusDays(10))
    );

    @Override
    public Card getCardByNumber(String cardNumber) {
        return cardList.stream()
                .filter(c -> c.getNumber().equals(cardNumber))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
