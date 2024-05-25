package com.example.parcautobackend.model.repositories;


import com.example.parcautobackend.model.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    public Optional<Utilisateur> findByUsername(String username);

    Optional<Utilisateur> findByEmail(String email);
}
