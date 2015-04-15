package com.google.android.apps.androidify;

import android.graphics.Bitmap;
import android.graphics.Picture;
import android.os.Handler;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import java.util.ArrayList;

public class cn extends BaseAdapter {
    Androidify a;
    ArrayList b;
    int c;
    int d;
    Handler e;
    Handler f;
    private Picture g;
    private Picture h;
    private Picture i;
    private Picture j;
    private Picture k;
    private Picture l;
    private Bitmap m;

    private View a() {
        View relativeLayout = new RelativeLayout(this.a);
        relativeLayout.setPadding(2, 2, 2, 2);
        relativeLayout.setBackgroundColor(0);
        View imageView = new ImageView(this.a);
        imageView.setScaleType(ScaleType.CENTER_INSIDE);
        imageView.setId(17778);
        imageView.setImageBitmap(this.m);
        imageView.setLayoutParams(new LayoutParams(this.c, this.d));
        View textView = new TextView(this.a);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.addRule(8, 17778);
        textView.setLayoutParams(layoutParams);
        textView.setPadding(4, 1, 4, 7);
        textView.setGravity(3);
        textView.setTextSize(14.0f);
        textView.setTextColor(-16777216);
        textView.setEllipsize(TruncateAt.END);
        textView.setSingleLine(true);
        textView.setLines(1);
        textView.setBackgroundColor(0);
        textView.setId(17779);
        relativeLayout.addView(imageView);
        relativeLayout.addView(textView);
        return relativeLayout;
    }

    public int getCount() {
        return this.b.size();
    }

    public Object getItem(int i) {
        return this.b.get(i);
    }

    public long getItemId(int i) {
        return new Double((double) ((az) this.b.get(i)).F()).longValue();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = a();
        }
        ((TextView) view.findViewById(17779)).setText(((az) this.b.get(i)).E().trim());
        this.e.post(new cp(this, i, view.findViewById(17778), null));
        return view;
    }
}
