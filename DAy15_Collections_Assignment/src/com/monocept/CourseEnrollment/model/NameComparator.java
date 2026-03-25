package com.monocept.CourseEnrollment.model;


import java.util.Comparator;


public class NameComparator implements Comparator<Participant> {

    @Override
    public int compare(Participant p1, Participant p2) {
        return p1.getName().compareTo(p2.getName());
    }
}