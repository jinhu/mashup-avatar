package com.google.a;

import com.google.a.a.b;
import com.google.a.b.f;
import com.google.a.b.h;
import com.google.a.b.i;
import com.google.a.b.k;
import com.google.a.b.n;
import com.google.a.d.a;
import com.google.android.apps.androidify.cm;
import java.util.Map;

public final class d implements g {
    public b a(String str, a aVar, int i, int i2, Map map) {
        g iVar;
        switch (e.a[aVar.ordinal()]) {
            case cm.HListView_android_divider /*1*/:
                iVar = new i();
                break;
            case cm.HListView_hlv_dividerWidth /*2*/:
                iVar = new h();
                break;
            case cm.HListView_hlv_headerDividersEnabled /*3*/:
                iVar = new n();
                break;
            case cm.HListView_hlv_footerDividersEnabled /*4*/:
                iVar = new a();
                break;
            case cm.HListView_hlv_overScrollHeader /*5*/:
                iVar = new f();
                break;
            case cm.HListView_hlv_overScrollFooter /*6*/:
                iVar = new com.google.a.b.d();
                break;
            case cm.HListView_hlv_measureWithChild /*7*/:
                iVar = new k();
                break;
            case cm.ExpandableHListView_hlv_childIndicatorPaddingTop /*8*/:
                iVar = new com.google.a.c.a.h();
                break;
            case 9:
                iVar = new com.google.a.b.b();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format " + aVar);
        }
        return iVar.a(str, aVar, i, i2, map);
    }
}
