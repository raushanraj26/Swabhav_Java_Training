package com.monocept.HospitalAppointment.model;


public class DiagnosticTest extends Service {

    public DiagnosticTest(int serviceId, String patientName, double consultationFee)
            throws InvalidServiceException {

        super(serviceId, patientName, consultationFee);
    }

    @Override
    public boolean validateService() {
        return consultationFee >= 500;
    }

    @Override
    public void processService() {

        System.out.println("Processing Diagnostic Test...");
        display();
        System.out.println("Lab technician assigned.");

    }

}
