package com.example.nikola.insomniac;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import static android.R.attr.value;


public class LearnMore extends MainActivity  {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learnmore);

        Button aboutinsomniac = (Button)findViewById(R.id.aboutinsomniac);
        aboutinsomniac.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent myIntent = new Intent(LearnMore.this, AboutInsomniac.class);
                        myIntent.putExtra("key", value); //Optional parameters
                        LearnMore.this.startActivity(myIntent);

                    }
                }
        );

        Button introduction = (Button)findViewById(R.id.introduction);
        introduction.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent myIntent = new Intent(LearnMore.this, LearnMoreIntroduction.class);
                        myIntent.putExtra("key", value); //Optional parameters
                        LearnMore.this.startActivity(myIntent);

                    }
                }
        );

        Button learnmorechecklist = (Button)findViewById(R.id.learnmorechecklist);
        learnmorechecklist.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent myIntent = new Intent(LearnMore.this, LearnMoreChecklist.class);
                        myIntent.putExtra("key", value); //Optional parameters
                        LearnMore.this.startActivity(myIntent);

                    }
                }
        );
        Button learnmoreworrybook = (Button)findViewById(R.id.learnmoreworrybook);
        learnmoreworrybook.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent myIntent = new Intent(LearnMore.this, LearnMoreWorryBook.class);
                        myIntent.putExtra("key", value); //Optional parameters
                        LearnMore.this.startActivity(myIntent);

                    }
                }
        );













    }




}