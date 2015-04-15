package com.google.android.apps.a;

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

class x implements o {
    private static final String n;
    private static final String o;
    private static final String p;
    private static final String q;
    private static final String r;
    private static final String s;
    private static final String t;
    private y a;
    private int b;
    private long c;
    private long d;
    private long e;
    private int f;
    private volatile int g;
    private boolean h;
    private boolean i;
    private boolean j;
    private int k;
    private Random l;
    private e m;

    static {
        n = "CREATE TABLE events (" + String.format(" '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,", new Object[]{"event_id"}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{"user_id"}) + String.format(" '%s' CHAR(256) NOT NULL,", new Object[]{"account_id"}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{"random_val"}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{"timestamp_first"}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{"timestamp_previous"}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{"timestamp_current"}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{"visits"}) + String.format(" '%s' CHAR(256) NOT NULL,", new Object[]{"category"}) + String.format(" '%s' CHAR(256) NOT NULL,", new Object[]{"action"}) + String.format(" '%s' CHAR(256), ", new Object[]{"label"}) + String.format(" '%s' INTEGER,", new Object[]{"value"}) + String.format(" '%s' INTEGER,", new Object[]{"screen_width"}) + String.format(" '%s' INTEGER);", new Object[]{"screen_height"});
        o = "CREATE TABLE IF NOT EXISTS session (" + String.format(" '%s' INTEGER PRIMARY KEY,", new Object[]{"timestamp_first"}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{"timestamp_previous"}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{"timestamp_current"}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{"visits"}) + String.format(" '%s' INTEGER NOT NULL);", new Object[]{"store_id"});
        p = "CREATE TABLE custom_variables (" + String.format(" '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,", new Object[]{"cv_id"}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{"event_id"}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{"cv_index"}) + String.format(" '%s' CHAR(64) NOT NULL,", new Object[]{"cv_name"}) + String.format(" '%s' CHAR(64) NOT NULL,", new Object[]{"cv_value"}) + String.format(" '%s' INTEGER NOT NULL);", new Object[]{"cv_scope"});
        q = "CREATE TABLE IF NOT EXISTS custom_var_cache (" + String.format(" '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,", new Object[]{"cv_id"}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{"event_id"}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{"cv_index"}) + String.format(" '%s' CHAR(64) NOT NULL,", new Object[]{"cv_name"}) + String.format(" '%s' CHAR(64) NOT NULL,", new Object[]{"cv_value"}) + String.format(" '%s' INTEGER NOT NULL);", new Object[]{"cv_scope"});
        r = "CREATE TABLE transaction_events (" + String.format(" '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,", new Object[]{"tran_id"}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{"event_id"}) + String.format(" '%s' TEXT NOT NULL,", new Object[]{"order_id"}) + String.format(" '%s' TEXT,", new Object[]{"tran_storename"}) + String.format(" '%s' TEXT NOT NULL,", new Object[]{"tran_totalcost"}) + String.format(" '%s' TEXT,", new Object[]{"tran_totaltax"}) + String.format(" '%s' TEXT);", new Object[]{"tran_shippingcost"});
        s = "CREATE TABLE item_events (" + String.format(" '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,", new Object[]{"item_id"}) + String.format(" '%s' INTEGER NOT NULL,", new Object[]{"event_id"}) + String.format(" '%s' TEXT NOT NULL,", new Object[]{"order_id"}) + String.format(" '%s' TEXT NOT NULL,", new Object[]{"item_sku"}) + String.format(" '%s' TEXT,", new Object[]{"item_name"}) + String.format(" '%s' TEXT,", new Object[]{"item_category"}) + String.format(" '%s' TEXT NOT NULL,", new Object[]{"item_price"}) + String.format(" '%s' TEXT NOT NULL);", new Object[]{"item_count"});
        t = "CREATE TABLE IF NOT EXISTS hits (" + String.format(" '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,", new Object[]{"hit_id"}) + String.format(" '%s' TEXT NOT NULL,", new Object[]{"hit_string"}) + String.format(" '%s' INTEGER NOT NULL);", new Object[]{"hit_time"});
    }

    x(Context context) {
        this(context, "google_analytics.db", 5);
    }

    x(Context context, String str, int i) {
        this.k = 100;
        this.l = new Random();
        this.a = new y(context, str, i, this);
        f();
        this.m = d();
    }

