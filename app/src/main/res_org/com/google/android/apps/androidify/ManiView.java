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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dev.game.legend.androidify.wallpaper.AndroidDrawer;
import dev.game.legend.avatar.R;
import dev.game.legend.svgandroid.SVG;
import it.sephiroth.android.library.widget.HListView;

public class ManiView {
    public static final Interpolator f1218a;
    public static final Interpolator f1219b;
    private Androidify f1220c;
    private boolean f1221d;
    private ViewGroup f1222e;
    private HListView mCategoryView;
    private HListView mAssetsView;
    private ViewGroup f1225h;
    private Context f1226i;
    private LayoutInflater mLayoutInflater;
    private final AssetDatabase mAssetDatabase;
    AccessoriesContainer f1229l;
    public SVG f1230m;
    public SVG f1231n;
    public PictureDrawable f1233p;
    private boolean f1234q;

    static {
        f1218a = new DecelerateInterpolator();
        f1219b = new AccelerateInterpolator();
    }

    private ManiView mManiViewVar;
    public SVG mSVG;
    public AndroidDrawer mAndroidDrawer;

    public ManiView(Androidify androidify, ViewGroup viewGroup, boolean z) {
        this.f1221d = false;
        this.f1229l = null;
        this.f1220c = androidify;
        this.f1222e = viewGroup;
        this.f1234q = z;
        this.f1226i = viewGroup.getContext();
        this.mCategoryView = (HListView) viewGroup.findViewById(R.id.main_drawer);
        this.mAssetsView = (HListView) viewGroup.findViewById(R.id.item_drawer);
        this.f1225h = (ViewGroup) viewGroup.findViewById(R.id.item_drawer_parent);
        this.mLayoutInflater = (LayoutInflater) this.f1226i.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mAssetDatabase = AssetDatabase.instance(this.f1226i);
        this.f1230m = this.mAssetDatabase.getSvgFromResource((int) R.raw.trash_icon);
        this.f1231n = this.mAssetDatabase.getSvgFromResource((int) R.raw.android_fullhead);
        this.mSVG = this.mAssetDatabase.getSvgFromResource((int) R.raw.new_badge);
        this.f1233p = new PictureDrawable(this.mAssetDatabase.getSvgFromResource((int) R.raw.color_square_selection).getPicture());
        SVG a = this.mAssetDatabase.getSvgFromResource((int) R.raw.drawer_icons_01);
        SVG a2 = this.mAssetDatabase.getSvgFromResource((int) R.raw.drawer_nba);
        SVG a3 = this.mAssetDatabase.getSvgFromResource((int) R.raw.drawer_icons_02);
        SVG a4 = this.mAssetDatabase.getSvgFromResource((int) R.raw.drawer_icons_03);
        SVG a5 = this.mAssetDatabase.getSvgFromResource((int) R.raw.drawer_icons_04);
        SVG a6 = this.mAssetDatabase.getSvgFromResource((int) R.raw.drawer_icons_05);
        SVG a7 = this.mAssetDatabase.getSvgFromResource((int) R.raw.drawer_icons_06);
        SVG a8 = this.mAssetDatabase.getSvgFromResource((int) R.raw.drawer_icons_07);
        SVG a9 = this.mAssetDatabase.getSvgFromResource((int) R.raw.drawer_icons_08);
        SVG a10 = this.mAssetDatabase.getSvgFromResource((int) R.raw.drawer_icons_09);
        SVG a11 = this.mAssetDatabase.getSvgFromResource((int) R.raw.drawer_icons_10);
        SVG a12 = this.mAssetDatabase.getSvgFromResource((int) R.raw.drawer_icons_11);
        SVG a13 = this.mAssetDatabase.getSvgFromResource((int) R.raw.drawer_icons_12);
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
        AccessoriesContainer.NBA.f1271w = true;
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
        AccessoriesContainer.SKIN.m1745a(a);
        AccessoriesContainer.NBA.m1745a(a2);
        AccessoriesContainer.NBA.f1269u = "nba";
        AccessoriesContainer.SHIRT.m1745a(a3);
        AccessoriesContainer.PANTS.m1745a(a4);
        AccessoriesContainer.SHOES.m1745a(a5);
        AccessoriesContainer.SHOES.m1744a(new RectF(66.306f, 300.165f, 331.641f, 560.5f));
        AccessoriesContainer.HAT.m1744a(new RectF(66.306f, 300.165f, 331.641f, 560.5f));
        AccessoriesContainer.FACE.m1744a(new RectF(66.306f, 300.165f, 331.641f, 560.5f));
        AccessoriesContainer.BODY.m1744a(new RectF(66.306f, 300.165f, 331.641f, 560.5f));
        AccessoriesContainer.HAND.m1744a(new RectF(66.306f, 300.165f, 331.641f, 560.5f));
        AccessoriesContainer.HAIR.m1745a(a6);
        AccessoriesContainer.HAIR_COLOR.m1745a(a7);
        AccessoriesContainer.BEARD.m1745a(a8);
        AccessoriesContainer.GLASSES.m1745a(a9);
        AccessoriesContainer.HAT.m1745a(a10);
        AccessoriesContainer.FACE.m1745a(a11);
        AccessoriesContainer.BODY.m1745a(a12);
        AccessoriesContainer.HAND.m1745a(a13);
        HListView hListView = this.mCategoryView;
        LayoutInflater layoutInflater = this.mLayoutInflater;
        HListView hListView2 = this.mCategoryView;
        if (!z) {
            arrayList2 = null;
        }
        hListView.setAdapter(m1702a((List) arrayList, layoutInflater, hListView2, arrayList2));
        this.mCategoryView.setOnItemClickListener(new ItemClickListener(this, androidify));
        this.mAssetsView.setOnItemClickListener(new ap(this));
    }

