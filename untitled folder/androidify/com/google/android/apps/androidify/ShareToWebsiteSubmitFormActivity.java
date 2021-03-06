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
import com.google.android.C0176a;
import com.google.android.apps.androidify.p018a.C0204a;
import com.google.android.apps.p016a.C0185i;
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
    private String f937a;
    private String f938b;
    private TextView f939c;
    private EditText f940d;
    private EditText f941e;
    private C0185i f942f;
    private String f943g;
    private boolean f944h;
    private df f945i;
    private az f946j;

    public ShareToWebsiteSubmitFormActivity() {
        this.f945i = df.ACCEPTING_TERMS;
    }

    private String m1566a(Context context) {
        try {
            Matcher matcher = Patterns.EMAIL_ADDRESS.matcher("");
            for (Account account : AccountManager.get(context).getAccountsByType("com.google")) {
                if (matcher.reset(account.name).matches()) {
                    return account.name;
                }
            }
        } catch (Throwable e) {
            C0176a.m1103a(e);
        }
        return null;
    }

    private String m1567a(HttpsURLConnection httpsURLConnection) {
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

    private void m1568a(int i, int i2) {
        ah a = ah.m1648a((Context) this);
        DrawView drawView = (DrawView) findViewById(i);
        ba baVar = new ba(this);
        baVar.m1844a(this.f946j, a);
        baVar.m1848b(0.6f);
        baVar.m1834a(0);
        drawView.setMotion(C0204a.m1596a((Context) this, i2));
        drawView.setDroidDrawer(baVar);
        drawView.m1426a();
        drawView.invalidate();
    }

    public static void m1569a(Activity activity, az azVar, boolean z) {
        try {
            Intent intent = new Intent(activity, ShareToWebsiteSubmitFormActivity.class);
            intent.putExtra("configString", azVar.m1787c());
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
    private void m1572c() {
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
            arrayList.add(new BasicNameValuePair("name", this.f940d.getText().toString()));
            arrayList.add(new BasicNameValuePair("famous", "true"));
            if (this.f937a != null) {
                arrayList.add(new BasicNameValuePair("email", this.f937a));
            }
            if (this.f941e.getText() != null && this.f941e.getText().length() > 0) {
                arrayList.add(new BasicNameValuePair("location", this.f941e.getText().toString()));
            }
            arrayList.add(new BasicNameValuePair("lang", getResources().getConfiguration().locale.getLanguage()));
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable e3) {
            C0176a.m1102a("Error submitting data.", e3);
            this.f945i = df.ERROR;
            if (this.f942f != null) {
                this.f942f.m1189a("shareToWebsite", "submit", "clientProtocolException", 0);
                return;
            }
            return;
        } catch (Throwable e32) {
            C0176a.m1102a("Error submitting data.", e32);
            this.f945i = df.ERROR;
            if (this.f942f != null) {
                this.f942f.m1189a("shareToWebsite", "submit", "ioException", 0);
                return;
            }
            return;
        }
        this.f946j.m1804g(null);
        arrayList.add(new BasicNameValuePair("android", this.f946j.m1787c()));
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
                    this.f945i = df.SUCCESS;
                    if (this.f942f != null) {
                        this.f942f.m1189a("shareToWebsite", "submit", "success", 0);
                    }
                    String a = m1567a(httpsURLConnection);
                    C0220c.m1912a("Server response: " + a);
                    this.f943g = new JSONObject(a).getString("share_id");
                    C0220c.m1912a("Server share id: " + this.f943g);
                    return;
                }
                C0220c.m1912a("Unexpected response code: " + responseCode);
                this.f945i = df.ERROR;
                if (this.f942f != null) {
                    this.f942f.m1189a("shareToWebsite", "submit", "httpErrorCode", responseCode);
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

    private void m1574d() {
        Builder builder = new Builder(this);
        builder.setIcon(R.drawable.ic_launcher);
        builder.setTitle(R.string.dialog_submit_error_title);
        builder.setMessage(R.string.dialog_submit_error_body);
        builder.setPositiveButton(R.string.dialog_submit_try_again, new da(this));
        builder.setNegativeButton(R.string.dialog_submit_cancel, null);
        builder.show();
    }

    public void m1578a() {
        this.f945i = df.SUBMITTING;
        m1579b();
        new dg().execute(new Object[0]);
    }

    public void m1579b() {
        if (this.f945i == df.SUBMITTING) {
            this.f939c.setText(R.string.sending);
            this.f939c.setEnabled(false);
            return;
        }
        this.f939c.setText(R.string.menu_share);
        this.f939c.setEnabled(true);
    }

    public void clickedClose(View view) {
        Androidify.m1337a((Activity) this);
        dh.m1956a((Context) this);
    }

    public void clickedSend(View view) {
        if (PreferenceManager.getDefaultSharedPreferences(this).contains("ACCEPTED_TERMS")) {
            m1578a();
        } else {
            showDialog(11);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.f946j = new az();
            this.f938b = getIntent().getStringExtra("configString");
            this.f946j.m1776a((Context) this, this.f938b);
        } catch (Throwable e) {
            Throwable th = e;
            this.f946j = (az) Androidify.m1335a((Activity) this, false).get(0);
            C0176a.m1103a(th);
        }
        this.f944h = getIntent().hasExtra("qrMode");
        setContentView(R.layout.activity_sharetowebsitesubmitform);
        this.f937a = m1566a((Context) this);
        Typeface a = TextViewCompat.m1580a((Context) this);
        this.f941e = (EditText) findViewById(R.id.et_location);
        this.f941e.setTypeface(a);
        this.f940d = (EditText) findViewById(R.id.et_droid_name);
        this.f940d.setTypeface(a);
        if (this.f946j.m1768D()) {
            this.f940d.setText(this.f946j.m1769E());
        }
        m1568a(R.id.dv_submitform_droid, R.raw.anim_cheering);
        this.f939c = (TextView) findViewById(R.id.tv_share_to_website);
        if (getIntent().hasExtra("qrMode")) {
            this.f939c.setText(R.string.submit_for_qr_code);
        }
        try {
            this.f942f = C0185i.m1177a();
            this.f942f.m1184a("shareToWebsiteForm");
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
