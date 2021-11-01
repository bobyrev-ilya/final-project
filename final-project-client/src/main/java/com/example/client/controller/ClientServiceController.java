package com.example.client.controller;

import com.example.atm.Request;
import com.example.client.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ClientServiceController {

    private final ClientService clientService;

    @GetMapping("/balance")
    public String requestBalance(@RequestParam("number") String number,
                                 @RequestParam("pin") String pin) {
        return clientService.getBalance(new Request(number, pin));
    }

}
