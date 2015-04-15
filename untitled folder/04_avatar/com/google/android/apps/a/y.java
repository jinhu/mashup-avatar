package com.google.android.apps.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;

class y extends SQLiteOpenHelper {
    private final int a;
    private final x b;

    y(Context context, String str, int i, x xVar) {
        super(context, str, null, i);
        this.a = i;
        this.b = xVar;
    }

    private void a(SQLiteDatabase sQLiteDatabase, int i) {
        this.b.b(sQLiteDatabase);
        this.b.m = this.b.a(sQLiteDatabase);
        h[] a = this.b.a(1000, sQLiteDatabase, i);
        for (h a2 : a) {
            this.b.a(a2, sQLiteDatabase, false);
        }
        sQLiteDatabase.execSQL("DELETE from events;");
        sQLiteDatabase.execSQL("DELETE from item_events;");
        sQLiteDatabase.execSQL("DELETE from transaction_events;");
        sQLiteDatabase.execSQL("DELETE from custom_variables;");
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS transaction_events;");
        sQLiteDatabase.execSQL(x.r);
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS item_events;");
        sQLiteDatabase.execSQL(x.s);
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS hits;");
        sQLiteDatabase.execSQL(x.t);
    }

    private void d(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS referrer;");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS referrer (referrer TEXT PRIMARY KEY NOT NULL,timestamp_referrer INTEGER NOT NULL,referrer_visit INTEGER NOT NULL DEFAULT 1,referrer_index INTEGER NOT NULL DEFAULT 1);");
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        Cursor query;
        Cursor query2;
        SQLiteException e;
        Throwable th;
        Cursor cursor = null;
        try {
            query = sQLiteDatabase.query("install_referrer", new String[]{"referrer"}, null, null, null, null, null);
            try {
                if (query.moveToFirst()) {
                    String string = query.getString(0);
                    query2 = sQLiteDatabase.query("session", null, null, null, null, null, null);
                    try {
                        long j = query2.moveToFirst() ? query2.getLong(0) : 0;
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("referrer", string);
                        contentValues.put("timestamp_referrer", Long.valueOf(j));
                        contentValues.put("referrer_visit", Integer.valueOf(1));
                        contentValues.put("referrer_index", Integer.valueOf(1));
                        sQLiteDatabase.insert("referrer", null, contentValues);
                    } catch (SQLiteException e2) {
                        e = e2;
                        cursor = query;
                        try {
                            Log.e("GoogleAnalyticsTracker", e.toString());
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (query2 == null) {
                                query2.close();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            query = cursor;
                            if (query != null) {
                                query.close();
                            }
                            if (query2 != null) {
                                query2.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (query != null) {
                            query.close();
                        }
                        if (query2 != null) {
                            query2.close();
                        }
                        throw th;
                    }
                }
                query2 = null;
                if (query != null) {
                    query.close();
                }
                if (query2 != null) {
                    query2.close();
                }
            } catch (SQLiteException e3) {
                e = e3;
                query2 = null;
                cursor = query;
                Log.e("GoogleAnalyticsTracker", e.toString());
                if (cursor != null) {
                    cursor.close();
                }
                if (query2 == null) {
                    query2.close();
                }
            } catch (Throwable th4) {
                th = th4;
                query2 = null;
                if (query != null) {
                    query.close();
                }
                if (query2 != null) {
                    query2.close();
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            query2 = null;
            Log.e("GoogleAnalyticsTracker", e.toString());
            if (cursor != null) {
                cursor.close();
            }
            if (query2 == null) {
                query2.close();
            }
        } catch (Throwable th5) {
            th = th5;
            query2 = null;
            query = null;
            if (query != null) {
                query.close();
            }
            if (query2 != null) {
                query2.close();
            }
            throw th;
        }
    }

    private void f(SQLiteDatabase sQLiteDatabase) {
        SQLiteException e;
        Cursor cursor;
        Throwable th;
        Cursor query;
        try {
            query = sQLiteDatabase.query("referrer", null, null, null, null, null, null);
            try {
                String[] columnNames = query.getColumnNames();
                Object obj = null;
                Object obj2 = null;
                for (int i = 0; i < columnNames.length; i++) {
                    if (columnNames[i].equals("referrer_index")) {
                        obj2 = 1;
                    } else if (columnNames[i].equals("referrer_visit")) {
                        int i2 = 1;
                    }
                }
                if (obj2 == null || r0 == null) {
                    ab abVar;
                    if (query.moveToFirst()) {
                        int columnIndex = query.getColumnIndex("referrer_visit");
                        int columnIndex2 = query.getColumnIndex("referrer_index");
                        abVar = new ab(query.getString(query.getColumnIndex("referrer")), query.getLong(query.getColumnIndex("timestamp_referrer")), columnIndex == -1 ? 1 : query.getInt(columnIndex), columnIndex2 == -1 ? 1 : query.getInt(columnIndex2));
                    } else {
                        abVar = null;
                    }
                    sQLiteDatabase.beginTransaction();
                    d(sQLiteDatabase);
                    if (abVar != null) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("referrer", abVar.a());
                        contentValues.put("timestamp_referrer", Long.valueOf(abVar.b()));
                        contentValues.put("referrer_visit", Integer.valueOf(abVar.c()));
                        contentValues.put("referrer_index", Integer.valueOf(abVar.d()));
                        sQLiteDatabase.insert("referrer", null, contentValues);
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                }
                if (query != null) {
                    query.close();
                }
                if (sQLiteDatabase.inTransaction()) {
                    x.f(sQLiteDatabase);
                }
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    Log.e("GoogleAnalyticsTracker", e.toString());
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase.inTransaction()) {
                        x.f(sQLiteDatabase);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    query = cursor;
                    if (query != null) {
                        query.close();
                    }
                    if (sQLiteDatabase.inTransaction()) {
                        x.f(sQLiteDatabase);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (query != null) {
                    query.close();
                }
                if (sQLiteDatabase.inTransaction()) {
                    x.f(sQLiteDatabase);
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
            if (sQLiteDatabase.inTransaction()) {
                x.f(sQLiteDatabase);
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            if (sQLiteDatabase.inTransaction()) {
                x.f(sQLiteDatabase);
            }
            throw th;
        }
    }

    void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS custom_variables;");
        sQLiteDatabase.execSQL(x.p);
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS custom_var_cache;");
        sQLiteDatabase.execSQL(x.q);
        for (int i = 1; i <= 5; i++) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("event_id", Integer.valueOf(0));
            contentValues.put("cv_index", Integer.valueOf(i));
            contentValues.put("cv_name", "");
            contentValues.put("cv_scope", Integer.valueOf(3));
            contentValues.put("cv_value", "");
            sQLiteDatabase.insert("custom_var_cache", "event_id", contentValues);
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS events;");
        sQLiteDatabase.execSQL(x.n);
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS install_referrer;");
        sQLiteDatabase.execSQL("CREATE TABLE install_referrer (referrer TEXT PRIMARY KEY NOT NULL);");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS session;");
        sQLiteDatabase.execSQL(x.o);
        if (this.a > 1) {
            a(sQLiteDatabase);
        }
        if (this.a > 2) {
            b(sQLiteDatabase);
        }
        if (this.a > 3) {
            c(sQLiteDatabase);
            d(sQLiteDatabase);
        }
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Log.w("GoogleAnalyticsTracker", "Downgrading database version from " + i + " to " + i2 + " not recommended.");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS referrer (referrer TEXT PRIMARY KEY NOT NULL,timestamp_referrer INTEGER NOT NULL,referrer_visit INTEGER NOT NULL DEFAULT 1,referrer_index INTEGER NOT NULL DEFAULT 1);");
        sQLiteDatabase.execSQL(x.t);
        sQLiteDatabase.execSQL(x.q);
        sQLiteDatabase.execSQL(x.o);
        Set hashSet = new HashSet();
        Cursor query = sQLiteDatabase.query("custom_var_cache", null, null, null, null, null, null, null);
        while (query.moveToNext()) {
            try {
                hashSet.add(Integer.valueOf(query.getInt(query.getColumnIndex("cv_index"))));
            } catch (SQLiteException e) {
                Log.e("GoogleAnalyticsTracker", "Error on downgrade: " + e.toString());
            } finally {
                query.close();
            }
        }
        for (int i3 = 1; i3 <= 5; i3++) {
            try {
                if (!hashSet.contains(Integer.valueOf(i3))) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("event_id", Integer.valueOf(0));
                    contentValues.put("cv_index", Integer.valueOf(i3));
                    contentValues.put("cv_name", "");
                    contentValues.put("cv_scope", Integer.valueOf(3));
                    contentValues.put("cv_value", "");
                    sQLiteDatabase.insert("custom_var_cache", "event_id", contentValues);
                }
            } catch (SQLiteException e2) {
                Log.e("GoogleAnalyticsTracker", "Error inserting custom variable on downgrade: " + e2.toString());
            }
        }
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase.isReadOnly()) {
            Log.w("GoogleAnalyticsTracker", "Warning: Need to update database, but it's read only.");
        } else {
            f(sQLiteDatabase);
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i > i2) {
            onDowngrade(sQLiteDatabase, i, i2);
            return;
        }
        if (i < 2 && i2 > 1) {
            a(sQLiteDatabase);
        }
        if (i < 3 && i2 > 2) {
            b(sQLiteDatabase);
        }
        if (i < 4 && i2 > 3) {
            c(sQLiteDatabase);
            d(sQLiteDatabase);
            a(sQLiteDatabase, i);
            e(sQLiteDatabase);
        }
    }
}
