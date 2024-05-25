package com.example.parcautobackend.dtos.Login;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {
    private String jwt;
    private Long id;
    private String role;

}
