package com.monocept.CourseEnrollment.model;



public class RegularParticipant extends Participant {

    public RegularParticipant(int id, String name, String track) {
        super(id, name, track);
    }

    @Override
    public String toString() {
        return super.toString() + " | Regular";
    }
}
