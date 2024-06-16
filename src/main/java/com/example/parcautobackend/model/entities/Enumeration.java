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
public class Enumeration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEnumeration;
    private String designationEnumeration;

    @OneToMany(mappedBy = "enumeration", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Vehicule> vehicules;
}
