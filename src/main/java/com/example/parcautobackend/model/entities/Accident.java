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
public class Accident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAccident;
    private Date dateAccident;
    private String descriptionAccident;
    private String lieuAccident;

    @ManyToOne
    @JoinColumn(name = "idVehicule")
    @JsonBackReference
    private Vehicule vehicule;

    // Getters and setters
}

