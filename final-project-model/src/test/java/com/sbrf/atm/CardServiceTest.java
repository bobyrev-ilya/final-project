package com.sbrf.atm;

import com.sbrf.atm.repository.CardRepositoryImpl;
import com.sbrf.atm.service.CardService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CardServiceTest {

    private CardService cardService = new CardService(new CardRepositoryImpl());

    @Test
    void getPinCodeByNumber() {
        assertEquals(cardService.getPinCodeByNumber("65623023251"), "0000");
        assertThrows(IllegalArgumentException.class,
                () -> cardService.getPinCodeByNumber("65623013251"));
    }

    @Test
    void getBalance() {
        assertEquals(cardService.getBalance("58965251551"), BigDecimal.valueOf(450.2));
    }

}
