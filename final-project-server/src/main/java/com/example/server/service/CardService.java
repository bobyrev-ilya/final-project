package com.example.server.service;


import com.example.atm.dto.Account;
import com.example.atm.dto.Card;
import com.example.server.exception.CardNotFoundException;
import com.example.server.repository.CardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    public String getPinCodeByNumber(String cardNumber) {
        return this.getCard(cardRepository.getCardByNumber(cardNumber))
                .getPin();
    }

    public Account getAccount(String cardNumber) {
        return this.getCard(cardRepository.getCardByNumber(cardNumber))
                .getAccount();
    }

    public LocalDate getExpireDate(String cardNumber) {
        return this.getCard(cardRepository.getCardByNumber(cardNumber))
                .getExpireDate();
    }

    private Card getCard(Optional<Card> card) {
        return card.orElseThrow(() -> new CardNotFoundException("Карта с данным номером не найдена"));
    }

}
