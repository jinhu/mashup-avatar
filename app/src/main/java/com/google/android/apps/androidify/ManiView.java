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

import static com.google.android.apps.androidify.Constants.*;

public class ManiView {
    public static final Interpolator f1218a;
    public static final Interpolator f1219b;
    Androidify mAndroidify;
    boolean f1221d;
    ViewGroup f1222e;
    HListView mCategoryView;
    HListView mAssetsView;
    ViewGroup f1225h;
    Context f1226i;
    LayoutInflater mLayoutInflater;
    final AssetDatabase mAssetDatabase;
    AccessoriesContainer f1229l;
    public SVG f1230m;
    public SVG f1231n;
    public PictureDrawable f1233p;
    boolean f1234q;

    static {
        f1218a = new DecelerateInterpolator();
        f1219b = new AccelerateInterpolator();
    }

    ManiView mManiViewVar;
    public SVG mSVG;
    public AndroidDrawer mAndroidDrawer;

    public ManiView(Androidify androidify, ViewGroup viewGroup, boolean z) {
        this.f1221d = false;
        this.f1229l = null;
        this.mAndroidify = androidify;
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
        this.mAssetsView.setOnItemClickListener(new MainViewOnClickListener(this));
    }

    AndroidViewAdapter getAdapter(AccessoriesContainer aAccessoriesContainerVar, List list, LayoutInflater layoutInflater, HListView hListView) {
        AndroidViewAdapter androidViewAdapterVar = new AndroidViewAdapter(mManiViewVar);
        androidViewAdapterVar.mAccessoryTypeContainer = aAccessoriesContainerVar;
        androidViewAdapterVar.f1276e = list;
        androidViewAdapterVar.f1273b = layoutInflater;
        androidViewAdapterVar.mHlistView = hListView;
        androidViewAdapterVar.f1278g = list.size();
        return androidViewAdapterVar;
    }

    AndroidViewAdapter getAdapter(AccessoriesContainer aAccessoriesContainerVar, int[] iArr, LayoutInflater layoutInflater, HListView hListView) {
        AndroidViewAdapter androidViewAdapterVar = new AndroidViewAdapter(this);
        androidViewAdapterVar.mAccessoryTypeContainer = aAccessoriesContainerVar;
        androidViewAdapterVar.f1273b = layoutInflater;
        androidViewAdapterVar.mHlistView = hListView;
        androidViewAdapterVar.f1278g = iArr.length;
        return androidViewAdapterVar;
    }

    AndroidViewAdapter m1702a(List list, LayoutInflater layoutInflater, HListView hListView, List list2) {
        AndroidViewAdapter androidViewAdapterVar = new AndroidViewAdapter(this);
        androidViewAdapterVar.f1274c = list;
        androidViewAdapterVar.f1273b = layoutInflater;
        androidViewAdapterVar.mHlistView = hListView;
        androidViewAdapterVar.f1275d = list2;
        androidViewAdapterVar.f1278g = list.size();
        return androidViewAdapterVar;
    }

