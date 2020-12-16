
package com.mm.planjson;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.List;

public class Courses implements Serializable, Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("classes")
    @Expose
    private List<Classes> classes = null;
    public final static Parcelable.Creator<Courses> CREATOR = new Creator<Courses>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Courses createFromParcel(Parcel in) {
            return new Courses(in);
        }

        public Courses[] newArray(int size) {
            return (new Courses[size]);
        }

    }
            ;
    private final static long serialVersionUID = 7928110068060658528L;

    protected Courses(Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.classes, (Classes.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Courses() {
    }

    /**
     *
     * @param classes
     * @param name
     */
    public Courses(String name, List<Classes> classes) {
        super();
        this.name = name;
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Classes> getClasses() {
        return classes;
    }

    public void setClasses(List<Classes> classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("name", name).append("classes", classes).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeList(classes);
    }

    public int describeContents() {
        return  0;
    }

}


//package com.mm.planjson;
//
//import java.util.List;
//
//public class Courses {
//
//    private String name;
//    List<Classes> classes;
//
//    public Courses(String name, List<Classes> classes) {
//        this.name = name;
//        this.classes = classes;
//    }
//}
