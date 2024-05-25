package com.example.parcautobackend.model.entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Elaborer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idElaborer;

    @ManyToOne
    @JoinColumn(name = "idCompagnie")
    @JsonBackReference
    private Compagnie compagnie;

    @ManyToOne
    @JoinColumn(name = "idModele")
    @JsonBackReference
    private Modele modele;

    // Getters and setters
}
