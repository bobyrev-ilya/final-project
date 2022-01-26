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

    private RestTemplate restTemplate;

    private String responseString;

    @Value("${server.service.getbalance}")
    private String balanceRequestUrl;

    public BankomatService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String getBalance(Request request) {
        try {
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
        } catch (Exception e) {
            return String.format("Ошибка при получении баланса карты %s: %s", request.getNumber(), e.getMessage());
        }
    }
}
