package com.example.server.roles;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRole {

    ADMIN("Администратор");

    private String description;
}
