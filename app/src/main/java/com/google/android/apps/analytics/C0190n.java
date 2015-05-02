package com.google.android.apps.analytics;

import com.google.android.apps.androidify.HListViewConstants;
import java.util.Locale;

/* renamed from: com.google.android.apps.a.n */
class C0190n {
    public static String m1196a(C0184h c0184h) {
        StringBuilder stringBuilder = new StringBuilder();
        C0181e j = c0184h.m1172j();
        if (j == null) {
            return "";
        }
        if (!j.m1144b()) {
            return "";
        }
        C0180d[] a = j.m1142a();
        C0190n.m1201a(a, stringBuilder, 8);
        C0190n.m1201a(a, stringBuilder, 9);
        C0190n.m1201a(a, stringBuilder, 11);
        return stringBuilder.toString();
    }

    public static String m1197a(C0184h c0184h, ab abVar) {
        StringBuilder stringBuilder = new StringBuilder();
        if ("__##GOOGLEPAGEVIEW##__".equals(c0184h.f632c)) {
            stringBuilder.append(C0190n.m1204c(c0184h, abVar));
        } else if ("__##GOOGLEITEM##__".equals(c0184h.f632c)) {
            stringBuilder.append(C0190n.m1207f(c0184h, abVar));
        } else if ("__##GOOGLETRANSACTION##__".equals(c0184h.f632c)) {
            stringBuilder.append(C0190n.m1206e(c0184h, abVar));
        } else {
            stringBuilder.append(C0190n.m1205d(c0184h, abVar));
        }
        if (c0184h.m1170h()) {
            stringBuilder.append("&aip=1");
        }
        if (!c0184h.m1171i()) {
            stringBuilder.append("&utmht=" + System.currentTimeMillis());
        }
        return stringBuilder.toString();
    }

    private static String m1198a(String str) {
        return str.replace("'", "'0").replace(")", "'1").replace("*", "'2").replace("!", "'3");
    }

    static void m1199a(StringBuilder stringBuilder, String str, double d) {
        stringBuilder.append(str).append("=");
        double floor = Math.floor((d * 1000000.0d) + 0.5d) / 1000000.0d;
        if (floor != 0.0d) {
            stringBuilder.append(Double.toString(floor));
        }
    }

    private static void m1200a(StringBuilder stringBuilder, String str, String str2) {
        stringBuilder.append(str).append("=");
        if (str2 != null && str2.trim().length() > 0) {
            stringBuilder.append(C0179c.m1133a(str2));
        }
    }

    private static void m1201a(C0180d[] c0180dArr, StringBuilder stringBuilder, int i) {
        stringBuilder.append(i).append("(");
        Object obj = 1;
        for (int i2 = 0; i2 < c0180dArr.length; i2++) {
            if (c0180dArr[i2] != null) {
                C0180d c0180d = c0180dArr[i2];
                if (obj == null) {
                    stringBuilder.append("*");
                } else {
                    obj = null;
                }
                stringBuilder.append(c0180d.m1138d()).append("!");
                switch (i) {
                    case HListViewConstants.ExpandableHListView_hlv_childIndicatorPaddingTop /*8*/:
                        stringBuilder.append(C0190n.m1198a(C0190n.m1203b(c0180d.m1136b())));
                        break;
                    case 9:
                        stringBuilder.append(C0190n.m1198a(C0190n.m1203b(c0180d.m1137c())));
                        break;
                    case 11:
                        stringBuilder.append(c0180d.m1135a());
                        break;
                    default:
                        break;
                }
            }
        }
        stringBuilder.append(")");
    }

    public static String m1202b(C0184h c0184h, ab abVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("__utma=");
        stringBuilder.append("1").append(".");
        stringBuilder.append(c0184h.m1168g()).append(".");
        stringBuilder.append(c0184h.m1160c()).append(".");
        stringBuilder.append(c0184h.m1162d()).append(".");
        stringBuilder.append(c0184h.m1164e()).append(".");
        stringBuilder.append(c0184h.m1166f()).append(";");
        if (abVar != null) {
            stringBuilder.append("+__utmz=");
            stringBuilder.append("1").append(".");
            stringBuilder.append(abVar.m1113b()).append(".");
            stringBuilder.append(Integer.valueOf(abVar.m1114c()).toString()).append(".");
            stringBuilder.append(Integer.valueOf(abVar.m1115d()).toString()).append(".");
            stringBuilder.append(abVar.m1112a()).append(";");
        }
        return C0190n.m1203b(stringBuilder.toString());
    }

    private static String m1203b(String str) {
        return C0179c.m1133a(str);
    }

