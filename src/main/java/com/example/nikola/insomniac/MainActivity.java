package com.example.nikola.insomniac;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



import static android.R.attr.value;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Button buttonLearnMore = (Button)findViewById(R.id.buttonLearnMore);
        buttonLearnMore.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent myIntent = new Intent(MainActivity.this, LearnMore.class);
                        myIntent.putExtra("key", value); //Optional parameters
                        MainActivity.this.startActivity(myIntent);

                    }
                }
        );
        Button WorryBook = (Button)findViewById(R.id.WorryBook);
        WorryBook.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent myIntent = new Intent(MainActivity.this, WorryBook.class);
                        myIntent.putExtra("key", value); //Optional parameters
                        MainActivity.this.startActivity(myIntent);
                    }
                }
        );



        Button ImproveSleep = (Button)findViewById(R.id.ImproveSleep);
        ImproveSleep.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent myIntent = new Intent(MainActivity.this, ImproveSleep.class);
                        myIntent.putExtra("key", value); //Optional parameters
                        MainActivity.this.startActivity(myIntent);

                    }
                });

        Button setreminders = (Button)findViewById(R.id.setreminders);
        setreminders.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent myIntent = new Intent(MainActivity.this, Reminders.class);
                        myIntent.putExtra("key", value); //Optional parameters
                        MainActivity.this.startActivity(myIntent);

                    }
                });





    }


}