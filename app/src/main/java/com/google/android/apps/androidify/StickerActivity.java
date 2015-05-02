package com.google.android.apps.androidify;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;
import java.util.List;

import dev.game.legend.avatar.R;

public class StickerActivity extends Activity {
    protected void onCreate(Bundle bundle) {
        AndroidConfig androidConfigVar = null;
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        if (getIntent().hasExtra("DroidConfig")) {
            String stringExtra = getIntent().getStringExtra("DroidConfig");
            try {
                AndroidConfig androidConfigVar2 = new AndroidConfig();
                androidConfigVar2.getInstance(this, stringExtra);
                androidConfigVar = androidConfigVar2;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Throwable aThrowable) {
                aThrowable.printStackTrace();
            }
        }
        setContentView(R.layout.activity_sticker);
        List<View> a = Util.m1907a((ViewGroup) findViewById(R.id.sticker_root));
        AssetDatabase a2 = AssetDatabase.instance(this);
        AndroidDrawer androidDrawerVar = new AndroidDrawer(this);
        androidDrawerVar.m1848b(0.75f);
        if (androidConfigVar != null) {
            androidDrawerVar.setAndroidConfig(androidConfigVar, a2);
        } else {
            androidDrawerVar.setAndroidConfig(a2.m1656a(), a2);
        }
        int i = 1;
        for (View view : a) {
            int i2;
            if (view instanceof DrawView) {
                DrawView drawView = (DrawView) view;
                drawView.setDroidDrawer(androidDrawerVar);
                if (i != 0) {
                    i2 = 0;
                    i = i2;
                } else {
                    RandomAngleRenerator randomAngleReneratorVar = new RandomAngleRenerator();
                    randomAngleReneratorVar.m1929a();
                    drawView.setPose(randomAngleReneratorVar);
                }
            }
            i2 = i;
            i = i2;
        }
    }
}
