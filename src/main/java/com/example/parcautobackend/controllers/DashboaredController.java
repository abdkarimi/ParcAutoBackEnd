package com.example.parcautobackend.controllers;

import com.example.parcautobackend.Service.UtilisateurService;
import com.example.parcautobackend.model.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/AULSH")
public class DashboaredController {
    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/navbar")
    public ResponseEntity<Utilisateur> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();

        // Retrieve UtilisateurDto by username
        Utilisateur userDto = utilisateurService.getUtilisateurByUsername(currentUserName);

        if (userDto != null) {
            return ResponseEntity.ok(userDto);
        } else {
            // Handle case where user is not found (optional)
            return ResponseEntity.notFound().build();
        }
    }

}
