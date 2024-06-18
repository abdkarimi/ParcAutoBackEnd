package com.example.parcautobackend.controllers;

import com.example.parcautobackend.model.entities.Concessionnaire;
import com.example.parcautobackend.Service.ConcessionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/AULSH/concessionnaires")
public class ConcessionnaireController {

    @Autowired
    private ConcessionnaireService concessionnaireService;

    @PostMapping
    public ResponseEntity<Concessionnaire> createConcessionnaire(@RequestBody Concessionnaire concessionnaire) {
        Concessionnaire savedConcessionnaire = concessionnaireService.saveConcessionnaire(concessionnaire);
        return ResponseEntity.ok(savedConcessionnaire);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Concessionnaire> getConcessionnaireById(@PathVariable Long id) {
        Optional<Concessionnaire> concessionnaire = concessionnaireService.getConcessionnaireById(id);
        return concessionnaire.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Concessionnaire>> getAllConcessionnaires() {
        List<Concessionnaire> concessionnaires = concessionnaireService.getAllConcessionnaires();
        return ResponseEntity.ok(concessionnaires);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Concessionnaire> updateConcessionnaire(@PathVariable Long id, @RequestBody Concessionnaire concessionnaire) {
        Concessionnaire updatedConcessionnaire = concessionnaireService.updateConcessionnaire(id, concessionnaire);
        return updatedConcessionnaire != null ? ResponseEntity.ok(updatedConcessionnaire) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConcessionnaire(@PathVariable Long id) {
        concessionnaireService.deleteConcessionnaire(id);
        return ResponseEntity.noContent().build();
    }
}
