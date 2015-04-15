package com.google.android.apps.androidify;

import android.content.Context;
import android.graphics.RectF;
import android.graphics.drawable.PictureDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.google.android.a;
import com.google.android.apps.b.b;
import it.sephiroth.android.library.widget.HListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class an {
    public static final Interpolator a;
    public static final Interpolator b;
    private Androidify c;
    private boolean d;
    private ViewGroup e;
    private HListView f;
    private HListView g;
    private ViewGroup h;
    private Context i;
    private LayoutInflater j;
    private final ah k;
    private av l;
    private b m;
    private b n;
    private b o;
    private PictureDrawable p;
    private boolean q;

    static {
        a = new DecelerateInterpolator();
        b = new AccelerateInterpolator();
    }

    public an(Androidify androidify, ViewGroup viewGroup, boolean z) {
        this.d = false;
        this.l = null;
        this.c = androidify;
        this.e = viewGroup;
        this.q = z;
        this.i = viewGroup.getContext();
        this.f = (HListView) viewGroup.findViewById(R.id.main_drawer);
        this.g = (HListView) viewGroup.findViewById(R.id.item_drawer);
        this.h = (ViewGroup) viewGroup.findViewById(R.id.item_drawer_parent);
        this.j = (LayoutInflater) this.i.getSystemService("layout_inflater");
        this.k = ah.a(this.i);
        this.m = this.k.a((int) R.raw.trash_icon);
        this.n = this.k.a((int) R.raw.android_fullhead);
        this.o = this.k.a((int) R.raw.new_badge);
        this.p = new PictureDrawable(this.k.a((int) R.raw.color_square_selection).a);
        b a = this.k.a((int) R.raw.drawer_icons_01);
        b a2 = this.k.a((int) R.raw.drawer_nba);
        b a3 = this.k.a((int) R.raw.drawer_icons_02);
        b a4 = this.k.a((int) R.raw.drawer_icons_03);
        b a5 = this.k.a((int) R.raw.drawer_icons_04);
        b a6 = this.k.a((int) R.raw.drawer_icons_05);
        b a7 = this.k.a((int) R.raw.drawer_icons_06);
        b a8 = this.k.a((int) R.raw.drawer_icons_07);
        b a9 = this.k.a((int) R.raw.drawer_icons_08);
        b a10 = this.k.a((int) R.raw.drawer_icons_09);
        b a11 = this.k.a((int) R.raw.drawer_icons_10);
        b a12 = this.k.a((int) R.raw.drawer_icons_11);
        b a13 = this.k.a((int) R.raw.drawer_icons_12);
        ArrayList arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        arrayList.add(a);
        arrayList2.add(Boolean.valueOf(false));
        arrayList.add(a3);
        arrayList2.add(Boolean.valueOf(false));
        arrayList.add(a4);
        arrayList2.add(Boolean.valueOf(false));
        arrayList.add(a5);
        arrayList2.add(Boolean.valueOf(false));
        arrayList.add(a6);
        arrayList2.add(Boolean.valueOf(false));
        arrayList.add(a7);
        arrayList2.add(Boolean.valueOf(false));
        arrayList.add(a8);
        arrayList2.add(Boolean.valueOf(false));
        arrayList.add(a2);
        av.NBA.w = true;
        arrayList2.add(Boolean.valueOf(true));
        arrayList.add(a9);
        arrayList2.add(Boolean.valueOf(false));
        arrayList.add(a10);
        arrayList2.add(Boolean.valueOf(false));
        arrayList.add(a11);
        arrayList2.add(Boolean.valueOf(false));
        arrayList.add(a12);
        arrayList2.add(Boolean.valueOf(false));
        arrayList.add(a13);
        arrayList2.add(Boolean.valueOf(false));
        av.SKIN.a(a);
        av.NBA.a(a2);
        av.NBA.u = "nba";
        av.SHIRT.a(a3);
        av.PANTS.a(a4);
        av.SHOES.a(a5);
        av.SHOES.a(new RectF(66.306f, 300.165f, 331.641f, 560.5f));
        av.HAT.a(new RectF(66.306f, 300.165f, 331.641f, 560.5f));
        av.FACE.a(new RectF(66.306f, 300.165f, 331.641f, 560.5f));
        av.BODY.a(new RectF(66.306f, 300.165f, 331.641f, 560.5f));
        av.HAND.a(new RectF(66.306f, 300.165f, 331.641f, 560.5f));
        av.HAIR.a(a6);
        av.HAIR_COLOR.a(a7);
        av.BEARD.a(a8);
        av.GLASSES.a(a9);
        av.HAT.a(a10);
        av.FACE.a(a11);
        av.BODY.a(a12);
        av.HAND.a(a13);
        HListView hListView = this.f;
        LayoutInflater layoutInflater = this.j;
        HListView hListView2 = this.f;
        if (!z) {
            arrayList2 = null;
        }
        hListView.setAdapter(a((List) arrayList, layoutInflater, hListView2, arrayList2));
        this.f.setOnItemClickListener(new ao(this, androidify));
        this.g.setOnItemClickListener(new ap(this));
    }

    private aw a(av avVar, List list, LayoutInflater layoutInflater, HListView hListView) {
        aw awVar = new aw();
        awVar.i = avVar;
        awVar.e = list;
        awVar.b = layoutInflater;
        awVar.h = hListView;
        awVar.g = list.size();
        return awVar;
    }

    private aw a(av avVar, int[] iArr, LayoutInflater layoutInflater, HListView hListView) {
        aw awVar = new aw();
        awVar.i = avVar;
        awVar.b = layoutInflater;
        awVar.h = hListView;
        awVar.g = iArr.length;
        return awVar;
    }

    private aw a(List list, LayoutInflater layoutInflater, HListView hListView, List list2) {
        aw awVar = new aw();
        awVar.c = list;
        awVar.b = layoutInflater;
        awVar.h = hListView;
        awVar.d = list2;
        awVar.g = list.size();
        return awVar;
    }

    private List a(av avVar, String str) {
        List<ag> b = b(avVar);
        List arrayList = new ArrayList();
        Object obj = 1;
        for (ag agVar : b) {
            Object obj2;
            if (obj != null) {
                arrayList.add(agVar);
                obj2 = null;
            } else if (str == null && a.b(agVar.c)) {
                arrayList.add(agVar);
                obj2 = obj;
            } else {
                if (str != null && str.equals(agVar.c)) {
                    arrayList.add(agVar);
                }
                obj2 = obj;
            }
            obj = obj2;
        }
        return arrayList;
    }

    private void a(int i) {
        this.g.setSelection(Math.max(0, i - ((int) ((((float) this.g.getWidth()) / ((float) this.g.getHeight())) / 2.0f))));
    }

    private void a(View view, boolean z, Runnable runnable) {
        if (z) {
            float height = (float) (this.e.getHeight() - view.getTop());
            view.setTranslationY(height);
            view.setVisibility(0);
            c.a(height, 0.0f, 0, 200, a, new as(this, view, runnable));
            return;
        }
        float height2 = (float) (this.e.getHeight() - view.getTop());
        view.setTranslationY(0.0f);
        c.a(0.0f, height2, 0, 200, b, new at(this, view, runnable));
    }

    private void a(VectorView vectorView, av avVar, List list, int i) {
        b a;
        ag agVar;
        az e = this.c.e();
        vectorView.setDefaultBounds(avVar.p);
        if (list != null) {
            ag a2 = this.k.a(avVar.o, ((ag) list.get(i)).b);
            ag agVar2 = a2;
            a = this.k.a(a2, e);
            agVar = agVar2;
        } else {
            a = null;
            agVar = null;
        }
        if (a == null) {
            if (!avVar.s) {
                b a3;
                b a4;
                switch (au.a[avVar.ordinal()]) {
                    case cm.HListView_hlv_headerDividersEnabled /*3*/:
                        a = this.k.a(avVar.o, ((ag) list.get(i)).b, null);
                        vectorView.setVectors(this.n, a);
                        break;
                    case cm.HListView_hlv_footerDividersEnabled /*4*/:
                        a3 = this.k.a(avVar.o, ((ag) list.get(i)).b, "back");
                        a4 = this.k.a(avVar.o, ((ag) list.get(i)).b, "front");
                        b a5 = this.k.a(avVar.o, ((ag) list.get(i)).b, "backextra");
                        a = this.k.a(avVar.o, ((ag) list.get(i)).b, "frontextra");
                        vectorView.setVectors((b[]) c.a(b.class, a3, a5, this.n, a4, a));
                        break;
                    case cm.HListView_hlv_overScrollHeader /*5*/:
                        a3 = this.k.a(avVar.o, ((ag) list.get(i)).b, "leg");
                        a4 = this.k.a(avVar.o, ((ag) list.get(i)).b, "top");
                        a = this.k.a(avVar.o, ((ag) list.get(i)).b, "skirt");
                        vectorView.setVectors((b[]) c.a(b.class, a3, a4, a));
                        break;
                    case cm.HListView_hlv_overScrollFooter /*6*/:
                        a3 = this.k.a(avVar.o, ((ag) list.get(i)).b, "body");
                        a = this.k.a(avVar.o, ((ag) list.get(i)).b, "top");
                        if (a3 != null) {
                            if (a != null) {
                                vectorView.setVectors(a3, a);
                                break;
                            }
                            vectorView.setVectors(a3);
                            break;
                        }
                        vectorView.setVectors(a);
                        break;
                    case 12:
                        vectorView.setVectors(this.k.a((int) R.raw.android_full, al.b, Integer.valueOf(al.ai[i])));
                        break;
                    case 13:
                        a = this.k.a((int) R.raw.android_hair, al.a, Integer.valueOf(al.af[i]));
                        vectorView.setVectors(this.n, a);
                        break;
                    default:
                        a = this.k.b(agVar, e);
                        vectorView.setVectors(a);
                        break;
                }
            }
            a = this.k.b((ag) list.get(i), e);
            vectorView.setVectors(a);
        } else {
            vectorView.setVectors(a);
        }
        if (this.q && agVar != null && agVar.e()) {
            vectorView.setNewBadge(this.o);
        }
    }

    private void a(av avVar, VectorView vectorView, List list, int i) {
        az e = this.c.e();
        b bVar = null;
        vectorView.setDefaultBounds(avVar.p);
        if (list != null) {
            bVar = this.k.a(avVar.o, ((ag) list.get(i)).a(), "chooser");
        }
        if (bVar != null) {
            vectorView.setVectors(bVar);
            return;
        }
        ag a = this.k.a(avVar.o, ((ag) list.get(i)).a());
        b b = this.k.b(a, e);
        vectorView.setVectors(b);
        if (this.q && a.e()) {
            vectorView.setNewBadge(this.o);
        }
    }

    private void a(av avVar, ag agVar, int i) {
        boolean z;
        boolean z2 = true;
        if (avVar == av.NBA) {
            Iterator it = this.k.e().iterator();
            while (it.hasNext()) {
                ag agVar2 = (ag) it.next();
                if (agVar2.b.equals(agVar.b)) {
                    this.c.a("pants", agVar2, false, false);
                }
            }
            this.c.s();
            z = false;
        } else {
            z = true;
        }
        Androidify androidify = this.c;
        String str = avVar.o;
        if (i != 0) {
            z2 = false;
        }
        androidify.a(str, agVar, z2, z);
    }

    private boolean a(av avVar, int i) {
        boolean z = true;
        az e = this.c.e();
        List a = avVar.a(this).e;
        String str = null;
        if (a != null) {
            str = ((ag) a.get(i)).b;
        }
        switch (au.a[avVar.ordinal()]) {
            case cm.HListView_android_divider /*1*/:
                return str.equals(e.h());
            case cm.HListView_hlv_dividerWidth /*2*/:
                return str.equals(e.i());
            case cm.HListView_hlv_headerDividersEnabled /*3*/:
                return str.equals(e.j());
            case cm.HListView_hlv_footerDividersEnabled /*4*/:
                return str.equals(e.e());
            case cm.HListView_hlv_overScrollHeader /*5*/:
                return str.equals(e.g());
            case cm.HListView_hlv_overScrollFooter /*6*/:
                return str.equals(e.f());
            case cm.HListView_hlv_measureWithChild /*7*/:
                return str.equals(e.f());
            case cm.ExpandableHListView_hlv_childIndicatorPaddingTop /*8*/:
                return str.equals(e.v());
            case 9:
                return str.equals(e.x());
            case 10:
                return str.equals(e.z());
            case 11:
                return str.equals(e.B());
            case 12:
                return this.c.p().getSkinColorIndex() == i;
            case 13:
                if (this.c.p().getHairColorIndex() != i) {
                    z = false;
                }
                return z;
            default:
                return false;
        }
    }

    private int b(av avVar, String str) {
        if (str == null) {
            return 0;
        }
        List a = avVar.a(this).e;
        for (int i = 0; i < a.size(); i++) {
            if (str.equals(((ag) a.get(i)).b)) {
                return i;
            }
        }
        return -1;
    }

    private List b(av avVar) {
        switch (au.a[avVar.ordinal()]) {
            case cm.HListView_android_divider /*1*/:
                return this.k.f();
            case cm.HListView_hlv_dividerWidth /*2*/:
                return this.k.g();
            case cm.HListView_hlv_headerDividersEnabled /*3*/:
                return this.k.h();
            case cm.HListView_hlv_footerDividersEnabled /*4*/:
                return this.k.c();
            case cm.HListView_hlv_overScrollHeader /*5*/:
                return this.k.e();
            case cm.HListView_hlv_overScrollFooter /*6*/:
                return this.k.d();
            case cm.HListView_hlv_measureWithChild /*7*/:
                return this.k.d();
            case cm.ExpandableHListView_hlv_childIndicatorPaddingTop /*8*/:
                return this.k.i();
            case 9:
                return this.k.j();
            case 10:
                return this.k.k();
            case 11:
                return this.k.l();
            default:
                return null;
        }
    }

    private void b(av avVar, int i) {
        if (avVar == av.SKIN) {
            this.c.b(i);
        } else if (avVar == av.HAIR_COLOR) {
            this.c.a(i);
        } else {
            a(avVar, (ag) avVar.a(this).e.get(i), i);
            switch (au.a[avVar.ordinal()]) {
                case cm.HListView_android_divider /*1*/:
                case cm.HListView_hlv_dividerWidth /*2*/:
                case cm.HListView_hlv_headerDividersEnabled /*3*/:
                case cm.HListView_hlv_footerDividersEnabled /*4*/:
                case cm.HListView_hlv_overScrollHeader /*5*/:
                case cm.ExpandableHListView_hlv_childIndicatorPaddingTop /*8*/:
                case 9:
                case 10:
                case cm.HListView_hlv_overScrollFooter /*6*/:
                    this.c.c(2);
                    this.c.a(1000, true);
                default:
            }
        }
    }

    private int c(av avVar) {
        az e = this.c.e();
        switch (au.a[avVar.ordinal()]) {
            case cm.HListView_android_divider /*1*/:
                return b(avVar, e.h());
            case cm.HListView_hlv_dividerWidth /*2*/:
                return b(avVar, e.i());
            case cm.HListView_hlv_headerDividersEnabled /*3*/:
                return b(avVar, e.j());
            case cm.HListView_hlv_footerDividersEnabled /*4*/:
                return b(avVar, e.e());
            case cm.HListView_hlv_overScrollHeader /*5*/:
                return b(avVar, e.g());
            case cm.HListView_hlv_overScrollFooter /*6*/:
                return b(avVar, e.f());
            case cm.HListView_hlv_measureWithChild /*7*/:
                return b(avVar, e.f());
            case cm.ExpandableHListView_hlv_childIndicatorPaddingTop /*8*/:
                return b(avVar, e.v());
            case 9:
                return b(avVar, e.x());
            case 10:
                return b(avVar, e.z());
            case 11:
                return b(avVar, e.B());
            case 12:
                return this.c.p().getSkinColorIndex();
            case 13:
                return this.c.p().getHairColorIndex();
            default:
                return -1;
        }
    }

    private int d(av avVar) {
        return c(avVar);
    }

    private int e(av avVar) {
        int c = c(avVar) + 1;
        aw a = avVar.a(this);
        int i = c == a.getCount() ? 0 : c;
        a(avVar, (ag) a.e.get(i), i);
        return i;
    }

    private void e() {
        int childCount = this.g.getChildCount();
        for (int i = 0; i < childCount; i++) {
            VectorView vectorView = (VectorView) this.g.getChildAt(i);
            vectorView.setSelected(a(this.l, ((Integer) vectorView.getTag()).intValue()));
        }
    }

    public void a() {
        if (this.l == null || !this.l.q) {
            a(av.HAIR);
        } else {
            a(this.l);
        }
    }

    public void a(av avVar) {
        if (avVar == null) {
            this.c.a(1000, true);
            this.c.c(3);
            this.c.a(4, true);
            this.c.c(1000);
            this.c.a(3, true);
            this.g.postDelayed(new aq(this), 2500);
            this.c.c(1);
            this.c.a(1, true);
            this.c.a(2, true);
            this.c.a(0, true);
        } else {
            this.c.a(0, false);
            this.c.a(1, false);
            this.c.a(2, false);
            this.c.a(3, false);
            this.c.d(3);
            this.c.c(4);
        }
        if (avVar == av.SKIN) {
            this.c.d(1);
        } else if (avVar == av.SHIRT) {
            this.c.d(2);
        }
        if (avVar != null && avVar.w && this.q) {
            this.c.v();
        }
        if (avVar != this.l) {
            Runnable arVar = new ar(this, avVar);
            if (this.l != null) {
                a(this.h, false, arVar);
            } else {
                arVar.run();
            }
        } else if (this.l != null && this.l != av.HAIR_COLOR && this.l != av.SKIN) {
            int e = e(this.l);
            a(e, false);
            a(e);
            this.g.invalidate();
        }
    }

    public boolean a(int i, boolean z) {
        boolean z2 = false;
        if (!a(this.l, i) || this.l == av.HAIR_COLOR || this.l == av.SKIN || !z) {
            b(this.l, i);
            z2 = true;
        } else {
            b(this.l, 0);
        }
        e();
        return z2;
    }

    public void b() {
        if (this.l == null || !this.l.r) {
            if (b(av.NBA, this.c.e().f()) > 0) {
                a(av.NBA);
                return;
            } else {
                a(av.SHIRT);
                return;
            }
        }
        a(this.l);
    }

    public void c() {
        a(null);
    }

    public boolean d() {
        if (this.l == null) {
            return false;
        }
        a(null);
        this.c.g();
        return true;
    }
}
