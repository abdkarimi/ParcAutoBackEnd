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
    @JsonBackReference
    private Modele modele;

    @ManyToOne
    @JoinColumn(name = "idAssurance")
    @JsonBackReference
    private Assurance assurance;

    @ManyToOne
    @JoinColumn(name = "idTypeCarburant")
    @JsonBackReference
    private TypeCarburant typeCarburant;

    @ManyToOne
    @JoinColumn(name = "idTypeVehicule")
    @JsonBackReference
    private TypeVehicule typeVehicule;

    @ManyToOne
    @JoinColumn(name = "idEnumeration")
    @JsonBackReference
    private Enumeration enumeration;

    @ManyToOne
    @JoinColumn(name = "idStatut")
    @JsonBackReference
    private Statut statut;

    @ManyToOne
    @JoinColumn(name = "concessionnaire_id")
    @JsonBackReference
    private Concessionnaire concessionnaire;

    @OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Intervention> interventions;

    @OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Accident> accidents;

    @OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Alerte> alertes;

    @OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<OrdreMission> ordreMissions;
}
