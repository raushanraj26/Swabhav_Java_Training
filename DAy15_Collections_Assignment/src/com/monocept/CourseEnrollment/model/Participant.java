package com.monocept.CourseEnrollment.model;


public abstract class Participant implements Comparable<Participant> {

    protected int id;
    protected String name;
    protected String track;

    public Participant(int id, String name, String track) {
        this.id = id;
        this.name = name;
        this.track = track;
    }

    public int getId() {
        return id;
    }

    public String getTrack() {
        return track;
    }

    public String getName() {
        return name;
    }

    // Natural ordering → by ID
    @Override
    public int compareTo(Participant p) {
        return this.id - p.id;
    }

    // Prevent duplicate
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Participant)) return false;

        Participant p = (Participant) obj;
        return this.id == p.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + track;
    }
}