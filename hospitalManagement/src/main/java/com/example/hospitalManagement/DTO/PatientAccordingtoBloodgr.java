package com.example.hospitalManagement.DTO;

import com.example.hospitalManagement.Entity.BloodGroupType;

public class PatientAccordingtoBloodgr {
    private BloodGroupType bloodGroupType;
    private Long count;

//constructor initllization
    public  PatientAccordingtoBloodgr(BloodGroupType bloodGroupType,Long count){
        this.bloodGroupType=bloodGroupType;
        this.count=count;
    }

//    public void setBloodGroupType(BloodGroupType bloodGroupType) {
//        this.bloodGroupType = bloodGroupType;
//    }
//
//    public void setCount(Long count) {
//        this.count = count;
//    }
//    There is:
//
//    no constructor
//
//    no field alias metadata
//
//    no mapping rule
//
//    no EntityManager mapping configuration
//
//    Hibernate has zero information on how to fill it.
//
//    So it gives you raw Tuple.
//    Spring fails to convert Tuple → DTO.
//            Exception.
public BloodGroupType getBloodGroupType() {
    return bloodGroupType;
}

    public Long getCount() {
        return count;
    }

}
