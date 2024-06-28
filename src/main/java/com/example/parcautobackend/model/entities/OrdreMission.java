package com.example.parcautobackend.model.entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;
import java.util.List;
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
    private Date dateDepart;
    private String heureDepart;
    private Date dateRetour;
    private String heureRetour;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "agent_id")
    private Utilisateur agent;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "vehicule_id")
    private Vehicule vehicule;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "destination_id")
    private Destination destination;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "perimetre_id")
    private Perimetre perimetre;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "historiqueTrajet_id")
    private HistoriqueTrajet historiqueTrajets;

    @ManyToMany
    private List<Utilisateur> accompagnant;
}
