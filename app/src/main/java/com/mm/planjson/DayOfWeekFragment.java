package com.mm.planjson;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class DayOfWeekFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_day_of_week, container, false);

        Bundle bundle = this.getArguments();
        //Bundle bundle1 = this.getArguments();
        ReadJson read = new ReadJson(getActivity().getApplicationContext());

        recyclerView = v.findViewById(R.id.recycler_view_plan);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        if(bundle != null){
            String adapter = bundle.getString("adapter");
            //ArrayList<String> user_choice = bundle1.getStringArrayList("user_plan");
            switch (adapter) {
                case "0": {
                    mAdapter = new PlanAdapter(read.restoreFromJson(1, "I1", "right"));
                    recyclerView.setAdapter(mAdapter);
                    break;
                }
                case "1": {
                    mAdapter = new PlanAdapter(read.restoreFromJson(2, "I1", "right"));
                    recyclerView.setAdapter(mAdapter);
                    break;
                }
                case "2": {
                    mAdapter = new PlanAdapter(read.restoreFromJson(3, "I1", "right"));
                    recyclerView.setAdapter(mAdapter);
                    break;
                }
                case "3": {
                    mAdapter = new PlanAdapter(read.restoreFromJson(4, "I1", "right"));
                    recyclerView.setAdapter(mAdapter);
                    break;
                }
                case "4": {
                    mAdapter = new PlanAdapter(read.restoreFromJson(5, "I1", "right"));
                    recyclerView.setAdapter(mAdapter);
                    break;
                }
            }
        }
        return v;
    }
}