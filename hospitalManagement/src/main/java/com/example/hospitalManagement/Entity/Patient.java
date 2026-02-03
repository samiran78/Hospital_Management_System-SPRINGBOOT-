package com.example.hospitalManagement.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "patient")
@UniqueConstraint(name = "unique_patient_email",columnNames = {"email"}),
@UniqueConstraint()
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String name;
    private LocalDate birthDate;
    private String email;
    private String gender;
}
