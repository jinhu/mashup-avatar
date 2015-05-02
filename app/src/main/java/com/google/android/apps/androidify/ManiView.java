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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dev.game.legend.avatar.R;
import dev.game.legend.svgandroid.SVG;
import it.sephiroth.android.library.widget.HListView;

import static com.google.android.apps.androidify.Constants.ANDROID_COLOR;

public class ManiView {
    public static final Interpolator theInterpolator;
    public static final Interpolator theOtherInterpolator;
    Androidify mAndroidify;
    boolean f1221d;
    ViewGroup f1222e;
    HListView mCategoryView;
    HListView mAssetsView;
    ViewGroup f1225h;
    Context f1226i;
    LayoutInflater mLayoutInflater;
    final AssetDatabase mAssetDatabase;
    AccessoriesContainer mAccessoryContainer;
    public SVG f1230m;
    public SVG f1231n;
    public PictureDrawable f1233p;
    boolean f1234q;

    static {
        theInterpolator = new DecelerateInterpolator();
        theOtherInterpolator = new AccelerateInterpolator();
    }

    ManiView mManiViewVar;
    public SVG mSVG;
    public AndroidDrawer mAndroidDrawer;

    public ManiView(Androidify androidify, ViewGroup viewGroup, boolean z) {
        this.f1221d = false;
        this.mAccessoryContainer = AccessoriesContainer.SKIN;
        this.mAndroidDrawer = new AndroidDrawer(androidify);
        this.mAndroidify = androidify;
        this.f1222e = viewGroup;
        this.f1234q = z;
        this.f1226i = viewGroup.getContext();
        this.mCategoryView = (HListView) viewGroup.findViewById(R.id.main_drawer);
        this.mAssetsView = (HListView) viewGroup.findViewById(R.id.item_drawer);
        this.f1225h = (ViewGroup) viewGroup.findViewById(R.id.item_drawer_parent);
        this.mLayoutInflater = (LayoutInflater) this.f1226i.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mAssetDatabase = AssetDatabase.instance(this.f1226i);
        this.f1230m = this.mAssetDatabase.getSvgFromResource(R.raw.trash_icon);
        this.f1231n = this.mAssetDatabase.getSvgFromResource(R.raw.android_fullhead);
        this.mSVG = this.mAssetDatabase.getSvgFromResource(R.raw.new_badge);
        this.f1233p = new PictureDrawable(this.mAssetDatabase.getSvgFromResource(R.raw.color_square_selection).getPicture());
        SVG a = this.mAssetDatabase.getSvgFromResource(R.raw.drawer_icons_01);
        SVG a2 = this.mAssetDatabase.getSvgFromResource(R.raw.drawer_nba);
        SVG a3 = this.mAssetDatabase.getSvgFromResource(R.raw.drawer_icons_02);
        SVG a4 = this.mAssetDatabase.getSvgFromResource(R.raw.drawer_icons_03);
        SVG a5 = this.mAssetDatabase.getSvgFromResource(R.raw.drawer_icons_04);
        SVG a6 = this.mAssetDatabase.getSvgFromResource(R.raw.drawer_icons_05);
        SVG a7 = this.mAssetDatabase.getSvgFromResource(R.raw.drawer_icons_06);
        SVG a8 = this.mAssetDatabase.getSvgFromResource(R.raw.drawer_icons_07);
        SVG a9 = this.mAssetDatabase.getSvgFromResource(R.raw.drawer_icons_08);
        SVG a10 = this.mAssetDatabase.getSvgFromResource(R.raw.drawer_icons_09);
        SVG a11 = this.mAssetDatabase.getSvgFromResource(R.raw.drawer_icons_10);
        SVG a12 = this.mAssetDatabase.getSvgFromResource(R.raw.drawer_icons_11);
        SVG a13 = this.mAssetDatabase.getSvgFromResource(R.raw.drawer_icons_12);
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
        AccessoriesContainer.NBA.bool4 = true;
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
        AccessoriesContainer.SKIN.setSvg(a);
        AccessoriesContainer.NBA.setSvg(a2);
        AccessoriesContainer.NBA.mString3 = "nba";
        AccessoriesContainer.SHIRT.setSvg(a3);
        AccessoriesContainer.PANTS.setSvg(a4);
        AccessoriesContainer.SHOES.setSvg(a5);
        AccessoriesContainer.SHOES.setRect(new RectF(66.306f, 300.165f, 331.641f, 560.5f));
        AccessoriesContainer.HAT.setRect(new RectF(66.306f, 300.165f, 331.641f, 560.5f));
        AccessoriesContainer.FACE.setRect(new RectF(66.306f, 300.165f, 331.641f, 560.5f));
        AccessoriesContainer.BODY.setRect(new RectF(66.306f, 300.165f, 331.641f, 560.5f));
        AccessoriesContainer.HAND.setRect(new RectF(66.306f, 300.165f, 331.641f, 560.5f));
        AccessoriesContainer.HAIR.setSvg(a6);
        AccessoriesContainer.HAIR_COLOR.setSvg(a7);
        AccessoriesContainer.BEARD.setSvg(a8);
        AccessoriesContainer.GLASSES.setSvg(a9);
        AccessoriesContainer.HAT.setSvg(a10);
        AccessoriesContainer.FACE.setSvg(a11);
        AccessoriesContainer.BODY.setSvg(a12);
        AccessoriesContainer.HAND.setSvg(a13);
        HListView hListView = this.mCategoryView;
        LayoutInflater layoutInflater = this.mLayoutInflater;
        HListView hListView2 = this.mCategoryView;
        if (!z) {
            arrayList2 = null;
        }
        hListView.setAdapter(getAdapter(arrayList, layoutInflater, hListView2, arrayList2));
        this.mCategoryView.setOnItemClickListener((aAdapterView, aView, i, l) -> {
            mAndroidify.m1392f();
            m1732a(AccessoriesContainer.values()[i]);
            mAndroidify.m1377a(AccessoriesContainer.values()[i].mString);

        });

        this.mAssetsView.setOnItemClickListener((aAdapterView, aView, i, l) -> {
            if (m1733a(i, true)) {
                int a1 = 0;//mAssetsView.sele.mCategoryView(mAndroidDrawer.getWidth() - 1, mAndroidDrawer.getHeight() / 2);
                com.google.android.Util.debug("[SELECT] Last index on screen=" + a1);
                if (a1 != -1) {
                    int width = (int) (mAndroidDrawer.getWidth() - aView.getRight());
                    if (a1 == i || (a1 == i + 1 && width < aView.getWidth() / 2)) {
                        mAndroidDrawer.m2293d(1);
                    }
                }
            }
        });
    }

