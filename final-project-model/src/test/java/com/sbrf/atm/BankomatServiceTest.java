package com.sbrf.atm;

import com.sbrf.atm.dto.Card;
import com.sbrf.atm.repository.CardRepositoryImpl;
import com.sbrf.atm.service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.naming.AuthenticationException;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class BankomatServiceTest {

    private Card testCard;

    private BankService bankService;

    private ClientService bankomatService;

    @Mock
    private CardInterface cardInterface;


    @BeforeEach
    void setUpBankomatService() {
        testCard = new Card("mockedNumber");
        cardInterface = Mockito.mock(CardInterface.class);
        bankService = new BankServiceImpl(new CardService(new CardRepositoryImpl()));
        bankomatService = new BankomatService(bankService, cardInterface);
    }

    @Test
    void getBalanceOfValidCard() {
        when(cardInterface.readCardNumber(any())).thenReturn("65623023251");
        assertEquals(bankomatService.getBalance(testCard, "0000"), BigDecimal.valueOf(600000));
    }

    @Test
    void getBalanceNonExistCard() {
        when(cardInterface.readCardNumber(any())).thenReturn("55655154858");
        assertThrows(IllegalArgumentException.class,
                () -> bankomatService.getBalance(testCard, "0001"));
    }

    @Test
    void getBalanceNonAuthClient() {
        when(cardInterface.readCardNumber(any())).thenReturn("65623023251");
        assertThrows(AuthenticationException.class,
                () -> bankomatService.getBalance(testCard, "0001"));
    }

    @Test
    void getBalanceExpiredCard() {
        when(cardInterface.readCardNumber(any())).thenReturn("58965251551");
        assertThrows(IllegalAccessException.class,
                () -> bankomatService.getBalance(testCard, "1663"));
    }

}
