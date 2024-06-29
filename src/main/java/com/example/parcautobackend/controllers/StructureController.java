package com.example.parcautobackend.controllers;

import com.example.parcautobackend.model.entities.Structure;
import com.example.parcautobackend.Service.StructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/AULSH/structures")
public class StructureController {

    @Autowired
    private StructureService structureService;

    @PostMapping
    public ResponseEntity<Structure> createStructure(@RequestBody Structure structure) {
        Structure savedStructure = structureService.saveStructure(structure);
        return ResponseEntity.ok(savedStructure);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Structure> getStructureById(@PathVariable Long id) {
        Optional<Structure> structure = structureService.getStructureById(id);
        return structure.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Structure>> getAllStructures() {
        List<Structure> structures = structureService.getAllStructures();
        return ResponseEntity.ok(structures);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Structure> updateStructure(@PathVariable Long id, @RequestBody Structure structure) {
        Structure updatedStructure = structureService.updateStructure(id, structure);
        return updatedStructure != null ? ResponseEntity.ok(updatedStructure) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStructure(@PathVariable Long id) {
        structureService.deleteStructure(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/top-parent/{userId}")
    public ResponseEntity<Object> getTopParentStructureByUserId(@PathVariable Long userId) {
        Object result = structureService.findTopParentStructureByUserId(userId);
        return ResponseEntity.ok(result);
    }
}
