package com.google.android.apps.androidify;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.google.android.apps.analytics.GoogleAnalyticsTracker;

import dev.game.legend.avatar.R;

public class AboutActivity extends Activity {
    public void clickedAboutVideo(View view) {
        Util.print((Context) this, "http://androidify.com/video");
    }

    public void clickedClose(View view) {
        finish();
        dh.m1956a((Context) this);
    }

    public void clickedSuggestion(View view) {
        Util.print((Context) this, "https://docs.google.com/forms/d/1nxP8jkIyQCr1Cvtfabc1CjRSkB6B-y_oD75h1qBa5QQ/viewform");
    }

    public void clickedViewCharacterGallery(View view) {
        Util.print((Context) this, "http://androidify.com/#/gallery");
    }

    public void clickedVisitAndroid(View view) {
        Util.print((Context) this, "http://android.com");
    }

    public void clickedVisitFAQ(View view) {
        Util.print((Context) this, "http://androidify.com/#/faq");
    }

    public void clickedVisitGithub(View view) {
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_about);
        View findViewById = findViewById(R.id.header);
        bu.m1894a(findViewById, getString(R.string.menu_about), false, false, false, false, true);
        findViewById.setBackgroundColor(-1);
        TextView textView = (TextView) findViewById(R.id.about_faq_text);
        textView.setText(Html.fromHtml(getString(R.string.about_visit_faq)));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        try {
            GoogleAnalyticsTracker.m1177a().m1184a("about");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
