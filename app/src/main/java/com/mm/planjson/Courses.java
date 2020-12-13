package com.mm.planjson;

import java.util.List;

public class Courses {

    private String name;
    List<Classes> classes;

    public Courses(String name, List<Classes> classes) {
        this.name = name;
        this.classes = classes;
    }
}
