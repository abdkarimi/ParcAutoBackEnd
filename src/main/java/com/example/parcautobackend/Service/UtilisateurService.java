package com.example.parcautobackend.Service;

import com.example.parcautobackend.model.entities.Utilisateur;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UtilisateurService {
    Utilisateur saveUtilisateur(MultipartFile file, Utilisateur utilisateur) throws IOException;
    Utilisateur getUtilisateurByUsername(String username);
    List<Utilisateur> getAllUtilisateurs();
    Utilisateur editUtilisateur(MultipartFile file, Utilisateur utilisateur) throws IOException;
    Utilisateur updateUtilisateurWithoutImage(Utilisateur utilisateur);
    void deleteUtilisateur(Long id);
    Utilisateur getUtilisateurById(Long id);
    boolean isUtilisateurExists(Utilisateur utilisateur);
}

