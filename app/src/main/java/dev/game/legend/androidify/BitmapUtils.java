package dev.game.legend.androidify;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Picture;

import dev.game.legend.androidify.wallpaper.AssetDatabase;

import dev.game.legend.avatar.R;


public class BitmapUtils {

    public static Bitmap getBitmap(Resources resources, int drawableResourceId) {
        return BitmapFactory.decodeResource(resources,
                drawableResourceId);
    }

    public static Bitmap combineDrawables(Resources resources, int head, int body, int legs) {
        Bitmap headBitmap = getBitmap(resources, head);
        Bitmap bodyBitmap = getBitmap(resources, body);
        Bitmap legsBitmap = getBitmap(resources, legs);

        int height = headBitmap.getHeight() + bodyBitmap.getHeight() + legsBitmap.getHeight();
        int width = Math.max(headBitmap.getWidth(), Math.max(bodyBitmap.getWidth(), legsBitmap.getWidth()));

        Bitmap result = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas comboImage = new Canvas(result);
        comboImage.drawBitmap(headBitmap, 0f, 0f, null);
        comboImage.drawBitmap(bodyBitmap, 0f, headBitmap.getHeight(), null);
        comboImage.drawBitmap(legsBitmap, 0f, headBitmap.getHeight() + bodyBitmap.getHeight(), null);

        return result;
    }

    public static Bitmap combineParts(AssetDatabase db) {


        int height = 800;
        int width = 600;

        Bitmap result = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas comboImage = new Canvas(result);
        Picture body = db.getSVGForResource(R.raw.android_body).getPicture();
        Picture head = db.getSVGForResource(R.raw.android_head).getPicture();
        Picture antenna = db.getSVGForResource(R.raw.android_antenna).getPicture();
        Picture arm = db.getSVGForResource(R.raw.android_arm).getPicture();
        Picture legs = db.getSVGForResource(R.raw.android_legs).getPicture();
        Picture feet = db.getSVGForResource(R.raw.android_feet).getPicture();
        body.draw(comboImage);
        head.draw(comboImage);
        antenna.draw(comboImage);
        arm.draw(comboImage);
        legs.draw(comboImage);
        feet.draw(comboImage);

        return result;    }
}
