package org.example.testseverstal.repo;


import jakarta.persistence.EntityNotFoundException;
import org.example.testseverstal.entities.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepo repo;
    private final PatientRepo patientRepo;
    private final DoctorRepo doctorRepo;
    private final IllnessRepo illnessRepo;

    public AppointmentService(AppointmentRepo repo,
                              PatientRepo patientRepo,
                              DoctorRepo doctorRepo,
                              IllnessRepo illnessRepo) {
        this.repo = repo;
        this.patientRepo = patientRepo;
        this.doctorRepo = doctorRepo;
        this.illnessRepo = illnessRepo;
    }

    public Appointment save(Appointment appointment) {
        if (appointment.getDoctor() == null || appointment.getDoctor().getId() == null)
            throw new IllegalArgumentException("Doctor id is required");

        if (appointment.getPatient() == null || appointment.getPatient().getId() == null)
            throw new IllegalArgumentException("Patient id is required");

        if (appointment.getIllness() == null || appointment.getIllness().getId() == null)
            throw new IllegalArgumentException("Illness id is required");

        appointment.setDoctor(doctorRepo.findById(appointment.getDoctor().getId())
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found")));
        appointment.setPatient(patientRepo.findById(appointment.getPatient().getId())
                .orElseThrow(() -> new EntityNotFoundException("Patient not found")));
        appointment.setIllness(illnessRepo.findById(appointment.getIllness().getId())
                .orElseThrow(() -> new EntityNotFoundException("Illness not found")));

        return repo.save(appointment);
    }


    public List<Appointment> findAll() {
        return repo.findAll();
    }
    public Appointment findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Appointment not found with id" + id));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Appointment update(Appointment appointment) {
        Appointment existing = repo.findById(appointment.getId())
                .orElseThrow(() -> new EntityNotFoundException("Appointment not found with id " + appointment.getId()));

        existing.setDoctor(doctorRepo.findById(appointment.getDoctor().getId())
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found")));
        existing.setPatient(patientRepo.findById(appointment.getPatient().getId())
                .orElseThrow(() -> new EntityNotFoundException("Patient not found")));
        existing.setIllness(illnessRepo.findById(appointment.getIllness().getId())
                .orElseThrow(() -> new EntityNotFoundException("Illness not found")));
        existing.setVisitDate(appointment.getVisitDate());

        return repo.save(existing);
    }


}
