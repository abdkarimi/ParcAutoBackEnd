package com.example.parcautobackend.Service;

import com.example.parcautobackend.model.entities.Utilisateur;
import java.util.List;

public interface  UtilisateurService {
    Utilisateur saveUtilisateur(Utilisateur utilisateur);
    Utilisateur getUtilisateurByUsername(String username);
    List<Utilisateur> getAllUtilisateurs();
    Utilisateur editUtilisateur(Utilisateur utilisateur);
    void deleteUtilisateur(Long id);
}