    private AndroidViewAdapter m1700a(AccessoriesContainer aAccessoriesContainerVar, List list, LayoutInflater layoutInflater, HListView hListView) {
        AndroidViewAdapter androidViewAdapterVar = new AndroidViewAdapter(mManiViewVar);
        androidViewAdapterVar.f1280i = aAccessoriesContainerVar;
        androidViewAdapterVar.f1276e = list;
        androidViewAdapterVar.f1273b = layoutInflater;
        androidViewAdapterVar.f1279h = hListView;
        androidViewAdapterVar.f1278g = list.size();
        return androidViewAdapterVar;
    }

    private AndroidViewAdapter getAdapter(AccessoriesContainer aAccessoriesContainerVar, int[] iArr, LayoutInflater layoutInflater, HListView hListView) {
        AndroidViewAdapter androidViewAdapterVar = new AndroidViewAdapter(this);
        androidViewAdapterVar.f1280i = aAccessoriesContainerVar;
        androidViewAdapterVar.f1273b = layoutInflater;
        androidViewAdapterVar.f1279h = hListView;
        androidViewAdapterVar.f1278g = iArr.length;
        return androidViewAdapterVar;
    }

    private AndroidViewAdapter m1702a(List list, LayoutInflater layoutInflater, HListView hListView, List list2) {
        AndroidViewAdapter androidViewAdapterVar = new AndroidViewAdapter(this);
        androidViewAdapterVar.f1274c = list;
        androidViewAdapterVar.f1273b = layoutInflater;
        androidViewAdapterVar.f1279h = hListView;
        androidViewAdapterVar.f1275d = list2;
        androidViewAdapterVar.f1278g = list.size();
        return androidViewAdapterVar;
    }

    private List m1705a(AccessoriesContainer aAccessoriesContainerVar, String str) {
        List<PartConfig> b = m1719b(aAccessoriesContainerVar);
        List arrayList = new ArrayList();
        Object obj = 1;
        for (PartConfig partConfigVar : b) {
            Object obj2;
            if (obj != null) {
                arrayList.add(partConfigVar);
                obj2 = null;
            } else if (str == null && com.google.android.Util.m1105b(partConfigVar.f1130c)) {
                arrayList.add(partConfigVar);
                obj2 = obj;
            } else {
                if (str != null && str.equals(partConfigVar.f1130c)) {
                    arrayList.add(partConfigVar);
                }
                obj2 = obj;
            }
            obj = obj2;
        }
        return arrayList;
    }

