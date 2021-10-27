package com.example.server;

import com.example.atm.dto.Account;
import com.example.server.exception.CardNotFoundException;
import com.example.server.repository.CardRepositoryImpl;
import com.example.server.service.CardService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CardServiceTest {

    private final CardService cardService = new CardService(new CardRepositoryImpl());

    @Test
    void getPinCodeByNumber() {
        assertEquals(cardService.getPinCodeByNumber("65623023251"), "0000");
        Assertions.assertThrows(CardNotFoundException.class,
                () -> cardService.getPinCodeByNumber("65623013251"));
    }

    @Test
    void getAccount() {
        assertEquals(cardService.getAccount("58965251551"), new Account(1L, BigDecimal.valueOf(450.2)));
    }

}
