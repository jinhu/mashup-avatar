package com.google.android.apps.androidify;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;
import com.google.android.Util;

public class SaveToPhotoGalleryActivity extends Activity {
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        Util.debug("[[SAVE TO PHOTO GALLERY ACTIVITY]]");
        sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", intent.getData()));
        Toast.makeText(this, "Droid saved to image gallery.", 0).show();
        finish();
    }
}
