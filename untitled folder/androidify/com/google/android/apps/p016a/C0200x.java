package com.google.android.apps.p016a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* renamed from: com.google.android.apps.a.x */
class C0200x implements C0191o {
    private static final String f706n;
    private static final String f707o;
    private static final String f708p;
    private static final String f709q;
    private static final String f710r;
    private static final String f711s;
    private static final String f712t;
    private C0201y f713a;
    private int f714b;
    private long f715c;
    private long f716d;
    private long f717e;
    private int f718f;
    private volatile int f719g;
    private boolean f720h;
    private boolean f721i;
    private boolean f722j;
    private int f723k;
    private Random f724l;
    private C0181e f725m;

    static {
        f706n = "CREATE TABLE events (" + String.format(" '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,", new Object[]{"event_id"}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{"user_id"}) + String.format(" '%s' CHAR(256) NOT NULL,", new Object[]{"account_id"}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{"random_val"}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{"timestamp_first"}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{"timestamp_previous"}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{"timestamp_current"}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{"visits"}) + String.format(" '%s' CHAR(256) NOT NULL,", new Object[]{"category"}) + String.format(" '%s' CHAR(256) NOT NULL,", new Object[]{"action"}) + String.format(" '%s' CHAR(256), ", new Object[]{"label"}) + String.format(" '%s' INTEGER,", new Object[]{"value"}) + String.format(" '%s' INTEGER,", new Object[]{"screen_width"}) + String.format(" '%s' INTEGER);", new Object[]{"screen_height"});
        f707o = "CREATE TABLE IF NOT EXISTS session (" + String.format(" '%s' INTEGER PRIMARY KEY,", new Object[]{"timestamp_first"}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{"timestamp_previous"}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{"timestamp_current"}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{"visits"}) + String.format(" '%s' INTEGER NOT NULL);", new Object[]{"store_id"});
        f708p = "CREATE TABLE custom_variables (" + String.format(" '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,", new Object[]{"cv_id"}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{"event_id"}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{"cv_index"}) + String.format(" '%s' CHAR(64) NOT NULL,", new Object[]{"cv_name"}) + String.format(" '%s' CHAR(64) NOT NULL,", new Object[]{"cv_value"}) + String.format(" '%s' INTEGER NOT NULL);", new Object[]{"cv_scope"});
        f709q = "CREATE TABLE IF NOT EXISTS custom_var_cache (" + String.format(" '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,", new Object[]{"cv_id"}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{"event_id"}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{"cv_index"}) + String.format(" '%s' CHAR(64) NOT NULL,", new Object[]{"cv_name"}) + String.format(" '%s' CHAR(64) NOT NULL,", new Object[]{"cv_value"}) + String.format(" '%s' INTEGER NOT NULL);", new Object[]{"cv_scope"});
        f710r = "CREATE TABLE transaction_events (" + String.format(" '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,", new Object[]{"tran_id"}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{"event_id"}) + String.format(" '%s' TEXT NOT NULL,", new Object[]{"order_id"}) + String.format(" '%s' TEXT,", new Object[]{"tran_storename"}) + String.format(" '%s' TEXT NOT NULL,", new Object[]{"tran_totalcost"}) + String.format(" '%s' TEXT,", new Object[]{"tran_totaltax"}) + String.format(" '%s' TEXT);", new Object[]{"tran_shippingcost"});
        f711s = "CREATE TABLE item_events (" + String.format(" '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,", new Object[]{"item_id"}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{"event_id"}) + String.format(" '%s' TEXT NOT NULL,", new Object[]{"order_id"}) + String.format(" '%s' TEXT NOT NULL,", new Object[]{"item_sku"}) + String.format(" '%s' TEXT,", new Object[]{"item_name"}) + String.format(" '%s' TEXT,", new Object[]{"item_category"}) + String.format(" '%s' TEXT NOT NULL,", new Object[]{"item_price"}) + String.format(" '%s' TEXT NOT NULL);", new Object[]{"item_count"});
        f712t = "CREATE TABLE IF NOT EXISTS hits (" + String.format(" '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,", new Object[]{"hit_id"}) + String.format(" '%s' TEXT NOT NULL,", new Object[]{"hit_string"}) + String.format(" '%s' INTEGER NOT NULL);", new Object[]{"hit_time"});
    }

    C0200x(Context context) {
        this(context, "google_analytics.db", 5);
    }

    C0200x(Context context, String str, int i) {
        this.f723k = 100;
        this.f724l = new Random();
        this.f713a = new C0201y(context, str, i, this);
        m1290f();
        this.f725m = m1288d();
    }

