package com.example.hospitalManagement.repository;

import com.example.hospitalManagement.DTO.PatientAccordingtoBloodgr;
import com.example.hospitalManagement.Entity.BloodGroupType;
import com.example.hospitalManagement.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
    @Query("select p from Patient p where p.Bloodgroup= :Bloodgroup")
    List<Patient> findByBloodGroup(@Param("Bloodgroup")BloodGroupType bloodGroupType);
    //birthdate after certain date
    @Query("select p from Patient p where p.birthDate > :birthDate")
    List<Patient>  findByBornAfterDate(@Param("birthDate") LocalDate birthDate);
    /// WE WANT THIS->
//   SELECT bloodgroup,count(*) FROM patient
//    WHERE bloodgroup is NOT NULL
//    GROUP BY bloodgroup
//    ORDER BY bloodgroup ;  --->>SO A GROUP OF ARRAY WILL RETURNED BESY USE->OBJECT
    @Query("select new com.example.hospitalManagement.DTO.PatientAccordingtoBloodgr" +
            "(" +
            "p.Bloodgroup,count(p) )FROM Patient p where p.Bloodgroup IS NOT NULL GROUP BY p.Bloodgroup ORDER BY p.Bloodgroup ")
    List<PatientAccordingtoBloodgr> totalCountBloodGrwise();
    //NOTE:-> With new → Hibernate directly calls your constructor
    //usuing native query ->
    @Query(value = "select * from Patient", nativeQuery = true)
    List<Patient> findAllPatients();
}
