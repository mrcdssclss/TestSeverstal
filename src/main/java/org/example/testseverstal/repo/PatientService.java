package org.example.testseverstal.repo;


import jakarta.persistence.EntityNotFoundException;
import org.example.testseverstal.entities.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepo repo;

    public PatientService(PatientRepo repo) {
        this.repo = repo;
    }

    public List<Patient> findAll() {
        return repo.findAll();
    }

    public Patient findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Patient save(Patient patient) {
        return repo.save(patient);
    }

    public Patient update(Patient patient) {
        Patient existing = repo.findById(patient.getId())
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id " + patient.getId()));
        existing.setName(patient.getName());
        existing.setOwner(patient.getOwner());
        existing.setAge(patient.getAge());
        return repo.save(existing);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
 }
