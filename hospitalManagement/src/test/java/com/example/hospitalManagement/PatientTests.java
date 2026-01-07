package com.example.hospitalManagement;

import com.example.hospitalManagement.Entity.Patient;
import com.example.hospitalManagement.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTests {
    //its basically the j-unit testing which will run like springboot which wriiten with @test'
    @Autowired
    private  PatientRepository patientRepository;
    @Test
    public void TestPatientRepository(){
        //IMP:-> There will be always void type inside TEST
       List<Patient> patientList =  patientRepository.findAll();
    }
}