    private void m1706a(int i) {
        this.mAssetsView.setSelection(Math.max(0, i - ((int) ((((float) this.mAssetsView.getWidth()) / ((float) this.mAssetsView.getHeight())) / 2.0f))));
    }

    private void m1707a(View view, boolean z, Runnable runnable) {
        if (z) {
            float height = (float) (this.f1222e.getHeight() - view.getTop());
            view.setTranslationY(height);
            //view.setVisibility(0);
            Util.print(height, 0.0f, 0, 200, f1218a, new as(this, view, runnable));
            return;
        }
        float height2 = (float) (this.f1222e.getHeight() - view.getTop());
        view.setTranslationY(0.0f);
        Util.performance(0.0f, height2, 0, 200, f1219b, new at(this, view, runnable));
    }

    void m1708a(VectorView vectorView, AccessoriesContainer aAccessoriesContainerVar, List list, int i) {
        SVG a;
        PartConfig partConfigVar;
        AndroidConfig e = this.f1220c.m1391e();
        vectorView.setDefaultBounds(aAccessoriesContainerVar.f1264p);
        if (list != null) {
            PartConfig a2 = this.mAssetDatabase.m1655a(aAccessoriesContainerVar.f1263o, ((PartConfig) list.get(i)).name);
            PartConfig partConfigVar2 = a2;
            a = this.mAssetDatabase.getSVG(a2, e);
            partConfigVar = partConfigVar2;
        } else {
            a = null;
            partConfigVar = null;
        }
        if (a == null) {
//            if (!avVar.f1267s) {
//                SVG a3;
//                SVG a4;
//                switch (au.f1247a[avVar.ordinal()]) {
//                    case cm.HListView_hlv_headerDividersEnabled /*3*/:
//                        a = this.mAssetDatabase.getSvgFromResource(avVar.f1263o, ((ag) list.get(i)).name, null);
//                        vectorView.setVectors(this.f1231n, a);
//                        break;
//                    case cm.HListView_hlv_footerDividersEnabled /*4*/:
//                        a3 = this.mAssetDatabase.getSvgFromResource(avVar.f1263o, ((ag) list.get(i)).name, "back");
//                        a4 = this.mAssetDatabase.getSvgFromRsesource(avVar.f1263o, ((ag) list.get(i)).name, "front");
//                        SVG a5 = this.mAssetDatabase.getSvgFromResource(avVar.f1263o, ((ag) list.get(i)).name, "backextra");
//                        a = this.mAssetDatabae.getSvgFromResource(avVar.f1263o, ((ag) list.get(i)).name, "frontextra");
//                        vectorView.setVectors((SVG[]) Log.inspect(SVG.class, a3, a5, this.f1231n, a4, a));
//                        break;
//                    case cm.HListView_hlv_overScrollHeader /*5*/:
//                        a3 = this.mAssetDatabase.getSvgFromResource(avVar.f1263o, ((ag) list.get(i)).name, "leg");
//                        a4 = this.mAssetDatabase.getSvgFromResource(avVar.f1263o, ((ag) list.get(i)).name, "top");
//                        a = this.mAssetDatabase.getSvgFromResource(avVar.f1263o, ((ag) list.get(i)).name, "skirt");
//                        vectorView.setVectors((SVG[]) Log.inspect(SVG.class, a3, a4, a));
//                        break;
//                    case cm.HListView_hlv_overScrollFooter /*6*/:
//                        a3 = this.mAssetDatabase.getSvgFromResource(avVar.f1263o, ((ag) list.get(i)).name, "body");
//                        a = this.mAssetDatabase.getSvgFromResource(avVar.f1263o, ((ag) list.get(i)).name, "top");
//                        if (a3 != null) {
//                            if (a != null) {
//                                vectorView.setVectors(a3, a);
//                                break;
//                            }
//                            vectorView.setVectors(a3);
//                            break;
//                        }
//                        vectorView.setVectors(a);
//                        break;
//                    case 12:
//                        vectorView.setVectors(this.mAssetDatabase.m1658a((int) R.raw.android_full, al.ANDROID_COLOR, Integer.valueOf(al.mSkinColors[i])));
//                        break;
//                    case 13:
//                        a = this.mAssetDatabase.m1658a((int) R.raw.android_hair, al.f1190a, Integer.valueOf(al.af[i]));
//                        vectorView.setVectors(this.f1231n, a);
//                        break;
//                    default:
//                        a = this.mAssetDatabase.getSvg(agVar, e);
//                        vectorView.setVectors(a);
//                        break;
//                }
//            }
//            a = this.mAssetDatabase.getSvg((ag) list.get(i), e);
//            vectorView.setVectors(a);
//        } else {
//            vectorView.setVectors(a);
//        }
//        if (this.f1234q && agVar != null && agVar.m1646e()) {
//            vectorView.setNewBadge(this.mSVG);
        }
    }

