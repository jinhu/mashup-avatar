package dev.game.legend.androidify;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import dev.game.legend.androidify.wallpaper.AndroidDrawer;
import dev.game.legend.androidify.wallpaper.AssetDatabase;

import java.util.Random;

import dev.game.legend.avatar.R;

public class PlaceholderFragment extends Fragment {

    private final String mySound = "my_recorded_sound";
    private AndroidSoundRecorder soundRecorder;
    private AndroidSoundPlayer soundPlayer;
    private AssetDatabase assetDatabase;
    private AndroidDrawer android;
    private AndroidDrawer nextAndroid;
    private long sceneTime;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        final ViewPager viewPagerHair = (ViewPager) rootView.findViewById(R.id.viewPagerHair);
        final ViewPager viewPagerGlass = (ViewPager) rootView.findViewById(R.id.viewPagerGlass);
        final ViewPager viewPagerBeard = (ViewPager) rootView.findViewById(R.id.viewPagerBeard);
        //final ViewPager viewPagerAccessory = (ViewPager) rootView.findViewById(R.id.viewPagerAccessory);
        final ViewPager viewPagerShirt = (ViewPager) rootView.findViewById(R.id.viewPagerShirt);
        final ViewPager viewPagerPants = (ViewPager) rootView.findViewById(R.id.viewPagerPants);
        final ViewPager viewPagerShoes = (ViewPager) rootView.findViewById(R.id.viewPagerShoes);

        FragmentManager fm = getActivity().getSupportFragmentManager();
        assetDatabase = new AssetDatabase(getActivity().getAssets(),getActivity().getResources());
        viewPagerHair.setAdapter(new SvgAssetsAdapter(fm, assetDatabase, "hair", "back"));
        viewPagerHair.setCurrentItem(1);
        viewPagerGlass.setAdapter(new SvgAssetsAdapter(fm, assetDatabase, "glasses", null));
        viewPagerGlass.setCurrentItem(1);
        viewPagerBeard.setAdapter(new SvgAssetsAdapter(fm, assetDatabase, "beard", null));
        viewPagerBeard.setCurrentItem(1);
        //viewPagerAccessory.setAdapter(new SvgAssetsAdapter(fm, db, "accessories", "head"));
        viewPagerShirt.setAdapter(new SvgAssetsAdapter(fm, assetDatabase, "shirt", "body"));
        viewPagerShirt.setCurrentItem(1);
        viewPagerPants.setAdapter(new SvgAssetsAdapter(fm, assetDatabase, "pants", "leg"));
        viewPagerPants.setCurrentItem(1);

        viewPagerShoes.setAdapter(new SvgAssetsAdapter(fm, assetDatabase, "shoes", null));
        viewPagerShoes.setCurrentItem(1);

        initShareButton(rootView, viewPagerHair, viewPagerBeard, viewPagerGlass);
        initPlayButton(rootView);
        initRecordButton(rootView);

        //setTouchEventsEnabled(true);
        //this.assetDatabase = new AssetDatabase(getAssets(), getResources());
        android = new AndroidDrawer(this.assetDatabase);
        nextAndroid = new AndroidDrawer(this.assetDatabase);
        // First android
        android.setAndroidConfig(assetDatabase.getRandomConfig(), this.assetDatabase);
        android.setBackgroundColor(getNextColor());
        // Set initial zoom
        //android.setZoom(createRandomZoomInfo());
        sceneTime = System.currentTimeMillis();
        Bitmap bitmap = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        //canvas.scale(4, 2, 0, 0);
        android.draw(canvas);
        ImageView view = new ImageView(getActivity());
        view.setImageBitmap(bitmap);
        return view;
        //return rootView;
    }
    private static final Random RANDOM = new Random();
    /**
     * The set of background colors
     */
    private static final int[] COLORS =
            {
                    0x59c0ce,
                    0xe684a9,
                    0xfef48b,
                    0x9dcb7a,
                    0xd65143,
            };
    private int getNextColor() {

        return COLORS[RANDOM.nextInt(COLORS.length)];
    }
    private void initPlayButton(View rootView) {
        soundPlayer = new AndroidSoundPlayer(mySound);

        View playButton = rootView.findViewById(R.id.button_play_sound);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (soundPlayer.isPlaying()) {
                    soundPlayer.stopPlaying();
                } else {
                    soundPlayer.startPlaying();
                }
            }
        });
    }

    private void initRecordButton(View rootView) {
        soundRecorder = new AndroidSoundRecorder(mySound);

        View recordButton = rootView.findViewById(R.id.button_record_sound);
        recordButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ImageButton recordButton = (ImageButton) view;

                if (MotionEvent.ACTION_UP == motionEvent.getAction()) {
                    if (soundRecorder.isRecording()) {
                        soundRecorder.stopRecording();
                        recordButton.setImageDrawable(getResources().getDrawable(R.drawable.record_off));
                    } else {
                        soundRecorder.startRecording();
                        recordButton.setImageDrawable(getResources().getDrawable(R.drawable.record_on));
                    }
                }

                return false;
            }
        });
    }

    private void initShareButton(View rootView, final ViewPager viewPagerHead, final ViewPager viewPagerBody, final ViewPager viewPagerLegs) {
        View shareButton = rootView.findViewById(R.id.button_share);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer head = AndroidDrawables.getHeads().get(viewPagerHead.getCurrentItem());
                Integer body = AndroidDrawables.getBodies().get(viewPagerBody.getCurrentItem());
                Integer legs = AndroidDrawables.getLegs().get(viewPagerLegs.getCurrentItem());
                assetDatabase = new AssetDatabase(getActivity().getAssets(), getActivity().getResources());
                Bitmap bitmap = BitmapUtils.combineParts(assetDatabase);
                //Drawables(getResources(), head, body, legs);

                String imagePath = MediaStore.Images.Media.insertImage(getActivity().getContentResolver(), bitmap, "Android Avatar", null);
                Uri imageURI = Uri.parse(imagePath);
                startShareActivity(imageURI);
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        soundRecorder.stopRecording();
        soundPlayer.stopPlaying();
    }

    private void startShareActivity(Uri imageURI) {
        final Intent shareIntent = new Intent(Intent.ACTION_SEND);

        shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        shareIntent.putExtra(Intent.EXTRA_STREAM, imageURI);
        shareIntent.setType("image/png");

        startActivity(shareIntent);
    }
}