package com.example.hospitalManagement.repository;

import com.example.hospitalManagement.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

    Patient findByName(String name);
    Patient findByBirthDate(LocalDate date);
    //expanding JPQL Methods
    List<Patient> findByBirthDateOrEmail(LocalDate date,String Email);

    List<Patient> findByNameContaining(String query);


    List<Patient> findAllByOrderByIdDesc();
    @Query("select * from patient where bloodgroup='O_NEGATIVE'")
    List<Patient> findByBloodGroup();
}