    void m1712a(AccessoriesContainer aAccessoriesContainerVar, VectorView vectorView, List list, int i) {
        AndroidConfig e = this.f1220c.m1391e();
        SVG SVG = null;
        vectorView.setDefaultBounds(aAccessoriesContainerVar.f1264p);
        if (list != null) {
            SVG = this.mAssetDatabase.getSVG(aAccessoriesContainerVar.f1263o);//, ((ag) list.get(i)).m1642a(), "chooser");
        }
        if (SVG != null) {
            vectorView.setVectors(SVG);
            return;
        }
        PartConfig a = this.mAssetDatabase.m1655a(aAccessoriesContainerVar.f1263o, ((PartConfig) list.get(i)).m1642a());
        SVG b = this.mAssetDatabase.getSvg(a, e);
        vectorView.setVectors(b);
        if (this.f1234q && a.m1646e()) {
            vectorView.setNewBadge(this.mSVG);
        }
    }

    private void m1713a(AccessoriesContainer aAccessoriesContainerVar, PartConfig aPartConfigVar, int i) {
        boolean z;
        boolean z2 = true;
        if (aAccessoriesContainerVar == AccessoriesContainer.NBA) {
            Iterator it = this.mAssetDatabase.m1675e().iterator();
            while (it.hasNext()) {
                PartConfig partConfigVar2 = (PartConfig) it.next();
                if (partConfigVar2.name.equals(aPartConfigVar.name)) {
                    //this.f1220c.m1379a("pants", agVar2, false, false);
                }
            }
            //this.f1220c.m1403s();
            z = false;
        } else {
            z = true;
        }
        Androidify androidify = this.f1220c;
        String str = aAccessoriesContainerVar.f1263o;
        if (i != 0) {
            z2 = false;
        }
        //androidify.m1379a(str, agVar, z2, z);
    }

    boolean m1715a(AccessoriesContainer aAccessoriesContainerVar, int i) {
        boolean z = true;
        AndroidConfig e = this.f1220c.m1391e();
        List a = aAccessoriesContainerVar.retrieveAdapterFromView(this).f1276e;
        String str = null;
        if (a != null) {
            str = ((PartConfig) a.get(i)).name;
        }
        switch (au.f1247a[aAccessoriesContainerVar.ordinal()]) {
            case cm.HListView_android_divider /*1*/:
                return str.equals(e.m1805h());
            case cm.HListView_hlv_dividerWidth /*2*/:
                return str.equals(e.m1807i());
            case cm.HListView_hlv_headerDividersEnabled /*3*/:
                return str.equals(e.m1808j());
            case cm.HListView_hlv_footerDividersEnabled /*4*/:
                return str.equals(e.getHair());
            case cm.HListView_hlv_overScrollHeader /*5*/:
                return str.equals(e.m1802g());
            case cm.HListView_hlv_overScrollFooter /*6*/:
                return str.equals(e.getOutfit());
            case cm.HListView_hlv_measureWithChild /*7*/:
                return str.equals(e.getOutfit());
            case cm.ExpandableHListView_hlv_childIndicatorPaddingTop /*8*/:
                return str.equals(e.getHat());
            case 9:
                return str.equals(e.m1822x());
            case 10:
                return str.equals(e.m1824z());
            case 11:
                return str.equals(e.m1766B());
//            case 12:
//                return this.f1220c.m1400p().getSkinColorIndex() == i;
//            case 13:
//                if (this.f1220c.m1400p().getHairColorIndex() != i) {
//                    z = false;
//                }
//                return z;
            default:
                return false;
        }
    }

