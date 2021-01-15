package com.mm.planjson;

import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;

public class ReadJson {

    private Context context;


    ArrayList<String> department = new ArrayList<>();
    ArrayList<String> field_of_study = new ArrayList<>();
    ArrayList<String> semester = new ArrayList<>();
    ArrayList<String> group = new ArrayList<>();
    ArrayList<String> subgroup = new ArrayList<>();
    Plan plan = null;
    public ReadJson(Context context) {
        this.context = context;
        getPlan();
    }
    public void getPlan(){
        Gson gson = new Gson();
        String json;
        try {
            InputStream inputStream = context.getAssets().open("teleinf_sem_V.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            json = new String(buffer, StandardCharsets.UTF_8);

            plan = gson.fromJson(json, Plan.class);
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public ArrayList<PlanItem> restoreFromJson(int day, String group, String subgroup) {

        Courses course;
        Lessons lesson;
        Schedule schedule;
        ArrayList<PlanItem> tmp = new ArrayList<>();
        ArrayList<PlanItem> schedule_plan = new ArrayList<>();
        boolean odd_week = true;
        String weeks;
        Calendar calender = Calendar.getInstance();
        int week_number = calender.get(Calendar.WEEK_OF_YEAR);
        if (week_number % 2 == 0){
            odd_week = false;
        }

        for (int i = 0; i < plan.getCourses().size(); i++) {
            course = plan.getCourses().get(i);
            for (int j = 0; j < course.getaClasses().size(); j++) {
                lesson = course.getaClasses().get(j);
                for (int k = 0; k < lesson.getSchedule().size(); k++) {
                    if (lesson.getSchedule().get(k).getWeeks().equals("odd") && odd_week){
                        weeks = "odd";
                    }else weeks = "even";
                    //if ((lesson.getSchedule().get(k).getGroup().equals(group) && (lesson.getSchedule().get(k).getSubgroup().equals(subgroup))) ||
                     //       (lesson.getSchedule().get(k).getGroup().equals("all") && (lesson.getSchedule().get(k).getSubgroup().equals("all")))) {
                    if ((lesson.getSchedule().get(k).getGroup().equals(group) && (lesson.getSchedule().get(k).getSubgroup().equals(subgroup)) && ((lesson.getSchedule().get(k).getWeeks().equals("all")) || lesson.getSchedule().get(k).getWeeks().equals(weeks))) ||
                            (lesson.getSchedule().get(k).getGroup().equals("all") && (lesson.getSchedule().get(k).getSubgroup().equals("all")) && ((lesson.getSchedule().get(k).getWeeks().equals("all")) || lesson.getSchedule().get(k).getWeeks().equals(weeks)))) {

                        schedule = lesson.getSchedule().get(k);
                        tmp.add(new PlanItem(schedule.getStartTime(), course.getName(), lesson.getSupervisor(), lesson.getRoom(), schedule.getDay(), schedule.getGroup(), schedule.getSubgroup(), schedule.getWeeks()));

                    }
                }
            }
        }

        for (int i = 0; i < tmp.size(); i++) {
            if (tmp.get(i).getDay() == day){
                schedule_plan.add(tmp.get(i));
            }
        }

        Collections.sort(schedule_plan, PlanItem.StuNameComparator);

        return schedule_plan;
    }


    public ArrayList<String> getDepartment() {
        department.add("Computing and Telecommunications");
        return department;
    }

    public ArrayList<String> getField_of_study() {
        field_of_study.add("ICT");
        return field_of_study;
    }

    public ArrayList<String> getSemester() {
        semester.add("V");
        return semester;
    }

    public ArrayList<String> getGroup() {
        Gson gson = new Gson();
        String json;
        Plan plan;

        try {
            InputStream inputStream = context.getAssets().open("teleinf_sem_V.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            json = new String(buffer, StandardCharsets.UTF_8);

            plan = gson.fromJson(json, Plan.class);
            Courses course;
            Lessons lesson;

            for (int i = 0; i < plan.getCourses().size(); i++) {
                course = plan.getCourses().get(i);
                for (int j = 0; j < course.getaClasses().size(); j++) {
                    lesson = course.getaClasses().get(j);
                    for (int k = 0; k < lesson.getSchedule().size(); k++) {
                        group.add(lesson.getSchedule().get(k).getGroup());
                    }
                }
            }

            ArrayList<String> group1 = new ArrayList<String>(new HashSet<String>(group));
            group1.remove("all");
            Collections.sort(group1);

            return group1;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> getSubgroup() {
        Gson gson = new Gson();
        String json;
        Plan plan;

        try {
            InputStream inputStream = context.getAssets().open("teleinf_sem_V.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            json = new String(buffer, StandardCharsets.UTF_8);

            plan = gson.fromJson(json, Plan.class);
            Courses course;
            Lessons lesson;

            for (int i = 0; i < plan.getCourses().size(); i++) {
                course = plan.getCourses().get(i);
                for (int j = 0; j < course.getaClasses().size(); j++) {
                    lesson = course.getaClasses().get(j);
                    for (int k = 0; k < lesson.getSchedule().size(); k++) {
                        subgroup.add(lesson.getSchedule().get(k).getSubgroup());
                    }
                }
            }

            ArrayList<String> subgroup1 = new ArrayList<String>(new HashSet<String>(subgroup));
            subgroup1.remove("all");
            Collections.sort(subgroup1);

            return subgroup1;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }


}