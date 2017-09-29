package com.miclip.entity;

import java.util.Date;

public class Student extends Identity {


    private String name;
    private Date joinedDate;
    private Date birthDate;
    private boolean waived;
    private boolean agreedTerms;

    public Student(){

    }

    public Student(String name, Date joinedDate, Date birthDate, boolean waived, boolean agreedTerms) {
        this.name = name;
        this.joinedDate = joinedDate;
        this.birthDate = birthDate;
        this.waived = waived;
        this.agreedTerms = agreedTerms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isWaived() {
        return waived;
    }

    public void setWaived(boolean waived) {
        this.waived = waived;
    }

    public boolean isAgreedTerms() {
        return agreedTerms;
    }

    public void setAgreedTerms(boolean agreedTerms) {
        this.agreedTerms = agreedTerms;
    }
}
