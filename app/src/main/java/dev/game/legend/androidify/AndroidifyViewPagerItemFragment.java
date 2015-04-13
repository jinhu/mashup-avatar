package dev.game.legend.androidify;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import dev.game.legend.svgandroid.SVG;

import dev.game.legend.avatar.R;

public class AndroidifyViewPagerItemFragment extends Fragment {

    public static final String IMG_ID = "IMG_ID";

    private int imgId;
    private String mImageSource;
    private SVG mSvg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            imgId = savedInstanceState.getInt(IMG_ID);
        }

        View rootView = inflater.inflate(R.layout.androidify_part, container, false);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.android_part);
        imageView.setImageResource(imgId);
        if(mSvg!=null) {
            imageView.setImageBitmap(mSvg.createBitmap());
        }
        return rootView;
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(IMG_ID, imgId);
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public void setImgSrc(String anImageSource) {
        mImageSource = anImageSource;
    }

    public void setSvg(SVG aSvg) {
        mSvg = aSvg;
    }
}
