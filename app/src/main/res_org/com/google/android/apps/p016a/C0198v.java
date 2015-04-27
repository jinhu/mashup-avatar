package com.google.android.apps.analytics;

import android.util.Log;
import java.util.Collections;
import java.util.LinkedList;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

/* renamed from: com.google.android.apps.a.v */
class C0198v implements Runnable {
    final /* synthetic */ C0197u f703a;
    private final LinkedList f704b;

    public C0198v(C0197u c0197u, C0189m[] c0189mArr) {
        this.f703a = c0197u;
        this.f704b = new LinkedList();
        Collections.addAll(this.f704b, c0189mArr);
    }

    private void m1251a(boolean z) {
        if (GoogleAnalyticsTracker.m1177a().m1193d() && z) {
            Log.v("GoogleAnalyticsTracker", "dispatching hits in dry run mode");
        }
        int i = 0;
        while (i < this.f704b.size() && i < this.f703a.f697e) {
            String str;
            String str2;
            HttpEntityEnclosingRequest basicHttpEntityEnclosingRequest;
            String a = af.m1130a(((C0189m) this.f704b.get(i)).f675a, System.currentTimeMillis());
            int indexOf = a.indexOf(63);
            if (indexOf < 0) {
                str = "";
                str2 = a;
            } else {
                str = indexOf > 0 ? a.substring(0, indexOf) : "";
                if (indexOf < a.length() - 2) {
                    String substring = a.substring(indexOf + 1);
                    str2 = str;
                    str = substring;
                } else {
                    str2 = str;
                    str = "";
                }
            }
            if (str.length() < 2036) {
                basicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("GET", a);
            } else {
                HttpEntityEnclosingRequest basicHttpEntityEnclosingRequest2 = new BasicHttpEntityEnclosingRequest("POST", "/p" + str2);
                basicHttpEntityEnclosingRequest2.addHeader("Content-Length", Integer.toString(str.length()));
                basicHttpEntityEnclosingRequest2.addHeader("Content-Type", "text/plain");
                basicHttpEntityEnclosingRequest2.setEntity(new StringEntity(str));
                basicHttpEntityEnclosingRequest = basicHttpEntityEnclosingRequest2;
            }
            a = this.f703a.f702j.f690b.getHostName();
            if (this.f703a.f702j.f690b.getPort() != 80) {
                a = a + ":" + this.f703a.f702j.f690b.getPort();
            }
            basicHttpEntityEnclosingRequest.addHeader("Host", a);
            basicHttpEntityEnclosingRequest.addHeader("User-Agent", this.f703a.f695c);
            if (GoogleAnalyticsTracker.m1177a().m1193d()) {
                StringBuffer stringBuffer = new StringBuffer();
                for (Object obj : basicHttpEntityEnclosingRequest.getAllHeaders()) {
                    stringBuffer.append(obj.toString()).append("\n");
                }
                stringBuffer.append(basicHttpEntityEnclosingRequest.getRequestLine().toString()).append("\n");
                Log.i("GoogleAnalyticsTracker", stringBuffer.toString());
            }
            if (str.length() > 8192) {
                Log.w("GoogleAnalyticsTracker", "Hit too long (> 8192 bytes)--not sent");
                this.f703a.f701i.m1253a();
            } else if (z) {
                this.f703a.f701i.m1253a();
            } else {
                this.f703a.f694b.m1302a(basicHttpEntityEnclosingRequest);
            }
            i++;
        }
        if (!z) {
            this.f703a.f694b.m1300a();
        }
    }

    public C0189m m1252a() {
        return (C0189m) this.f704b.poll();
    }

    public void run() {
        this.f703a.f699g = this;
        int i = 0;
        while (i < 5 && this.f704b.size() > 0) {
            long j = 0;
            try {
                if (this.f703a.f696d == 500 || this.f703a.f696d == 503) {
                    j = (long) (Math.random() * ((double) this.f703a.f698f));
                    if (this.f703a.f698f < 256) {
                        C0197u.m1238a(this.f703a, 2);
                    }
                } else {
                    this.f703a.f698f = 2;
                }
                Thread.sleep(j * 1000);
                m1251a(this.f703a.f702j.m1234a());
                i++;
            } catch (Throwable e) {
                Log.w("GoogleAnalyticsTracker", "Couldn't sleep.", e);
            } catch (Throwable e2) {
                Log.w("GoogleAnalyticsTracker", "Problem with socket or streams.", e2);
            } catch (Throwable e22) {
                Log.w("GoogleAnalyticsTracker", "Problem with http streams.", e22);
            }
        }
        this.f703a.f694b.m1303b();
        this.f703a.f700h.m1149a();
        this.f703a.f699g = null;
    }
}
