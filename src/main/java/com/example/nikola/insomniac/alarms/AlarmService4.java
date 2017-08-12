package com.example.nikola.insomniac.alarms;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.nikola.insomniac.R;
import com.example.nikola.insomniac.WorryBook;

import static com.example.nikola.insomniac.R.id.worrybook;

public class AlarmService4 extends IntentService {
    private NotificationManager alarmNotificationManager4;

    public AlarmService4 () {
        super("AlarmService4");
    }

    @Override
    public void onHandleIntent(Intent intent) {
        sendNotification("It's worry time, we hope you have slept well.");

    }

    private void sendNotification(String msg) {
        Log.d("AlarmService4", "Preparing to send notification...: " + msg);
        alarmNotificationManager4 = (NotificationManager) this
                .getSystemService(Context.NOTIFICATION_SERVICE);

        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, WorryBook.class), 0);

        NotificationCompat.Builder alamNotificationBuilder = new NotificationCompat.Builder(
                this).setContentTitle("Reminder").setSmallIcon(R.mipmap.ic_launcher)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(msg))
                .setContentText(msg);


        alamNotificationBuilder.setContentIntent(contentIntent);
        alarmNotificationManager4.notify(1, alamNotificationBuilder.build());
        Log.d("AlarmService4", "Notification sent.");
    }
}