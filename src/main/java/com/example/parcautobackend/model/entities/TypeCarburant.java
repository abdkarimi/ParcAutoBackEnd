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
public class TypeCarburant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTypeCarburant;
    private String libelleTypeCarburant;

    @OneToMany(mappedBy = "typeCarburant", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Vehicule> vehicules;
}
