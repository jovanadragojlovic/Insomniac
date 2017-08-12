package com.example.nikola.insomniac;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nikola.insomniac.alarms.AlarmActivity;
import com.example.nikola.insomniac.alarms.AlarmActivity2;
import com.example.nikola.insomniac.alarms.AlarmActivity3;
import com.example.nikola.insomniac.alarms.AlarmActivity4;

import static android.R.attr.value;

public class Reminders extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.reminders);

        Button nightlyreminder = (Button)findViewById(R.id.nightlyreminder);
        nightlyreminder.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent myIntent = new Intent(Reminders.this, AlarmActivity.class);
                        myIntent.putExtra("key", value); //Optional parameters
                        Reminders.this.startActivity(myIntent);

                    }
                }
        );

        Button dailyreminder = (Button)findViewById(R.id.dailyreminder);
        dailyreminder.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent myIntent = new Intent(Reminders.this, AlarmActivity2.class);
                        myIntent.putExtra("key", value); //Optional parameters
                        Reminders.this.startActivity(myIntent);

                    }
                }
        );

        Button morningreminder = (Button)findViewById(R.id.morningreminder);
        morningreminder.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent myIntent = new Intent(Reminders.this, AlarmActivity3.class);
                        myIntent.putExtra("key", value); //Optional parameters
                        Reminders.this.startActivity(myIntent);

                    }
                }
        );

        Button worrytime = (Button)findViewById(R.id.worrytime);
        worrytime.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent myIntent = new Intent(Reminders.this, AlarmActivity4.class);
                        myIntent.putExtra("key", value); //Optional parameters
                        Reminders.this.startActivity(myIntent);

                    }
                }
        );

    }
}

