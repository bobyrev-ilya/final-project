package com.example.server.repository;

import com.example.atm.dto.Card;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CardRepository {

    Optional<Card> getCardByNumber(String cardNumber);

}
