package com.example.parcautobackend.controllers;

import com.example.parcautobackend.model.entities.Garage;
import com.example.parcautobackend.Service.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/AULSH/garages")
public class GarageController {

    @Autowired
    private GarageService garageService;

    @PostMapping
    public ResponseEntity<Garage> createGarage(@RequestBody Garage garage) {
        Garage savedGarage = garageService.saveGarage(garage);
        return ResponseEntity.ok(savedGarage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Garage> getGarageById(@PathVariable Long id) {
        Optional<Garage> garage = garageService.getGarageById(id);
        return garage.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Garage>> getAllGarages() {
        List<Garage> garages = garageService.getAllGarages();
        return ResponseEntity.ok(garages);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Garage> updateGarage(@PathVariable Long id, @RequestBody Garage garage) {
        Garage updatedGarage = garageService.updateGarage(id, garage);
        return updatedGarage != null ? ResponseEntity.ok(updatedGarage) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGarage(@PathVariable Long id) {
        garageService.deleteGarage(id);
        return ResponseEntity.noContent().build();
    }
}
