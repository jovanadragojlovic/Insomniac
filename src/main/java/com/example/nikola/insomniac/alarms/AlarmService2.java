package com.example.nikola.insomniac.alarms;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.nikola.insomniac.WorryBook;
import com.example.nikola.insomniac.R;

public class AlarmService2 extends IntentService {
    private NotificationManager alarmNotificationManager2;

    public AlarmService2 () {
        super("AlarmService2");
    }

    @Override
    public void onHandleIntent(Intent intent) {
        sendNotification("Open Insomniac to see what is left to do today in order to improve your sleep.");
    }

    private void sendNotification(String msg) {
        Log.d("AlarmService2", "Preparing to send notification...: " + msg);
        alarmNotificationManager2 = (NotificationManager) this
                .getSystemService(Context.NOTIFICATION_SERVICE);

        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, WorryBook.class), 0);

        NotificationCompat.Builder alamNotificationBuilder = new NotificationCompat.Builder(
                this).setContentTitle("Reminder").setSmallIcon(R.mipmap.ic_launcher)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(msg))
                .setContentText(msg);


        alamNotificationBuilder.setContentIntent(contentIntent);
        alarmNotificationManager2.notify(1, alamNotificationBuilder.build());
        Log.d("AlarmService2", "Notification sent.");
    }
}