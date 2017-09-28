package com.miclip.dto;

import java.util.Date;
import java.util.List;

public class SessionDto {

    private List<InstructorDto> instructors;
    private String code;
    private Date startDateTime;
    private int duration;
    private int studentCapacity;
    private String location;
    private List<StudentDto> students;

    public List<InstructorDto> getInstructorDtos() {
        return instructors;
    }

    public void setInstructors(List<InstructorDto> instructors) {
        this.instructors = instructors;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getStudentCapacity() {
        return studentCapacity;
    }

    public void setStudentCapacity(int studentCapacity) {
        this.studentCapacity = studentCapacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<StudentDto> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDto> students) {
        this.students = students;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}
