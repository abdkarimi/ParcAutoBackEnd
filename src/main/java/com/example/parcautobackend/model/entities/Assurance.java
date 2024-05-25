package com.example.parcautobackend.model.entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Assurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAssurance;
    private String police;
    private Date debutGarantie;
    private Date finGarantie;

    @OneToMany(mappedBy = "assurance", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Vehicule> vehicules;

    // Getters and setters
}

