package org.example.testseverstal.controller;

import org.example.testseverstal.dto.PatientDTO;
import org.example.testseverstal.entities.Patient;
import org.example.testseverstal.repo.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService service;

    public PatientController(PatientService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> get(@PathVariable long id) {
        return ResponseEntity.ok(PatientDTO.fromEntity(service.findById(id)));
    }

    @PostMapping
    public ResponseEntity<PatientDTO> save(@RequestBody PatientDTO dto) {
        Patient patient = service.save(PatientDTO.toEntity(dto));
        return ResponseEntity.ok(PatientDTO.fromEntity(patient));
    }

    @GetMapping
    public ResponseEntity<List<PatientDTO>> getAll(){
        List<PatientDTO> patients= service.findAll().stream()
                .map(PatientDTO::fromEntity).toList();
        return ResponseEntity.ok(patients);
    }

    @PutMapping
    public ResponseEntity<Patient> update(@RequestBody PatientDTO dto) {
        return ResponseEntity.ok(service.update(PatientDTO.toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
