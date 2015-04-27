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
import com.google.android.C0176a;
import com.google.android.apps.p019b.C0249b;
import it.sephiroth.android.library.widget.HListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class an {
    public static final Interpolator f1218a;
    public static final Interpolator f1219b;
    private Androidify f1220c;
    private boolean f1221d;
    private ViewGroup f1222e;
    private HListView f1223f;
    private HListView f1224g;
    private ViewGroup f1225h;
    private Context f1226i;
    private LayoutInflater f1227j;
    private final ah f1228k;
    private av f1229l;
    private C0249b f1230m;
    private C0249b f1231n;
    private C0249b f1232o;
    private PictureDrawable f1233p;
    private boolean f1234q;

    static {
        f1218a = new DecelerateInterpolator();
        f1219b = new AccelerateInterpolator();
    }

    public an(Androidify androidify, ViewGroup viewGroup, boolean z) {
        this.f1221d = false;
        this.f1229l = null;
        this.f1220c = androidify;
        this.f1222e = viewGroup;
        this.f1234q = z;
        this.f1226i = viewGroup.getContext();
        this.f1223f = (HListView) viewGroup.findViewById(R.id.main_drawer);
        this.f1224g = (HListView) viewGroup.findViewById(R.id.item_drawer);
        this.f1225h = (ViewGroup) viewGroup.findViewById(R.id.item_drawer_parent);
        this.f1227j = (LayoutInflater) this.f1226i.getSystemService("layout_inflater");
        this.f1228k = ah.m1648a(this.f1226i);
        this.f1230m = this.f1228k.m1657a((int) R.raw.trash_icon);
        this.f1231n = this.f1228k.m1657a((int) R.raw.android_fullhead);
        this.f1232o = this.f1228k.m1657a((int) R.raw.new_badge);
        this.f1233p = new PictureDrawable(this.f1228k.m1657a((int) R.raw.color_square_selection).f1708a);
        C0249b a = this.f1228k.m1657a((int) R.raw.drawer_icons_01);
        C0249b a2 = this.f1228k.m1657a((int) R.raw.drawer_nba);
        C0249b a3 = this.f1228k.m1657a((int) R.raw.drawer_icons_02);
        C0249b a4 = this.f1228k.m1657a((int) R.raw.drawer_icons_03);
        C0249b a5 = this.f1228k.m1657a((int) R.raw.drawer_icons_04);
        C0249b a6 = this.f1228k.m1657a((int) R.raw.drawer_icons_05);
        C0249b a7 = this.f1228k.m1657a((int) R.raw.drawer_icons_06);
        C0249b a8 = this.f1228k.m1657a((int) R.raw.drawer_icons_07);
        C0249b a9 = this.f1228k.m1657a((int) R.raw.drawer_icons_08);
        C0249b a10 = this.f1228k.m1657a((int) R.raw.drawer_icons_09);
        C0249b a11 = this.f1228k.m1657a((int) R.raw.drawer_icons_10);
        C0249b a12 = this.f1228k.m1657a((int) R.raw.drawer_icons_11);
        C0249b a13 = this.f1228k.m1657a((int) R.raw.drawer_icons_12);
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
        av.NBA.f1271w = true;
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
        av.SKIN.m1745a(a);
        av.NBA.m1745a(a2);
        av.NBA.f1269u = "nba";
        av.SHIRT.m1745a(a3);
        av.PANTS.m1745a(a4);
        av.SHOES.m1745a(a5);
        av.SHOES.m1744a(new RectF(66.306f, 300.165f, 331.641f, 560.5f));
        av.HAT.m1744a(new RectF(66.306f, 300.165f, 331.641f, 560.5f));
        av.FACE.m1744a(new RectF(66.306f, 300.165f, 331.641f, 560.5f));
        av.BODY.m1744a(new RectF(66.306f, 300.165f, 331.641f, 560.5f));
        av.HAND.m1744a(new RectF(66.306f, 300.165f, 331.641f, 560.5f));
        av.HAIR.m1745a(a6);
        av.HAIR_COLOR.m1745a(a7);
        av.BEARD.m1745a(a8);
        av.GLASSES.m1745a(a9);
        av.HAT.m1745a(a10);
        av.FACE.m1745a(a11);
        av.BODY.m1745a(a12);
        av.HAND.m1745a(a13);
        HListView hListView = this.f1223f;
        LayoutInflater layoutInflater = this.f1227j;
        HListView hListView2 = this.f1223f;
        if (!z) {
            arrayList2 = null;
        }
        hListView.setAdapter(m1702a((List) arrayList, layoutInflater, hListView2, arrayList2));
        this.f1223f.setOnItemClickListener(new ao(this, androidify));
        this.f1224g.setOnItemClickListener(new ap(this));
    }

    private aw m1700a(av avVar, List list, LayoutInflater layoutInflater, HListView hListView) {
        aw awVar = new aw();
        awVar.f1280i = avVar;
        awVar.f1276e = list;
        awVar.f1273b = layoutInflater;
        awVar.f1279h = hListView;
        awVar.f1278g = list.size();
        return awVar;
    }

    private aw m1701a(av avVar, int[] iArr, LayoutInflater layoutInflater, HListView hListView) {
        aw awVar = new aw();
        awVar.f1280i = avVar;
        awVar.f1273b = layoutInflater;
        awVar.f1279h = hListView;
        awVar.f1278g = iArr.length;
        return awVar;
    }

    private aw m1702a(List list, LayoutInflater layoutInflater, HListView hListView, List list2) {
        aw awVar = new aw();
        awVar.f1274c = list;
        awVar.f1273b = layoutInflater;
        awVar.f1279h = hListView;
        awVar.f1275d = list2;
        awVar.f1278g = list.size();
        return awVar;
    }

    private List m1705a(av avVar, String str) {
        List<ag> b = m1719b(avVar);
        List arrayList = new ArrayList();
        Object obj = 1;
        for (ag agVar : b) {
            Object obj2;
            if (obj != null) {
                arrayList.add(agVar);
                obj2 = null;
            } else if (str == null && C0176a.m1105b(agVar.f1130c)) {
                arrayList.add(agVar);
                obj2 = obj;
            } else {
                if (str != null && str.equals(agVar.f1130c)) {
                    arrayList.add(agVar);
                }
                obj2 = obj;
            }
            obj = obj2;
        }
        return arrayList;
    }

    private void m1706a(int i) {
        this.f1224g.setSelection(Math.max(0, i - ((int) ((((float) this.f1224g.getWidth()) / ((float) this.f1224g.getHeight())) / 2.0f))));
    }

    private void m1707a(View view, boolean z, Runnable runnable) {
        if (z) {
            float height = (float) (this.f1222e.getHeight() - view.getTop());
            view.setTranslationY(height);
            view.setVisibility(0);
            C0220c.m1909a(height, 0.0f, 0, 200, f1218a, new as(this, view, runnable));
            return;
        }
        float height2 = (float) (this.f1222e.getHeight() - view.getTop());
        view.setTranslationY(0.0f);
        C0220c.m1909a(0.0f, height2, 0, 200, f1219b, new at(this, view, runnable));
    }

    private void m1708a(VectorView vectorView, av avVar, List list, int i) {
        C0249b a;
        ag agVar;
        az e = this.f1220c.m1391e();
        vectorView.setDefaultBounds(avVar.f1264p);
        if (list != null) {
            ag a2 = this.f1228k.m1655a(avVar.f1263o, ((ag) list.get(i)).f1129b);
            ag agVar2 = a2;
            a = this.f1228k.m1659a(a2, e);
            agVar = agVar2;
        } else {
            a = null;
            agVar = null;
        }
        if (a == null) {
            if (!avVar.f1267s) {
                C0249b a3;
                C0249b a4;
                switch (au.f1247a[avVar.ordinal()]) {
                    case cm.HListView_hlv_headerDividersEnabled /*3*/:
                        a = this.f1228k.m1662a(avVar.f1263o, ((ag) list.get(i)).f1129b, null);
                        vectorView.setVectors(this.f1231n, a);
                        break;
                    case cm.HListView_hlv_footerDividersEnabled /*4*/:
                        a3 = this.f1228k.m1662a(avVar.f1263o, ((ag) list.get(i)).f1129b, "back");
                        a4 = this.f1228k.m1662a(avVar.f1263o, ((ag) list.get(i)).f1129b, "front");
                        C0249b a5 = this.f1228k.m1662a(avVar.f1263o, ((ag) list.get(i)).f1129b, "backextra");
                        a = this.f1228k.m1662a(avVar.f1263o, ((ag) list.get(i)).f1129b, "frontextra");
                        vectorView.setVectors((C0249b[]) C0220c.m1913a(C0249b.class, a3, a5, this.f1231n, a4, a));
                        break;
                    case cm.HListView_hlv_overScrollHeader /*5*/:
                        a3 = this.f1228k.m1662a(avVar.f1263o, ((ag) list.get(i)).f1129b, "leg");
                        a4 = this.f1228k.m1662a(avVar.f1263o, ((ag) list.get(i)).f1129b, "top");
                        a = this.f1228k.m1662a(avVar.f1263o, ((ag) list.get(i)).f1129b, "skirt");
                        vectorView.setVectors((C0249b[]) C0220c.m1913a(C0249b.class, a3, a4, a));
                        break;
                    case cm.HListView_hlv_overScrollFooter /*6*/:
                        a3 = this.f1228k.m1662a(avVar.f1263o, ((ag) list.get(i)).f1129b, "body");
                        a = this.f1228k.m1662a(avVar.f1263o, ((ag) list.get(i)).f1129b, "top");
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
                        vectorView.setVectors(this.f1228k.m1658a((int) R.raw.android_full, al.f1191b, Integer.valueOf(al.ai[i])));
                        break;
                    case 13:
                        a = this.f1228k.m1658a((int) R.raw.android_hair, al.f1190a, Integer.valueOf(al.af[i]));
                        vectorView.setVectors(this.f1231n, a);
                        break;
                    default:
                        a = this.f1228k.m1669b(agVar, e);
                        vectorView.setVectors(a);
                        break;
                }
            }
            a = this.f1228k.m1669b((ag) list.get(i), e);
            vectorView.setVectors(a);
        } else {
            vectorView.setVectors(a);
        }
        if (this.f1234q && agVar != null && agVar.m1646e()) {
            vectorView.setNewBadge(this.f1232o);
        }
    }

    private void m1712a(av avVar, VectorView vectorView, List list, int i) {
        az e = this.f1220c.m1391e();
        C0249b c0249b = null;
        vectorView.setDefaultBounds(avVar.f1264p);
        if (list != null) {
            c0249b = this.f1228k.m1662a(avVar.f1263o, ((ag) list.get(i)).m1642a(), "chooser");
        }
        if (c0249b != null) {
            vectorView.setVectors(c0249b);
            return;
        }
        ag a = this.f1228k.m1655a(avVar.f1263o, ((ag) list.get(i)).m1642a());
        C0249b b = this.f1228k.m1669b(a, e);
        vectorView.setVectors(b);
        if (this.f1234q && a.m1646e()) {
            vectorView.setNewBadge(this.f1232o);
        }
    }

    private void m1713a(av avVar, ag agVar, int i) {
        boolean z;
        boolean z2 = true;
        if (avVar == av.NBA) {
            Iterator it = this.f1228k.m1675e().iterator();
            while (it.hasNext()) {
                ag agVar2 = (ag) it.next();
                if (agVar2.f1129b.equals(agVar.f1129b)) {
                    this.f1220c.m1379a("pants", agVar2, false, false);
                }
            }
            this.f1220c.m1403s();
            z = false;
        } else {
            z = true;
        }
        Androidify androidify = this.f1220c;
        String str = avVar.f1263o;
        if (i != 0) {
            z2 = false;
        }
        androidify.m1379a(str, agVar, z2, z);
    }

    private boolean m1715a(av avVar, int i) {
        boolean z = true;
        az e = this.f1220c.m1391e();
        List a = avVar.m1743a(this).f1276e;
        String str = null;
        if (a != null) {
            str = ((ag) a.get(i)).f1129b;
        }
        switch (au.f1247a[avVar.ordinal()]) {
            case cm.HListView_android_divider /*1*/:
                return str.equals(e.m1805h());
            case cm.HListView_hlv_dividerWidth /*2*/:
                return str.equals(e.m1807i());
            case cm.HListView_hlv_headerDividersEnabled /*3*/:
                return str.equals(e.m1808j());
            case cm.HListView_hlv_footerDividersEnabled /*4*/:
                return str.equals(e.m1796e());
            case cm.HListView_hlv_overScrollHeader /*5*/:
                return str.equals(e.m1802g());
            case cm.HListView_hlv_overScrollFooter /*6*/:
                return str.equals(e.m1799f());
            case cm.HListView_hlv_measureWithChild /*7*/:
                return str.equals(e.m1799f());
            case cm.ExpandableHListView_hlv_childIndicatorPaddingTop /*8*/:
                return str.equals(e.m1820v());
            case 9:
                return str.equals(e.m1822x());
            case 10:
                return str.equals(e.m1824z());
            case 11:
                return str.equals(e.m1766B());
            case 12:
                return this.f1220c.m1400p().getSkinColorIndex() == i;
            case 13:
                if (this.f1220c.m1400p().getHairColorIndex() != i) {
                    z = false;
                }
                return z;
            default:
                return false;
        }
    }

    private int m1716b(av avVar, String str) {
        if (str == null) {
            return 0;
        }
        List a = avVar.m1743a(this).f1276e;
        for (int i = 0; i < a.size(); i++) {
            if (str.equals(((ag) a.get(i)).f1129b)) {
                return i;
            }
        }
        return -1;
    }

    private List m1719b(av avVar) {
        switch (au.f1247a[avVar.ordinal()]) {
            case cm.HListView_android_divider /*1*/:
                return this.f1228k.m1677f();
            case cm.HListView_hlv_dividerWidth /*2*/:
                return this.f1228k.m1679g();
            case cm.HListView_hlv_headerDividersEnabled /*3*/:
                return this.f1228k.m1681h();
            case cm.HListView_hlv_footerDividersEnabled /*4*/:
                return this.f1228k.m1671c();
            case cm.HListView_hlv_overScrollHeader /*5*/:
                return this.f1228k.m1675e();
            case cm.HListView_hlv_overScrollFooter /*6*/:
                return this.f1228k.m1673d();
            case cm.HListView_hlv_measureWithChild /*7*/:
                return this.f1228k.m1673d();
            case cm.ExpandableHListView_hlv_childIndicatorPaddingTop /*8*/:
                return this.f1228k.m1683i();
            case 9:
                return this.f1228k.m1685j();
            case 10:
                return this.f1228k.m1687k();
            case 11:
                return this.f1228k.m1688l();
            default:
                return null;
        }
    }

    private void m1720b(av avVar, int i) {
        if (avVar == av.SKIN) {
            this.f1220c.m1383b(i);
        } else if (avVar == av.HAIR_COLOR) {
            this.f1220c.m1370a(i);
        } else {
            m1713a(avVar, (ag) avVar.m1743a(this).f1276e.get(i), i);
            switch (au.f1247a[avVar.ordinal()]) {
                case cm.HListView_android_divider /*1*/:
                case cm.HListView_hlv_dividerWidth /*2*/:
                case cm.HListView_hlv_headerDividersEnabled /*3*/:
                case cm.HListView_hlv_footerDividersEnabled /*4*/:
                case cm.HListView_hlv_overScrollHeader /*5*/:
                case cm.ExpandableHListView_hlv_childIndicatorPaddingTop /*8*/:
                case 9:
                case 10:
                case cm.HListView_hlv_overScrollFooter /*6*/:
                    this.f1220c.m1386c(2);
                    this.f1220c.m1371a(1000, true);
                default:
            }
        }
    }

    private int m1722c(av avVar) {
        az e = this.f1220c.m1391e();
        switch (au.f1247a[avVar.ordinal()]) {
            case cm.HListView_android_divider /*1*/:
                return m1716b(avVar, e.m1805h());
            case cm.HListView_hlv_dividerWidth /*2*/:
                return m1716b(avVar, e.m1807i());
            case cm.HListView_hlv_headerDividersEnabled /*3*/:
                return m1716b(avVar, e.m1808j());
            case cm.HListView_hlv_footerDividersEnabled /*4*/:
                return m1716b(avVar, e.m1796e());
            case cm.HListView_hlv_overScrollHeader /*5*/:
                return m1716b(avVar, e.m1802g());
            case cm.HListView_hlv_overScrollFooter /*6*/:
                return m1716b(avVar, e.m1799f());
            case cm.HListView_hlv_measureWithChild /*7*/:
                return m1716b(avVar, e.m1799f());
            case cm.ExpandableHListView_hlv_childIndicatorPaddingTop /*8*/:
                return m1716b(avVar, e.m1820v());
            case 9:
                return m1716b(avVar, e.m1822x());
            case 10:
                return m1716b(avVar, e.m1824z());
            case 11:
                return m1716b(avVar, e.m1766B());
            case 12:
                return this.f1220c.m1400p().getSkinColorIndex();
            case 13:
                return this.f1220c.m1400p().getHairColorIndex();
            default:
                return -1;
        }
    }

    private int m1724d(av avVar) {
        return m1722c(avVar);
    }

    private int m1726e(av avVar) {
        int c = m1722c(avVar) + 1;
        aw a = avVar.m1743a(this);
        int i = c == a.getCount() ? 0 : c;
        m1713a(avVar, (ag) a.f1276e.get(i), i);
        return i;
    }

    private void m1728e() {
        int childCount = this.f1224g.getChildCount();
        for (int i = 0; i < childCount; i++) {
            VectorView vectorView = (VectorView) this.f1224g.getChildAt(i);
            vectorView.setSelected(m1715a(this.f1229l, ((Integer) vectorView.getTag()).intValue()));
        }
    }

    public void m1731a() {
        if (this.f1229l == null || !this.f1229l.f1265q) {
            m1732a(av.HAIR);
        } else {
            m1732a(this.f1229l);
        }
    }

    public void m1732a(av avVar) {
        if (avVar == null) {
            this.f1220c.m1371a(1000, true);
            this.f1220c.m1386c(3);
            this.f1220c.m1371a(4, true);
            this.f1220c.m1386c(1000);
            this.f1220c.m1371a(3, true);
            this.f1224g.postDelayed(new aq(this), 2500);
            this.f1220c.m1386c(1);
            this.f1220c.m1371a(1, true);
            this.f1220c.m1371a(2, true);
            this.f1220c.m1371a(0, true);
        } else {
            this.f1220c.m1371a(0, false);
            this.f1220c.m1371a(1, false);
            this.f1220c.m1371a(2, false);
            this.f1220c.m1371a(3, false);
            this.f1220c.m1389d(3);
            this.f1220c.m1386c(4);
        }
        if (avVar == av.SKIN) {
            this.f1220c.m1389d(1);
        } else if (avVar == av.SHIRT) {
            this.f1220c.m1389d(2);
        }
        if (avVar != null && avVar.f1271w && this.f1234q) {
            this.f1220c.m1406v();
        }
        if (avVar != this.f1229l) {
            Runnable arVar = new ar(this, avVar);
            if (this.f1229l != null) {
                m1707a(this.f1225h, false, arVar);
            } else {
                arVar.run();
            }
        } else if (this.f1229l != null && this.f1229l != av.HAIR_COLOR && this.f1229l != av.SKIN) {
            int e = m1726e(this.f1229l);
            m1733a(e, false);
            m1706a(e);
            this.f1224g.invalidate();
        }
    }

    public boolean m1733a(int i, boolean z) {
        boolean z2 = false;
        if (!m1715a(this.f1229l, i) || this.f1229l == av.HAIR_COLOR || this.f1229l == av.SKIN || !z) {
            m1720b(this.f1229l, i);
            z2 = true;
        } else {
            m1720b(this.f1229l, 0);
        }
        m1728e();
        return z2;
    }

    public void m1734b() {
        if (this.f1229l == null || !this.f1229l.f1266r) {
            if (m1716b(av.NBA, this.f1220c.m1391e().m1799f()) > 0) {
                m1732a(av.NBA);
                return;
            } else {
                m1732a(av.SHIRT);
                return;
            }
        }
        m1732a(this.f1229l);
    }

    public void m1735c() {
        m1732a(null);
    }

    public boolean m1736d() {
        if (this.f1229l == null) {
            return false;
        }
        m1732a(null);
        this.f1220c.m1393g();
        return true;
    }
}
