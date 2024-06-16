package com.example.parcautobackend.controllers;

import com.example.parcautobackend.model.entities.Accident;
import com.example.parcautobackend.Service.AccidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/AULSH/accidents")
public class AccidentController {

    @Autowired
    private AccidentService accidentService;

    @PostMapping
    public ResponseEntity<Accident> createAccident(@RequestBody Accident accident) {
        Accident savedAccident = accidentService.saveAccident(accident);
        return ResponseEntity.ok(savedAccident);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Accident> getAccidentById(@PathVariable Long id) {
        Optional<Accident> accident = accidentService.getAccidentById(id);
        return accident.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Accident>> getAllAccidents() {
        List<Accident> accidents = accidentService.getAllAccidents();
        return ResponseEntity.ok(accidents);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Accident> updateAccident(@PathVariable Long id, @RequestBody Accident accident) {
        Accident updatedAccident = accidentService.updateAccident(id, accident);
        return updatedAccident != null ? ResponseEntity.ok(updatedAccident) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccident(@PathVariable Long id) {
        accidentService.deleteAccident(id);
        return ResponseEntity.noContent().build();
    }
}
