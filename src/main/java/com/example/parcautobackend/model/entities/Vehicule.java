package com.example.parcautobackend.model.entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicule;
    private String matriculeVehicule;
    private Date dateCirculation;
    private int puissanceFiscale;
    private int nbPlace;
    private String couleurVehicule;
    private String photoVehicule;

    @ManyToOne
    @JoinColumn(name = "idModele")
    @JsonBackReference(value = "modele-vehicule")
    private Modele modele;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "idAssurance")
    private Assurance assurance;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "idTypeCarburant")
    private TypeCarburant typeCarburant;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "idTypeVehicule")
    private TypeVehicule typeVehicule;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "idEnumeration")
    private Enumeration enumeration;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "idStatut")
    private Statut statut;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "idConcessionnaire")
    private Concessionnaire concessionnaire;

}
