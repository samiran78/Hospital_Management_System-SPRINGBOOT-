package com.example.hospitalManagement.Entity;

import jakarta.persistence.*;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(

        name = "patient_tbl", uniqueConstraints = {
        @UniqueConstraint(name = "unique_patient_tbl_email",columnNames = {"email"}),
        @UniqueConstraint(name = "Unique_patient_tbl_name_birthDate", columnNames = {"name","birthDate"})
},
        indexes = {
                @Index(name = "idx_patient_name_birthDate",columnList = "birthDate")
        }

)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(name = "patient_name", nullable = false,length = 255,scale = )
    private  String name;
    @ToString.Exclude
    private LocalDate birthDate;
    @Column(unique = true,nullable = false)
    private String email;
    private String gender;
    @CreationTimestamp
    private LocalDateTime createdAt;
}
