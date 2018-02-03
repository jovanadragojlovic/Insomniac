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


public class LearnMoreInsomniac extends LearnMore {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learnmore_insomniac);

        SpannableString ss = new SpannableString("\n" +
                "Insomniac aims to help people with chronic primary insomnia to learn about and tract factors that have been shown to improve sleep quality.\n" +
                "\n" +
                "It is important to note that there are different types of insomnia. Mayor division is on primary and secondary insomnia. Primary or hyperarousal insomnia is the name for insomnia that is not associated with another medical condition. Secondary insomnia is a symptom of a medical or psychiatric illness (such as depression, anxiety or cancer), another sleep disorder, or substance abuse (see 1). Thus it is very important to talk to your health care provider if you have troubles initiating and staying asleep. \n" +
                "\n" +
                "Insomniac is not intended for use in the diagnosis of disease or other conditions, or in the cure, mitigation, treatment or prevention of disease. \n" +
                "\n" +
                "Find out more\n" +
                "\n" +
                "1. Thorpy, M. J. (2012). Classification of Sleep Disorders. Neurotherapeutics, 9(4), 687–701. \n"  );

        ClickableSpan span1 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {

                Uri uri = Uri.parse("https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3480567/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);


            }

        };

        ss.setSpan(span1, 818, 842, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        TextView textView = (TextView) findViewById(R.id.learnmoretext);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

    }
}
