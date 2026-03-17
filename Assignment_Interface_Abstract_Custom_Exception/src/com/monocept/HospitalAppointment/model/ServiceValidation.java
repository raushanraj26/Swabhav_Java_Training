package com.monocept.HospitalAppointment.model;

public interface ServiceValidation {

    boolean validateService() throws InvalidServiceException;

}
