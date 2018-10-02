package com.example.nikola.insomniac.learnMore;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import com.example.nikola.insomniac.MainActivity;
import com.example.nikola.insomniac.R;


public class LearnMoreInsomniac extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learnmore_insomniac);

        SpannableString ss = new SpannableString("\n" +
                "Insomniac aims to help people to learn about and tract factors that have been shown to improve sleep quality.\n" +
                "\n" +
                "Insomniac is not intended for use in the diagnosis of disease or other conditions, or in the cure, mitigation, treatment or prevention of disease. \n" +
                "\n"  );


        TextView textView = (TextView) findViewById(R.id.learnmoretext);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

    }
}
