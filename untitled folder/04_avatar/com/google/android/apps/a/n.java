package com.google.android.apps.a;

import com.google.android.apps.androidify.cm;
import java.util.Locale;

class n {
    public static String a(h hVar) {
        StringBuilder stringBuilder = new StringBuilder();
        e j = hVar.j();
        if (j == null) {
            return "";
        }
        if (!j.b()) {
            return "";
        }
        d[] a = j.a();
        a(a, stringBuilder, 8);
        a(a, stringBuilder, 9);
        a(a, stringBuilder, 11);
        return stringBuilder.toString();
    }

    public static String a(h hVar, ab abVar) {
        StringBuilder stringBuilder = new StringBuilder();
        if ("__##GOOGLEPAGEVIEW##__".equals(hVar.c)) {
            stringBuilder.append(c(hVar, abVar));
        } else if ("__##GOOGLEITEM##__".equals(hVar.c)) {
            stringBuilder.append(f(hVar, abVar));
        } else if ("__##GOOGLETRANSACTION##__".equals(hVar.c)) {
            stringBuilder.append(e(hVar, abVar));
        } else {
            stringBuilder.append(d(hVar, abVar));
        }
        if (hVar.h()) {
            stringBuilder.append("&aip=1");
        }
        if (!hVar.i()) {
            stringBuilder.append("&utmht=" + System.currentTimeMillis());
        }
        return stringBuilder.toString();
    }

    private static String a(String str) {
        return str.replace("'", "'0").replace(")", "'1").replace("*", "'2").replace("!", "'3");
    }

    static void a(StringBuilder stringBuilder, String str, double d) {
        stringBuilder.append(str).append("=");
        double floor = Math.floor((d * 1000000.0d) + 0.5d) / 1000000.0d;
        if (floor != 0.0d) {
            stringBuilder.append(Double.toString(floor));
        }
    }

    private static void a(StringBuilder stringBuilder, String str, String str2) {
        stringBuilder.append(str).append("=");
        if (str2 != null && str2.trim().length() > 0) {
            stringBuilder.append(c.a(str2));
        }
    }

    private static void a(d[] dVarArr, StringBuilder stringBuilder, int i) {
        stringBuilder.append(i).append("(");
        Object obj = 1;
        for (int i2 = 0; i2 < dVarArr.length; i2++) {
            if (dVarArr[i2] != null) {
                d dVar = dVarArr[i2];
                if (obj == null) {
                    stringBuilder.append("*");
                } else {
                    obj = null;
                }
                stringBuilder.append(dVar.d()).append("!");
                switch (i) {
                    case cm.ExpandableHListView_hlv_childIndicatorPaddingTop /*8*/:
                        stringBuilder.append(a(b(dVar.b())));
                        break;
                    case 9:
                        stringBuilder.append(a(b(dVar.c())));
                        break;
                    case 11:
                        stringBuilder.append(dVar.a());
                        break;
                    default:
                        break;
                }
            }
        }
        stringBuilder.append(")");
    }

    public static String b(h hVar, ab abVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("__utma=");
        stringBuilder.append("1").append(".");
        stringBuilder.append(hVar.g()).append(".");
        stringBuilder.append(hVar.c()).append(".");
        stringBuilder.append(hVar.d()).append(".");
        stringBuilder.append(hVar.e()).append(".");
        stringBuilder.append(hVar.f()).append(";");
        if (abVar != null) {
            stringBuilder.append("+__utmz=");
            stringBuilder.append("1").append(".");
            stringBuilder.append(abVar.b()).append(".");
            stringBuilder.append(Integer.valueOf(abVar.c()).toString()).append(".");
            stringBuilder.append(Integer.valueOf(abVar.d()).toString()).append(".");
            stringBuilder.append(abVar.a()).append(";");
        }
        return b(stringBuilder.toString());
    }

    private static String b(String str) {
        return c.a(str);
    }

