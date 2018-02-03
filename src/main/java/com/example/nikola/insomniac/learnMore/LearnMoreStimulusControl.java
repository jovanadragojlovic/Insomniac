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

public class LearnMoreStimulusControl extends LearnMore {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learnmore_stimuluscontrol);

        SpannableString ss = new SpannableString("\n" +
                "Stimulus control \n" +
                "\n" +
                "In order to cope with insomnia, insomniacs have a tendency to engage in various activities in their bed when unable to sleep. This leads to associating bed or bedroom with a wakeful state. Stimulus control therapy aims at reassociating the bed/bedroom with sleep. The following instructions aim to achieve this (see 1):\n" +
                "\n" +
                "1. Go to sleep only when sleepy. \n" +
                "\n" +
                "2. When unable to sleep, get out of the bed/bedroom. \n" +
                "\n" +
                "3. Avoid any activity in the bed/bedroom other than sleep or sexual activity. \n" +
                "\n" +
                "4. Wake up at the same time every morning.\n" +
                "\n" +
                "5. Avoid napping. \n" +
                "\n" +
                "Find out more \n" +
                "\n" +
                "1. Morin, C. M., Bootzin, R. R., Buysse, D. J., Edinger, J. D., Espie, C. A., and Lichstein, K. L. (2006). Psychological and behavioral treatment of insomnia: update of the recent evidence (1998-2004). Sleep, 29(11), 1398–1414. \n" +
                "\n" );

        ClickableSpan span1 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {

                Uri uri = Uri.parse("https://www.ncbi.nlm.nih.gov/pubmed/17162986");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);


            }

        };

        ss.setSpan(span1, 590, 697, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        TextView textView = (TextView) findViewById(R.id.learnmoresctext);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

    }
}
