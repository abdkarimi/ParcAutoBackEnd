package com.example.parcautobackend.controllers;


import com.example.parcautobackend.Service.UtilisateurService;
import com.example.parcautobackend.model.entities.Utilisateur;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/AULSH/utilisateurs")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Utilisateur>> getAllUtilisateurs() {
        List<Utilisateur> utilisateurs = utilisateurService.getAllUtilisateurs();
        return ResponseEntity.ok(utilisateurs);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveUtilisateur(
            @RequestPart("utilisateur") String utilisateurJson,
            @RequestPart("file") MultipartFile file
    ) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Utilisateur utilisateur = objectMapper.readValue(utilisateurJson, Utilisateur.class);
            Utilisateur savedUtilisateur = utilisateurService.saveUtilisateur(file, utilisateur);
            return new ResponseEntity<>(savedUtilisateur, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable Long id) {
        try {
            Utilisateur utilisateur = utilisateurService.getUtilisateurById(id);
            if (utilisateur != null) {
                return new ResponseEntity<>(utilisateur, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable Long id) {
        try {
            utilisateurService.deleteUtilisateur(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateUtilisateur(
            @RequestPart("utilisateur") String utilisateurJson,
            @RequestPart(value = "file", required = false) MultipartFile file
    ) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Utilisateur utilisateur = objectMapper.readValue(utilisateurJson, Utilisateur.class);

            Utilisateur updatedUtilisateur;
            if (file != null && !file.isEmpty()) {
                // If file is provided, update utilisateur with new image
                updatedUtilisateur = utilisateurService.editUtilisateur(file, utilisateur);
            } else {
                // If file is not provided, update utilisateur without changing the image
                updatedUtilisateur = utilisateurService.updateUtilisateurWithoutImage(utilisateur);
            }
            return new ResponseEntity<>(updatedUtilisateur, HttpStatus.OK);
        } catch (RuntimeException e) {
            // Handle runtime exceptions (e.g., utilisateur not found, conflict)
            if (e.getMessage().contains("Utilisateur with ID")) {
                // Utilisateur not found
                return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
            } else if (e.getMessage().contains("Un utilisateur avec le même Matricule, nom d'utilisateur ou email existe déjà.")) {
                // Conflict with existing utilisateur
                return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
            } else {
                // Other runtime exceptions
                return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<String> handleUsernameNotFoundException(UsernameNotFoundException e) {
        return new ResponseEntity<>("User not found: " + e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception e) {
        return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