    private int m1716b(AccessoriesContainer aAccessoriesContainerVar, String str) {
        if (str == null) {
            return 0;
        }
        List a = aAccessoriesContainerVar.retrieveAdapterFromView(this).f1276e;
        for (int i = 0; i < a.size(); i++) {
            if (str.equals(((PartConfig) a.get(i)).name)) {
                return i;
            }
        }
        return -1;
    }

    private List m1719b(AccessoriesContainer aAccessoriesContainerVar) {
        switch (au.f1247a[aAccessoriesContainerVar.ordinal()]) {
            case cm.HListView_android_divider /*1*/:
                return this.mAssetDatabase.m1677f();
            case cm.HListView_hlv_dividerWidth /*2*/:
                return this.mAssetDatabase.m1679g();
            case cm.HListView_hlv_headerDividersEnabled /*3*/:
                return this.mAssetDatabase.m1681h();
            case cm.HListView_hlv_footerDividersEnabled /*4*/:
                return this.mAssetDatabase.m1671c();
            case cm.HListView_hlv_overScrollHeader /*5*/:
                return this.mAssetDatabase.m1675e();
            case cm.HListView_hlv_overScrollFooter /*6*/:
                return this.mAssetDatabase.m1673d();
            case cm.HListView_hlv_measureWithChild /*7*/:
                return this.mAssetDatabase.m1673d();
            case cm.ExpandableHListView_hlv_childIndicatorPaddingTop /*8*/:
                return this.mAssetDatabase.m1683i();
            case 9:
                return this.mAssetDatabase.m1685j();
            case 10:
                return this.mAssetDatabase.m1687k();
            case 11:
                return this.mAssetDatabase.m1688l();
            default:
                return null;
        }
    }

    private void m1720b(AccessoriesContainer aAccessoriesContainerVar, int i) {
//        if (avVar == av.SKIN) {
//            this.f1220c.m1383b(i);
//        } else if (avVar == av.HAIR_COLOR) {
//            this.f1220c.changeHairColor(i);
//        } else {
            m1713a(aAccessoriesContainerVar, (PartConfig) aAccessoriesContainerVar.retrieveAdapterFromView(this).f1276e.get(i), i);
            switch (au.f1247a[aAccessoriesContainerVar.ordinal()]) {
                case cm.HListView_android_divider /*1*/:
                case cm.HListView_hlv_dividerWidth /*2*/:
                case cm.HListView_hlv_headerDividersEnabled /*3*/:
                case cm.HListView_hlv_footerDividersEnabled /*4*/:
                case cm.HListView_hlv_overScrollHeader /*5*/:
                case cm.ExpandableHListView_hlv_childIndicatorPaddingTop /*8*/:
                case 9:
                case 10:
                case cm.HListView_hlv_overScrollFooter /*6*/:
//                    this.f1220c.m1386c(2);
//                    this.f1220c.proceedTutorial(1000, true);
                default:
            }
//        }
    }

    private int m1722c(AccessoriesContainer aAccessoriesContainerVar) {
        AndroidConfig e = this.f1220c.m1391e();
        switch (au.f1247a[aAccessoriesContainerVar.ordinal()]) {
            case cm.HListView_android_divider /*1*/:
                return m1716b(aAccessoriesContainerVar, e.m1805h());
            case cm.HListView_hlv_dividerWidth /*2*/:
                return m1716b(aAccessoriesContainerVar, e.m1807i());
            case cm.HListView_hlv_headerDividersEnabled /*3*/:
                return m1716b(aAccessoriesContainerVar, e.m1808j());
            case cm.HListView_hlv_footerDividersEnabled /*4*/:
                return m1716b(aAccessoriesContainerVar, e.getHair());
            case cm.HListView_hlv_overScrollHeader /*5*/:
                return m1716b(aAccessoriesContainerVar, e.m1802g());
            case cm.HListView_hlv_overScrollFooter /*6*/:
                return m1716b(aAccessoriesContainerVar, e.getOutfit());
            case cm.HListView_hlv_measureWithChild /*7*/:
                return m1716b(aAccessoriesContainerVar, e.getOutfit());
            case cm.ExpandableHListView_hlv_childIndicatorPaddingTop /*8*/:
                return m1716b(aAccessoriesContainerVar, e.getHat());
            case 9:
                return m1716b(aAccessoriesContainerVar, e.m1822x());
            case 10:
                return m1716b(aAccessoriesContainerVar, e.m1824z());
            case 11:
                return m1716b(aAccessoriesContainerVar, e.m1766B());
//            case 12:
//                return this.f1220c.m1400p().getSkinColorIndex();
//            case 13:
//                return this.f1220c.m1400p().getHairColorIndex();
            default:
                return -1;
        }
    }

