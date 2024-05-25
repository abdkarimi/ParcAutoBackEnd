package com.example.parcautobackend.model.entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTache;
    private String libelleTache;
    private double prixHTTache;
    private double tvaTache;
    private double prixTTC;

    @ManyToOne
    @JoinColumn(name = "idIntervention")
    @JsonBackReference
    private Intervention intervention;

    @ManyToOne
    @JoinColumn(name = "idGarage")
    @JsonBackReference
    private Garage garage;

    @OneToMany(mappedBy = "tache", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Facture> factures;

    // Getters and setters
}
