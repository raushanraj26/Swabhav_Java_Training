package com.monocept.HospitalPatientToken.model;

import java.util.Objects;

public abstract class Patient {
    int id;
    String name;
    int age;

    public Patient(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public abstract String getType();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Patient)) return false;
        Patient p = (Patient) obj;
        return this.id == p.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id + " " + name + " Age:" + age + " Type:" + getType();
    }
}
