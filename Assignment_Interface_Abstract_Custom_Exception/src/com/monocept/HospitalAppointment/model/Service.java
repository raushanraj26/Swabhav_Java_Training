package com.monocept.HospitalAppointment.model;

public abstract class Service implements ServiceValidation {

    protected int serviceId;
    protected String patientName;
    protected double consultationFee;

    static {
        System.out.println("Hospital configuration loaded...");
    }

    public Service(int serviceId, String patientName, double consultationFee) throws InvalidServiceException {

        if(serviceId <= 0)
            throw new InvalidServiceException("Invalid Service ID");

        if(consultationFee < 0)
            throw new InvalidServiceException("Consultation Fee cannot be negative");

        this.serviceId = serviceId;
        this.patientName = patientName;
        this.consultationFee = consultationFee;
    }

    public abstract void processService();

    public void display() {
        System.out.println("Service ID: " + serviceId);
        System.out.println("Patient Name: " + patientName);
        System.out.println("Consultation Fee: " + consultationFee);
    }

}
