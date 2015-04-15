package com.google.a.d.b;

import com.google.a.d.a.a;
import com.google.a.d.a.b;
import com.google.a.d.a.c;

public final class g {
    private b a;
    private a b;
    private c c;
    private int d;
    private b e;

    public g() {
        this.d = -1;
    }

    public static boolean b(int i) {
        return i >= 0 && i < 8;
    }

    public b a() {
        return this.e;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    public void a(b bVar) {
        this.a = bVar;
    }

    public void a(c cVar) {
        this.c = cVar;
    }

    public void a(b bVar) {
        this.e = bVar;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(200);
        stringBuilder.append("<<\n");
        stringBuilder.append(" mode: ");
        stringBuilder.append(this.a);
        stringBuilder.append("\n ecLevel: ");
        stringBuilder.append(this.b);
        stringBuilder.append("\n version: ");
        stringBuilder.append(this.c);
        stringBuilder.append("\n maskPattern: ");
        stringBuilder.append(this.d);
        if (this.e == null) {
            stringBuilder.append("\n matrix: null\n");
        } else {
            stringBuilder.append("\n matrix:\n");
            stringBuilder.append(this.e.toString());
        }
        stringBuilder.append(">>\n");
        return stringBuilder.toString();
    }
}
