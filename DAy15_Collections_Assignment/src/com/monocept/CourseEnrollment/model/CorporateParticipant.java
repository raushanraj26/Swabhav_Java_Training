package com.monocept.CourseEnrollment.model;


public class CorporateParticipant extends Participant {

    private String companyName;

    public CorporateParticipant(int id, String name, String track, String companyName) {
        super(id, name, track);
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return super.toString() + " | Corporate | " + companyName;
    }
}