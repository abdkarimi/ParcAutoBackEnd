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
    @JsonBackReference(value = "modele-vehicule")
    private Modele modele;

    @ManyToOne
    @JoinColumn(name = "idAssurance")
    @JsonBackReference(value = "assurance-vehicule")
    private Assurance assurance;

    @ManyToOne
    @JoinColumn(name = "idTypeCarburant")
    @JsonBackReference(value = "typeCarburant-vehicule")
    private TypeCarburant typeCarburant;

    @ManyToOne
    @JoinColumn(name = "idTypeVehicule")
    @JsonBackReference(value = "typeVehicule-vehicule")
    private TypeVehicule typeVehicule;

    @ManyToOne
    @JoinColumn(name = "idEnumeration")
    @JsonBackReference(value = "enumeration-vehicule")
    private Enumeration enumeration;

    @ManyToOne
    @JoinColumn(name = "idStatut")
    @JsonBackReference(value = "statut-vehicule")
    private Statut statut;

    @ManyToOne
    @JoinColumn(name = "idConcessionnaire")
    @JsonBackReference(value = "concessionnaire-vehicule")
    private Concessionnaire concessionnaire;

    @OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "vehicule-intervention")
    private Set<Intervention> interventions;

    @OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "vehicule-accident")
    private Set<Accident> accidents;

    @OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "vehicule-alerte")
    private Set<Alerte> alertes;

    @OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "vehicule-ordreMission")
    private Set<OrdreMission> ordreMissions;
}
