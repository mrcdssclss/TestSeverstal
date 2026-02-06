package org.example.testseverstal.dto;

import lombok.Data;
import org.example.testseverstal.entities.Patient;

@Data
public class PatientDTO {
    private Long id;
    private String name;
    private String owner;
    private int age;

    public static PatientDTO fromEntity (Patient patient) {
        if (patient == null) {
            return null;
        }
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(patient.getId());
        patientDTO.setName(patient.getName());
        patientDTO.setOwner(patient.getOwner());
        patientDTO.setAge(patient.getAge());
        return patientDTO;
    }

    public static Patient toEntity (PatientDTO patientDTO) {
        if (patientDTO == null) {
            return null;
        }
        Patient patient = new Patient();
        patient.setId(patientDTO.getId());
        patient.setName(patientDTO.getName());
        patient.setOwner(patientDTO.getOwner());
        patient.setAge(patientDTO.getAge());
        return patient;
    }
}
