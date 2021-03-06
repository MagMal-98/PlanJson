package com.mm.planjson;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class DayOfWeekFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private ArrayList<PlanItem> arrayList;
    String hour;
    String supervisor;
    String room;
    String name;
    int weekDay;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_day_of_week, container, false);
        if(getActivity() instanceof MainActivity) {
            MainActivity activity = (MainActivity) getActivity();
            Context applicationContext = activity.getApplicationContext();
            Bundle bundle = this.getArguments();
            SharedPreferences preference = applicationContext.getSharedPreferences("PREFERENCE", applicationContext.MODE_PRIVATE);

            ReadJson read = activity.getReadJson();

            recyclerView = v.findViewById(R.id.recycler_view_plan);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(activity));
            if (bundle != null) {
                String adapter = bundle.getString("adapter");
                String supervisor = bundle.getString("supervisor");
                String room = bundle.getString("room");
                String course = bundle.getString("course");
                if (supervisor != null){
                    Integer day = Integer.valueOf(adapter) + 1;
                    mAdapter = new PlanAdapter(read.getSupervisorPlan(day, supervisor));
                }else if (room != null){
                    Integer day = Integer.valueOf(adapter) + 1;
                    mAdapter = new PlanAdapter(read.getRoomPlan(day, room));
                }else if (course != null){
                    Integer day = Integer.valueOf(adapter) + 1;
                    mAdapter = new PlanAdapter(read.getCoursePlan(day, course));
                } else {
                    String group = preference.getString("group", "0");
                    String subgroup = preference.getString("subgroup", "0");
                    Integer day = Integer.valueOf(adapter) + 1;
                    arrayList = read.restoreFromJson(day, group, subgroup);
                    mAdapter = new PlanAdapter(arrayList);
                }
                recyclerView.setAdapter(mAdapter);
            }
        }

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {


                        if (position!=RecyclerView.NO_POSITION){
                            hour = arrayList.get(position).getHour();
                            supervisor = arrayList.get(position).getSupervisor();
                            room = arrayList.get(position).getRoom();
                            name = arrayList.get(position).getName();
                            weekDay = arrayList.get(position).getDay();

                        }

                        Intent intent;
                        intent = new Intent(getContext(), PlanItemOptions.class);
                        intent.putExtra("courseName", name);
                        intent.putExtra("supervisor", supervisor);
                        intent.putExtra("room", room);
                        intent.putExtra("hour", hour);
                        intent.putExtra("weekDay", weekDay);
                        startActivity(intent);
                        //Toast.makeText(getContext(), name + " "+ supervisor + " " + room + " "+ hour, Toast.LENGTH_LONG).show();
                    }
                })
        );

        return v;
    }

}
