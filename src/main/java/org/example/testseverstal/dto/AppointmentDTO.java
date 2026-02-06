package org.example.testseverstal.dto;

import lombok.Data;
import org.example.testseverstal.entities.Appointment;
import org.example.testseverstal.entities.Doctor;
import org.example.testseverstal.entities.Illness;
import org.example.testseverstal.entities.Patient;

import java.time.LocalDateTime;

@Data
public class AppointmentDTO {
    private Long id;
    private Patient patient;
    private Doctor doctor;
    private Illness illness;
    private LocalDateTime visitDate;

    public static AppointmentDTO fromEntity(Appointment appointment) {
        if (appointment == null) {
            return null;
        }
        AppointmentDTO appointmentDTO = new AppointmentDTO();
        appointmentDTO.setId(appointment.getId());
        appointmentDTO.setPatient(appointment.getPatient());
        appointmentDTO.setDoctor(appointment.getDoctor());
        appointmentDTO.setIllness(appointment.getIllness());
        appointmentDTO.setVisitDate(appointment.getVisitDate());
        return appointmentDTO;
    }

    public static Appointment toEntity(AppointmentDTO appointmentDTO) {
        if (appointmentDTO == null) {
            return null;
        }

        Appointment appointment = new Appointment();
        appointment.setId(appointmentDTO.getId());
        appointment.setPatient(appointmentDTO.getPatient());
        appointment.setDoctor(appointmentDTO.getDoctor());
        appointment.setIllness(appointmentDTO.getIllness());
        appointment.setVisitDate(
                appointmentDTO.getVisitDate() != null
                        ? appointmentDTO.getVisitDate()
                        : LocalDateTime.now()
        );
        return appointment;
    }
}
