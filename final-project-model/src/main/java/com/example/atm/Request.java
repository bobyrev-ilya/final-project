package com.example.atm;

import lombok.Value;

@Value
public class Request {
    private String number;
    private String pin;
}
