package com.mm.planjson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AlarmActivityLesson extends AppCompatActivity {

    private TextView textViewHour;
    private TextView textViewLessonName;
    private TextView textViewRoom;
    private TextView textViewSupervisor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_lesson);

        textViewHour = findViewById(R.id.textViewHourSchedule);
        textViewLessonName = findViewById(R.id.textViewLessonName);
        textViewRoom = findViewById(R.id.textViewRoom);
        textViewSupervisor = findViewById(R.id.textViewSupervisor);

        Bundle extras = getIntent().getExtras();
        String hour = extras.getString("hour");
        String name = extras.getString("name");
        String room = extras.getString("room");
        String supervisor = extras.getString("supervisor");

        textViewHour.setText(hour);
        textViewLessonName.setText(name);
        textViewRoom.setText(room);
        textViewSupervisor.setText(supervisor);
    }
}