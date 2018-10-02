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

import static com.example.nikola.insomniac.R.id.dva;


public class LearnMoreSleep extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learnmore_sleep);

        SpannableString ss = new SpannableString("\n" +
                "How do our body and mind know when to sleep? \n" + "\n" +
                "The part of the brain called Suprachiasmatic nucleus (SCN), contains specialized cells which with the help of a special molecular mechanism have a daily activity oscillations. These oscillations are modulated by the light, setting the 24-h rhythm for all physiological rhythms in the organism, including wakefulness and sleep. Studies have shown that light activates the cells in SCN, promoting wakefulness (see reference 1). On the other hand, molecule called melatonin, which production is highest in the evening, inhibits the activity of the cells in SCN (see 2). Another important molecule involved in sleep regulation is called adenosine, a byproduct of energy metabolism. Research has shown that adenosine inhibits the activity of many wake-promoting brain areas (see 3). \n" +
                "\n" +
                "Find out more \n" +
                "\n" +
                "1. Pace-Schott, E. F., and Hobson, J. A. (2002). The Neurobiology of Sleep: Genetics, cellular physiology and subcortical networks. Nature Reviews Neuroscience, 3(8), 591–605.  \n" +
                "\n" +
                "2. Srinivasan, V., Pandi-Perumal, S. R., Trahkt, I., Spence, D. W., Poeggeler, B., Hardeland, R., and Cardinali, D. P. (2009). Melatonin and melatonergic drugs on sleep: possible mechanisms of action. The International Journal of Neuroscience, 119(6), 821–846.  \n" +
                "\n" +
                "3. Basheer, R., Strecker, R. E., Thakkar, M. M., and McCarley, R. W. (2004). Adenosine and sleep-wake regulation. Progress in Neurobiology, 73(6), 379–396. \n" +
                "\n"
        );

        ClickableSpan span1 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Uri uri = Uri.parse("http://www.nature.com/nrn/journal/v3/n8/full/nrn895.html");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

        };
        ClickableSpan span2 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Uri uri = Uri.parse("https://www.ncbi.nlm.nih.gov/pubmed/19326288");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

        };
        ClickableSpan span3 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Uri uri = Uri.parse("https://www.ncbi.nlm.nih.gov/pubmed/15313333 ");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

        };


        ss.setSpan(span1, 844, 892, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(span2, 1023, 1150, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(span3, 1287, 1363, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        TextView textView = (TextView) findViewById(dva);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

}

}