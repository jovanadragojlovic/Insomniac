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


public class LearnMoreImproveSleepQuality extends LearnMore {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learnmore_improvesleepquality);

        SpannableString ss = new SpannableString("\n" +
                "How to increase sleepiness? \n" +
                "\n" +
                "Daily light. Humans used to spend most of the day outside, being exposed to high levels of bright light. Today, even on a cloudy day, the light outside can be greater than the level normally achieved indoors (see reference 1). Research has shown that the rate of production of serotonin (a molecule involved in the synthesis of melatonin, sleep promoting hormone) by the brain was directly related to the prevailing duration of bright sunlight (see 2, 3). You should increase the amount of time you spend outside." +
                "\n" +  "\n" +
                "Physical activity. An analysis combining 66 studies has shown that regular exercise has significant positive effect on the sleep quality. Longer exercises were associated with increased sleep quality, while there were no differences between aerobic and anaerobic exercises (see 4). You should choose the type of physical activity that you prefer and include it into your daily routine." +
                "\n" +
                "\n" +
                "Evening light. Studies have shown that evening light exposure inhibits the naturally timed rise of melatonin (sleep promoting hormone), which in turn delays the onset of sleep (see 5, 6). We recommend you to dim all the lights you can and to lower the brightness of your computer and mobile phone screens. " +
                "\n" +
                "\n" +
                "How to decrease arousal? \n" +
                "\n" +
                "Optimal sleep environment. Your bedroom should be a place where you can relax and fall asleep. Many sleep experts say that a cool room increases sleep quality. In addition, your bed, pillow and beddings should be comfortable and supportive. In a recent Bedroom Poll by the National Sleep Foundation, roughly three quarters of people say they get a more comfortable night's sleep on sheets with fresh scent (see 7). " +
                "\n" +
                "\n" +
                "Food and water. Hunger and thirst may disturb your sleep. Getting out of bed and going to the kitchen during the night requires turning on the lights that can awaken you. You should prepare a glass of water and a light snack close to your bed." +
                "\n" +  "\n" +
                "Coffee consumption. Caffeine is a stimulant of the central nervous system. Studies have shown that caffeine blocks adenosine (sleep promoting molecule) receptors and thus increase wakefulness (see 8). You should limit coffee/tea consumption for the morning hours." +
                "\n" +
                "\n" +
                "Find out more \n" +
                "\n" +
                "1. Young, S. N. (2007). How to increase serotonin in the human brain without drugs. Journal of Psychiatry and Neuroscience, 32(6), 394–399. \n" +
                "\n" +
                "2. Lambert, G. W., Reid, C., Kaye, D. M., Jennings, G. L., and Esler, M. D. (2002). Effect of sunlight and season on serotonin turnover in the brain. Lancet, 360(9348), 1840–1842.\n" +
                "\n" +
                "3. Aan het Rot, M., Moskowitz, D. S., and Young, S. N. (2008). Exposure to bright light is associated with positive social interaction and good mood over short time periods: A naturalistic study in mildly seasonal people. Journal of Psychiatric Research, 42(4), 311–319. \n" +
                "\n" +
                "4. Kredlow, M. A., Capozzoli, M. C., Hearon, B. A., Calkins, A. W., and Otto, M. W. (2015). The effects of physical activity on sleep: a meta-analytic review. Journal of Behavioral Medicine, 38(3), 427–449.\n" +
                "\n" +
                "5. Zeitzer, J. M., Dijk, D.-J., Kronauer, R. E., Brown, E. N., and Czeisler, C. A. (2000). Sensitivity of the human circadian pacemaker to nocturnal light: melatonin phase resetting and suppression. The Journal of Physiology, 526(3), 695–702. \n" +
                "\n" +
                "6. Cajochen, C., Münch, M., Kobialka, S., Kräuchi, K., Steiner, R., Oelhafen, P., Wirz-Justice, A. (2005). High Sensitivity of Human Melatonin, Alertness, Thermoregulation, and Heart Rate to Short Wavelength Light. The Journal of Clinical Endocrinology and Metabolism, 90(3), 1311–1316. \n" +
                "\n" +
                "7. https://sleepfoundation.org/bedroom/ \n" +
                "\n" +
                "8. Roehrs, T., and Roth, T. (2008). Caffeine: sleep and daytime sleepiness. Sleep Medicine Reviews, 12(2), 153–162. \n"

        );

        ClickableSpan span1 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Uri uri = Uri.parse("https://www.ncbi.nlm.nih.gov/pmc/articles/PMC2077351/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

        };

        ClickableSpan span2 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Uri uri = Uri.parse("https://www.ncbi.nlm.nih.gov/pubmed/12480364");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

        };

        ClickableSpan span3 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Uri uri = Uri.parse("https://www.ncbi.nlm.nih.gov/pubmed/17275841");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

        };
        ClickableSpan span4 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Uri uri = Uri.parse("https://www.ncbi.nlm.nih.gov/pubmed/25596964");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

        };
        ClickableSpan span5 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Uri uri = Uri.parse("https://www.ncbi.nlm.nih.gov/pmc/articles/PMC2270041/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

        };
        ClickableSpan span6 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Uri uri = Uri.parse("https://www.ncbi.nlm.nih.gov/pubmed/15585546");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

        };
        ClickableSpan span7 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Uri uri = Uri.parse("https://sleepfoundation.org/bedroom/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

        };
        ClickableSpan span8 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Uri uri = Uri.parse("https://www.ncbi.nlm.nih.gov/pubmed/17950009");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

        };


        ss.setSpan(span1, 2209, 2234, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(span2, 2351, 2436, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(span3, 2532, 2596, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(span4, 2805, 2898, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(span5, 3013, 3105, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(span6, 3258, 3366, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(span7, 3546, 3588, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(span8, 3589, 3626, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        TextView textView = (TextView) findViewById(R.id.osam);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
}
}