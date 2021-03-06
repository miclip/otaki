package com.miclip.entity;

import java.util.Date;

public class Schedule  extends Identity{

    private String name;
    private String startTime;
    private int[] dayOfWeek;
    private int[] month;
    private int[] year;

    public Schedule()
    {}

    public Schedule(String name, String startTime, int[] dayOfWeek, int[] month, int[] year) {
        this.name = name;
        this.startTime = startTime;
        this.dayOfWeek = dayOfWeek;
        this.month = month;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int[] getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int[] dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int[] getMonth() {
        return month;
    }

    public void setMonth(int[] month) {
        this.month = month;
    }

    public int[] getYear() {
        return year;
    }

    public void setYear(int[] year) {
        this.year = year;
    }
}
