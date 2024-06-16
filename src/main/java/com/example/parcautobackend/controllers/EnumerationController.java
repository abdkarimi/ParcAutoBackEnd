package com.example.parcautobackend.controllers;

import com.example.parcautobackend.model.entities.Enumeration;
import com.example.parcautobackend.Service.EnumerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/AULSH/enumerations")
public class EnumerationController {

    @Autowired
    private EnumerationService enumerationService;

    @PostMapping
    public ResponseEntity<Enumeration> createEnumeration(@RequestBody Enumeration enumeration) {
        Enumeration savedEnumeration = enumerationService.saveEnumeration(enumeration);
        return ResponseEntity.ok(savedEnumeration);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enumeration> getEnumerationById(@PathVariable Long id) {
        Optional<Enumeration> enumeration = enumerationService.getEnumerationById(id);
        return enumeration.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Enumeration>> getAllEnumerations() {
        List<Enumeration> enumerations = enumerationService.getAllEnumerations();
        return ResponseEntity.ok(enumerations);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Enumeration> updateEnumeration(@PathVariable Long id, @RequestBody Enumeration enumeration) {
        Enumeration updatedEnumeration = enumerationService.updateEnumeration(id, enumeration);
        return updatedEnumeration != null ? ResponseEntity.ok(updatedEnumeration) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnumeration(@PathVariable Long id) {
        enumerationService.deleteEnumeration(id);
        return ResponseEntity.noContent().build();
    }
}
