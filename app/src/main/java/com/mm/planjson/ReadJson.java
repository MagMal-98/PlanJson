package com.mm.planjson;

import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;

public class ReadJson {

    private Context context;
    ArrayList<PlanItem> I1rightMon = new ArrayList<>();
    ArrayList<PlanItem> tmp = new ArrayList<>();

    public ReadJson(Context context) {
        this.context = context;
    }

    public ArrayList<PlanItem> restoreFromJson(int day, String group, String subgroup) {
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

            Courses coursesMOIWSP = plan.getCourses().get(0);
            Courses coursesBD = plan.getCourses().get(1);
            Courses coursesWDM = plan.getCourses().get(2);
            Courses coursesBSD = plan.getCourses().get(3);
            Courses coursesSSIZ = plan.getCourses().get(4);
            Courses coursesSSO = plan.getCourses().get(5);
            Courses coursesPM = plan.getCourses().get(6);

            Lessons MOIWSPLecture = coursesMOIWSP.getaClasses().get(0);
            Lessons MOIWSPLab = coursesMOIWSP.getaClasses().get(1);

            Lessons BDLecture = coursesBD.getaClasses().get(0);
            Lessons BDLab1 = coursesBD.getaClasses().get(1);
            Lessons BDLab2 = coursesBD.getaClasses().get(2);

            Lessons WDMLecture = coursesWDM.getaClasses().get(0);
            Lessons WDMLab1 = coursesWDM.getaClasses().get(1);
            Lessons WDMLab2 = coursesWDM.getaClasses().get(2);
            Lessons WDMLab3 = coursesWDM.getaClasses().get(3);

            Lessons BSDLecture = coursesBSD.getaClasses().get(0);
            Lessons BSDLab1 = coursesBSD.getaClasses().get(1);
            Lessons BSDLab2 = coursesBSD.getaClasses().get(2);

            Lessons SSIZLecture = coursesSSIZ.getaClasses().get(0);
            Lessons SSIZLab = coursesSSIZ.getaClasses().get(1);

            Lessons SSOLecture = coursesSSO.getaClasses().get(0);
            Lessons SSOLab = coursesSSO.getaClasses().get(1);

            Lessons PMLecture = coursesPM.getaClasses().get(0);
            Lessons PMLab1 = coursesPM.getaClasses().get(1);
            Lessons PMLab2 = coursesPM.getaClasses().get(2);

            Schedule MOIWSPLectureS = MOIWSPLecture.getSchedule().get(0);
            Schedule MOIWSPLabS1 = MOIWSPLab.getSchedule().get(0);
            Schedule MOIWSPLabS2 = MOIWSPLab.getSchedule().get(1);
            Schedule MOIWSPLabS3 = MOIWSPLab.getSchedule().get(2);
            Schedule MOIWSPLabS4 = MOIWSPLab.getSchedule().get(3);
            Schedule MOIWSPLabS5 = MOIWSPLab.getSchedule().get(4);
            Schedule MOIWSPLabS6 = MOIWSPLab.getSchedule().get(5);

            Schedule BDLectureS = BDLecture.getSchedule().get(0);
            Schedule BDLab1S1 = BDLab1.getSchedule().get(0);
            Schedule BDLab1S2 = BDLab1.getSchedule().get(1);
            Schedule BDLab2S1 = BDLab2.getSchedule().get(0);
            Schedule BDLab2S2 = BDLab2.getSchedule().get(1);
            Schedule BDLab2S3 = BDLab2.getSchedule().get(2);
            Schedule BDLab2S4 = BDLab2.getSchedule().get(3);

            Schedule WDMLectureS = WDMLecture.getSchedule().get(0);
            Schedule WDMLab1S1 = WDMLab1.getSchedule().get(0);
            Schedule WDMLab1S2 = WDMLab1.getSchedule().get(1);
            Schedule WDMLab1S3 = WDMLab1.getSchedule().get(2);
            Schedule WDMLab1S4 = WDMLab1.getSchedule().get(3);
            Schedule WDMLab2S = WDMLab2.getSchedule().get(0);
            Schedule WDMLab3S = WDMLab3.getSchedule().get(0);

            Schedule BSDLectureS = BSDLecture.getSchedule().get(0);
            Schedule BSDLab1S1 = BSDLab1.getSchedule().get(0);
            Schedule BSDLab1S2 = BSDLab1.getSchedule().get(1);
            Schedule BSDLab1S3 = BSDLab1.getSchedule().get(2);
            Schedule BSDLab1S4 = BSDLab1.getSchedule().get(3);
            Schedule BSDLab2S1 = BSDLab2.getSchedule().get(0);
            Schedule BSDLab2S2 = BSDLab2.getSchedule().get(1);

            Schedule SSIZLectureS = SSIZLecture.getSchedule().get(0);
            Schedule SSIZLabS1 = SSIZLab.getSchedule().get(0);
            Schedule SSIZLabS2 = SSIZLab.getSchedule().get(1);
            Schedule SSIZLabS3 = SSIZLab.getSchedule().get(2);
            Schedule SSIZLabS4 = SSIZLab.getSchedule().get(3);
            Schedule SSIZLabS5 = SSIZLab.getSchedule().get(4);
            Schedule SSIZLabS6 = SSIZLab.getSchedule().get(5);

            Schedule SSOLectureS = SSOLecture.getSchedule().get(0);
            Schedule SSOLabS1 = SSOLab.getSchedule().get(0);
            Schedule SSOLabS2 = SSOLab.getSchedule().get(1);
            Schedule SSOLabS3 = SSOLab.getSchedule().get(2);
            Schedule SSOLabS4 = SSOLab.getSchedule().get(3);
            Schedule SSOLabS5 = SSOLab.getSchedule().get(4);
            Schedule SSOLabS6 = SSOLab.getSchedule().get(5);

            Schedule PMLectureS = PMLecture.getSchedule().get(0);
            Schedule PMLab1S1 = PMLab1.getSchedule().get(0);
            Schedule PMLab1S2 = PMLab1.getSchedule().get(1);
            Schedule PMLab1S3 = PMLab1.getSchedule().get(2);
            Schedule PMLab2S1 = PMLab2.getSchedule().get(0);
            Schedule PMLab2S2 = PMLab2.getSchedule().get(1);
            Schedule PMLab2S3 = PMLab2.getSchedule().get(2);

            I1rightMon.add(new PlanItem(MOIWSPLectureS.getStartTime(), coursesMOIWSP.getName(), MOIWSPLecture.getSupervisor(), MOIWSPLecture.getRoom(), MOIWSPLectureS.getDay(), MOIWSPLectureS.getGroup(), MOIWSPLectureS.getSubgroup(), MOIWSPLectureS.getWeeks()));
            I1rightMon.add(new PlanItem(MOIWSPLabS1.getStartTime(), coursesMOIWSP.getName(), MOIWSPLab.getSupervisor(), MOIWSPLab.getRoom(), MOIWSPLabS1.getDay(), MOIWSPLabS1.getGroup(), MOIWSPLabS1.getSubgroup(), MOIWSPLabS1.getWeeks()));
            I1rightMon.add(new PlanItem(BDLectureS.getStartTime(), coursesBD.getName(), BDLecture.getSupervisor(), BDLecture.getRoom(), BDLectureS.getDay(), BDLectureS.getGroup(), BDLectureS.getSubgroup(), BDLectureS.getWeeks()));
            I1rightMon.add(new PlanItem(PMLab1S1.getStartTime(), coursesPM.getName(), PMLab1.getSupervisor(), PMLab1.getRoom(), PMLab1S1.getDay(), PMLab1S1.getGroup(), PMLab1S1.getSubgroup(), PMLab1S1.getWeeks()));
            I1rightMon.add(new PlanItem(SSOLabS6.getStartTime(), coursesSSO.getName(), SSOLab.getSupervisor(), SSOLab.getRoom(), SSOLabS6.getDay(), SSOLabS6.getGroup(), SSOLabS6.getSubgroup(), SSOLabS6.getWeeks()));

            for (int i=0; i<I1rightMon.size(); i++){
                if((I1rightMon.get(i).getGroup().equals(group) && (I1rightMon.get(i).getSubgroup().equals(subgroup))) || (I1rightMon.get(i).getGroup().equals("all") && (I1rightMon.get(i).getSubgroup().equals("all")))){
                    tmp.add(I1rightMon.get(i));
                }
            }

            Collections.sort(tmp, PlanItem.StuNameComparator);

            return tmp;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }


}
