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
                azVar2.a((Context) this, stringExtra);
                azVar = azVar2;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        setContentView(R.layout.activity_sticker);
        List<View> a = c.a((ViewGroup) findViewById(R.id.sticker_root));
        ah a2 = ah.a((Context) this);
        ba baVar = new ba(this);
        baVar.b(0.75f);
        if (azVar != null) {
            baVar.a(azVar, a2);
        } else {
            baVar.a(a2.a(), a2);
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
                    cjVar.a();
                    drawView.setPose(cjVar);
                }
            }
            i2 = i;
            i = i2;
        }
    }
}
