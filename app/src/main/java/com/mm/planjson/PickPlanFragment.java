package com.mm.planjson;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class PickPlanFragment extends Fragment {

    //ArrayList<String> spinners_choose = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_pick_plan, container, false);

        Spinner department_spinner = v.findViewById(R.id.department_spinner);
        Spinner field_of_study_spinner = v.findViewById(R.id.field_of_study_spinner);
        Spinner semester_spinner = v.findViewById(R.id.semester_spinner);
        Spinner group_spinner = v.findViewById(R.id.group_spinner);
        Spinner subgroup_spinner = v.findViewById(R.id.subgroup_spinner);

        ReadJson readJson = new ReadJson(getActivity().getApplicationContext());

        ArrayAdapter<String> department_adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),
                android.R.layout.simple_spinner_item, readJson.getDepartment());
        department_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        department_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                String item = adapterView.getItemAtPosition(position).toString();
                //spinners_choose.add(item);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        department_spinner.setAdapter(
                new NothingSelectedSpinnerAdapter(
                        department_adapter,
                        R.layout.spinner_row_nothing_selected,
                        getActivity().getApplicationContext()));


        ArrayAdapter<String> field_of_study_adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item, readJson.getField_of_study());
        field_of_study_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        field_of_study_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                Object item = adapterView.getItemAtPosition(position);
                //spinners_choose.add(item.toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        field_of_study_spinner.setAdapter(
                new NothingSelectedSpinnerAdapter(
                        field_of_study_adapter,
                        R.layout.spinner_row_nothing_selected,
                        getActivity().getApplicationContext()));


        ArrayAdapter<String> semester_adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item, readJson.getSemester());
        semester_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        semester_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                Object item = adapterView.getItemAtPosition(position);
               // spinners_choose.add(item.toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        semester_spinner.setAdapter(
                new NothingSelectedSpinnerAdapter(
                        semester_adapter,
                        R.layout.spinner_row_nothing_selected,
                        getActivity().getApplicationContext()));

        ArrayAdapter<String> group_adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item, readJson.getGroup());
        group_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        group_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                Object item = adapterView.getItemAtPosition(position);
               // spinners_choose.add(item.toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        group_spinner.setAdapter(
                new NothingSelectedSpinnerAdapter(
                        group_adapter,
                        R.layout.spinner_row_nothing_selected,
                        getActivity().getApplicationContext()));

        ArrayAdapter<String> subgroup_adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item, readJson.getSubgroup());
        subgroup_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subgroup_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                Object item = adapterView.getItemAtPosition(position);
               // spinners_choose.add(item.toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        subgroup_spinner.setAdapter(
                new NothingSelectedSpinnerAdapter(
                        subgroup_adapter,
                        R.layout.spinner_row_nothing_selected,
                        getActivity().getApplicationContext()));


//        Button button_add_plan = v.findViewById(R.id.add_plan_button);
//        button_add_plan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), MainActivity.class);
//                intent.putExtra("user_plan", spinners_choose);
//                startActivity(intent);
//            }
//        });

        return v;
    }

//    @SuppressLint("NonConstantResourceId")
//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        String text;
//        switch(parent.getId()){
//            case R.id.department_spinner:{
//                text = parent.getItemAtPosition(position).toString();
//                spinners_choose.add(text);
//            }
//            case R.id.field_of_study_spinner:{
//                text = parent.getItemAtPosition(position).toString();
//                spinners_choose.add(text);
//            }
//            case R.id.semester_spinner:{
//                text = parent.getItemAtPosition(position).toString();
//                spinners_choose.add(text);
//            }
//            case R.id.group_spinner:{
//                text = parent.getItemAtPosition(position).toString();
//                spinners_choose.add(text);
//            }
//            case R.id.subgroup_spinner:{
//                text = parent.getItemAtPosition(position).toString();
//                spinners_choose.add(text);
//            }
//        }
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//
//    }parent
}