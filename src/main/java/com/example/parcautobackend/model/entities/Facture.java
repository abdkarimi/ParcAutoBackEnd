package com.example.parcautobackend.model.entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFacture;
    private String numeroFacture;
    private Date dateFacture;

    @ManyToOne
    @JoinColumn(name = "idTache")
    @JsonBackReference
    private Tache tache;

    // Getters and setters
}

