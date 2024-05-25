package com.example.parcautobackend.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "Nom", nullable = false)
    private String nom;

    @Lob
    @Column(name = "Description", nullable = false)
    private String description;

}