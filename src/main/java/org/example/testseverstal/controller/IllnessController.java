package org.example.testseverstal.controller;


import org.example.testseverstal.dto.IllnessDTO;
import org.example.testseverstal.dto.PatientDTO;
import org.example.testseverstal.entities.Illness;
import org.example.testseverstal.entities.Patient;
import org.example.testseverstal.repo.IllnessService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/illnesses")
public class IllnessController {
    private final IllnessService service;

    public IllnessController(IllnessService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public ResponseEntity<IllnessDTO> get(@RequestBody long id) {
        return ResponseEntity.ok(IllnessDTO.fromEntity(service.findById(id)));
    }

    @PostMapping
    public ResponseEntity<IllnessDTO> save(@RequestBody IllnessDTO dto) {
        Illness illness = service.save(IllnessDTO.toEntity(dto));
        return ResponseEntity.ok(IllnessDTO.fromEntity(illness));
    }

    @GetMapping
    public ResponseEntity<List<IllnessDTO>> getAll(){
        List<IllnessDTO> illnesses = service.findAll().stream()
                .map(IllnessDTO::fromEntity).toList();
        return ResponseEntity.ok(illnesses);
    }

    @PutMapping
    public ResponseEntity<Illness> update(@RequestBody IllnessDTO dto) {
        return ResponseEntity.ok(service.update(IllnessDTO.toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
