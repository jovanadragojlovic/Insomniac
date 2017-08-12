package com.example.nikola.insomniac;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.R.attr.value;


public class ImproveSleep extends MainActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.improvesleep);

        Button checklist = (Button)findViewById(R.id.checklist);
        checklist.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent myIntent = new Intent(ImproveSleep.this, NewChecklist.class);
                        myIntent.putExtra("key", value); //Optional parameters
                        ImproveSleep.this.startActivity(myIntent);

                    }
                }
        );
        Button sleepquality = (Button)findViewById(R.id.sleepquality);
        sleepquality.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent myIntent = new Intent(ImproveSleep.this, SleepQuality.class);
                        myIntent.putExtra("key", value); //Optional parameters
                        ImproveSleep.this.startActivity(myIntent);
                    }
                }
        );

        Button btnView = (Button)findViewById(R.id.btnView);
        btnView.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent myIntent = new Intent(ImproveSleep.this, Istorija.class);
                        myIntent.putExtra("key", value); //Optional parameters
                        ImproveSleep.this.startActivity(myIntent);
                    }
                }
        );




    }


}