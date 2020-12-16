
package com.mm.planjson;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;


public class Classes implements Serializable, Parcelable
{

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("room")
    @Expose
    private String room;
    @SerializedName("supervisor")
    @Expose
    private String supervisor;
    @SerializedName("schedule")
    @Expose
    private List<Schedule> schedule = null;
    public final static Parcelable.Creator<Classes> CREATOR = new Creator<Classes>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Classes createFromParcel(Parcel in) {
            return new Classes(in);
        }

        public Classes[] newArray(int size) {
            return (new Classes[size]);
        }

    }
            ;
    private final static long serialVersionUID = -4916457578812788858L;

    protected Classes(Parcel in) {
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.room = ((String) in.readValue((String.class.getClassLoader())));
        this.supervisor = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.schedule, (com.mm.planjson.Schedule.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Classes() {
    }

    /**
     *
     * @param schedule
     * @param type
     * @param room
     * @param supervisor
     */
    public Classes(String type, String room, String supervisor, List<Schedule> schedule) {
        super();
        this.type = type;
        this.room = room;
        this.supervisor = supervisor;
        this.schedule = schedule;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public List<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Schedule> schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("type", type).append("room", room).append("supervisor", supervisor).append("schedule", schedule).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(type);
        dest.writeValue(room);
        dest.writeValue(supervisor);
        dest.writeList(schedule);
    }

    public int describeContents() {
        return  0;
    }

}



//package com.mm.planjson;
//
//import java.util.List;
//
//public class Classes {
//
//    private String type;
//    private String room;
//    private String supervisor;
//    private List <Schedule> schedule;
//
//    public Classes(String type, String room, String supervisor, List<Schedule> schedule) {
//        this.type = type;
//        this.room = room;
//        this.supervisor = supervisor;
//        this.schedule = schedule;
//    }
//}