    private void m1257a(C0184h c0184h, SQLiteDatabase sQLiteDatabase, boolean z) {
        if (!c0184h.m1175m()) {
            c0184h.m1152a(this.f724l.nextInt(Integer.MAX_VALUE));
            c0184h.m1161c((int) this.f715c);
            c0184h.m1163d((int) this.f716d);
            c0184h.m1165e((int) this.f717e);
            c0184h.m1167f(this.f718f);
        }
        c0184h.m1156a(this.f722j);
        if (c0184h.m1168g() == -1) {
            c0184h.m1169g(this.f714b);
        }
        m1275a(c0184h, sQLiteDatabase);
        ab g = m1262g(sQLiteDatabase);
        String[] split = c0184h.f631b.split(",");
        if (split.length == 1) {
            m1276a(c0184h, g, sQLiteDatabase, z);
            return;
        }
        for (String c0184h2 : split) {
            m1276a(new C0184h(c0184h, c0184h2), g, sQLiteDatabase, z);
        }
    }

    private boolean m1259a(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.delete("referrer", null, null);
            sQLiteDatabase.insert("referrer", null, contentValues);
            sQLiteDatabase.setTransactionSuccessful();
            return !sQLiteDatabase.inTransaction() || C0200x.m1261f(sQLiteDatabase);
        } catch (SQLiteException e) {
            Log.e("GoogleAnalyticsTracker", e.toString());
            return (!sQLiteDatabase.inTransaction() || C0200x.m1261f(sQLiteDatabase)) ? false : false;
        } catch (Throwable th) {
            if (sQLiteDatabase.inTransaction() && !C0200x.m1261f(sQLiteDatabase)) {
                return false;
            }
        }
    }

    private static boolean m1261f(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.endTransaction();
            return true;
        } catch (SQLiteException e) {
            Log.e("GoogleAnalyticsTracker", "exception ending transaction:" + e.toString());
            return false;
        }
    }

    private ab m1262g(SQLiteDatabase sQLiteDatabase) {
        ab d = m1287d(sQLiteDatabase);
        if (d == null) {
            return null;
        }
        if (d.m1113b() != 0) {
            return d;
        }
        int d2 = d.m1115d();
        String a = d.m1112a();
        ContentValues contentValues = new ContentValues();
        contentValues.put("referrer", a);
        contentValues.put("timestamp_referrer", Long.valueOf(this.f717e));
        contentValues.put("referrer_visit", Integer.valueOf(this.f718f));
        contentValues.put("referrer_index", Integer.valueOf(d2));
        return m1259a(sQLiteDatabase, contentValues) ? new ab(a, this.f717e, this.f718f, d2) : null;
    }

    ac m1270a(long j, SQLiteDatabase sQLiteDatabase) {
        SQLiteException e;
        Throwable th;
        Cursor query;
        try {
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            query = sQLiteDatabase2.query("transaction_events", null, "event_id= ?", new String[]{Long.toString(j)}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    ac a = new ae(query.getString(query.getColumnIndex("order_id")), query.getDouble(query.getColumnIndex("tran_totalcost"))).m1128a(query.getString(query.getColumnIndex("tran_storename"))).m1127a(query.getDouble(query.getColumnIndex("tran_totaltax"))).m1129b(query.getDouble(query.getColumnIndex("tran_shippingcost"))).m1126a();
                    if (query == null) {
                        return a;
                    }
                    query.close();
                    return a;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    Log.e("GoogleAnalyticsTracker", e.toString());
                    if (query != null) {
                        query.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            Log.e("GoogleAnalyticsTracker", e.toString());
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    C0181e m1271a(SQLiteDatabase sQLiteDatabase) {
        Cursor query;
        SQLiteException e;
        Throwable th;
        C0181e c0181e = new C0181e();
        try {
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            query = sQLiteDatabase2.query("custom_var_cache", null, "cv_scope= ?", new String[]{Integer.toString(1)}, null, null, null);
            while (query.moveToNext()) {
                try {
                    c0181e.m1140a(new C0180d(query.getInt(query.getColumnIndex("cv_index")), query.getString(query.getColumnIndex("cv_name")), query.getString(query.getColumnIndex("cv_value")), query.getInt(query.getColumnIndex("cv_scope"))));
                } catch (SQLiteException e2) {
                    e = e2;
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            try {
                Log.e("GoogleAnalyticsTracker", e.toString());
                if (query != null) {
                    query.close();
                }
                return c0181e;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return c0181e;
    }

    public void m1272a(int i) {
        this.f723k = i;
    }

    public synchronized void m1273a(long j) {
        try {
            this.f719g -= this.f713a.getWritableDatabase().delete("hits", "hit_id = ?", new String[]{Long.toString(j)});
        } catch (SQLiteException e) {
            Log.e("GoogleAnalyticsTracker", e.toString());
        }
    }

    public void m1274a(C0184h c0184h) {
        if (this.f719g >= 1000) {
            Log.w("GoogleAnalyticsTracker", "Store full. Not storing last event.");
            return;
        }
        if (this.f723k != 100) {
            if ((c0184h.m1168g() == -1 ? this.f714b : c0184h.m1168g()) % 10000 >= this.f723k * 100) {
                if (C0185i.m1177a().m1193d()) {
                    Log.v("GoogleAnalyticsTracker", "User has been sampled out. Aborting hit.");
                    return;
                }
                return;
            }
        }
        synchronized (this) {
            try {
                SQLiteDatabase writableDatabase = this.f713a.getWritableDatabase();
                try {
                    writableDatabase.beginTransaction();
                    if (!this.f720h) {
                        m1286c(writableDatabase);
                    }
                    m1257a(c0184h, writableDatabase, true);
                    writableDatabase.setTransactionSuccessful();
                    if (writableDatabase.inTransaction()) {
                        C0200x.m1261f(writableDatabase);
                    }
                } catch (SQLiteException e) {
                    Log.e("GoogleAnalyticsTracker", "putEventOuter:" + e.toString());
                    if (writableDatabase.inTransaction()) {
                        C0200x.m1261f(writableDatabase);
                    }
                } catch (Throwable th) {
                    if (writableDatabase.inTransaction()) {
                        C0200x.m1261f(writableDatabase);
                    }
                }
            } catch (SQLiteException e2) {
                Log.e("GoogleAnalyticsTracker", "Can't get db: " + e2.toString());
            }
        }
    }

    void m1275a(C0184h c0184h, SQLiteDatabase sQLiteDatabase) {
        if (!"__##GOOGLEITEM##__".equals(c0184h.f632c) && !"__##GOOGLETRANSACTION##__".equals(c0184h.f632c)) {
            try {
                C0180d b;
                C0181e c0181e;
                C0181e j = c0184h.m1172j();
                if (this.f721i) {
                    if (j == null) {
                        j = new C0181e();
                        c0184h.m1154a(j);
                    }
                    for (int i = 1; i <= 5; i++) {
                        b = this.f725m.m1143b(i);
                        C0180d b2 = j.m1143b(i);
                        if (b != null && b2 == null) {
                            j.m1140a(b);
                        }
                    }
                    this.f721i = false;
                    c0181e = j;
                } else {
                    c0181e = j;
                }
                if (c0181e != null) {
                    for (int i2 = 1; i2 <= 5; i2++) {
                        if (!c0181e.m1141a(i2)) {
                            b = c0181e.m1143b(i2);
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("event_id", Integer.valueOf(0));
                            contentValues.put("cv_index", Integer.valueOf(b.m1138d()));
                            contentValues.put("cv_name", b.m1136b());
                            contentValues.put("cv_scope", Integer.valueOf(b.m1135a()));
                            contentValues.put("cv_value", b.m1137c());
                            sQLiteDatabase.update("custom_var_cache", contentValues, "cv_index = ?", new String[]{Integer.toString(b.m1138d())});
                            if (b.m1135a() == 1) {
                                this.f725m.m1140a(b);
                            } else {
                                this.f725m.m1145c(b.m1138d());
                            }
                        }
                    }
                }
            } catch (SQLiteException e) {
                Log.e("GoogleAnalyticsTracker", e.toString());
            }
        }
    }

    void m1276a(C0184h c0184h, ab abVar, SQLiteDatabase sQLiteDatabase, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("hit_string", C0190n.m1197a(c0184h, abVar));
        contentValues.put("hit_time", Long.valueOf(z ? System.currentTimeMillis() : 0));
        sQLiteDatabase.insert("hits", null, contentValues);
        this.f719g++;
    }

    public void m1277a(boolean z) {
        this.f722j = z;
    }

    public C0184h[] m1278a(int i, SQLiteDatabase sQLiteDatabase, int i2) {
        SQLiteException e;
        Cursor cursor;
        Throwable th;
        List arrayList = new ArrayList();
        Cursor query;
        try {
            query = sQLiteDatabase.query("events", null, null, null, null, null, "event_id", Integer.toString(i));
            while (query.moveToNext()) {
                try {
                    C0184h c0184h = new C0184h(query.getLong(0), query.getString(2), query.getInt(3), query.getInt(4), query.getInt(5), query.getInt(6), query.getInt(7), query.getString(8), query.getString(9), query.getString(10), query.getInt(11), query.getInt(12), query.getInt(13));
                    c0184h.m1169g(query.getInt(1));
                    long j = query.getLong(query.getColumnIndex("event_id"));
                    if ("__##GOOGLETRANSACTION##__".equals(c0184h.f632c)) {
                        ac a = m1270a(j, sQLiteDatabase);
                        if (a == null) {
                            Log.w("GoogleAnalyticsTracker", "missing expected transaction for event " + j);
                        }
                        c0184h.m1153a(a);
                    } else if ("__##GOOGLEITEM##__".equals(c0184h.f632c)) {
                        C0192p b = m1281b(j, sQLiteDatabase);
                        if (b == null) {
                            Log.w("GoogleAnalyticsTracker", "missing expected item for event " + j);
                        }
                        c0184h.m1155a(b);
                    } else {
                        c0184h.m1154a(i2 > 1 ? m1284c(j, sQLiteDatabase) : new C0181e());
                    }
                    arrayList.add(c0184h);
                } catch (SQLiteException e2) {
                    e = e2;
                    cursor = query;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (query != null) {
                query.close();
            }
            return (C0184h[]) arrayList.toArray(new C0184h[arrayList.size()]);
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            try {
                Log.e("GoogleAnalyticsTracker", e.toString());
                C0184h[] c0184hArr = new C0184h[0];
                if (cursor == null) {
                    return c0184hArr;
                }
                cursor.close();
                return c0184hArr;
            } catch (Throwable th3) {
                th = th3;
                query = cursor;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public C0189m[] m1279a() {
        return m1283b(1000);
    }

    public int m1280b() {
        return this.f719g;
    }

    C0192p m1281b(long j, SQLiteDatabase sQLiteDatabase) {
        Cursor query;
        SQLiteException e;
        Cursor cursor;
        Throwable th;
        try {
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            query = sQLiteDatabase2.query("item_events", null, "event_id= ?", new String[]{Long.toString(j)}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    C0192p a = new C0194r(query.getString(query.getColumnIndex("order_id")), query.getString(query.getColumnIndex("item_sku")), query.getDouble(query.getColumnIndex("item_price")), query.getLong(query.getColumnIndex("item_count"))).m1228a(query.getString(query.getColumnIndex("item_name"))).m1229b(query.getString(query.getColumnIndex("item_category"))).m1227a();
                    if (query == null) {
                        return a;
                    }
                    query.close();
                    return a;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    Log.e("GoogleAnalyticsTracker", e.toString());
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    query = cursor;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            Log.e("GoogleAnalyticsTracker", e.toString());
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public void m1282b(SQLiteDatabase sQLiteDatabase) {
        SQLiteException e;
        Throwable th;
        Cursor query;
        try {
            query = sQLiteDatabase.query("session", null, null, null, null, null, null);
            try {
                if (query.moveToFirst()) {
                    this.f715c = query.getLong(0);
                    this.f716d = query.getLong(1);
                    this.f717e = query.getLong(2);
                    this.f718f = query.getInt(3);
                    this.f714b = query.getInt(4);
                    ab d = m1287d(sQLiteDatabase);
                    boolean z = this.f715c != 0 && (d == null || d.m1113b() != 0);
                    this.f720h = z;
                } else {
                    this.f720h = false;
                    this.f721i = true;
                    this.f714b = new SecureRandom().nextInt() & Integer.MAX_VALUE;
                    query.close();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("timestamp_first", Long.valueOf(0));
                    contentValues.put("timestamp_previous", Long.valueOf(0));
                    contentValues.put("timestamp_current", Long.valueOf(0));
                    contentValues.put("visits", Integer.valueOf(0));
                    contentValues.put("store_id", Integer.valueOf(this.f714b));
                    sQLiteDatabase.insert("session", null, contentValues);
                    query = null;
                }
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    Log.e("GoogleAnalyticsTracker", e.toString());
                    if (query != null) {
                        query.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            Log.e("GoogleAnalyticsTracker", e.toString());
            if (query != null) {
                query.close();
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public C0189m[] m1283b(int i) {
        Cursor query;
        SQLiteException e;
        Throwable th;
        List arrayList = new ArrayList();
        try {
            query = this.f713a.getReadableDatabase().query("hits", null, null, null, null, null, "hit_id", Integer.toString(i));
            while (query.moveToNext()) {
                try {
                    arrayList.add(new C0189m(query.getString(1), query.getLong(0)));
                } catch (SQLiteException e2) {
                    e = e2;
                }
            }
            if (query != null) {
                query.close();
            }
            return (C0189m[]) arrayList.toArray(new C0189m[arrayList.size()]);
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            try {
                Log.e("GoogleAnalyticsTracker", e.toString());
                C0189m[] c0189mArr = new C0189m[0];
                if (query == null) {
                    return c0189mArr;
                }
                query.close();
                return c0189mArr;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    C0181e m1284c(long j, SQLiteDatabase sQLiteDatabase) {
        Cursor query;
        SQLiteException e;
        Throwable th;
        C0181e c0181e = new C0181e();
        try {
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            query = sQLiteDatabase2.query("custom_variables", null, "event_id= ?", new String[]{Long.toString(j)}, null, null, null);
            while (query.moveToNext()) {
                try {
                    c0181e.m1140a(new C0180d(query.getInt(query.getColumnIndex("cv_index")), query.getString(query.getColumnIndex("cv_name")), query.getString(query.getColumnIndex("cv_value")), query.getInt(query.getColumnIndex("cv_scope"))));
                } catch (SQLiteException e2) {
                    e = e2;
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            try {
                Log.e("GoogleAnalyticsTracker", e.toString());
                if (query != null) {
                    query.close();
                }
                return c0181e;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return c0181e;
    }

    public synchronized void m1285c() {
        this.f720h = false;
        this.f721i = true;
        this.f719g = m1289e();
    }

    void m1286c(SQLiteDatabase sQLiteDatabase) {
        SQLiteDatabase writableDatabase = this.f713a.getWritableDatabase();
        writableDatabase.delete("session", null, null);
        if (this.f715c == 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            this.f715c = currentTimeMillis;
            this.f716d = currentTimeMillis;
            this.f717e = currentTimeMillis;
            this.f718f = 1;
        } else {
            this.f716d = this.f717e;
            this.f717e = System.currentTimeMillis() / 1000;
            if (this.f717e == this.f716d) {
                this.f717e++;
            }
            this.f718f++;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("timestamp_first", Long.valueOf(this.f715c));
        contentValues.put("timestamp_previous", Long.valueOf(this.f716d));
        contentValues.put("timestamp_current", Long.valueOf(this.f717e));
        contentValues.put("visits", Integer.valueOf(this.f718f));
        contentValues.put("store_id", Integer.valueOf(this.f714b));
        writableDatabase.insert("session", null, contentValues);
        this.f720h = true;
    }

    ab m1287d(SQLiteDatabase sQLiteDatabase) {
        Cursor query;
        SQLiteException e;
        Cursor cursor;
        Throwable th;
        try {
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            query = sQLiteDatabase2.query("referrer", new String[]{"referrer", "timestamp_referrer", "referrer_visit", "referrer_index"}, null, null, null, null, null);
            try {
                ab abVar;
                if (query.moveToFirst()) {
                    abVar = new ab(query.getString(query.getColumnIndex("referrer")), query.getLong(query.getColumnIndex("timestamp_referrer")), query.getInt(query.getColumnIndex("referrer_visit")), query.getInt(query.getColumnIndex("referrer_index")));
                } else {
                    abVar = null;
                }
                if (query == null) {
                    return abVar;
                }
                query.close();
                return abVar;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    Log.e("GoogleAnalyticsTracker", e.toString());
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    query = cursor;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            Log.e("GoogleAnalyticsTracker", e.toString());
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    C0181e m1288d() {
        try {
            return m1271a(this.f713a.getReadableDatabase());
        } catch (SQLiteException e) {
            Log.e("GoogleAnalyticsTracker", e.toString());
            return new C0181e();
        }
    }

    public int m1289e() {
        Cursor cursor = null;
        int i = 0;
        try {
            cursor = this.f713a.getReadableDatabase().rawQuery("SELECT COUNT(*) from hits", null);
            if (cursor.moveToFirst()) {
                i = (int) cursor.getLong(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (SQLiteException e) {
            Log.e("GoogleAnalyticsTracker", e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return i;
    }

    public void m1290f() {
        try {
            m1282b(this.f713a.getWritableDatabase());
        } catch (SQLiteException e) {
            Log.e("GoogleAnalyticsTracker", e.toString());
        }
    }
}
