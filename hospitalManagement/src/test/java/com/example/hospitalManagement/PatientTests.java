package com.example.hospitalManagement;

import com.example.hospitalManagement.Entity.Patient;
import com.example.hospitalManagement.Service.PatientService;
import com.example.hospitalManagement.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTests {
    //its basically the j-unit testing which will run like springboot which wriiten with @test'
    @Autowired
    private  PatientRepository patientRepository;
    @Autowired
    private PatientService patientService;
    @Test
    public void TestPatientRepository(){
        //IMP:-> There will be always void type inside TEST
       List<Patient> patientList =  patientRepository.findAll();
       System.out.println(patientList);
        Patient p1 = new Patient();
        patientRepository.save(p1);
    }
    @Test
    public void testTransactionMethods(){
        Patient p1 = patientService.getPatientById(1L);
        System.out.println(p1);
        Patient patient = patientRepository.findByName("Deepika Rao");
        System.out.println(patient);
        List<Patient> patientList = patientRepository.findByBirthDateOrEmail(LocalDate.of(1990,03,14),"vinayak.desai@example.com");
        System.out.println(patientList);
        //ANYWHERE %'RA'$ ->
        List<Patient> patientNameList = patientRepository.findByNameContaining("Ra");
        System.out.println(patientNameList);
        //DESECENDING ORDER->
        List<Patient> patientNamedESCList = patientRepository.findAllByOrderByIdDesc();
        System.out.println(patientNamedESCList);
        //jpql->
        List<Patient> patientsbloodgr = patientRepository.findByBloodGroup();
        System.out.print(patientsbloodgr);
    }

}
