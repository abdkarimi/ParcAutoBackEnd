package com.example.parcautobackend.controllers;

import com.example.parcautobackend.model.entities.Vehicule;
import com.example.parcautobackend.Service.VehiculeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/AULSH/vehicules")
public class VehiculeController {

    @Autowired
    private VehiculeService vehiculeService;

    @PostMapping
    public ResponseEntity<Vehicule> createVehicule(@RequestParam("file") MultipartFile file, @RequestParam("vehicule") String vehiculeJson) throws IOException {
        Vehicule vehicule = new ObjectMapper().readValue(vehiculeJson, Vehicule.class);
        Vehicule savedVehicule = vehiculeService.saveVehicule(file, vehicule);
        return ResponseEntity.ok(savedVehicule);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicule> getVehiculeById(@PathVariable Long id) {
        Optional<Vehicule> vehicule = vehiculeService.getVehiculeById(id);
        return vehicule.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Vehicule>> getAllVehicules() {
        List<Vehicule> vehicules = vehiculeService.getAllVehicules();
        return ResponseEntity.ok(vehicules);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicule> updateVehicule(@PathVariable Long id, @RequestParam(value = "file", required = false) MultipartFile file, @RequestParam("vehicule") String vehiculeJson) throws IOException {
        Vehicule vehicule = new ObjectMapper().readValue(vehiculeJson, Vehicule.class);
        Vehicule updatedVehicule;
        if (file != null && !file.isEmpty()) {
            updatedVehicule = vehiculeService.updateVehicule(id, file, vehicule);
        } else {
            updatedVehicule = vehiculeService.updateVehiculeWithoutImage(vehicule);
        }
        return updatedVehicule != null ? ResponseEntity.ok(updatedVehicule) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicule(@PathVariable Long id) {
        vehiculeService.deleteVehicule(id);
        return ResponseEntity.noContent().build();
    }
}
