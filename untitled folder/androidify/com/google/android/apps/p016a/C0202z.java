package com.google.android.apps.p016a;

import android.util.Log;
import java.io.IOException;
import java.net.Socket;
import org.apache.http.Header;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.impl.DefaultHttpClientConnection;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

/* renamed from: com.google.android.apps.a.z */
class C0202z {
    DefaultHttpClientConnection f728a;
    aa f729b;
    int f730c;
    boolean f731d;
    HttpHost f732e;
    SocketFactory f733f;

    public C0202z(HttpHost httpHost) {
        this(httpHost, new PlainSocketFactory());
    }

    public C0202z(HttpHost httpHost, SocketFactory socketFactory) {
        this.f728a = new DefaultHttpClientConnection();
        this.f731d = true;
        this.f732e = httpHost;
        this.f733f = socketFactory;
    }

    private void m1298c() {
        if (this.f728a == null || !this.f728a.isOpen()) {
            HttpParams basicHttpParams = new BasicHttpParams();
            Socket connectSocket = this.f733f.connectSocket(this.f733f.createSocket(), this.f732e.getHostName(), this.f732e.getPort(), null, 0, basicHttpParams);
            connectSocket.setReceiveBufferSize(8192);
            this.f728a.bind(connectSocket, basicHttpParams);
        }
    }

    private void m1299d() {
        if (this.f728a != null && this.f728a.isOpen()) {
            try {
                this.f728a.close();
            } catch (IOException e) {
            }
        }
    }

    public void m1300a() {
        this.f728a.flush();
        HttpConnectionMetrics metrics = this.f728a.getMetrics();
        while (metrics.getResponseCount() < metrics.getRequestCount()) {
            HttpResponse receiveResponseHeader = this.f728a.receiveResponseHeader();
            if (!receiveResponseHeader.getStatusLine().getProtocolVersion().greaterEquals(HttpVersion.HTTP_1_1)) {
                this.f729b.m1111a(false);
                this.f731d = false;
            }
            Header[] headers = receiveResponseHeader.getHeaders("Connection");
            if (headers != null) {
                for (Header value : headers) {
                    if ("close".equalsIgnoreCase(value.getValue())) {
                        this.f729b.m1111a(false);
                        this.f731d = false;
                    }
                }
            }
            this.f730c = receiveResponseHeader.getStatusLine().getStatusCode();
            if (this.f730c != 200) {
                this.f729b.m1110a(this.f730c);
                m1299d();
                return;
            }
            this.f728a.receiveResponseEntity(receiveResponseHeader);
            receiveResponseHeader.getEntity().consumeContent();
            this.f729b.m1109a();
            if (C0185i.m1177a().m1193d()) {
                Log.v("GoogleAnalyticsTracker", "HTTP Response Code: " + receiveResponseHeader.getStatusLine().getStatusCode());
            }
            if (!this.f731d) {
                m1299d();
                return;
            }
        }
    }

    public void m1301a(aa aaVar) {
        this.f729b = aaVar;
    }

    public void m1302a(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        m1298c();
        this.f728a.sendRequestHeader(httpEntityEnclosingRequest);
        this.f728a.sendRequestEntity(httpEntityEnclosingRequest);
    }

    public void m1303b() {
        m1299d();
    }
}
