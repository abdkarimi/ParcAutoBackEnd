package com.example.parcautobackend.controllers;

import com.example.parcautobackend.model.entities.Assurance;
import com.example.parcautobackend.Service.AssuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/AULSH/assurances")
public class AssuranceController {

    @Autowired
    private AssuranceService assuranceService;

    @PostMapping
    public ResponseEntity<Assurance> createAssurance(@RequestBody Assurance assurance) {
        Assurance savedAssurance = assuranceService.saveAssurance(assurance);
        return ResponseEntity.ok(savedAssurance);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assurance> getAssuranceById(@PathVariable Long id) {
        Optional<Assurance> assurance = assuranceService.getAssuranceById(id);
        return assurance.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Assurance>> getAllAssurances() {
        List<Assurance> assurances = assuranceService.getAllAssurances();
        return ResponseEntity.ok(assurances);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Assurance> updateAssurance(@PathVariable Long id, @RequestBody Assurance assurance) {
        Assurance updatedAssurance = assuranceService.updateAssurance(id, assurance);
        return updatedAssurance != null ? ResponseEntity.ok(updatedAssurance) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssurance(@PathVariable Long id) {
        assuranceService.deleteAssurance(id);
        return ResponseEntity.noContent().build();
    }
}
