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
}
