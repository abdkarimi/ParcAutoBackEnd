package com.example.parcautobackend.model.entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Perimetre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerimetre;
    private String nomPerimetre;
    private Double latitudePerimetre;
    private Double longitudePerimetre;

    @OneToMany(mappedBy = "perimetre", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<OrdreMission> ordreMissions;
}
