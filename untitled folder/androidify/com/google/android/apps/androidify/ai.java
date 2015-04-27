package com.google.android.apps.androidify;

import android.content.Context;
import com.google.android.C0176a;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ai {
    private HashMap f1162a;

    public ai() {
        this.f1162a = null;
    }

    public List m1689a(String str) {
        return (List) this.f1162a.get(str);
    }

    public void m1690a(Context context) {
        this.f1162a = new HashMap();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open("assets.tsv")));
        bufferedReader.readLine();
        bufferedReader.readLine();
        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
            String[] split = readLine.split("\\t");
            String str = split[0];
            String str2 = split[1];
            String str3 = "";
            if (split.length > 2) {
                str3 = split[2];
            }
            boolean z = true;
            if (split.length > 3) {
                readLine = split[3];
                boolean z2 = readLine.equalsIgnoreCase("yes") || readLine.equalsIgnoreCase("true");
                z = z2;
            }
            boolean z3 = false;
            boolean z4 = false;
            Integer num = null;
            Integer num2 = null;
            if (split.length > 4) {
                readLine = split[4];
                z2 = readLine.equalsIgnoreCase("yes") || readLine.equalsIgnoreCase("true");
                z3 = z2;
            }
            if (split.length > 5) {
                num = C0176a.m1105b(split[5]) ? null : Integer.valueOf(C0176a.m1107d(split[5]));
            }
            if (split.length > 6) {
                num2 = C0176a.m1105b(split[6]) ? null : Integer.valueOf(C0176a.m1107d(split[6]));
            }
            if (split.length > 7) {
                readLine = split[7];
                z2 = readLine.equalsIgnoreCase("yes") || readLine.equalsIgnoreCase("true");
                z4 = z2;
            }
            ag agVar = new ag(str, str2, str3, z, z3, num, num2, z4);
            ArrayList arrayList = (ArrayList) this.f1162a.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.f1162a.put(str, arrayList);
            }
            arrayList.add(agVar);
        }
        bufferedReader.close();
    }
}
