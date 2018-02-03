package com.example.nikola.insomniac;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nikola.insomniac.improveSleep.Bedroom;
import com.example.nikola.insomniac.improveSleep.Coffee;
import com.example.nikola.insomniac.improveSleep.DailyLight;
import com.example.nikola.insomniac.improveSleep.NightlyLight;
import com.example.nikola.insomniac.improveSleep.PhysicalActivity;
import com.example.nikola.insomniac.improveSleep.SleepQuality;


public class ImproveSleep extends MainActivity {

    private static final String TAG = "SleepQuality";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.improvesleep);
        Button sleepquality = (Button)findViewById(R.id.sleepquality);
        sleepquality.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent myIntent = new Intent(ImproveSleep.this, SleepQuality.class);
                        ImproveSleep.this.startActivity(myIntent);
                    }
                }
        );

        Button physicalactivity = (Button)findViewById(R.id.physicalactivity);
        physicalactivity.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent myIntent = new Intent(ImproveSleep.this, PhysicalActivity.class);
                        ImproveSleep.this.startActivity(myIntent);
                    }
                }
        );

        Button dailylight = (Button)findViewById(R.id.dailylight);
        dailylight.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent myIntent = new Intent(ImproveSleep.this, DailyLight.class);
                        ImproveSleep.this.startActivity(myIntent);
                    }
                }
        );

        Button nightlylight = (Button)findViewById(R.id.nightlylight);
        nightlylight.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent myIntent = new Intent(ImproveSleep.this, NightlyLight.class);
                        ImproveSleep.this.startActivity(myIntent);
                    }
                }
        );


        Button coffee = (Button)findViewById(R.id.coffee);
        coffee.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent myIntent = new Intent(ImproveSleep.this, Coffee.class);
                        ImproveSleep.this.startActivity(myIntent);
                    }
                }
        );

        Button bedroom = (Button)findViewById(R.id.bedroom);
        bedroom.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent myIntent = new Intent(ImproveSleep.this, Bedroom.class);
                        ImproveSleep.this.startActivity(myIntent);
                    }
                }
        );



    }


}