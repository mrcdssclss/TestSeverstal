package org.example.testseverstal.controller;

import org.example.testseverstal.dto.DoctorDTO;
import org.example.testseverstal.entities.Doctor;
import org.example.testseverstal.repo.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/doctors")
public class DoctorController{

    private final DoctorService service;

    public DoctorController(DoctorService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDTO> get(@PathVariable long id) {
        return ResponseEntity.ok(DoctorDTO.fromEntity(service.findById(id)));
    }


    @PostMapping
    public ResponseEntity<DoctorDTO> save(@RequestBody DoctorDTO dto) {
        Doctor doctor = service.save(DoctorDTO.toEntity(dto));
        return ResponseEntity.ok(DoctorDTO.fromEntity(doctor));
    }

    @GetMapping
    public ResponseEntity<List<DoctorDTO>> getAll(){
        List<DoctorDTO> doctors = service.findAll().stream()
                .map(DoctorDTO::fromEntity).toList();
        return ResponseEntity.ok(doctors);
    }

    @PutMapping
    public ResponseEntity<Doctor> update(@RequestBody DoctorDTO dto) {
        Doctor doctor = DoctorDTO.toEntity(dto);
        return ResponseEntity.ok(service.update(doctor));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
