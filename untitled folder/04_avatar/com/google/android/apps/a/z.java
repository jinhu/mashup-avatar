package com.google.android.apps.a;

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

class z {
    DefaultHttpClientConnection a;
    aa b;
    int c;
    boolean d;
    HttpHost e;
    SocketFactory f;

    public z(HttpHost httpHost) {
        this(httpHost, new PlainSocketFactory());
    }

    public z(HttpHost httpHost, SocketFactory socketFactory) {
        this.a = new DefaultHttpClientConnection();
        this.d = true;
        this.e = httpHost;
        this.f = socketFactory;
    }

    private void c() {
        if (this.a == null || !this.a.isOpen()) {
            HttpParams basicHttpParams = new BasicHttpParams();
            Socket connectSocket = this.f.connectSocket(this.f.createSocket(), this.e.getHostName(), this.e.getPort(), null, 0, basicHttpParams);
            connectSocket.setReceiveBufferSize(8192);
            this.a.bind(connectSocket, basicHttpParams);
        }
    }

    private void d() {
        if (this.a != null && this.a.isOpen()) {
            try {
                this.a.close();
            } catch (IOException e) {
            }
        }
    }

    public void a() {
        this.a.flush();
        HttpConnectionMetrics metrics = this.a.getMetrics();
        while (metrics.getResponseCount() < metrics.getRequestCount()) {
            HttpResponse receiveResponseHeader = this.a.receiveResponseHeader();
            if (!receiveResponseHeader.getStatusLine().getProtocolVersion().greaterEquals(HttpVersion.HTTP_1_1)) {
                this.b.a(false);
                this.d = false;
            }
            Header[] headers = receiveResponseHeader.getHeaders("Connection");
            if (headers != null) {
                for (Header value : headers) {
                    if ("close".equalsIgnoreCase(value.getValue())) {
                        this.b.a(false);
                        this.d = false;
                    }
                }
            }
            this.c = receiveResponseHeader.getStatusLine().getStatusCode();
            if (this.c != 200) {
                this.b.a(this.c);
                d();
                return;
            }
            this.a.receiveResponseEntity(receiveResponseHeader);
            receiveResponseHeader.getEntity().consumeContent();
            this.b.a();
            if (i.a().d()) {
                Log.v("GoogleAnalyticsTracker", "HTTP Response Code: " + receiveResponseHeader.getStatusLine().getStatusCode());
            }
            if (!this.d) {
                d();
                return;
            }
        }
    }

    public void a(aa aaVar) {
        this.b = aaVar;
    }

    public void a(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        c();
        this.a.sendRequestHeader(httpEntityEnclosingRequest);
        this.a.sendRequestEntity(httpEntityEnclosingRequest);
    }

    public void b() {
        d();
    }
}
