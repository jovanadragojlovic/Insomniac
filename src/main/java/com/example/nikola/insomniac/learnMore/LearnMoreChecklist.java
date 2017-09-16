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


public class LearnMoreChecklist extends LearnMore {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learnmore_checklist);


        SpannableString ss = new SpannableString("\n" +
                "How to increase sleepiness? \n" +
                "\n" +
                "Daily light. Humans used to spend most of the day outside, being exposed to high levels of bright light. Today, even on a cloudy day, the light outside can be greater than the level normally achieved indoors (see reference 1). Research has shown that the rate of production of serotonin (a molecule involved in sleep regulation) by the brain was directly related to the prevailing duration of bright sunlight (see 2, 3). You should increase the amount of time you spend outside. \n" +
                "\n" +
                "Physical activity. An analysis combining 66 studies has shown that regular exercise has significant positive effect on the sleep quality. Longer exercises were associated with increased sleep quality, while there were no differences between aerobic and anaerobic exercises (see 4). Studies have shown that exercise increases release and synthesis of serotonin in the human brain (see 5, 6, 7). In addition, there is an increase in the brain of the serotonin precursor tryptophan that persists after exercise (see 8). You should choose the type of physical activity that you prefer and include it into your daily routine. \n" +
                "\n" +
                "Evening light. Studies have shown that evening light exposure inhibits the naturally timed rise of melatonin (sleep promoting hormone), which in turn delays the onset of sleep (see 9, 10). We recommend you to dim all the lights you can and to lower the brightness of your computer and mobile phone screens.  \n" +
                "\n" +
                "How to decrease arousal? \n" +
                "\n" +
                "Optimal sleep environment. Your bedroom should be a place where you can relax and fall asleep. Many sleep experts say that a cool room increases sleep quality. In addition, your bed, pillow and beddings should be comfortable and supportive. In a recent Bedroom Poll by the National Sleep Foundation, more than three fourths of people said they are more excited to go to bed when the sheets have a fresh scent, and roughly three quarters of people say they get a more comfortable night's sleep on sheets with fresh scent (see 11). \n" +
                "\n" +
                "Food and water. People with physiological predisposition to hyperarousal naturally take longer time to fall asleep. Prolonged time spent in bed can make you hungry and/or thirsty, and getting out of bed and going to the kitchen in the middle of the night requires turning on the lights keeping you more awake. Prepare a glass of water and a light snack close to your bed. \n" +
                "\n" +
                "Coffee consumption. Caffeine is a stimulant of the central nervous system and its effects on sleep are well known (see 12, 13). Studies have shown that caffeine blocks adenosine receptors and thus increase wakefulness. You should limit coffee/tea consumption for the morning hours.   \n" +
                "\n" +
                "Find out more \n" +
                "\n" +
                "1. Young, S. N. (2007). How to increase serotonin in the human brain without drugs. Journal of Psychiatry and Neuroscience : JPN, 32(6), 394–399. \n" +
                "\n" +
                "2. Lambert, G. W., Reid, C., Kaye, D. M., Jennings, G. L., and Esler, M. D. (2002). Effect of sunlight and season on serotonin turnover in the brain. Lancet (London, England), 360(9348), 1840–1842.\n" +
                "\n" +
                "3. Aan het Rot, M., Moskowitz, D. S., and Young, S. N. (2008). Exposure to bright light is associated with positive social interaction and good mood over short time. \n" +
                "\n" +
                "4. Kredlow, M. A., Capozzoli, M. C., Hearon, B. A., Calkins, A. W., and Otto, M. W. (2015). The effects of physical activity on sleep: a meta-analytic review. Journal of Behavioral Medicine, 38(3), 427–449.  \n" +
                "\n" +
                "5. Post, R. M., and Goodwin, F. K. (1973). Simulated behavior states: an approach to specificity in psychobiological research. Biological Psychiatry, 7(3), 237–254. \n" +
                "\n" +
                "6. Jacobs, B. L., and Fornal, C. A. (1999). Activity of serotonergic neurons in behaving animals. Neuropsychopharmacology : Official Publication of the American College of Neuropsychopharmacology, 21(2 Suppl), 9S–15S. \n" +
                "\n" +
                "7. Rueter, L. E., and Jacobs, B. L. (1996). A microdialysis examination of serotonin release in the rat forebrain induced by  behavioral/environmental manipulations. Brain Research, 739(1–2), 57–69. \n" +
                "\n" +
                "8. Chaouloff, F., Laude, D., Guezennec, Y., and Elghozi, J. L. (1986). Motor activity increases tryptophan, 5-hydroxyindoleacetic acid, and homovanillic acid in ventricular cerebrospinal fluid of the conscious rat. Journal of Neurochemistry, 46(4), 1313–1316. \n" +
                "\n" +
                "9. Zeitzer, J. M., Dijk, D.-J., Kronauer, R. E., Brown, E. N., and Czeisler, C. A. (2000). Sensitivity of the human circadian pacemaker to nocturnal light: melatonin phase resetting and suppression. The Journal of Physiology, 526(3), 695–702. \n" +
                "\n" +
                "10. Cajochen, C., Münch, M., Kobialka, S., Kräuchi, K., Steiner, R., Oelhafen, P., Wirz-Justice, A. (2005). High Sensitivity of Human Melatonin, Alertness, Thermoregulation, and Heart Rate to Short Wavelength Light. The Journal of Clinical Endocrinology and Metabolism, 90(3), 1311–1316.  \n" +
                "\n" +
                "11. https://sleepfoundation.org/bedroom/ \n" +
                "\n" +
                "12. Březinová, V. (1974). Effects of caffeine on sleep: EEG study in late middle age people. British Journal of Clinical Pharmacology, 1(3), 203–208.  \n" +
                "\n" +
                "13. Levy, M., and Zylber-Katz, E. (1983). Caffeine metabolism and coffee-attributed sleep disturbances. Clinical Pharmacology and Therapeutics, 33(6), 770–775.   \n"


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
                Uri uri = Uri.parse("https://www.ncbi.nlm.nih.gov/labs/articles/4357567/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

        };
        ClickableSpan span6 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Uri uri = Uri.parse("https://www.ncbi.nlm.nih.gov/pubmed/10432483");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

        };
        ClickableSpan span7 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Uri uri = Uri.parse("http://www.nature.com/npp/journal/v21/n1s/full/1395336a.html?foxtrotcallback=true");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

        };
        ClickableSpan span8 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Uri uri = Uri.parse("http://onlinelibrary.wiley.com/doi/10.1111/j.1471-4159.1986.tb00656.x/abstract");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

        };
        ClickableSpan span9 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Uri uri = Uri.parse("https://www.ncbi.nlm.nih.gov/pmc/articles/PMC2270041/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

        };
        ClickableSpan span10 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Uri uri = Uri.parse("https://www.ncbi.nlm.nih.gov/pubmed/15585546");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

        };
        ClickableSpan span11 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Uri uri = Uri.parse("https://sleepfoundation.org/bedroom/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

        };
        ClickableSpan span12 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Uri uri = Uri.parse("https://www.ncbi.nlm.nih.gov/pmc/articles/PMC1402564/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

        };
        ClickableSpan span13 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Uri uri = Uri.parse("https://www.ncbi.nlm.nih.gov/pubmed/6851408");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

        };


        ss.setSpan(span1, 2680, 2703, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(span2, 2825, 2912, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(span3, 3025, 3089, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(span4, 3195, 3286, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(span5, 3402, 3447, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(span6, 3570, 3616, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(span7, 3792, 3836, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(span8, 3993, 4063, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(span9, 4252, 4345, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(span10, 4497, 4607, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(span11, 4790, 4832, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(span12, 4834, 4859, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(span13, 4987, 5029, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        TextView textView = (TextView) findViewById(R.id.osam);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
}
}