    List getAccessories(AccessoriesContainer aAccessoriesContainerVar, String str) {
        List<PartConfig> b = getAccessories(aAccessoriesContainerVar);
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

    void m1706a(int i) {
        this.mAssetsView.setSelection(Math.max(0, i - ((int) ((((float) this.mAssetsView.getWidth()) / ((float) this.mAssetsView.getHeight())) / 2.0f))));
    }

    void m1707a(View view, boolean z, Runnable runnable) {
        if (z) {
            float height = (float) (this.f1222e.getHeight() - view.getTop());
            view.setTranslationY(height);
            //view.setVisibility(0);
            Util.print(height, 0.0f, 0, 200, f1218a, new MainViewTransitionRunner(this, view, runnable));
            return;
        }
        float height2 = (float) (this.f1222e.getHeight() - view.getTop());
        view.setTranslationY(0.0f);
        Util.performance(0.0f, height2, 0, 200, f1219b, new MainViewHideRunner(this, view, runnable));
    }

    void m1708a(VectorView vectorView, AccessoriesContainer aAccessoriesContainerVar, List list, int i) {
        SVG svg;
        PartConfig partConfigVar= null;
        AndroidConfig config = this.mAndroidify.getCurrentConfig();
        vectorView.setDefaultBounds(aAccessoriesContainerVar.f1264p);
        if (list != null) {
            partConfigVar = this.mAssetDatabase.m1655a(aAccessoriesContainerVar.f1263o, ((PartConfig) list.get(i)).name);
            svg = this.mAssetDatabase.getSVG(partConfigVar, config);
        } else {
            svg = null;
            partConfigVar = null;
        }
        if (svg == null) {
            if (!aAccessoriesContainerVar.f1267s) {
                SVG a3;
                SVG a4;
                switch (AccessoryContainerIndex.theAccessoryContainerIndex[aAccessoriesContainerVar.ordinal()]) {
                    case cm.HListView_hlv_headerDividersEnabled /*3*/:
                        svg = this.mAssetDatabase.getSVG(aAccessoriesContainerVar.f1263o, ((PartConfig) list.get(i)).name, null);
                        vectorView.setVectors( this.f1231n, svg);
                        break;
                    case cm.HListView_hlv_footerDividersEnabled /*4*/:
                        a3 = this.mAssetDatabase.getSVG(aAccessoriesContainerVar.f1263o, ((PartConfig) list.get(i)).name, "back");
                        a4 = this.mAssetDatabase.getSVG(aAccessoriesContainerVar.f1263o, ((PartConfig) list.get(i)).name, "front");
                        SVG a5 = this.mAssetDatabase.getSVG(aAccessoriesContainerVar.f1263o, ((PartConfig) list.get(i)).name, "backextra");
                        svg = this.mAssetDatabase.getSVG(aAccessoriesContainerVar.f1263o, ((PartConfig) list.get(i)).name, "frontextra");
                        vectorView.setVectors((SVG[]) Util.collect(SVG.class, a3, a5, this.f1231n, a4, svg));
                        break;
                    case cm.HListView_hlv_overScrollHeader /*5*/:
                        a3 = this.mAssetDatabase.getSVG(aAccessoriesContainerVar.f1263o, ((PartConfig) list.get(i)).name, "leg");
                        a4 = this.mAssetDatabase.getSVG(aAccessoriesContainerVar.f1263o, ((PartConfig) list.get(i)).name, "top");
                        svg = this.mAssetDatabase.getSVG(aAccessoriesContainerVar.f1263o, ((PartConfig) list.get(i)).name, "skirt");
                        vectorView.setVectors((SVG[]) Util.collect(SVG.class, a3, a4, svg));
                        break;
                    case cm.HListView_hlv_overScrollFooter /*6*/:
                        a3 = this.mAssetDatabase.getSVG(aAccessoriesContainerVar.f1263o, ((PartConfig) list.get(i)).name, "body");
                        svg = this.mAssetDatabase.getSVG(aAccessoriesContainerVar.f1263o, ((PartConfig) list.get(i)).name, "top");
                        if (a3 != null) {
                            if (svg != null) {
                                vectorView.setVectors(a3, svg);
                                break;
                            }
                            vectorView.setVectors(a3);
                            break;
                        }
                        vectorView.setVectors(svg);
                        break;
                    case 12:
                        vectorView.setVectors(this.mAssetDatabase.getSvgFromResource((int) R.raw.android_full, ANDROID_COLOR, Integer.valueOf(Constants.mSkinColors[i])));
                        break;
                    case 13:
                        svg = this.mAssetDatabase.getSvgFromResource((int) R.raw.android_hair, Constants.f1190a, Integer.valueOf(Constants.af[i]));
                        vectorView.setVectors(this.f1231n, svg);
                        break;
                    default:
                        svg = this.mAssetDatabase.getSvg(partConfigVar, config);
                        vectorView.setVectors(svg);
                        break;
                }
            }
            svg = this.mAssetDatabase.getSvg((PartConfig) list.get(i), config);
            vectorView.setVectors(svg);
        } else {
            vectorView.setVectors(svg);
        }
        if (this.f1234q && partConfigVar != null && partConfigVar.m1646e()) {
            vectorView.setNewBadge(this.mSVG);
        }
    }

    void m1712a(AccessoriesContainer aAccessoriesContainerVar, VectorView vectorView, List list, int i) {
        AndroidConfig e = this.mAndroidify.getCurrentConfig();
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

    void m1713a(AccessoriesContainer aAccessoriesContainerVar, PartConfig aPartConfigVar, int i) {
        boolean z;
        boolean z2 = true;
        if (aAccessoriesContainerVar == AccessoriesContainer.NBA) {
            Iterator it = this.mAssetDatabase.m1675e().iterator();
            while (it.hasNext()) {
                PartConfig partConfigVar2 = (PartConfig) it.next();
                if (partConfigVar2.name.equals(aPartConfigVar.name)) {
                    //this.mAndroidify.m1379a("pants", agVar2, false, false);
                }
            }
            //this.mAndroidify.m1403s();
            z = false;
        } else {
            z = true;
        }
        Androidify androidify = this.mAndroidify;
        String str = aAccessoriesContainerVar.f1263o;
        if (i != 0) {
            z2 = false;
        }
        //androidify.m1379a(str, agVar, z2, z);
    }

    boolean m1715a(AccessoriesContainer aAccessoriesContainerVar, int i) {
        boolean z = true;
        AndroidConfig e = this.mAndroidify.getCurrentConfig();
        List a = aAccessoriesContainerVar.retrieveAdapterFromView(this).f1276e;
        String str = null;
        if (a != null) {
            str = ((PartConfig) a.get(i)).name;
        }
        switch (AccessoryContainerIndex.theAccessoryContainerIndex[aAccessoriesContainerVar.ordinal()]) {
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
//                return this.mAndroidify.m1400p().getSkinColorIndex() == i;
//            case 13:
//                if (this.mAndroidify.m1400p().getHairColorIndex() != i) {
//                    z = false;
//                }
//                return z;
            default:
                return false;
        }
    }

    int m1716b(AccessoriesContainer aAccessoriesContainerVar, String str) {
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

    List getAccessories(AccessoriesContainer aAccessoriesContainerVar) {
        switch (AccessoryContainerIndex.theAccessoryContainerIndex[aAccessoriesContainerVar.ordinal()]) {
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

    void m1720b(AccessoriesContainer aAccessoriesContainerVar, int i) {
//        if (mAndroidDrawer == av.SKIN) {
//            this.mAndroidify.m1383b(i);
//        } else if (mAndroidDrawer == av.HAIR_COLOR) {
//            this.mAndroidify.changeHairColor(i);
//        } else {
            m1713a(aAccessoriesContainerVar, (PartConfig) aAccessoriesContainerVar.retrieveAdapterFromView(this).f1276e.get(i), i);
            switch (AccessoryContainerIndex.theAccessoryContainerIndex[aAccessoriesContainerVar.ordinal()]) {
                case cm.HListView_android_divider /*1*/:
                case cm.HListView_hlv_dividerWidth /*2*/:
                case cm.HListView_hlv_headerDividersEnabled /*3*/:
                case cm.HListView_hlv_footerDividersEnabled /*4*/:
                case cm.HListView_hlv_overScrollHeader /*5*/:
                case cm.ExpandableHListView_hlv_childIndicatorPaddingTop /*8*/:
                case 9:
                case 10:
                case cm.HListView_hlv_overScrollFooter /*6*/:
                    this.mAndroidify.m1386c(2);
                    this.mAndroidify.proceedTutorial(1000, true);
                default:
            }
//        }
    }

    int m1722c(AccessoriesContainer aAccessoriesContainerVar) {
        AndroidConfig e = this.mAndroidify.getCurrentConfig();
        switch (AccessoryContainerIndex.theAccessoryContainerIndex[aAccessoriesContainerVar.ordinal()]) {
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
//                return this.mAndroidify.m1400p().getSkinColorIndex();
//            case 13:
//                return this.mAndroidify.m1400p().getHairColorIndex();
            default:
                return -1;
        }
    }

    int m1724d(AccessoriesContainer aAccessoriesContainerVar) {
        return m1722c(aAccessoriesContainerVar);
    }

    int m1726e(AccessoriesContainer aAccessoriesContainerVar) {
        int c = m1722c(aAccessoriesContainerVar) + 1;
        AndroidViewAdapter a = aAccessoriesContainerVar.retrieveAdapterFromView(this);
        int i = c == a.getCount() ? 0 : c;
        m1713a(aAccessoriesContainerVar, (PartConfig) a.f1276e.get(i), i);
        return i;
    }

    void m1728e() {
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
//        if (mAndroidDrawer == null) {
//            this.mAndroidify.proceedTutorial(1000, true);
//            this.mAndroidify.m1386c(3);
//            this.mAndroidify.proceedTutorial(4, true);
//            this.mAndroidify.m1386c(1000);
//            this.mAndroidify.proceedTutorial(3, true);
//            this.mAssetsView.postDelayed(new aq(this), 2500);
//            this.mAndroidify.m1386c(1);
//            this.mAndroidify.proceedTutorial(1, true);
//            this.mAndroidify.proceedTutorial(2, true);
//            this.mAndroidify.proceedTutorial(0, true);
//        } else {
//            this.mAndroidify.proceedTutorial(0, false);
//            this.mAndroidify.proceedTutorial(1, false);
//            this.mAndroidify.proceedTutorial(2, false);
//            this.mAndroidify.proceedTutorial(3, false);
//            this.mAndroidify.m1389d(3);
//            this.mAndroidify.m1386c(4);
//        }
//        if (mAndroidDrawer == av.SKIN) {
//            this.mAndroidify.m1389d(1);
//        } else if (mAndroidDrawer == av.SHIRT) {
//            this.mAndroidify.m1389d(2);
//        }
        if (aAccessoriesContainerVar != null && aAccessoriesContainerVar.f1271w && this.f1234q) {
            this.mAndroidify.showBadge();
        }
        if (aAccessoriesContainerVar != this.f1229l) {
            Runnable arVar = new MainViewAccessoryRunnable(this, aAccessoriesContainerVar);
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
            if (m1716b(AccessoriesContainer.NBA, this.mAndroidify.getCurrentConfig().getOutfit()) > 0) {
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
//        this.mAndroidify.m1393g();
        return true;
    }
}
