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

import static com.example.nikola.insomniac.R.id.dva;


public class LearnMoreIntroduction extends LearnMore {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learnmore_intro);



        SpannableString ss = new SpannableString("\n" +
                "What is causing chronic insomnia? \n" + "\n" +
                "In the past, chronic insomnia has been considered a behavioral or emotional problem. However, experimental work has shown that when many people were exposed to the identical stressors, some of them had a very poor sleep while others had only slightly change from their baseline sleep. During sleep, people who had poor sleep also had cardiac changes consistent with arousal system activation (sympathetic nervous system activation). In addition, research has shown that patients with chronic insomnia had increased brain activation, elevated heart rates, increased brain and body metabolism, decreased sleep hormone (melatonin) and increased stress hormone (cortisol). This increase was measured both throughout the day and night and was chronic (see reference 1). The question is what is causing this hyperarousal? A team of neuroscientists from the Netherlands have shown that the activity of the part of the brain (caudate nucleus) involved in reducing responsiveness of the brain (cortical excitability) was reduced in patients with insomnia and it was associated with self-reported hyperarousal (see 2). Taken together these findings indicate that subjects with a physiological predisposition to increased responsiveness of the brain and subsequent hyperarousal are more likely to react with insomnia response to many physiological and psychological stressors. \n" +
                "\n" +
                "How do our body and mind know when to sleep? \n" + "\n" +
                "Our brain contains specialized cells in the part of the brain called Suprachiasmatic nucleus (SCN), which with the help of a special molecular mechanism have a daily activity oscillations used for many functions, including sleep. These oscillations are termed circadian rhythm (circa - around, dia - day) and represent any biological process that cycles around the Earth day (24 hours). SCN is directly connected to retina (part of our eyes that detects light) and modulation of SCN cells by the daily light–dark cycle sets the 24-h rhythm for all physiological rhythms in the organism (see 3). At subjective dusk, SCN increases the secretion of adenosine, a molecule that promotes sleep by inhibiting brain areas that increase arousal (see 4). In addition, it triggers the release of melatonin by the pineal gland, a molecule that prevents the arousal of cortex by other parts of the brain (see 5). Other molecules also play important roles in sleep homeostasis.  For example, studies have shown that serotonin has a complex effect of sleep. Firstly, research has shown that time spent in wakefulness is associated with an increase in serotonin in the SCN, sleep promoting part of the brain (see 6). Secondly, serotonin is very important in the process of melatonin synthesis (see 7). Thirdly, some studies have shown that serotonin can directly inhibit cortical and thalamic neurons (see 8). Overall, SCN acts as a “master clock”, promoting sleep through complex interaction with other molecules in our body during daily light-dark cycle. \n" +
                "\n" +
                "Find out more \n" +
                "\n" +
                "1. Bonnet, M. H., and Arand, D. L. (2010). Hyperarousal and insomnia: State of the science. Sleep Medicine Reviews, 14(1), 9–15. \n" +
                "\n" +
                "2. Stoffers, D., Altena, E., van der Werf, Y. D., Sanz-Arigita, E. J., Voorn, T. A., Astill, R. G., … Van Someren, E. J. W. (2014). The caudate: a key node in the neuronal network imbalance of insomnia? Brain, 137(2), 610–620.  \n" +
                "\n" +
                "3. Pace-Schott, E. F., and Hobson, J. A. (2002). The Neurobiology of Sleep: Genetics, cellular physiology and subcortical networks. Nat Rev Neurosci, 3(8), 591–605.  \n" +
                "\n" +
                "4. Basheer, R., Strecker, R. E., Thakkar, M. M., and McCarley, R. W. (2004). Adenosine and sleep-wake regulation. Progress in Neurobiology, 73(6), 379–396.  \n" +
                "\n" +
                "5. Srinivasan V, Pandi-Perumal SR, Trahkt I, et al. Melatonin and melatonergic drugs on sleep: possible mechanisms of action. Int J Neurosci 2009, 119:821–46.  \n" +
                "\n" +
                "6. Deurveilher, S., and Semba, K. (2008). Reciprocal connections between the suprachiasmatic nucleus and the midbrain raphe nuclei: A putative role in the circadian control of behavioral states. In J. M. Monti, S. R. Pandi-Perumal, B. L. Jacobs, and D. J. Nutt (Eds.), Serotonin and Sleep: Molecular, Functional and Clinical Aspects (pp. 103–131). Basel: Birkhäuser Basel.  \n" +
                "\n" +
                "7. Klein, D. C., Coon, S. L., Roseboom, P. H., Weller, J. L., Bernard, M., Gastel, J. A., … Baler, R. (1997). The melatonin rhythm-generating enzyme: molecular regulation of serotonin. Recent Progress in Hormone Research, 52, 307-57-358.  \n" +
                "\n" +
                "8. Rogawski, M. A., and Aghajanian, G. K. (1980). Norepinephrine and serotonin: opposite effects on the activity of lateral geniculate neurons evoked by optic pathway stimulation. Experimental Neurology, 69(3), 678–694.  \n"
        );


        ClickableSpan span1 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Uri uri = Uri.parse("https://www.ncbi.nlm.nih.gov/pubmed/19640748");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

        };
        ClickableSpan span2 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Uri uri = Uri.parse("https://www.ncbi.nlm.nih.gov/pubmed/24285642");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

        };
        ClickableSpan span3 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Uri uri = Uri.parse("https://www.ncbi.nlm.nih.gov/pubmed/12154361");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

        };
        ClickableSpan span4 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Uri uri = Uri.parse("https://www.ncbi.nlm.nih.gov/pubmed/15313333");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

        };
        ClickableSpan span5 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Uri uri = Uri.parse("https://www.ncbi.nlm.nih.gov/pubmed/19326288");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

        };
        ClickableSpan span6 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Uri uri = Uri.parse("https://www.ncbi.nlm.nih.gov/pmc/articles/PMC2675905/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

        };
        ClickableSpan span7 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Uri uri = Uri.parse("https://www.ncbi.nlm.nih.gov/pubmed/9238858");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

        };
        ClickableSpan span8 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Uri uri = Uri.parse("https://ucdavis.pure.elsevier.com/en/publications/norepinephrine-and-serotonin-opposite-effects-on-the-activity-of-");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

        };

        ss.setSpan(span1, 3008, 3054, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(span2, 3142, 3274, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(span3, 3372, 3420, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(span4, 3540, 3617, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(span5, 3699, 3750, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(span6, 3861, 3902, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(span7, 4234, 4346, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(span8, 4475, 4527, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);



        TextView textView = (TextView) findViewById(dva);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());






}

}