    private void a(h hVar, SQLiteDatabase sQLiteDatabase, boolean z) {
        if (!hVar.m()) {
            hVar.a(this.l.nextInt(Integer.MAX_VALUE));
            hVar.c((int) this.c);
            hVar.d((int) this.d);
            hVar.e((int) this.e);
            hVar.f(this.f);
        }
        hVar.a(this.j);
        if (hVar.g() == -1) {
            hVar.g(this.b);
        }
        a(hVar, sQLiteDatabase);
        ab g = g(sQLiteDatabase);
        String[] split = hVar.b.split(",");
        if (split.length == 1) {
            a(hVar, g, sQLiteDatabase, z);
            return;
        }
        for (String hVar2 : split) {
            a(new h(hVar, hVar2), g, sQLiteDatabase, z);
        }
    }

    private boolean a(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.delete("referrer", null, null);
            sQLiteDatabase.insert("referrer", null, contentValues);
            sQLiteDatabase.setTransactionSuccessful();
            return !sQLiteDatabase.inTransaction() || f(sQLiteDatabase);
        } catch (SQLiteException e) {
            Log.e("GoogleAnalyticsTracker", e.toString());
            return (!sQLiteDatabase.inTransaction() || f(sQLiteDatabase)) ? false : false;
        } catch (Throwable th) {
            if (sQLiteDatabase.inTransaction() && !f(sQLiteDatabase)) {
                return false;
            }
        }
    }

    private static boolean f(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.endTransaction();
            return true;
        } catch (SQLiteException e) {
            Log.e("GoogleAnalyticsTracker", "exception ending transaction:" + e.toString());
            return false;
        }
    }

    private ab g(SQLiteDatabase sQLiteDatabase) {
        ab d = d(sQLiteDatabase);
        if (d == null) {
            return null;
        }
        if (d.b() != 0) {
            return d;
        }
        int d2 = d.d();
        String a = d.a();
        ContentValues contentValues = new ContentValues();
        contentValues.put("referrer", a);
        contentValues.put("timestamp_referrer", Long.valueOf(this.e));
        contentValues.put("referrer_visit", Integer.valueOf(this.f));
        contentValues.put("referrer_index", Integer.valueOf(d2));
        return a(sQLiteDatabase, contentValues) ? new ab(a, this.e, this.f, d2) : null;
    }

    ac a(long j, SQLiteDatabase sQLiteDatabase) {
        SQLiteException e;
        Throwable th;
        Cursor query;
        try {
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            query = sQLiteDatabase2.query("transaction_events", null, "event_id= ?", new String[]{Long.toString(j)}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    ac a = new ae(query.getString(query.getColumnIndex("order_id")), query.getDouble(query.getColumnIndex("tran_totalcost"))).a(query.getString(query.getColumnIndex("tran_storename"))).a(query.getDouble(query.getColumnIndex("tran_totaltax"))).b(query.getDouble(query.getColumnIndex("tran_shippingcost"))).a();
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

    e a(SQLiteDatabase sQLiteDatabase) {
        Cursor query;
        SQLiteException e;
        Throwable th;
        e eVar = new e();
        try {
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            query = sQLiteDatabase2.query("custom_var_cache", null, "cv_scope= ?", new String[]{Integer.toString(1)}, null, null, null);
            while (query.moveToNext()) {
                try {
                    eVar.a(new d(query.getInt(query.getColumnIndex("cv_index")), query.getString(query.getColumnIndex("cv_name")), query.getString(query.getColumnIndex("cv_value")), query.getInt(query.getColumnIndex("cv_scope"))));
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
                return eVar;
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
        return eVar;
    }

    public void a(int i) {
        this.k = i;
    }

    public synchronized void a(long j) {
        try {
            this.g -= this.a.getWritableDatabase().delete("hits", "hit_id = ?", new String[]{Long.toString(j)});
        } catch (SQLiteException e) {
            Log.e("GoogleAnalyticsTracker", e.toString());
        }
    }

    public void a(h hVar) {
        if (this.g >= 1000) {
            Log.w("GoogleAnalyticsTracker", "Store full. Not storing last event.");
            return;
        }
        if (this.k != 100) {
            if ((hVar.g() == -1 ? this.b : hVar.g()) % 10000 >= this.k * 100) {
                if (i.a().d()) {
                    Log.v("GoogleAnalyticsTracker", "User has been sampled out. Aborting hit.");
                    return;
                }
                return;
            }
        }
        synchronized (this) {
            try {
                SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
                try {
                    writableDatabase.beginTransaction();
                    if (!this.h) {
                        c(writableDatabase);
                    }
                    a(hVar, writableDatabase, true);
                    writableDatabase.setTransactionSuccessful();
                    if (writableDatabase.inTransaction()) {
                        f(writableDatabase);
                    }
                } catch (SQLiteException e) {
                    Log.e("GoogleAnalyticsTracker", "putEventOuter:" + e.toString());
                    if (writableDatabase.inTransaction()) {
                        f(writableDatabase);
                    }
                } catch (Throwable th) {
                    if (writableDatabase.inTransaction()) {
                        f(writableDatabase);
                    }
                }
            } catch (SQLiteException e2) {
                Log.e("GoogleAnalyticsTracker", "Can't get db: " + e2.toString());
            }
        }
    }

    void a(h hVar, SQLiteDatabase sQLiteDatabase) {
        if (!"__##GOOGLEITEM##__".equals(hVar.c) && !"__##GOOGLETRANSACTION##__".equals(hVar.c)) {
            try {
                d b;
                e eVar;
                e j = hVar.j();
                if (this.i) {
                    if (j == null) {
                        j = new e();
                        hVar.a(j);
                    }
                    for (int i = 1; i <= 5; i++) {
                        b = this.m.b(i);
                        d b2 = j.b(i);
                        if (b != null && b2 == null) {
                            j.a(b);
                        }
                    }
                    this.i = false;
                    eVar = j;
                } else {
                    eVar = j;
                }
                if (eVar != null) {
                    for (int i2 = 1; i2 <= 5; i2++) {
                        if (!eVar.a(i2)) {
                            b = eVar.b(i2);
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("event_id", Integer.valueOf(0));
                            contentValues.put("cv_index", Integer.valueOf(b.d()));
                            contentValues.put("cv_name", b.b());
                            contentValues.put("cv_scope", Integer.valueOf(b.a()));
                            contentValues.put("cv_value", b.c());
                            sQLiteDatabase.update("custom_var_cache", contentValues, "cv_index = ?", new String[]{Integer.toString(b.d())});
                            if (b.a() == 1) {
                                this.m.a(b);
                            } else {
                                this.m.c(b.d());
                            }
                        }
                    }
                }
            } catch (SQLiteException e) {
                Log.e("GoogleAnalyticsTracker", e.toString());
            }
        }
    }

    void a(h hVar, ab abVar, SQLiteDatabase sQLiteDatabase, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("hit_string", n.a(hVar, abVar));
        contentValues.put("hit_time", Long.valueOf(z ? System.currentTimeMillis() : 0));
        sQLiteDatabase.insert("hits", null, contentValues);
        this.g++;
    }

    public void a(boolean z) {
        this.j = z;
    }

    public h[] a(int i, SQLiteDatabase sQLiteDatabase, int i2) {
        SQLiteException e;
        Cursor cursor;
        Throwable th;
        List arrayList = new ArrayList();
        Cursor query;
        try {
            query = sQLiteDatabase.query("events", null, null, null, null, null, "event_id", Integer.toString(i));
            while (query.moveToNext()) {
                try {
                    h hVar = new h(query.getLong(0), query.getString(2), query.getInt(3), query.getInt(4), query.getInt(5), query.getInt(6), query.getInt(7), query.getString(8), query.getString(9), query.getString(10), query.getInt(11), query.getInt(12), query.getInt(13));
                    hVar.g(query.getInt(1));
                    long j = query.getLong(query.getColumnIndex("event_id"));
                    if ("__##GOOGLETRANSACTION##__".equals(hVar.c)) {
                        ac a = a(j, sQLiteDatabase);
                        if (a == null) {
                            Log.w("GoogleAnalyticsTracker", "missing expected transaction for event " + j);
                        }
                        hVar.a(a);
                    } else if ("__##GOOGLEITEM##__".equals(hVar.c)) {
                        p b = b(j, sQLiteDatabase);
                        if (b == null) {
                            Log.w("GoogleAnalyticsTracker", "missing expected item for event " + j);
                        }
                        hVar.a(b);
                    } else {
                        hVar.a(i2 > 1 ? c(j, sQLiteDatabase) : new e());
                    }
                    arrayList.add(hVar);
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
            return (h[]) arrayList.toArray(new h[arrayList.size()]);
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            try {
                Log.e("GoogleAnalyticsTracker", e.toString());
                h[] hVarArr = new h[0];
                if (cursor == null) {
                    return hVarArr;
                }
                cursor.close();
                return hVarArr;
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

    public m[] a() {
        return b(1000);
    }

    public int b() {
        return this.g;
    }

    p b(long j, SQLiteDatabase sQLiteDatabase) {
        SQLiteException e;
        Cursor cursor;
        Throwable th;
        Cursor query;
        try {
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            query = sQLiteDatabase2.query("item_events", null, "event_id= ?", new String[]{Long.toString(j)}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    p a = new r(query.getString(query.getColumnIndex("order_id")), query.getString(query.getColumnIndex("item_sku")), query.getDouble(query.getColumnIndex("item_price")), query.getLong(query.getColumnIndex("item_count"))).a(query.getString(query.getColumnIndex("item_name"))).b(query.getString(query.getColumnIndex("item_category"))).a();
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

    public void b(SQLiteDatabase sQLiteDatabase) {
        Cursor query;
        SQLiteException e;
        Throwable th;
        try {
            query = sQLiteDatabase.query("session", null, null, null, null, null, null);
            try {
                if (query.moveToFirst()) {
                    this.c = query.getLong(0);
                    this.d = query.getLong(1);
                    this.e = query.getLong(2);
                    this.f = query.getInt(3);
                    this.b = query.getInt(4);
                    ab d = d(sQLiteDatabase);
                    boolean z = this.c != 0 && (d == null || d.b() != 0);
                    this.h = z;
                } else {
                    this.h = false;
                    this.i = true;
                    this.b = new SecureRandom().nextInt() & Integer.MAX_VALUE;
                    query.close();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("timestamp_first", Long.valueOf(0));
                    contentValues.put("timestamp_previous", Long.valueOf(0));
                    contentValues.put("timestamp_current", Long.valueOf(0));
                    contentValues.put("visits", Integer.valueOf(0));
                    contentValues.put("store_id", Integer.valueOf(this.b));
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

    public m[] b(int i) {
        Cursor query;
        SQLiteException e;
        Throwable th;
        List arrayList = new ArrayList();
        try {
            query = this.a.getReadableDatabase().query("hits", null, null, null, null, null, "hit_id", Integer.toString(i));
            while (query.moveToNext()) {
                try {
                    arrayList.add(new m(query.getString(1), query.getLong(0)));
                } catch (SQLiteException e2) {
                    e = e2;
                }
            }
            if (query != null) {
                query.close();
            }
            return (m[]) arrayList.toArray(new m[arrayList.size()]);
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            try {
                Log.e("GoogleAnalyticsTracker", e.toString());
                m[] mVarArr = new m[0];
                if (query == null) {
                    return mVarArr;
                }
                query.close();
                return mVarArr;
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

    e c(long j, SQLiteDatabase sQLiteDatabase) {
        SQLiteException e;
        Throwable th;
        e eVar = new e();
        Cursor query;
        try {
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            query = sQLiteDatabase2.query("custom_variables", null, "event_id= ?", new String[]{Long.toString(j)}, null, null, null);
            while (query.moveToNext()) {
                try {
                    eVar.a(new d(query.getInt(query.getColumnIndex("cv_index")), query.getString(query.getColumnIndex("cv_name")), query.getString(query.getColumnIndex("cv_value")), query.getInt(query.getColumnIndex("cv_scope"))));
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
                return eVar;
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
        return eVar;
    }

    public synchronized void c() {
        this.h = false;
        this.i = true;
        this.g = e();
    }

    void c(SQLiteDatabase sQLiteDatabase) {
        SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
        writableDatabase.delete("session", null, null);
        if (this.c == 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            this.c = currentTimeMillis;
            this.d = currentTimeMillis;
            this.e = currentTimeMillis;
            this.f = 1;
        } else {
            this.d = this.e;
            this.e = System.currentTimeMillis() / 1000;
            if (this.e == this.d) {
                this.e++;
            }
            this.f++;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("timestamp_first", Long.valueOf(this.c));
        contentValues.put("timestamp_previous", Long.valueOf(this.d));
        contentValues.put("timestamp_current", Long.valueOf(this.e));
        contentValues.put("visits", Integer.valueOf(this.f));
        contentValues.put("store_id", Integer.valueOf(this.b));
        writableDatabase.insert("session", null, contentValues);
        this.h = true;
    }

    ab d(SQLiteDatabase sQLiteDatabase) {
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

    e d() {
        try {
            return a(this.a.getReadableDatabase());
        } catch (SQLiteException e) {
            Log.e("GoogleAnalyticsTracker", e.toString());
            return new e();
        }
    }

    public int e() {
        Cursor cursor = null;
        int i = 0;
        try {
            cursor = this.a.getReadableDatabase().rawQuery("SELECT COUNT(*) from hits", null);
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

    public void f() {
        try {
            b(this.a.getWritableDatabase());
        } catch (SQLiteException e) {
            Log.e("GoogleAnalyticsTracker", e.toString());
        }
    }
}