    private int m1724d(AccessoriesContainer aAccessoriesContainerVar) {
        return m1722c(aAccessoriesContainerVar);
    }

    private int m1726e(AccessoriesContainer aAccessoriesContainerVar) {
        int c = m1722c(aAccessoriesContainerVar) + 1;
        AndroidViewAdapter a = aAccessoriesContainerVar.retrieveAdapterFromView(this);
        int i = c == a.getCount() ? 0 : c;
        m1713a(aAccessoriesContainerVar, (PartConfig) a.f1276e.get(i), i);
        return i;
    }

    private void m1728e() {
        int childCount = this.mAssetsView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            VectorView vectorView = (VectorView) this.mAssetsView.getChildAt(i);
            vectorView.setSelected(m1715a(this.f1229l, ((Integer) vectorView.getTag()).intValue()));
        }
    }

    public void m1731a() {
        if (this.f1229l == null || !this.f1229l.f1265q) {
            m1732a(AccessoriesContainer.HAIR);
        } else {
            m1732a(this.f1229l);
        }
    }

    public void m1732a(AccessoriesContainer aAccessoriesContainerVar) {
//        if (avVar == null) {
//            this.f1220c.proceedTutorial(1000, true);
//            this.f1220c.m1386c(3);
//            this.f1220c.proceedTutorial(4, true);
//            this.f1220c.m1386c(1000);
//            this.f1220c.proceedTutorial(3, true);
//            this.mAssetsView.postDelayed(new aq(this), 2500);
//            this.f1220c.m1386c(1);
//            this.f1220c.proceedTutorial(1, true);
//            this.f1220c.proceedTutorial(2, true);
//            this.f1220c.proceedTutorial(0, true);
//        } else {
//            this.f1220c.proceedTutorial(0, false);
//            this.f1220c.proceedTutorial(1, false);
//            this.f1220c.proceedTutorial(2, false);
//            this.f1220c.proceedTutorial(3, false);
//            this.f1220c.m1389d(3);
//            this.f1220c.m1386c(4);
//        }
//        if (avVar == av.SKIN) {
//            this.f1220c.m1389d(1);
//        } else if (avVar == av.SHIRT) {
//            this.f1220c.m1389d(2);
//        }
        if (aAccessoriesContainerVar != null && aAccessoriesContainerVar.f1271w && this.f1234q) {
            this.f1220c.showBadge();
        }
        if (aAccessoriesContainerVar != this.f1229l) {
            Runnable arVar = new ar(this, aAccessoriesContainerVar);
            if (this.f1229l != null) {
                m1707a(this.f1225h, false, arVar);
            } else {
                arVar.run();
            }
        } else if (this.f1229l != null && this.f1229l != AccessoriesContainer.HAIR_COLOR && this.f1229l != AccessoriesContainer.SKIN) {
            int e = m1726e(this.f1229l);
            m1733a(e, false);
            m1706a(e);
            this.mAssetsView.invalidate();
        }
    }

    public boolean m1733a(int i, boolean z) {
        boolean z2 = false;
        if (!m1715a(this.f1229l, i) || this.f1229l == AccessoriesContainer.HAIR_COLOR || this.f1229l == AccessoriesContainer.SKIN || !z) {
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
            if (m1716b(AccessoriesContainer.NBA, this.f1220c.m1391e().getOutfit()) > 0) {
                m1732a(AccessoriesContainer.NBA);
                return;
            } else {
                m1732a(AccessoriesContainer.SHIRT);
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
//        this.f1220c.m1393g();
        return true;
    }
}
