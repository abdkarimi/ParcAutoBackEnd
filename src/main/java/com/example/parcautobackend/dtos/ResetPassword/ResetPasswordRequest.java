package com.example.parcautobackend.dtos.ResetPassword;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResetPasswordRequest {
    private String token;
    private String newPassword;
}

