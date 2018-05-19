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

import com.example.nikola.insomniac.R;
import com.example.nikola.insomniac.learnMore.LearnMore;


public class LearnMoreWorryBook extends LearnMore {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learnmore_worrybook);

        SpannableString ss = new SpannableString("\n" +
                "Worry Book \n" +
                "\n" +
                "Psychological research have shown that scheduling a time of the day for worrying about problems can be a good way to decrease insomnia (see 1). During the evening, write down problems that are bothering you and postpone thinking about them for the certain part of the following day.\n" +
                "\n" +
                "Find out more \n" +
                "\n" +
                "1. McGowan, S. K., and Behar, E. (2013). A preliminary investigation of stimulus control training for worry: effects on anxiety and insomnia. Behavior Modification, 37(1), 90–112. \n");


        ClickableSpan span2 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {

                Uri uri = Uri.parse("http://journals.sagepub.com/doi/abs/10.1177/0145445512455661?journalCode=bmoa");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);


            }

        };
        ss.setSpan(span2, 314, 354, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        TextView textView = (TextView) findViewById(R.id.dvanaest);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
}}

