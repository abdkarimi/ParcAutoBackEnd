package com.example.parcautobackend.model.repositories;


import com.example.parcautobackend.model.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Optional<Utilisateur> findByUsername(String username);

    Optional<Utilisateur> findByEmail(String email);
    Optional<Utilisateur> findByUsernameAndAccountIsTrue(String username);
    boolean existsByMatricule(String ppr);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
    Optional<Utilisateur> findById(Long id);
    long count();
}
