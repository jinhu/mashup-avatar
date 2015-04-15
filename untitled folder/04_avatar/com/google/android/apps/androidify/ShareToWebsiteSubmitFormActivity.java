package com.google.android.apps.androidify;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.a;
import com.google.android.apps.a.i;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

public class ShareToWebsiteSubmitFormActivity extends Activity {
    private String a;
    private String b;
    private TextView c;
    private EditText d;
    private EditText e;
    private i f;
    private String g;
    private boolean h;
    private df i;
    private az j;

    public ShareToWebsiteSubmitFormActivity() {
        this.i = df.ACCEPTING_TERMS;
    }

    private String a(Context context) {
        try {
            Matcher matcher = Patterns.EMAIL_ADDRESS.matcher("");
            for (Account account : AccountManager.get(context).getAccountsByType("com.google")) {
                if (matcher.reset(account.name).matches()) {
                    return account.name;
                }
            }
        } catch (Throwable e) {
            a.a(e);
        }
        return null;
    }

    private String a(HttpsURLConnection httpsURLConnection) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                stringBuilder.append(readLine);
            } else {
                bufferedReader.close();
                return stringBuilder.toString();
            }
        }
    }

    private void a(int i, int i2) {
        ah a = ah.a((Context) this);
        DrawView drawView = (DrawView) findViewById(i);
        ba baVar = new ba(this);
        baVar.a(this.j, a);
        baVar.b(0.6f);
        baVar.a(0);
        drawView.setMotion(com.google.android.apps.androidify.a.a.a((Context) this, i2));
        drawView.setDroidDrawer(baVar);
        drawView.a();
        drawView.invalidate();
    }

    public static void a(Activity activity, az azVar, boolean z) {
        try {
            Intent intent = new Intent(activity, ShareToWebsiteSubmitFormActivity.class);
            intent.putExtra("configString", azVar.c());
            if (z) {
                intent.putExtra("qrMode", true);
            }
            activity.startActivity(intent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c() {
        HttpsURLConnection httpsURLConnection;
        List arrayList;
        Throwable e;
        OutputStream outputStream;
        try {
            httpsURLConnection = (HttpsURLConnection) new URL("https://www.androidify.com/api/v1/submission/").openConnection();
            httpsURLConnection.setReadTimeout(10000);
            httpsURLConnection.setConnectTimeout(15000);
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setDoOutput(true);
            arrayList = new ArrayList(2);
            arrayList.add(new BasicNameValuePair("name", this.d.getText().toString()));
            arrayList.add(new BasicNameValuePair("famous", "true"));
            if (this.a != null) {
                arrayList.add(new BasicNameValuePair("email", this.a));
            }
            if (this.e.getText() != null && this.e.getText().length() > 0) {
                arrayList.add(new BasicNameValuePair("location", this.e.getText().toString()));
            }
            arrayList.add(new BasicNameValuePair("lang", getResources().getConfiguration().locale.getLanguage()));
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable e3) {
            a.a("Error submitting data.", e3);
            this.i = df.ERROR;
            if (this.f != null) {
                this.f.a("shareToWebsite", "submit", "clientProtocolException", 0);
                return;
            }
            return;
        } catch (Throwable e32) {
            a.a("Error submitting data.", e32);
            this.i = df.ERROR;
            if (this.f != null) {
                this.f.a("shareToWebsite", "submit", "ioException", 0);
                return;
            }
            return;
        }
        this.j.g(null);
        arrayList.add(new BasicNameValuePair("android", this.j.c()));
        UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(arrayList);
        httpsURLConnection.connect();
        try {
            outputStream = httpsURLConnection.getOutputStream();
            try {
                urlEncodedFormEntity.writeTo(outputStream);
                if (outputStream != null) {
                    outputStream.close();
                }
                int responseCode = httpsURLConnection.getResponseCode();
                if (responseCode == 200 || responseCode == 201) {
                    this.i = df.SUCCESS;
                    if (this.f != null) {
                        this.f.a("shareToWebsite", "submit", "success", 0);
                    }
                    String a = a(httpsURLConnection);
                    c.a("Server response: " + a);
                    this.g = new JSONObject(a).getString("share_id");
                    c.a("Server share id: " + this.g);
                    return;
                }
                c.a("Unexpected response code: " + responseCode);
                this.i = df.ERROR;
                if (this.f != null) {
                    this.f.a("shareToWebsite", "submit", "httpErrorCode", responseCode);
                }
            } catch (Throwable th) {
                e32 = th;
                if (outputStream != null) {
                    outputStream.close();
                }
                throw e32;
            }
        } catch (Throwable th2) {
            e32 = th2;
            outputStream = null;
            if (outputStream != null) {
                outputStream.close();
            }
            throw e32;
        }
    }

    private void d() {
        Builder builder = new Builder(this);
        builder.setIcon(R.drawable.ic_launcher);
        builder.setTitle(R.string.dialog_submit_error_title);
        builder.setMessage(R.string.dialog_submit_error_body);
        builder.setPositiveButton(R.string.dialog_submit_try_again, new da(this));
        builder.setNegativeButton(R.string.dialog_submit_cancel, null);
        builder.show();
    }

    public void a() {
        this.i = df.SUBMITTING;
        b();
        new dg().execute(new Object[0]);
    }

    public void b() {
        if (this.i == df.SUBMITTING) {
            this.c.setText(R.string.sending);
            this.c.setEnabled(false);
            return;
        }
        this.c.setText(R.string.menu_share);
        this.c.setEnabled(true);
    }

    public void clickedClose(View view) {
        Androidify.a((Activity) this);
        dh.a((Context) this);
    }

    public void clickedSend(View view) {
        if (PreferenceManager.getDefaultSharedPreferences(this).contains("ACCEPTED_TERMS")) {
            a();
        } else {
            showDialog(11);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.j = new az();
            this.b = getIntent().getStringExtra("configString");
            this.j.a((Context) this, this.b);
        } catch (Throwable e) {
            Throwable th = e;
            this.j = (az) Androidify.a((Activity) this, false).get(0);
            a.a(th);
        }
        this.h = getIntent().hasExtra("qrMode");
        setContentView(R.layout.activity_sharetowebsitesubmitform);
        this.a = a((Context) this);
        Typeface a = TextViewCompat.a((Context) this);
        this.e = (EditText) findViewById(R.id.et_location);
        this.e.setTypeface(a);
        this.d = (EditText) findViewById(R.id.et_droid_name);
        this.d.setTypeface(a);
        if (this.j.D()) {
            this.d.setText(this.j.E());
        }
        a(R.id.dv_submitform_droid, R.raw.anim_cheering);
        this.c = (TextView) findViewById(R.id.tv_share_to_website);
        if (getIntent().hasExtra("qrMode")) {
            this.c.setText(R.string.submit_for_qr_code);
        }
        try {
            this.f = i.a();
            this.f.a("shareToWebsiteForm");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 11:
                Builder builder = new Builder(this);
                Resources resources = getResources();
                builder.setTitle(resources.getString(R.string.tc_title));
                View textView = new TextView(this);
                textView.setText(Html.fromHtml(getString(R.string.tc_text)));
                int dimension = (int) getResources().getDimension(R.dimen.tc_spacer);
                textView.setPadding(dimension, dimension, dimension, dimension);
                textView.setClickable(true);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                textView.setAutoLinkMask(1);
                builder.setView(textView);
                builder.setPositiveButton(resources.getString(R.string.dialog_button_accept), new db(this));
                builder.setNeutralButton(resources.getString(R.string.dialog_submit_cancel), new dc(this));
                builder.setOnCancelListener(new dd(this));
                builder.setOnKeyListener(new de(this));
                return builder.create();
            default:
                return null;
        }
    }
}
