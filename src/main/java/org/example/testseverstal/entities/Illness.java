package org.example.testseverstal.entities;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "illnesses")
public class Illness {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
}
