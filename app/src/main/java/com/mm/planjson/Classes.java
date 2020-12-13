package com.mm.planjson;

import java.util.List;

public class Classes {

    private String type;
    private String room;
    private String supervisor;
    private List <Schedule> schedule;

    public Classes(String type, String room, String supervisor, List<Schedule> schedule) {
        this.type = type;
        this.room = room;
        this.supervisor = supervisor;
        this.schedule = schedule;
    }
}
