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
public class Sanctionner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSanction;

    @ManyToOne
    @JoinColumn(name = "idPV")
    @JsonBackReference
    private PV pv;

    // Getters and setters
}

