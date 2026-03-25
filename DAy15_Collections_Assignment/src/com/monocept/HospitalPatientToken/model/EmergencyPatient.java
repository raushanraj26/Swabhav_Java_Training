package com.monocept.HospitalPatientToken.model;


public class EmergencyPatient extends Patient {

    public EmergencyPatient(int id, String name, int age) {
        super(id, name, age);
    }

    @Override
    public String getType() {
        return "Emergency";
    }
}