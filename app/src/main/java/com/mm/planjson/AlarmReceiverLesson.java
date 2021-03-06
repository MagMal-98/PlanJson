package com.mm.planjson;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class AlarmReceiverLesson extends BroadcastReceiver {

    public static final String CHANNEL_ID = "CHANNEL_SAMPLE";

    @Override
    public void onReceive(Context context, Intent intent) {

        String hour = intent.getStringExtra("hour");
        String name = intent.getStringExtra("courseName");
        String room = intent.getStringExtra("room");
        String supervisor = intent.getStringExtra("supervisor");
        int notificationId = intent.getIntExtra("notificationId", 0);

        Intent mainIntent = new Intent(context, AlarmActivityLesson.class);
        mainIntent.putExtra("hour", hour);
        mainIntent.putExtra("name", name);
        mainIntent.putExtra("room", room);
        mainIntent.putExtra("supervisor", supervisor);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, mainIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("EPLAN NOTIFICATION")
                .setContentText("New lesson notification")
                .setContentIntent(contentIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Your class " + name + " starts now"))
                .setAutoCancel(true);

        notificationManager.notify(notificationId, builder.build());
    }
}