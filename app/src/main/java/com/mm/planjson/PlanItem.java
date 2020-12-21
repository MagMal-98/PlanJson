package com.mm.planjson;

public class PlanItem {

    private String mHour;
    private String mName;
    private String mSupervisor;
    private String mRoom;

    public PlanItem(String hour, String name, String supervisor, String room) {
        mHour = hour;
        mName = name;
        mSupervisor = supervisor;
        mRoom = room;
    }

    public String getHour() {
        return mHour;
    }

    public String getName() {
        return mName;
    }

    public String getSupervisor() {
        return mSupervisor;
    }

    public String getRoom() {
        return mRoom;
    }
}