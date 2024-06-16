package com.example.parcautobackend.model.entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Intervention {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIntervention;
    private String objetIntervention;
    private Date dateIntervention;
    private Date echeanceIntervention;
    private int kmIntervention;

    @ManyToOne
    @JoinColumn(name = "idVehicule")
    @JsonBackReference(value = "vehicule-intervention")
    private Vehicule vehicule;

    @ManyToOne
    @JoinColumn(name = "idTypeIntervention")
    @JsonBackReference(value = "typeIntervention-intervention")
    private TypeIntervention typeIntervention;

    @ManyToOne
    @JoinColumn(name = "idGarage")
    @JsonBackReference(value = "garage-intervention")
    private Garage garage;

    @OneToMany(mappedBy = "intervention", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "intervention-tache")
    private Set<Tache> taches;
}
