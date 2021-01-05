package com.mm.planjson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.FragmentTransaction;
import android.os.Bundle;

import java.util.ArrayList;

public class FirstStartActivity extends AppCompatActivity{ //implements PickPlanFragment.onSomeEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_start);

//        Fragment pickPlanFragment = new PickPlanFragment();
//        FragmentTransaction ft = getFragmentManager().beginTransaction();
//        //ft.add(R.id.fragment_pick_plan, pickPlanFragment);
//        ft.commit();
    }

//    @Override
//    public void someEvent(ArrayList<String> arrayList) {
//        DayOfWeekFragment fragment = new DayOfWeekFragment();
//        Bundle bundle1 = new Bundle();
//        bundle1.putStringArrayList("user_plan", arrayList);
//
//    }
}