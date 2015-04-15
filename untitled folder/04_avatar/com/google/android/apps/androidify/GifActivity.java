package com.google.android.apps.androidify;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.apps.androidify.a.a;
import com.google.android.apps.androidify.a.e;

public class GifActivity extends Activity {
    private ba a;
    private e b;
    private long c;

    public GifActivity() {
        this.c = 0;
    }

    private void a() {
        long currentTimeMillis = System.currentTimeMillis();
        c.a("- Elapsed: " + (currentTimeMillis - this.c));
        this.c = currentTimeMillis;
    }

    public void encodeClicked(View view) {
        new bt(this).execute(new Void[0]);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_gif);
        ah a = ah.a((Context) this);
        this.a = new ba(this);
        az a2 = a.a();
        this.a.a(a2, a);
        this.a.a(400, 400);
        this.a.b(0.75f);
        this.b = a.a((Context) this, (int) R.raw.anim_bodywave);
        DrawView drawView = (DrawView) findViewById(R.id.draw_view);
        drawView.setDroidConfig(a2);
        drawView.setMotion(this.b);
    }
}
