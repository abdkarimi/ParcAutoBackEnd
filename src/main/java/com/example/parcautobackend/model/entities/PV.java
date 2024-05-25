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
public class PV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPV;
    private Date datePV;
    private String cheminPV;

    @OneToMany(mappedBy = "pv", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Sanctionner> sanctions;

    // Getters and setters
}

