package com.miclip.dto;

import java.util.Date;
import java.util.List;

public class ProgramDto  {

    private String name;
    private String code;
    private List<InstructorDto> instructors;
    private Date startDate;
    private List<ScheduleDto> schedules;
    private List<SessionDto> sessions;
    private int duration;
    private int studentCapacity;
    private String location;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public List<SessionDto> getSessions() {
        return sessions;
    }

    public void setSessions(List<SessionDto> sessions) {
        this.sessions = sessions;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<InstructorDto> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<InstructorDto> instructors) {
        this.instructors = instructors;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public List<ScheduleDto> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<ScheduleDto> schedules) {
        this.schedules = schedules;
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


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}
