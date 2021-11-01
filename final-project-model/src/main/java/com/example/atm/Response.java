package com.example.atm;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Response {
    private ResponseStatus status;
    private String description;
    private BigDecimal balance;
}