    AndroidViewAdapter getAdapter(AccessoriesContainer aAccessoriesContainerVar, List list, LayoutInflater layoutInflater, HListView hListView) {
        AndroidViewAdapter androidViewAdapterVar = new AndroidViewAdapter(mManiViewVar);
        androidViewAdapterVar.mAccessoryTypeContainer = aAccessoriesContainerVar;
        androidViewAdapterVar.mList3 = list;
        androidViewAdapterVar.f1273b = layoutInflater;
        androidViewAdapterVar.mHlistView = hListView;
        androidViewAdapterVar.f1278g = list.size();
        return androidViewAdapterVar;
    }

    AndroidViewAdapter getAdapter(AccessoriesContainer aAccessoryContainer, int[] iArr, LayoutInflater layoutInflater, HListView hListView) {
        AndroidViewAdapter androidViewAdapterVar = new AndroidViewAdapter(this);
        androidViewAdapterVar.mAccessoryTypeContainer = aAccessoryContainer;
        androidViewAdapterVar.f1273b = layoutInflater;
        androidViewAdapterVar.mHlistView = hListView;
        androidViewAdapterVar.f1278g = iArr.length;
        AssetCatalogue catalogue = new AssetCatalogue();
        try {
            catalogue.initAssets(mAndroidify);
        } catch (IOException e) {
            e.printStackTrace();
        }
        androidViewAdapterVar.mList3 = catalogue.getAssets("face");
        return androidViewAdapterVar;
    }

