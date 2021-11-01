package com.example.server.controller;

import com.example.atm.Request;
import com.example.atm.Response;
import com.example.atm.ResponseStatus;
import com.example.server.service.BankService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@AllArgsConstructor
@Log
public class ServerRestController {

    private BankService bankService;

    @PostMapping("/getbalance")
    Response getBalance(@RequestBody Request request) {
        Response response = new Response();
        try {
            BigDecimal cardBalance = bankService.getCardBalance(request.getNumber(), request.getPin());
            response.setStatus(ResponseStatus.SUCCESS);
            response.setBalance(cardBalance);
            return response;
        } catch (RuntimeException e) {
            response.setStatus(ResponseStatus.ERROR);
            response.setDescription(e.getMessage());
            return response;
        }
    }

}
