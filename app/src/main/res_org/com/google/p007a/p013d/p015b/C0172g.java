package com.google.p007a.p013d.p015b;

import com.google.p007a.p013d.p014a.C0160a;
import com.google.p007a.p013d.p014a.C0161b;
import com.google.p007a.p013d.p014a.C0162c;

/* renamed from: com.google.a.d.b.g */
public final class C0172g {
    private C0161b f599a;
    private C0160a f600b;
    private C0162c f601c;
    private int f602d;
    private C0167b f603e;

    public C0172g() {
        this.f602d = -1;
    }

    public static boolean m1086b(int i) {
        return i >= 0 && i < 8;
    }

    public C0167b m1087a() {
        return this.f603e;
    }

    public void m1088a(int i) {
        this.f602d = i;
    }

    public void m1089a(C0160a c0160a) {
        this.f600b = c0160a;
    }

    public void m1090a(C0161b c0161b) {
        this.f599a = c0161b;
    }

    public void m1091a(C0162c c0162c) {
        this.f601c = c0162c;
    }

    public void m1092a(C0167b c0167b) {
        this.f603e = c0167b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(200);
        stringBuilder.append("<<\n");
        stringBuilder.append(" mode: ");
        stringBuilder.append(this.f599a);
        stringBuilder.append("\n ecLevel: ");
        stringBuilder.append(this.f600b);
        stringBuilder.append("\n version: ");
        stringBuilder.append(this.f601c);
        stringBuilder.append("\n maskPattern: ");
        stringBuilder.append(this.f602d);
        if (this.f603e == null) {
            stringBuilder.append("\n matrix: null\n");
        } else {
            stringBuilder.append("\n matrix:\n");
            stringBuilder.append(this.f603e.toString());
        }
        stringBuilder.append(">>\n");
        return stringBuilder.toString();
    }
}