    AndroidViewAdapter getAdapter(List list, LayoutInflater layoutInflater, HListView hListView, List list2) {
        AndroidViewAdapter androidViewAdapterVar = new AndroidViewAdapter(this);
        androidViewAdapterVar.mList1 = list;
        androidViewAdapterVar.f1273b = layoutInflater;
        androidViewAdapterVar.mHlistView = hListView;
        androidViewAdapterVar.mList2 = list2;
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
            Util.print(height, 0.0f, 0, 200, theInterpolator, new MainViewTransitionRunner(this, view, runnable));
            return;
        }
        float height2 = (float) (this.f1222e.getHeight() - view.getTop());
        view.setTranslationY(0.0f);
        Util.performance(0.0f, height2, 0, 200, theOtherInterpolator, new MainViewHideRunner(this, view, runnable));
    }

    void m1708a(VectorView vectorView, AccessoriesContainer aAccessoriesContainerVar, List list, int i) {
        SVG svg;
        PartConfig partConfigVar= null;
        AndroidConfig config = this.mAndroidify.getCurrentConfig();
        vectorView.setDefaultBounds(aAccessoriesContainerVar.mRectF);
        if (list != null) {
            partConfigVar = this.mAssetDatabase.m1655a(aAccessoriesContainerVar.mString, ((PartConfig) list.get(i)).name);
            svg = this.mAssetDatabase.getSVG(partConfigVar, config);
        } else {
            svg = null;
            partConfigVar = null;
        }
        if (svg == null) {
            if (!aAccessoriesContainerVar.bool3) {
                SVG a3;
                SVG a4;
                switch (AccessoryContainerIndex.theAccessoryContainerIndex[aAccessoriesContainerVar.ordinal()]) {
                    case HListViewConstants.HListView_hlv_headerDividersEnabled /*3*/:
                        svg = this.mAssetDatabase.getSVG(aAccessoriesContainerVar.mString, ((PartConfig) list.get(i)).name, null);
                        vectorView.setVectors( this.f1231n, svg);
                        break;
                    case HListViewConstants.HListView_hlv_footerDividersEnabled /*4*/:
                        a3 = this.mAssetDatabase.getSVG(aAccessoriesContainerVar.mString, ((PartConfig) list.get(i)).name, "back");
                        a4 = this.mAssetDatabase.getSVG(aAccessoriesContainerVar.mString, ((PartConfig) list.get(i)).name, "front");
                        SVG a5 = this.mAssetDatabase.getSVG(aAccessoriesContainerVar.mString, ((PartConfig) list.get(i)).name, "backextra");
                        svg = this.mAssetDatabase.getSVG(aAccessoriesContainerVar.mString, ((PartConfig) list.get(i)).name, "frontextra");
                        vectorView.setVectors((SVG[]) Util.collect(SVG.class, a3, a5, this.f1231n, a4, svg));
                        break;
                    case HListViewConstants.HListView_hlv_overScrollHeader /*5*/:
                        a3 = this.mAssetDatabase.getSVG(aAccessoriesContainerVar.mString, ((PartConfig) list.get(i)).name, "leg");
                        a4 = this.mAssetDatabase.getSVG(aAccessoriesContainerVar.mString, ((PartConfig) list.get(i)).name, "top");
                        svg = this.mAssetDatabase.getSVG(aAccessoriesContainerVar.mString, ((PartConfig) list.get(i)).name, "skirt");
                        vectorView.setVectors((SVG[]) Util.collect(SVG.class, a3, a4, svg));
                        break;
                    case HListViewConstants.HListView_hlv_overScrollFooter /*6*/:
                        a3 = this.mAssetDatabase.getSVG(aAccessoriesContainerVar.mString, ((PartConfig) list.get(i)).name, "body");
                        svg = this.mAssetDatabase.getSVG(aAccessoriesContainerVar.mString, ((PartConfig) list.get(i)).name, "top");
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
                        vectorView.setVectors(this.mAssetDatabase.getSvgFromResource(R.raw.android_full, ANDROID_COLOR, Integer.valueOf(Constants.mSkinColors[i])));
                        break;
                    case 13:
                        svg = this.mAssetDatabase.getSvgFromResource(R.raw.android_hair, Constants.f1190a, Integer.valueOf(Constants.af[i]));
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
        vectorView.setDefaultBounds(aAccessoriesContainerVar.mRectF);
        if (list != null) {
            SVG = this.mAssetDatabase.getSVG(aAccessoriesContainerVar.mString);//, ((ag) list.get(i)).m1642a(), "chooser");
        }
        if (SVG != null) {
            vectorView.setVectors(SVG);
            return;
        }
        PartConfig a = this.mAssetDatabase.m1655a(aAccessoriesContainerVar.mString, ((PartConfig) list.get(i)).m1642a());
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
        String str = aAccessoriesContainerVar.mString;
        if (i != 0) {
            z2 = false;
        }
        //androidify.m1379a(str, agVar, z2, z);
    }

    boolean selectCategory(AccessoriesContainer aAccessoriesContainer, int i) {
        boolean z = true;
        AndroidConfig e = this.mAndroidify.getCurrentConfig();
        List a = aAccessoriesContainer.retrieveAdapterFromView(this).mList3;
        String str = null;
        if (a != null) {
            str = ((PartConfig) a.get(i)).name;
        }
        switch (AccessoryContainerIndex.theAccessoryContainerIndex[aAccessoriesContainer.ordinal()]) {
            case HListViewConstants.HListView_android_divider /*1*/:
                return str.equals(e.m1805h());
            case HListViewConstants.HListView_hlv_dividerWidth /*2*/:
                return str.equals(e.m1807i());
            case HListViewConstants.HListView_hlv_headerDividersEnabled /*3*/:
                return str.equals(e.m1808j());
            case HListViewConstants.HListView_hlv_footerDividersEnabled /*4*/:
                return str.equals(e.getHair());
            case HListViewConstants.HListView_hlv_overScrollHeader /*5*/:
                return str.equals(e.m1802g());
            case HListViewConstants.HListView_hlv_overScrollFooter /*6*/:
                return str.equals(e.getOutfit());
            case HListViewConstants.HListView_hlv_measureWithChild /*7*/:
                return str.equals(e.getOutfit());
            case HListViewConstants.ExpandableHListView_hlv_childIndicatorPaddingTop /*8*/:
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
        List a = aAccessoriesContainerVar.retrieveAdapterFromView(this).mList3;
        for (int i = 0; i < a.size(); i++) {
            if (str.equals(((PartConfig) a.get(i)).name)) {
                return i;
            }
        }
        return -1;
    }

    List getAccessories(AccessoriesContainer aAccessoriesContainerVar) {
        switch (AccessoryContainerIndex.theAccessoryContainerIndex[aAccessoriesContainerVar.ordinal()]) {
            case HListViewConstants.HListView_android_divider /*1*/:
                return this.mAssetDatabase.m1677f();
            case HListViewConstants.HListView_hlv_dividerWidth /*2*/:
                return this.mAssetDatabase.m1679g();
            case HListViewConstants.HListView_hlv_headerDividersEnabled /*3*/:
                return this.mAssetDatabase.m1681h();
            case HListViewConstants.HListView_hlv_footerDividersEnabled /*4*/:
                return this.mAssetDatabase.m1671c();
            case HListViewConstants.HListView_hlv_overScrollHeader /*5*/:
                return this.mAssetDatabase.m1675e();
            case HListViewConstants.HListView_hlv_overScrollFooter /*6*/:
                return this.mAssetDatabase.m1673d();
            case HListViewConstants.HListView_hlv_measureWithChild /*7*/:
                return this.mAssetDatabase.m1673d();
            case HListViewConstants.ExpandableHListView_hlv_childIndicatorPaddingTop /*8*/:
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

    void m1720b(AccessoriesContainer aAccessoryContainer, int i) {
//        if (mAndroidDrawer == av.SKIN) {
//            this.mAndroidify.m1383b(i);
//        } else if (mAndroidDrawer == av.HAIR_COLOR) {
//            this.mAndroidify.changeHairColor(i);
//        } else {
            m1713a(aAccessoryContainer, (PartConfig) aAccessoryContainer.retrieveAdapterFromView(this).mList3.get(i), i);
            switch (AccessoryContainerIndex.theAccessoryContainerIndex[aAccessoryContainer.ordinal()]) {
                case HListViewConstants.HListView_android_divider /*1*/:
                case HListViewConstants.HListView_hlv_dividerWidth /*2*/:
                case HListViewConstants.HListView_hlv_headerDividersEnabled /*3*/:
                case HListViewConstants.HListView_hlv_footerDividersEnabled /*4*/:
                case HListViewConstants.HListView_hlv_overScrollHeader /*5*/:
                case HListViewConstants.ExpandableHListView_hlv_childIndicatorPaddingTop /*8*/:
                case 9:
                case 10:
                case HListViewConstants.HListView_hlv_overScrollFooter /*6*/:
                    this.mAndroidify.m1386c(2);
                    this.mAndroidify.proceedTutorial(1000, true);
                default:
            }
//        }
    }

    int m1722c(AccessoriesContainer aAccessoriesContainerVar) {
        AndroidConfig e = this.mAndroidify.getCurrentConfig();
        switch (AccessoryContainerIndex.theAccessoryContainerIndex[aAccessoriesContainerVar.ordinal()]) {
            case HListViewConstants.HListView_android_divider /*1*/:
                return m1716b(aAccessoriesContainerVar, e.m1805h());
            case HListViewConstants.HListView_hlv_dividerWidth /*2*/:
                return m1716b(aAccessoriesContainerVar, e.m1807i());
            case HListViewConstants.HListView_hlv_headerDividersEnabled /*3*/:
                return m1716b(aAccessoriesContainerVar, e.m1808j());
            case HListViewConstants.HListView_hlv_footerDividersEnabled /*4*/:
                return m1716b(aAccessoriesContainerVar, e.getHair());
            case HListViewConstants.HListView_hlv_overScrollHeader /*5*/:
                return m1716b(aAccessoriesContainerVar, e.m1802g());
            case HListViewConstants.HListView_hlv_overScrollFooter /*6*/:
                return m1716b(aAccessoriesContainerVar, e.getOutfit());
            case HListViewConstants.HListView_hlv_measureWithChild /*7*/:
                return m1716b(aAccessoriesContainerVar, e.getOutfit());
            case HListViewConstants.ExpandableHListView_hlv_childIndicatorPaddingTop /*8*/:
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
        m1713a(aAccessoriesContainerVar, (PartConfig) a.mList3.get(i), i);
        return i;
    }

    void m1728e() {
        int childCount = this.mAssetsView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            VectorView vectorView = (VectorView) this.mAssetsView.getChildAt(i);
            vectorView.setSelected(selectCategory(this.mAccessoryContainer, ((Integer) vectorView.getTag()).intValue()));
        }
    }

    public void m1731a() {
        if (this.mAccessoryContainer == null || !this.mAccessoryContainer.bool1) {
            m1732a(AccessoriesContainer.HAIR);
        } else {
            m1732a(this.mAccessoryContainer);
        }
    }

    public void m1732a(AccessoriesContainer anAccessoriesContainer) {
        if (mAndroidDrawer == null) {
            this.mAndroidify.proceedTutorial(1000, true);
            this.mAndroidify.m1386c(3);
            this.mAndroidify.proceedTutorial(4, true);
            this.mAndroidify.m1386c(1000);
            this.mAndroidify.proceedTutorial(3, true);
            //this.mAssetsView.postDelayed(new aq(this), 2500);
            this.mAndroidify.m1386c(1);
            this.mAndroidify.proceedTutorial(1, true);
            this.mAndroidify.proceedTutorial(2, true);
            this.mAndroidify.proceedTutorial(0, true);
        } else {
            this.mAndroidify.proceedTutorial(0, false);
            this.mAndroidify.proceedTutorial(1, false);
            this.mAndroidify.proceedTutorial(2, false);
            this.mAndroidify.proceedTutorial(3, false);
            this.mAndroidify.m1389d(3);
            this.mAndroidify.m1386c(4);
        }
//        if (mAndroidDrawer == av.SKIN) {
//            this.mAndroidify.m1389d(1);
//        } else if (mAndroidDrawer == av.SHIRT) {
//            this.mAndroidify.m1389d(2);
//        }
        if (anAccessoriesContainer != null && anAccessoriesContainer.bool4 && this.f1234q) {
            this.mAndroidify.showBadge();
        }
        if (anAccessoriesContainer != this.mAccessoryContainer) {
            Runnable arVar = ()->{
                if (this.mAccessoryContainer == null || !this.mAccessoryContainer.bool1) {
                    if (anAccessoriesContainer != null && anAccessoriesContainer.bool1) {
                    }
                } else if (anAccessoriesContainer != null) {
                }
                if (anAccessoriesContainer != null && anAccessoriesContainer.bool1) {
                    //this.mManiView.mAndroidify.getDroidView().setAccessoryType();
                }
                this.mAccessoryContainer = anAccessoriesContainer;
                if (this.mAccessoryContainer != null) {
                    this.mAndroidDrawer.setAdapter(this.mAccessoryContainer.retrieveAdapterFromView(this));
                    int c = this.m1724d(this.mAccessoryContainer);
                    if (c >= 0) {
                        this.mCategoryView.setSelection(c);
                        this.m1728e();
                    }
                    this.m1707a(this.f1225h, true, null);
                }
            };
            if (this.mAccessoryContainer != null) {
                m1707a(this.f1225h, false, arVar);
            } else {
                arVar.run();
            }
        } else if (this.mAccessoryContainer != null && this.mAccessoryContainer != AccessoriesContainer.HAIR_COLOR && this.mAccessoryContainer != AccessoriesContainer.SKIN) {
            int e = m1726e(this.mAccessoryContainer);
            m1733a(e, false);
            m1706a(e);
            this.mAssetsView.invalidate();
        }
    }

    public boolean m1733a(int i, boolean z) {
        boolean z2 = false;
        if (!selectCategory(this.mAccessoryContainer, i) || this.mAccessoryContainer == AccessoriesContainer.HAIR_COLOR || this.mAccessoryContainer == AccessoriesContainer.SKIN || !z) {
            m1720b(this.mAccessoryContainer, i);
            z2 = true;
        } else {
            m1720b(this.mAccessoryContainer, 0);
        }
        m1728e();
        return z2;
    }

    public void m1734b() {
        if (this.mAccessoryContainer == null || !this.mAccessoryContainer.bool2) {
            if (m1716b(AccessoriesContainer.NBA, this.mAndroidify.getCurrentConfig().getOutfit()) > 0) {
                m1732a(AccessoriesContainer.NBA);
                return;
            } else {
                m1732a(AccessoriesContainer.SHIRT);
                return;
            }
        }
        m1732a(this.mAccessoryContainer);
    }

    public void m1735c() {
        m1732a(null);
    }

    public boolean m1736d() {
        if (this.mAccessoryContainer == null) {
            return false;
        }
        m1732a(null);
//        this.mAndroidify.m1393g();
        return true;
    }
}
