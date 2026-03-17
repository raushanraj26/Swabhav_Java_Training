package com.monocept.HospitalAppointment.model;



public class Surgery extends Service {

    public Surgery(int serviceId, String patientName, double consultationFee)
            throws InvalidServiceException {

        super(serviceId, patientName, consultationFee);
    }

    @Override
    public boolean validateService() {
        return consultationFee >= 5000;
    }

    @Override
    public void processService() {

        System.out.println("Processing Surgery Service...");
        display();
        System.out.println("Operation theatre scheduled.");

    }

}