package org.example.testseverstal.dto;

import lombok.Data;
import org.example.testseverstal.entities.Doctor;

@Data
public class DoctorDTO {

    private Long id;
    private String name;
    private String surname;

    public static DoctorDTO fromEntity(Doctor doctor) {
        if (doctor == null) {
            return null;
        }
        DoctorDTO doctorDTO = new DoctorDTO();
        doctorDTO.setId(doctor.getId());
        doctorDTO.setName(doctor.getName());
        doctorDTO.setSurname(doctor.getSurname());
        return doctorDTO;
    }

    public static Doctor toEntity(DoctorDTO doctorDTO) {
        if (doctorDTO == null) {
            return null;
        }
        Doctor doctor = new Doctor();
        doctor.setId(doctorDTO.getId());
        doctor.setName(doctorDTO.getName());
        doctor.setSurname(doctorDTO.getSurname());
        return doctor;
    }
}
