package org.example.testseverstal.repo;

import jakarta.persistence.EntityNotFoundException;
import org.example.testseverstal.entities.Doctor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepo repo;

    public DoctorService(DoctorRepo repo) {
        this.repo = repo;
    }

    public List<Doctor> findAll() {
        return repo.findAll();
    }

    public Doctor findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Doctor save(Doctor doctor) {
        return repo.save(doctor);
    }
    public Doctor update(Doctor doctor) {
        Doctor existing = repo.findById(doctor.getId())
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found with id " + doctor.getId()));
        existing.setName(doctor.getName());
        existing.setSurname(doctor.getSurname());
        return repo.save(existing);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
