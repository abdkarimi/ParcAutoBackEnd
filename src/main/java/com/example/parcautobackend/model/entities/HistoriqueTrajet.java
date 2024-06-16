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
public class HistoriqueTrajet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTrajet;
    private Double latitudeTrajet;
    private Double longitudeTrajet;

    @ManyToOne
    @JoinColumn(name = "ordre_mission_id")
    @JsonBackReference(value = "ordreMission-historiqueTrajet")
    private OrdreMission ordreMission;
}
