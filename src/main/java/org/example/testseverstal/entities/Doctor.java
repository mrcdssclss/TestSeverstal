package org.example.testseverstal.entities;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;
}
