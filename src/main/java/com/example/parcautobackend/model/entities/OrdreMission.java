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
public class OrdreMission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOm;
    private String refOm;
    private Date dateOm;
    private String objetOm;
    private Integer kmDepartOm;
    private Integer kmRetourOm;
    private Double dotationCarburant;
    private String statutOm;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    @JsonBackReference(value = "utilisateur-ordreMission")
    private Utilisateur agent;

    @ManyToOne
    @JoinColumn(name = "vehicule_id")
    @JsonBackReference(value = "vehicule-ordreMission")
    private Vehicule vehicule;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    @JsonBackReference(value = "destination-ordreMission")
    private Destination destination;

    @ManyToOne
    @JoinColumn(name = "perimetre_id")
    @JsonBackReference(value = "perimetre-ordreMission")
    private Perimetre perimetre;

    @OneToMany(mappedBy = "ordreMission", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "ordreMission-historiqueTrajet")
    private Set<HistoriqueTrajet> historiqueTrajets;
}
