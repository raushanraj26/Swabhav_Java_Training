package com.monocept.HospitalPatientToken.model;

import java.util.*;

public class PatientManager {

    Set<Patient> patientSet = new HashSet<>(); // avoid duplicates

    Queue<Patient> generalQueue = new LinkedList<>();
    Queue<Patient> emergencyQueue = new LinkedList<>();

    Map<String, List<Patient>> departmentMap = new HashMap<>();

    // Add patient
    public void addPatient(Patient p, String department) {
        if (patientSet.add(p)) {

            // Queue logic
            if (p instanceof EmergencyPatient) {
                emergencyQueue.add(p);
            } else {
                generalQueue.add(p);
            }

            // Department mapping
            departmentMap
                .computeIfAbsent(department, k -> new ArrayList<>())
                .add(p);
            System.out.println("DOctor added successfully");

        } else {
            System.out.println("Duplicate patient not allowed: " + p.id);
        }
    }

    // Process next patient (Emergency first)
    public void processPatient() {
        Patient p;

        if (!emergencyQueue.isEmpty()) {
            p = emergencyQueue.poll();
        } else {
            p = generalQueue.poll();
        }

        if (p != null) {
            System.out.println("Processing: " + p);
        } else {
            System.out.println("No patients in queue");
        }
    }

    // Display all patients
    public void displayAll() {
        for (Patient p : patientSet) {
            System.out.println(p);
        }
    }

    // Department-wise display
    public void displayByDepartment(String dept) {
        List<Patient> list = departmentMap.get(dept);
        if (list != null) {
            for (Patient p : list) {
                System.out.println(p);
            }
        }else {
        System.out.println("No doctor found!");
        }
    }

    // Sort by age
    public void sortByAge() {
        List<Patient> list = new ArrayList<>(patientSet);
        list.sort((a, b) -> a.age - b.age);

        for (Patient p : list) {
            System.out.println(p);
        }
    }

    // Remove discharged patients (age > 60 example)
    public void removeDischarged() {
        Iterator<Patient> it = patientSet.iterator();

        while (it.hasNext()) {
            Patient p = it.next();
            if (p.age > 60) {
                it.remove();
                System.out.println("Removed: " + p);
            }
        }
    }
}