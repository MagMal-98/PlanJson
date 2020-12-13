package com.mm.planjson;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DayOfWeekFragment extends Fragment {

//    private static final String ARG_TEXT = "argText";
//    private String text;
//
//    public static DayOfWeekFragment newInstance(String param1) {
//        DayOfWeekFragment fragment = new DayOfWeekFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_TEXT, param1);
//        fragment.setArguments(args);
//        return fragment;
//    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        View v = inflater.inflate(R.layout.fragment_day_of_week, container, false);
//        TextView textView = v.findViewById(R.id.stringTextView);
//        if(getArguments() != null){
//            textView.setText(getArguments().getString(ARG_TEXT));
//        }
//        return inflater.inflate(R.layout.fragment_day_of_week, container, false);

        View v = inflater.inflate(R.layout.fragment_day_of_week, container, false);

        TextView textView = v.findViewById(R.id.stringTextView);
        String sTitle = getArguments().getString("title");
        textView.setText(sTitle);

        return v;
    }
}