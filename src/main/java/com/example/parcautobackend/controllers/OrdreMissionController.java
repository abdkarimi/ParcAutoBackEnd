package com.example.parcautobackend.controllers;

import com.example.parcautobackend.model.entities.OrdreMission;
import com.example.parcautobackend.Service.OrdreMissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/AULSH/ordremissions")
public class OrdreMissionController {

    @Autowired
    private OrdreMissionService ordreMissionService;

    @PostMapping
    public ResponseEntity<OrdreMission> createOrdreMission(@RequestBody OrdreMission ordreMission) {
        OrdreMission savedOrdreMission = ordreMissionService.saveOrdreMission(ordreMission);
        return ResponseEntity.ok(savedOrdreMission);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdreMission> getOrdreMissionById(@PathVariable Long id) {
        Optional<OrdreMission> ordreMission = ordreMissionService.getOrdreMissionById(id);
        return ordreMission.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<OrdreMission>> getAllOrdreMissions() {
        List<OrdreMission> ordreMissions = ordreMissionService.getAllOrdreMissions();
        return ResponseEntity.ok(ordreMissions);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdreMission> updateOrdreMission(@PathVariable Long id, @RequestBody OrdreMission ordreMission) {
        OrdreMission updatedOrdreMission = ordreMissionService.updateOrdreMission(id, ordreMission);
        return updatedOrdreMission != null ? ResponseEntity.ok(updatedOrdreMission) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrdreMission(@PathVariable Long id) {
        ordreMissionService.deleteOrdreMission(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/departement/{departementId}")
    public ResponseEntity<List<OrdreMission>> getAllOrdreMissionOfDepartement(@PathVariable Long departementId) {
        List<OrdreMission> ordreMissions = ordreMissionService.getAllOrdreMissionOfDepartement(departementId);
        return ResponseEntity.ok(ordreMissions);
    }
}
