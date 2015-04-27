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
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.apps.androidify.p018a.JsonUtil;
import com.google.android.apps.analytics.GoogleAnalyticsTracker;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

import javax.net.ssl.HttpsURLConnection;

import dev.game.legend.avatar.R;

public class ShareToWebsiteSubmitFormActivity extends Activity {
    private String f937a;
    private String f938b;
    private TextView f939c;
    private EditText f940d;
    private EditText f941e;
    private GoogleAnalyticsTracker f942f;
    String f943g;
    boolean f944h;
    ResultState mResultState;
    AndroidConfig f946j;

    public ShareToWebsiteSubmitFormActivity() {
        this.mResultState = ResultState.ACCEPTING_TERMS;
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
            com.google.android.Util.m1103a(e);
        }
        return null;
    }

    private String m1567a(HttpsURLConnection httpsURLConnection) throws IOException {
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
        AssetDatabase a = AssetDatabase.instance((Context) this);
        DrawView drawView = (DrawView) findViewById(i);
        AndroidDrawer androidDrawerVar = new AndroidDrawer(this);
        androidDrawerVar.setAndroidConfig(this.f946j, a);
        androidDrawerVar.m1848b(0.6f);
        androidDrawerVar.m1834a(0);
        drawView.setMotion(JsonUtil.getAnimationCatalogue((Context) this, i2));
        drawView.setDroidDrawer(androidDrawerVar);
        drawView.m1426a();
        drawView.invalidate();
    }

    public static void m1569a(Activity activity, AndroidConfig aAndroidConfigVar, boolean z) {
        try {
            Intent intent = new Intent(activity, ShareToWebsiteSubmitFormActivity.class);
            intent.putExtra("configString", aAndroidConfigVar.m1787c());
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
    void m1572c() throws Throwable {
        HttpsURLConnection httpsURLConnection = null;
        List arrayList = null;
        Throwable e;
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
            com.google.android.Util.error("Error submitting data.", e3);
            this.mResultState = ResultState.ERROR;
            if (this.f942f != null) {
                this.f942f.m1189a("shareToWebsite", "submit", "clientProtocolException", 0);
                return;
            }
            return;
        }
        this.f946j.m1804g(null);
        arrayList.add(new BasicNameValuePair("android", this.f946j.m1787c()));
        UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(arrayList);
        httpsURLConnection.connect();
        OutputStream outputStream;
        Throwable e32;
        try {
            outputStream = httpsURLConnection.getOutputStream();
            try {
                urlEncodedFormEntity.writeTo(outputStream);
                if (outputStream != null) {
                    outputStream.close();
                }
                int responseCode = httpsURLConnection.getResponseCode();
                if (responseCode == 200 || responseCode == 201) {
                    this.mResultState = ResultState.SUCCESS;
                    if (this.f942f != null) {
                        this.f942f.m1189a("shareToWebsite", "submit", "success", 0);
                    }
                    String a = m1567a(httpsURLConnection);
                    Util.debug("Server response: " + a);
                    this.f943g = new JSONObject(a).getString("share_id");
                    Util.debug("Server share id: " + this.f943g);
                    return;
                }
                Util.debug("Unexpected response code: " + responseCode);
                this.mResultState = ResultState.ERROR;
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

    void m1574d() {
        Builder builder = new Builder(this);
        builder.setIcon(R.drawable.ic_launcher);
        builder.setTitle(R.string.dialog_submit_error_title);
        builder.setMessage(R.string.dialog_submit_error_body);
        builder.setPositiveButton(R.string.dialog_submit_try_again, new da(this));
        builder.setNegativeButton(R.string.dialog_submit_cancel, null);
        builder.show();
    }

    public void m1578a() {
        this.mResultState = ResultState.SUBMITTING;
        m1579b();
        new ShareTask().execute(new Object[0]);
    }

    public void m1579b() {
        if (this.mResultState == ResultState.SUBMITTING) {
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
            this.f946j = new AndroidConfig();
            this.f938b = getIntent().getStringExtra("configString");
            this.f946j.getInstance((Context) this, this.f938b);
        } catch (Throwable e) {
            Throwable th = e;
            this.f946j = (AndroidConfig) Androidify.getSaveList((Activity) this, false).get(0);
            com.google.android.Util.m1103a(th);
        }
        this.f944h = getIntent().hasExtra("qrMode");
        setContentView(R.layout.activity_sharetowebsitesubmitform);
        this.f937a = m1566a((Context) this);
        Typeface a = TextViewCompat.createTypeface((Context) this);
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
            this.f942f = GoogleAnalyticsTracker.m1177a();
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
                //textView.setText(Html.fromHtml(getString(R.string.tc_text)));
                int dimension = (int) getResources().getDimension(R.dimen.tc_spacer);
                textView.setPadding(dimension, dimension, dimension, dimension);
                textView.setClickable(true);
                //textView.setMovementMethod(LinkMovementMethod.getInstance());
                //textView.setAutoLinkMask(1);
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
