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
    @JsonBackReference
    private Utilisateur agent;

    @ManyToOne
    @JoinColumn(name = "vehicule_id")
    @JsonBackReference
    private Vehicule vehicule;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Destination destination;

    @ManyToOne
    @JoinColumn(name = "perimetre_id")
    private Perimetre perimetre;

    @OneToMany(mappedBy = "ordreMission", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<HistoriqueTrajet> historiqueTrajets;
}
