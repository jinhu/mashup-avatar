package dev.game.legend.androidify;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import dev.game.legend.androidify.wallpaper.AssetDatabase;
import dev.game.legend.svgandroid.SVG;

import java.util.List;

public class SvgAssetsAdapter extends FragmentPagerAdapter {

    private final AssetDatabase mAssetsDatabase;
    private final String mAccessory;
    private List<String> imgIds;
    private String mSuffix;

    public SvgAssetsAdapter(FragmentManager fm, AssetDatabase anAssetDatabase, String anAccessory, String aSuffix) {
        super(fm);
        mAssetsDatabase = anAssetDatabase;
        mAccessory = anAccessory;
        mSuffix = aSuffix;
    }

    @Override
    public Fragment getItem(int position) {
        AndroidifyViewPagerItemFragment fragment = new AndroidifyViewPagerItemFragment();
        SVG svg = mAssetsDatabase.getSVGForAsset(mAccessory, mAssetsDatabase.getAssets(mAccessory).get(position),mSuffix);
        fragment.setSvg(svg);
        return fragment;
    }

    @Override
    public int getCount() {
        return mAssetsDatabase.getAssets(mAccessory).size();
    }
}
