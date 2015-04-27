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
    Androidify f1516a;
    ArrayList f1517b;
    int f1518c;
    int f1519d;
    Handler f1520e;
    Handler f1521f;
    private Picture f1522g;
    private Picture f1523h;
    private Picture f1524i;
    private Picture f1525j;
    private Picture f1526k;
    private Picture f1527l;
    private Bitmap f1528m;

    private View m1931a() {
        View relativeLayout = new RelativeLayout(this.f1516a);
        relativeLayout.setPadding(2, 2, 2, 2);
        relativeLayout.setBackgroundColor(0);
        View imageView = new ImageView(this.f1516a);
        imageView.setScaleType(ScaleType.CENTER_INSIDE);
        imageView.setId(17778);
        imageView.setImageBitmap(this.f1528m);
        imageView.setLayoutParams(new LayoutParams(this.f1518c, this.f1519d));
        View textView = new TextView(this.f1516a);
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
        return this.f1517b.size();
    }

    public Object getItem(int i) {
        return this.f1517b.get(i);
    }

    public long getItemId(int i) {
        return new Double((double) ((AndroidConfig) this.f1517b.get(i)).m1770F()).longValue();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = m1931a();
        }
        ((TextView) view.findViewById(17779)).setText(((AndroidConfig) this.f1517b.get(i)).m1769E().trim());
        this.f1520e.post(new cp(this, i, view.findViewById(17778), null));
        return view;
    }
}
