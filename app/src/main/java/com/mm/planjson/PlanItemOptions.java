package com.mm.planjson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class PlanItemOptions extends AppCompatActivity {

    private Button buttonSupervisorSchedule;
    private Button buttonRoomSchedule;
    private Button buttonCourseSchedule;
    private Button buttonPlanNotification;
    private Switch switchCyclicNotification;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_item_options);

        buttonSupervisorSchedule = findViewById(R.id.button_show_supervisor);
        buttonRoomSchedule = findViewById(R.id.button_show_room);
        buttonCourseSchedule = findViewById(R.id.button_show_course);
        buttonPlanNotification = findViewById(R.id.button_set_notification_schedule);

        buttonSupervisorSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String supervisorSchedule = getIntent().getStringExtra("supervisor");
                Intent intent;
                intent = new Intent(PlanItemOptions.this, MainActivity.class);
                intent.putExtra("supervisor", supervisorSchedule);
                startActivity(intent);

            }

        });

        buttonRoomSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String roomSchedule = getIntent().getStringExtra("room");
                Intent intent;
                intent = new Intent(PlanItemOptions.this, MainActivity.class);
                intent.putExtra("room", roomSchedule);
                startActivity(intent);
            }
        });

        buttonCourseSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String courseSchedule = getIntent().getStringExtra("courseName");
                Intent intent;
                intent = new Intent(PlanItemOptions.this, MainActivity.class);
                intent.putExtra("course", courseSchedule);
                startActivity(intent);
            }
        });

        buttonPlanNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}