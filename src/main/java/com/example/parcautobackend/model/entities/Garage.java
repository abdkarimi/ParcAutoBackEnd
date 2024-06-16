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
public class Garage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGarage;
    private String nomGarage;
    private String nomResponsableG;
    private String telGarage;
    private String gsmGarage;
    private String emailGarage;
    private String adresseGarage;

}
