package com.example.parcautobackend.controllers;

import com.example.parcautobackend.model.entities.TypeCarburant;
import com.example.parcautobackend.Service.TypeCarburantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/AULSH/typecarburants")
public class TypeCarburantController {

    @Autowired
    private TypeCarburantService typeCarburantService;

    @PostMapping
    public ResponseEntity<TypeCarburant> createTypeCarburant(@RequestBody TypeCarburant typeCarburant) {
        TypeCarburant savedTypeCarburant = typeCarburantService.saveTypeCarburant(typeCarburant);
        return ResponseEntity.ok(savedTypeCarburant);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeCarburant> getTypeCarburantById(@PathVariable Long id) {
        Optional<TypeCarburant> typeCarburant = typeCarburantService.getTypeCarburantById(id);
        return typeCarburant.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<TypeCarburant>> getAllTypeCarburants() {
        List<TypeCarburant> typeCarburants = typeCarburantService.getAllTypeCarburants();
        return ResponseEntity.ok(typeCarburants);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeCarburant> updateTypeCarburant(@PathVariable Long id, @RequestBody TypeCarburant typeCarburant) {
        TypeCarburant updatedTypeCarburant = typeCarburantService.updateTypeCarburant(id, typeCarburant);
        return updatedTypeCarburant != null ? ResponseEntity.ok(updatedTypeCarburant) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypeCarburant(@PathVariable Long id) {
        typeCarburantService.deleteTypeCarburant(id);
        return ResponseEntity.noContent().build();
    }
}
