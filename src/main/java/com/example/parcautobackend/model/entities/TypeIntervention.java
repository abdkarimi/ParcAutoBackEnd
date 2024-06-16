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
public class TypeIntervention {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTypeIntervention;
    private String libelleTypeIntervention;

    @OneToMany(mappedBy = "typeIntervention", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Intervention> interventions;
}
