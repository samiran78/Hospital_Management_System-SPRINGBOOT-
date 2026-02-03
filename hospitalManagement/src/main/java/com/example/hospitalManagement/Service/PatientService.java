package com.example.hospitalManagement.Service;

import com.example.hospitalManagement.Entity.Patient;
import com.example.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {
    @Autowired
    private  PatientRepository patientRepository;
    @Transactional
    public Patient getPatientById(Long id){
        //usuing patientRepo for findbyID
       Patient p1 =  patientRepository.findById(id).orElseThrow();
       Patient p2 =  patientRepository.findById(id).orElseThrow();
       System.out.println(p1==p2);
       return  p1;
    }

}
