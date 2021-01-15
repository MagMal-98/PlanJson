package com.mm.planjson;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
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
                String group = preference.getString("group", "0");
                String subgroup = preference.getString("subgroup", "0");
                Integer day = Integer.valueOf(adapter) + 1;
                mAdapter = new PlanAdapter(read.restoreFromJson(day, group, subgroup));
                recyclerView.setAdapter(mAdapter);
            }
        }
        return v;
    }
}