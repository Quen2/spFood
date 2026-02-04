package com.cda.spfood.dtos.users;

public record UserRequestDTO (
        String lastname,
        String firstname,
        String email,
        String password,
        String role,
        String phone
){}
