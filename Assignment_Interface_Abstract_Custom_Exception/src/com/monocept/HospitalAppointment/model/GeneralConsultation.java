package com.monocept.HospitalAppointment.model;



public class GeneralConsultation extends Service {

    public GeneralConsultation(int serviceId, String patientName, double consultationFee) 
            throws InvalidServiceException {

        super(serviceId, patientName, consultationFee);
    }

    @Override
    public boolean validateService() {
        return consultationFee >= 200;
    }

    @Override
    public void processService() {

        System.out.println("Processing General Consultation...");
        display();
        System.out.println("Doctor assigned for consultation.");

    }

}
