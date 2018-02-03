package com.example.nikola.insomniac;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;


import com.example.nikola.insomniac.learnMore.LearnMore;
import com.example.nikola.insomniac.statistics.TrackProgress;

import static android.R.attr.value;
import static com.example.nikola.insomniac.R.id.buttonLearnMore;
import static com.example.nikola.insomniac.R.id.nl;
import static com.example.nikola.insomniac.R.id.textView;

public class MainActivity extends AppCompatActivity {

    final Context context = this;
    final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

        if (settings.getBoolean("my_first_time", true)) {

            // nl_info dialog
            final Dialog dialog = new Dialog(context);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.my_first_time);


            // set the nl_info dialog components - text, image and button
            TextView text1 = (TextView) dialog.findViewById(R.id.text1);
            TextView text2 = (TextView) dialog.findViewById(R.id.text2);
            TextView text3 = (TextView) dialog.findViewById(R.id.text3);


            Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
            // if button is clicked, close the nl_info dialog
            dialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            dialog.show();

            settings.edit().putBoolean("my_first_time", false).commit();

        }



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

        Button ImproveSleep = (Button)findViewById(R.id.ImproveSleep);
        ImproveSleep.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent myIntent = new Intent(MainActivity.this, ImproveSleep.class);
                        myIntent.putExtra("key", value); //Optional parameters
                        MainActivity.this.startActivity(myIntent);

                    }
                });

        Button trackProgress = (Button)findViewById(R.id.trackprogress);
        trackProgress.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent myIntent = new Intent(MainActivity.this, TrackProgress.class);
                        MainActivity.this.startActivity(myIntent);

                    }
                });

        Button WorryBook = (Button)findViewById(R.id.WorryBook);
        WorryBook.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent myIntent = new Intent(MainActivity.this, com.example.nikola.insomniac.worrybook.WorryBook.class);
                        myIntent.putExtra("key", value); //Optional parameters
                        MainActivity.this.startActivity(myIntent);
                    }
                }
        );



    }


}