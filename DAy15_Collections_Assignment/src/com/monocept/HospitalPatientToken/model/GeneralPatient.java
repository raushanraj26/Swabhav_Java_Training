package com.monocept.HospitalPatientToken.model;

public class GeneralPatient extends Patient {

    public GeneralPatient(int id, String name, int age) {
        super(id, name, age);
    }

    @Override
    public String getType() {
        return "General";
    }
}
