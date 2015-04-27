package android.support.v4.p002c;

import android.util.Log;
import java.io.Writer;

/* renamed from: android.support.v4.c.e */
public class C0039e extends Writer {
    private final String f204a;
    private StringBuilder f205b;

    public C0039e(String str) {
        this.f205b = new StringBuilder(128);
        this.f204a = str;
    }

    private void m249a() {
        if (this.f205b.length() > 0) {
            Log.d(this.f204a, this.f205b.toString());
            this.f205b.delete(0, this.f205b.length());
        }
    }

    public void close() {
        m249a();
    }

    public void flush() {
        m249a();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                m249a();
            } else {
                this.f205b.append(c);
            }
        }
    }
}
