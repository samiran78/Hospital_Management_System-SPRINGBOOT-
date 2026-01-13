package com.example.hospitalManagement.Service;

import com.example.hospitalManagement.Entity.Patient;
import com.example.hospitalManagement.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {
    @Autowired
    private  PatientRepository patientRepository;
    public Patient getPatientById(Long id){
       Patient p1 =  patientRepository.findById(id).orElseThrow();
       Patient p2 =  patientRepository.findById(id).orElseThrow();
       return  p1;
    }

}
