package com.mm.planjson;

public class Schedule {
    private String day;
    private String startTime;
    private String duration;
    private String weeks;
    private String group;
    private String subgroup;


    public Schedule(String day, String startTime, String duration, String weeks, String group, String subgroup) {
        this.day = day;
        this.startTime = startTime;
        this.duration = duration;
        this.weeks = weeks;
        this.group = group;
        this.subgroup = subgroup;
    }

}
