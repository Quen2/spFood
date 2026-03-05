package com.cda.spfood.dtos.auth;

import lombok.Data;

@Data
public class LoginResponseDTO {
    private String token;
    private String type = "Bearer";
    private String email;
    private String role;

    public LoginResponseDTO(String token, String email, String role) {
        this.token = token;
        this.email = email;
        this.role = role;
    }
}