    private static String c(h hVar, ab abVar) {
        String str = "";
        if (hVar.d != null) {
            str = hVar.d;
        }
        if (!str.startsWith("/")) {
            str = "/" + str;
        }
        str = b(str);
        String a = a(hVar);
        Locale locale = Locale.getDefault();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/__utm.gif");
        stringBuilder.append("?utmwv=4.8.1ma");
        stringBuilder.append("&utmn=").append(hVar.a());
        if (a.length() > 0) {
            stringBuilder.append("&utme=").append(a);
        }
        stringBuilder.append("&utmcs=UTF-8");
        stringBuilder.append(String.format("&utmsr=%dx%d", new Object[]{Integer.valueOf(hVar.g), Integer.valueOf(hVar.h)}));
        stringBuilder.append(String.format("&utmul=%s-%s", new Object[]{locale.getLanguage(), locale.getCountry()}));
        stringBuilder.append("&utmp=").append(str);
        stringBuilder.append("&utmac=").append(hVar.b);
        stringBuilder.append("&utmcc=").append(b(hVar, abVar));
        if (hVar.b() != 0) {
            stringBuilder.append("&utmhid=").append(hVar.b());
        }
        return stringBuilder.toString();
    }

    private static String d(h hVar, ab abVar) {
        Locale locale = Locale.getDefault();
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(String.format("5(%s*%s", new Object[]{b(hVar.c), b(hVar.d)}));
        if (hVar.e != null) {
            stringBuilder2.append("*").append(b(hVar.e));
        }
        stringBuilder2.append(")");
        if (hVar.f > -1) {
            stringBuilder2.append(String.format("(%d)", new Object[]{Integer.valueOf(hVar.f)}));
        }
        stringBuilder2.append(a(hVar));
        stringBuilder.append("/__utm.gif");
        stringBuilder.append("?utmwv=4.8.1ma");
        stringBuilder.append("&utmn=").append(hVar.a());
        stringBuilder.append("&utmt=event");
        stringBuilder.append("&utme=").append(stringBuilder2.toString());
        stringBuilder.append("&utmcs=UTF-8");
        stringBuilder.append(String.format("&utmsr=%dx%d", new Object[]{Integer.valueOf(hVar.g), Integer.valueOf(hVar.h)}));
        stringBuilder.append(String.format("&utmul=%s-%s", new Object[]{locale.getLanguage(), locale.getCountry()}));
        stringBuilder.append("&utmac=").append(hVar.b);
        stringBuilder.append("&utmcc=").append(b(hVar, abVar));
        if (hVar.b() != 0) {
            stringBuilder.append("&utmhid=").append(hVar.b());
        }
        return stringBuilder.toString();
    }

    private static String e(h hVar, ab abVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/__utm.gif");
        stringBuilder.append("?utmwv=4.8.1ma");
        stringBuilder.append("&utmn=").append(hVar.a());
        stringBuilder.append("&utmt=tran");
        ac k = hVar.k();
        if (k != null) {
            a(stringBuilder, "&utmtid", k.a());
            a(stringBuilder, "&utmtst", k.b());
            a(stringBuilder, "&utmtto", k.c());
            a(stringBuilder, "&utmttx", k.d());
            a(stringBuilder, "&utmtsp", k.e());
            a(stringBuilder, "&utmtci", "");
            a(stringBuilder, "&utmtrg", "");
            a(stringBuilder, "&utmtco", "");
        }
        stringBuilder.append("&utmac=").append(hVar.b);
        stringBuilder.append("&utmcc=").append(b(hVar, abVar));
        return stringBuilder.toString();
    }

    private static String f(h hVar, ab abVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/__utm.gif");
        stringBuilder.append("?utmwv=4.8.1ma");
        stringBuilder.append("&utmn=").append(hVar.a());
        stringBuilder.append("&utmt=item");
        p l = hVar.l();
        if (l != null) {
            a(stringBuilder, "&utmtid", l.a());
            a(stringBuilder, "&utmipc", l.b());
            a(stringBuilder, "&utmipn", l.c());
            a(stringBuilder, "&utmiva", l.d());
            a(stringBuilder, "&utmipr", l.e());
            stringBuilder.append("&utmiqt=");
            if (l.f() != 0) {
                stringBuilder.append(l.f());
            }
        }
        stringBuilder.append("&utmac=").append(hVar.b);
        stringBuilder.append("&utmcc=").append(b(hVar, abVar));
        return stringBuilder.toString();
    }
}
