package com.example.nikola.insomniac.improveSleep;



import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nikola.insomniac.DatabaseHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DailyLightService extends Service implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mLight;

    //Ove variable sam napravio cisto da vidim kako sensor radi
    private String lux_light;
    ArrayList<String> listaluxa = new ArrayList<String>();
    TextView textLIGHT_reading;

    //ove koristim za merenje vremena
    private float luks;

    //ove za Log i merenje vremena
    String StringElapsedTimeDailyligjt;

    //ove za databazu
    DatabaseHelper mDatabaseHelper;
    String dailyLight;
    final Context context = this;

    //za hours of the day
    Calendar calendar = Calendar.getInstance();
    int hour = calendar.get(Calendar.HOUR_OF_DAY);

    //counteri
    double counterdailylight;


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //generated
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        luks = event.values[0];

        lux_light = String.valueOf(event.values[0]);
        listaluxa.add(lux_light);
        Log.d("list", listaluxa.toString());


        if (hour >= 5 && hour <19) {

            if (luks >50) {
                counterdailylight = counterdailylight + 0.2;
                StringElapsedTimeDailyligjt = String.valueOf(counterdailylight);
                Log.d("Sa  svetlom   -", StringElapsedTimeDailyligjt);
                dailyLight = StringElapsedTimeDailyligjt;
            } else if (counterdailylight != 0) {
                AddData2(dailyLight);
                counterdailylight = 0;
            }

        }

        if(hour == 19 && dailyLight != "0") {
            AddData2(dailyLight);
            dailyLight = "0";
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this, "MyService Started.", Toast.LENGTH_SHORT).show();

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        mSensorManager.registerListener(this, mLight, 1000000000);

        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // ignore this since not linked to an activity
        return null;
    }

    @Override
    public void onDestroy() {
        mSensorManager.unregisterListener(this, mLight);
        Toast.makeText(this, "MyService Completed", Toast.LENGTH_SHORT).show();
    }


    public void AddData2(String dailyLight) {
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        try {
            mDatabaseHelper = new DatabaseHelper(context);
            mDatabaseHelper.addDailyLightData(dailyLight, date);
            toastMessage("Data Successfully Inserted!");
        } catch(Exception e) {
            toastMessage("Something went wrong");
        }
    }

    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}