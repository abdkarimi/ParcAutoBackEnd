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
public class Alerte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlerte;
    private String descriptionAlerte;
    private Boolean kmAlerte;
    private String declencheAlerte;

    @ManyToOne
    @JoinColumn(name = "vehicule_id")
    @JsonBackReference(value = "vehicule-alerte")
    private Vehicule vehicule;
}
