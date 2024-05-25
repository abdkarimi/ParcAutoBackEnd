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
public class TypeVehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTypeVehicule;
    private String libelleTypeVehicule;

    @OneToMany(mappedBy = "typeVehicule", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Vehicule> vehicules;

    // Getters and setters
}

