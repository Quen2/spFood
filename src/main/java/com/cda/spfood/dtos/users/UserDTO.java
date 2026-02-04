package com.cda.spfood.dtos.users;

public record UserDTO (
        String lastname,
        String firstname,
        String email,
        String role,
        String phone
){}
