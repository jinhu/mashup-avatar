package com.google.android.apps.a;

import android.util.Log;
import java.util.Collections;
import java.util.LinkedList;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

class v implements Runnable {
    final /* synthetic */ u a;
    private final LinkedList b;

    public v(u uVar, m[] mVarArr) {
        this.a = uVar;
        this.b = new LinkedList();
        Collections.addAll(this.b, mVarArr);
    }

    private void a(boolean z) {
        if (i.a().d() && z) {
            Log.v("GoogleAnalyticsTracker", "dispatching hits in dry run mode");
        }
        int i = 0;
        while (i < this.b.size() && i < this.a.e) {
            String str;
            String str2;
            HttpEntityEnclosingRequest basicHttpEntityEnclosingRequest;
            String a = af.a(((m) this.b.get(i)).a, System.currentTimeMillis());
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
            a = this.a.j.b.getHostName();
            if (this.a.j.b.getPort() != 80) {
                a = a + ":" + this.a.j.b.getPort();
            }
            basicHttpEntityEnclosingRequest.addHeader("Host", a);
            basicHttpEntityEnclosingRequest.addHeader("User-Agent", this.a.c);
            if (i.a().d()) {
                StringBuffer stringBuffer = new StringBuffer();
                for (Object obj : basicHttpEntityEnclosingRequest.getAllHeaders()) {
                    stringBuffer.append(obj.toString()).append("\n");
                }
                stringBuffer.append(basicHttpEntityEnclosingRequest.getRequestLine().toString()).append("\n");
                Log.i("GoogleAnalyticsTracker", stringBuffer.toString());
            }
            if (str.length() > 8192) {
                Log.w("GoogleAnalyticsTracker", "Hit too long (> 8192 bytes)--not sent");
                this.a.i.a();
            } else if (z) {
                this.a.i.a();
            } else {
                this.a.b.a(basicHttpEntityEnclosingRequest);
            }
            i++;
        }
        if (!z) {
            this.a.b.a();
        }
    }

    public m a() {
        return (m) this.b.poll();
    }

    public void run() {
        this.a.g = this;
        int i = 0;
        while (i < 5 && this.b.size() > 0) {
            long j = 0;
            try {
                if (this.a.d == 500 || this.a.d == 503) {
                    j = (long) (Math.random() * ((double) this.a.f));
                    if (this.a.f < 256) {
                        u.a(this.a, 2);
                    }
                } else {
                    this.a.f = 2;
                }
                Thread.sleep(j * 1000);
                a(this.a.j.a());
                i++;
            } catch (Throwable e) {
                Log.w("GoogleAnalyticsTracker", "Couldn't sleep.", e);
            } catch (Throwable e2) {
                Log.w("GoogleAnalyticsTracker", "Problem with socket or streams.", e2);
            } catch (Throwable e22) {
                Log.w("GoogleAnalyticsTracker", "Problem with http streams.", e22);
            }
        }
        this.a.b.b();
        this.a.h.a();
        this.a.g = null;
    }
}
