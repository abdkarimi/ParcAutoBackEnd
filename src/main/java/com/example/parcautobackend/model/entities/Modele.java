package com.example.parcautobackend.model.entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Modele {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModele;
    private String libelleModele;

    @OneToMany(mappedBy = "modele", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Elaborer> elaborers;

    @ManyToOne
    @JoinColumn(name = "idMarque")
    @JsonBackReference
    private Marque marque;

    // Getters and setters
}

