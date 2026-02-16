package com.example.hospitalManagement.Entity;

import jakarta.persistence.*;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(

        name = "Patient", uniqueConstraints = {
        @UniqueConstraint(name = "unique_patient_tbl_email",columnNames = {"email"}),
        @UniqueConstraint(name = "Unique_patient_tbl_name_birthDate", columnNames = {"patient_name","birthDate"})
},
        indexes = {
                @Index(name = "idx_patient_name_birthDate",columnList = "birthDate")
        }

)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(name = "patient_name", nullable = false,length = 255)
    private  String name;
    @ToString.Exclude
    @Column(name = "birthDate")
    private LocalDate birthDate;
    @Column(unique = true,nullable = false)
    private String email;
    private String gender;
    @ToString.Exclude
    private String Bloodgroup;
    @CreationTimestamp
    @Column(updatable = false)
//    updateable=false makes sure that in future this createdAt will never change.
    private LocalDateTime createdAt;
}
