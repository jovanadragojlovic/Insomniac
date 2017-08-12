package com.example.nikola.insomniac;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.example.nikola.insomniac.R.id.LearnMoreText;
import static com.example.nikola.insomniac.R.id.textView;


public class AboutInsomniac extends LearnMore {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutinsomniac);


        TextView LearnMoreText = (TextView) findViewById(R.id.LearnMoreText);
        LearnMoreText.setMovementMethod(new ScrollingMovementMethod());






    }
}
