package com.example.nikola.insomniac.onFirstStart;

import android.content.Intent;
import android.os.Bundle;

import com.example.nikola.insomniac.MainActivity;
import com.example.nikola.insomniac.R;
import com.shashank.sony.fancywalkthroughlib.FancyWalkthroughActivity;
import com.shashank.sony.fancywalkthroughlib.FancyWalkthroughCard;

import java.util.ArrayList;
import java.util.List;

public class OnBoardingActivity extends FancyWalkthroughActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FancyWalkthroughCard fancywalkthroughCard2 = new FancyWalkthroughCard("Learn more", "Learn how to improve your sleep.");
        FancyWalkthroughCard fancywalkthroughCard3 = new FancyWalkthroughCard("Improve sleep", "Follow factors that are influencing your sleep.");
        FancyWalkthroughCard fancywalkthroughCard4 = new FancyWalkthroughCard("Track progress", "Get insights into your habits and see what you have done when you slept better.");

        fancywalkthroughCard2.setBackgroundColor(R.color.purpletrans);
        fancywalkthroughCard2.setIconLayoutParams(400,400,0,0,0,0);
        fancywalkthroughCard3.setBackgroundColor(R.color.purpletrans);
        fancywalkthroughCard3.setIconLayoutParams(400,400,0,0,0,0);
        fancywalkthroughCard4.setBackgroundColor(R.color.purpletrans);
        fancywalkthroughCard4.setIconLayoutParams(400,400,0,0,0,0);


        List<FancyWalkthroughCard> pages = new ArrayList<>();

        pages.add(fancywalkthroughCard2);
        pages.add(fancywalkthroughCard3);
        pages.add(fancywalkthroughCard4);

        for (FancyWalkthroughCard page : pages) {
            page.setTitleColor(R.color.white);
            page.setDescriptionColor(R.color.white);
        }
        setFinishButtonTitle("Get Started");
        showNavigationControls(true);
        setImageBackground(R.drawable.pozadina);
        setInactiveIndicatorColor(R.color.blacktrans);
        setActiveIndicatorColor(R.color.white);
        setOnboardPages(pages);
    }

    @Override
    public void onFinishButtonPressed() {
        Intent myIntent = new Intent(OnBoardingActivity.this, MainActivity.class);
        OnBoardingActivity.this.startActivity(myIntent);
    }
}
