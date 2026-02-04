package com.cda.spfood.dtos.users;

public record UserResponseDTO(
        Integer id,
        String lastname,
        String firstname,
        String email,
        String role,
        String phone
        ){}
