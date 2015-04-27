package com.google.p007a;

import com.google.android.apps.androidify.cm;
import com.google.p007a.p008a.C0129b;
import com.google.p007a.p010b.C0136b;
import com.google.p007a.p010b.C0138d;
import com.google.p007a.p010b.C0140f;
import com.google.p007a.p010b.C0144h;
import com.google.p007a.p010b.C0145i;
import com.google.p007a.p010b.C0147k;
import com.google.p007a.p010b.C0148n;
import com.google.p007a.p011c.p012a.C0157h;
import com.google.p007a.p013d.C0165a;
import java.util.Map;

/* renamed from: com.google.a.d */
public final class C0173d implements C0134g {
    public C0129b m1093a(String str, C0131a c0131a, int i, int i2, Map map) {
        C0134g c0145i;
        switch (C0174e.f604a[c0131a.ordinal()]) {
            case cm.HListView_android_divider /*1*/:
                c0145i = new C0145i();
                break;
            case cm.HListView_hlv_dividerWidth /*2*/:
                c0145i = new C0144h();
                break;
            case cm.HListView_hlv_headerDividersEnabled /*3*/:
                c0145i = new C0148n();
                break;
            case cm.HListView_hlv_footerDividersEnabled /*4*/:
                c0145i = new C0165a();
                break;
            case cm.HListView_hlv_overScrollHeader /*5*/:
                c0145i = new C0140f();
                break;
            case cm.HListView_hlv_overScrollFooter /*6*/:
                c0145i = new C0138d();
                break;
            case cm.HListView_hlv_measureWithChild /*7*/:
                c0145i = new C0147k();
                break;
            case cm.ExpandableHListView_hlv_childIndicatorPaddingTop /*8*/:
                c0145i = new C0157h();
                break;
            case 9:
                c0145i = new C0136b();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format " + c0131a);
        }
        return c0145i.m952a(str, c0131a, i, i2, map);
    }
}