    private static String m1204c(C0184h c0184h, ab abVar) {
        String str = "";
        if (c0184h.f633d != null) {
            str = c0184h.f633d;
        }
        if (!str.startsWith("/")) {
            str = "/" + str;
        }
        str = C0190n.m1203b(str);
        String a = C0190n.m1196a(c0184h);
        Locale locale = Locale.getDefault();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/__utm.gif");
        stringBuilder.append("?utmwv=4.8.1ma");
        stringBuilder.append("&utmn=").append(c0184h.m1151a());
        if (a.length() > 0) {
            stringBuilder.append("&utme=").append(a);
        }
        stringBuilder.append("&utmcs=UTF-8");
        stringBuilder.append(String.format("&utmsr=%dx%d", new Object[]{Integer.valueOf(c0184h.f636g), Integer.valueOf(c0184h.f637h)}));
        stringBuilder.append(String.format("&utmul=%s-%s", new Object[]{locale.getLanguage(), locale.getCountry()}));
        stringBuilder.append("&utmp=").append(str);
        stringBuilder.append("&utmac=").append(c0184h.f631b);
        stringBuilder.append("&utmcc=").append(C0190n.m1202b(c0184h, abVar));
        if (c0184h.m1157b() != 0) {
            stringBuilder.append("&utmhid=").append(c0184h.m1157b());
        }
        return stringBuilder.toString();
    }

    private static String m1205d(C0184h c0184h, ab abVar) {
        Locale locale = Locale.getDefault();
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(String.format("5(%s*%s", new Object[]{C0190n.m1203b(c0184h.f632c), C0190n.m1203b(c0184h.f633d)}));
        if (c0184h.f634e != null) {
            stringBuilder2.append("*").append(C0190n.m1203b(c0184h.f634e));
        }
        stringBuilder2.append(")");
        if (c0184h.f635f > -1) {
            stringBuilder2.append(String.format("(%d)", new Object[]{Integer.valueOf(c0184h.f635f)}));
        }
        stringBuilder2.append(C0190n.m1196a(c0184h));
        stringBuilder.append("/__utm.gif");
        stringBuilder.append("?utmwv=4.8.1ma");
        stringBuilder.append("&utmn=").append(c0184h.m1151a());
        stringBuilder.append("&utmt=event");
        stringBuilder.append("&utme=").append(stringBuilder2.toString());
        stringBuilder.append("&utmcs=UTF-8");
        stringBuilder.append(String.format("&utmsr=%dx%d", new Object[]{Integer.valueOf(c0184h.f636g), Integer.valueOf(c0184h.f637h)}));
        stringBuilder.append(String.format("&utmul=%s-%s", new Object[]{locale.getLanguage(), locale.getCountry()}));
        stringBuilder.append("&utmac=").append(c0184h.f631b);
        stringBuilder.append("&utmcc=").append(C0190n.m1202b(c0184h, abVar));
        if (c0184h.m1157b() != 0) {
            stringBuilder.append("&utmhid=").append(c0184h.m1157b());
        }
        return stringBuilder.toString();
    }

    private static String m1206e(C0184h c0184h, ab abVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/__utm.gif");
        stringBuilder.append("?utmwv=4.8.1ma");
        stringBuilder.append("&utmn=").append(c0184h.m1151a());
        stringBuilder.append("&utmt=tran");
        ac k = c0184h.m1173k();
        if (k != null) {
            C0190n.m1200a(stringBuilder, "&utmtid", k.m1116a());
            C0190n.m1200a(stringBuilder, "&utmtst", k.m1117b());
            C0190n.m1199a(stringBuilder, "&utmtto", k.m1118c());
            C0190n.m1199a(stringBuilder, "&utmttx", k.m1119d());
            C0190n.m1199a(stringBuilder, "&utmtsp", k.m1120e());
            C0190n.m1200a(stringBuilder, "&utmtci", "");
            C0190n.m1200a(stringBuilder, "&utmtrg", "");
            C0190n.m1200a(stringBuilder, "&utmtco", "");
        }
        stringBuilder.append("&utmac=").append(c0184h.f631b);
        stringBuilder.append("&utmcc=").append(C0190n.m1202b(c0184h, abVar));
        return stringBuilder.toString();
    }

    private static String m1207f(C0184h c0184h, ab abVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/__utm.gif");
        stringBuilder.append("?utmwv=4.8.1ma");
        stringBuilder.append("&utmn=").append(c0184h.m1151a());
        stringBuilder.append("&utmt=item");
        C0192p l = c0184h.m1174l();
        if (l != null) {
            C0190n.m1200a(stringBuilder, "&utmtid", l.m1215a());
            C0190n.m1200a(stringBuilder, "&utmipc", l.m1216b());
            C0190n.m1200a(stringBuilder, "&utmipn", l.m1217c());
            C0190n.m1200a(stringBuilder, "&utmiva", l.m1218d());
            C0190n.m1199a(stringBuilder, "&utmipr", l.m1219e());
            stringBuilder.append("&utmiqt=");
            if (l.m1220f() != 0) {
                stringBuilder.append(l.m1220f());
            }
        }
        stringBuilder.append("&utmac=").append(c0184h.f631b);
        stringBuilder.append("&utmcc=").append(C0190n.m1202b(c0184h, abVar));
        return stringBuilder.toString();
    }
}
