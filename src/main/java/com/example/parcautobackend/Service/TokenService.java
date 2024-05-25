package com.example.parcautobackend.Service;

import com.example.parcautobackend.model.entities.Utilisateur;

public interface TokenService {
    public void saveToken(String jwt, Utilisateur user);
    public void revokeAllTokensByUser(Utilisateur user);
}
