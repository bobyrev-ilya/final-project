package com.example.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ClientAppConfig {

    @Bean
    public RestTemplate atmRestTemplate(@Value("${atm.user}") String user,
                                        @Value("${atm.password}") String password,
                                        RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder
                .basicAuthentication(user, password)
                .build();
    }
}
