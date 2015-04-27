package com.google.android.apps.androidify;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MatrixCursor.RowBuilder;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;

public class ImageProvider extends ContentProvider {
    public static final Uri f881a;
    private MatrixCursor f882b;

    static {
        f881a = Uri.parse("content://com.google.android.apps.androidify");
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        Log.d("DROIDIFY PROVIDER", "GETTYPE Called.");
        return "image/png";
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        Log.d("ANDROIDIFY PROVIDER", "--------------------- CREATED.");
        return true;
    }

    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        Log.d("DROIDIFY PROVIDER", "OPEN FILE CALLED, URI: " + uri + ", s: " + str);
        return openFileHelper(uri, str);
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i = 0;
        String lastPathSegment = uri.getLastPathSegment();
        Log.d("ANDROIDIFY PROVIDER", "QUERY Called, last segment is: " + lastPathSegment);
        try {
            int parseInt = Integer.parseInt(lastPathSegment);
            File file = new File("/data/data/com.google.android.apps.androidify/files/android" + parseInt + ".png");
            Log.d("ANDROIDIFY PROVIDER", "File length: " + file.length());
            if (strArr == null) {
                strArr = new String[]{"_id", "_data", "_display_name", "_size", "mime_type"};
            }
            for (String str3 : strArr) {
                Log.d("ANDROIDIFY PROVIDER", "Field: " + str3);
            }
            Log.d("ANDROIDIFY PROVIDER", "Selection: " + str);
            if (strArr2 == null) {
                Log.d("ANDROIDIFY PROVIDER", "No selection args.");
            } else {
                for (String str32 : strArr2) {
                    Log.d("ANDROIDIFY PROVIDER", "Sel Arg: " + str32);
                }
            }
            Log.d("ANDROIDIFY PROVIDER", "Sort Order: " + str2);
            this.f882b = new MatrixCursor(strArr);
            RowBuilder newRow = this.f882b.newRow();
            int length = strArr.length;
            while (i < length) {
                Object obj = strArr[i];
                if ("_id".equals(obj)) {
                    newRow.add(new Integer(1));
                } else if ("_data".equals(obj)) {
                    newRow.add("/data/data/com.google.android.apps.androidify/files/android" + parseInt + ".png");
                } else if ("mime_type".equals(obj)) {
                    newRow.add("image/png");
                } else if ("_display_name".equals(obj)) {
                    newRow.add("android.png");
                } else if ("_size".equals(obj)) {
                    newRow.add(Long.valueOf(file.length()));
                } else {
                    newRow.add("");
                }
                i++;
            }
            this.f882b.setNotificationUri(getContext().getContentResolver(), uri);
            return this.f882b;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
