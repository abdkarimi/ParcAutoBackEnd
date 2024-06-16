package com.example.parcautobackend.model.entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Marque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMarque;
    private String libelleMarque;

    @OneToMany(mappedBy = "marque", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Modele> modeles;
}
