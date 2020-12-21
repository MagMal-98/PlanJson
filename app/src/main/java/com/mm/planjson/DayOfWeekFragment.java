package com.mm.planjson;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

public class DayOfWeekFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_day_of_week, container, false);

        ReadJson read = new ReadJson(getActivity().getApplicationContext());
        //MainActivity mainActivity = new MainActivity();

        recyclerView = v.findViewById(R.id.recycler_view_plan);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //recyclerView.setAdapter(mainActivity.mAdapter);
        recyclerView.setAdapter(mAdapter);
        mAdapter = new PlanAdapter(read.restoreFromJson(1, "I1", "right"));

        return v;
    }
}