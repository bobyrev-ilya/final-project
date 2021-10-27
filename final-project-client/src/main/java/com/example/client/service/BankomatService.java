package com.example.client.service;

import com.example.atm.Request;
import com.example.atm.Response;
import com.example.atm.ResponseStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BankomatService implements ClientService {

    private final static RestTemplate restTemplate = new RestTemplate();
    private String responseString;

    @Value("${server.service.getbalance}")
    private String balanceRequestUrl;

    @Override
    public String getBalance(Request request) {
        HttpEntity<Request> serverRequest = new HttpEntity<>(request);
        Response response = restTemplate.postForObject(
                balanceRequestUrl,
                serverRequest,
                Response.class
        );
        if (response.getStatus().equals(ResponseStatus.SUCCESS)) {
            responseString = String.format("Баланс карты %s: %s", request.getNumber(), response.getBalance());
        } else {
            responseString = String.format("Ошибка при получении баланса карты %s: %s", request.getNumber(), response.getDescription());
        }
        return responseString;
    }
}
