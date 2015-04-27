package com.google.android.apps.androidify;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import java.io.IOException;
import java.util.List;

public class StickerActivity extends Activity {
    protected void onCreate(Bundle bundle) {
        az azVar = null;
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        if (getIntent().hasExtra("DroidConfig")) {
            String stringExtra = getIntent().getStringExtra("DroidConfig");
            try {
                az azVar2 = new az();
                azVar2.m1776a((Context) this, stringExtra);
                azVar = azVar2;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        setContentView(R.layout.activity_sticker);
        List<View> a = C0220c.m1907a((ViewGroup) findViewById(R.id.sticker_root));
        ah a2 = ah.m1648a((Context) this);
        ba baVar = new ba(this);
        baVar.m1848b(0.75f);
        if (azVar != null) {
            baVar.m1844a(azVar, a2);
        } else {
            baVar.m1844a(a2.m1656a(), a2);
        }
        int i = 1;
        for (View view : a) {
            int i2;
            if (view instanceof DrawView) {
                DrawView drawView = (DrawView) view;
                drawView.setDroidDrawer(baVar);
                if (i != 0) {
                    i2 = 0;
                    i = i2;
                } else {
                    cj cjVar = new cj();
                    cjVar.m1929a();
                    drawView.setPose(cjVar);
                }
            }
            i2 = i;
            i = i2;
        }
    }
}
