package org.example.testseverstal.controller;


import org.example.testseverstal.dto.AppointmentDTO;
import org.example.testseverstal.entities.Appointment;
import org.example.testseverstal.repo.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentService service;

    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> get(@PathVariable long id) {
        return ResponseEntity.ok(AppointmentDTO.fromEntity(service.findById(id)));
    }

    @PostMapping
    public ResponseEntity<AppointmentDTO> save(@RequestBody AppointmentDTO dto) {
        Appointment appointment = service.save(AppointmentDTO.toEntity(dto));
        return ResponseEntity.status(201).body(AppointmentDTO.fromEntity(appointment));
    }

    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> getAll(){
        List<AppointmentDTO> appointment = service.findAll().stream()
                .map(AppointmentDTO::fromEntity).toList();
        return ResponseEntity.ok(appointment);
    }

    @PutMapping
    public ResponseEntity<AppointmentDTO> update(@RequestBody AppointmentDTO dto) {
        Appointment appointment = AppointmentDTO.toEntity(dto);
        Appointment updated = service.update(appointment);
        return ResponseEntity.ok(AppointmentDTO.fromEntity(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
