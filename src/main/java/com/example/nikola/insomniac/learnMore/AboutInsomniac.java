package com.example.nikola.insomniac.learnMore;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.example.nikola.insomniac.R;


public class AboutInsomniac extends LearnMore {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutinsomniac);


        TextView LearnMoreText = (TextView) findViewById(R.id.LearnMoreText);
        LearnMoreText.setMovementMethod(new ScrollingMovementMethod());






    }
}
