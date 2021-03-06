package com.google.android.apps.androidify.wallpaper;

import android.service.wallpaper.WallpaperService;

import com.google.android.apps.androidify.Constants;
import com.google.android.apps.androidify.AndroidConfig;
import java.util.Random;

public class LiveWallpaper extends WallpaperService {
    public static final String[] f1669a;
    static final Random f1670b;
    static final int[] f1671c;
    static boolean f1672d;

    static {
        f1669a = new String[]{"AAAAAQEABzAwMG5vbmUBAAswMDFyZWRwbGFpZAEAEDAwMWJsYWNrc25lYWtlcnMBAA4wMDhkYXJrZ2xhc3NlcwEADjAxN21lZGl1bWJlYXJkAQAAAS9VgJHwAQAERHVkZT94cLw/iIW7P4Kz+z/CfBg/gAAAP4AAAD9bzERAGCgv/wAAAP+4hkr/n787AQAEaGVhZAAJMDEyc3B5aGF0AAEACDAwMWplYW5z", "AAAAAQEABjAxNmJveQEAEDAzMXZpb2xldHN3ZWF0ZXIBABAwMDRncmVlbnNuZWFrZXJzAQAHMDAwbm9uZQEACjAwOHN0dWJibGUBAAABL45J2zUBAAVMYXJyeT9K3gs/fjpEP6xISz/E1ew/HAWIP35QAj8kaPw/uMZ6/5CQkP//3rj/n787AAEACDAwMmplYW5z", "AAAAAQEABzAxMnBhcnQBAAcwMjlzdWl0AQANMDI2YmxhY2tzaG9lcwEADDAyMWZyYW1lbGVzcwEABzAwMG5vbmUBAAABL45POq0BAARFcmljPz7SrT+XnZI/rEhLP8TV7D8cBYg/flACPyDCKz/rxAX/mXkv///euP+fvzsAAQAMMDA0c3VpdHBhbnRz", "AAAAAQEABzAzM2Fmcm8BAAcwMzBzdWl0AQAGMDA1Ym53AQAKMDE3cm91bmRlZAEABzAwMG5vbmUBAAABL45RszEBAAhCaWcgSGFpcj8zqBE/gIasP7o0Uj/UOGw/BNzSPz7x0T8ZmZo/gAAA/wAAAP9fPiv/n787AAEADDAwNHN1aXRwYW50cw==", "AAAAAQEADTA0NGxvbmdfY3VybHkBAAwwMTdjdXRlZHJlc3MBAAcwMDBub25lAQAHMDAwbm9uZQEABzAwMG5vbmUBAAABL45VIiEBAAdSZWRoZWFkP0zXvz98rU8/tVuSP849/z8SaXg/mTrxP0VAvD+AAAD/3UkA/+HEkv+fvzsBAARmYWNlAAswMDFmcmVja2xlcwEABGJvZHkAEDA0MWhlYXJ0bmVja2xhY2UAAQAHMDAwbm9uZQ==", "AAAAAQEABzAwMWNyZXcBAAwwMDJibHVlcGxhaWQBAAkwMDZnZG50b3ABAAwwMDFhcmNoaXRlY3QBABIwMTFjaGluc3RyYXBzdHVibGUBAAABL45YRp0BAAZTY3J1ZmY/gAAAP4AAAD+MNlA/m6BzPz1skz+KwqE/gAAAP4AAAP84KAD/4cSS/5+/OwABAAgwMDFqZWFucw==", "AAAAAQEACzAwOHJlY2VkaW5nAQALMDc1YmxhY2t0ZWUBAAkwMDZnZG50b3ABAAcwMDBub25lAQAHMDAwbm9uZQEAAAEvjlox/QEAC0JsYWNrIFNoaXJ0P1f8fT+Gvos/nW+VP+Trlj89bJM/isKhP1aWaj+AAAD/OCgA/+HEkv+fvzsAAQAIMDAxamVhbnM=", "AAAAAQEAFTAzNHNpZGVfbG9uZ19zdHJhaWdodAEADTAxNHNoaXJ0ZHJlc3MBABAwMDl3aGl0ZXNuZWFrZXJzAQAHMDAwbm9uZQEABzAwMG5vbmUBAAABL45fzdUBAAtGbG93ZXIgSGFpcj9LuE0/luWpP5yQsT+8qLM/PWyTP4rCoT9BqZs/7gGm/+DaAP/hxJL/n787AQAEaGVhZAAJMDA1Zmxvd2VyAAEABzAwMG5vbmU=", "AAAAAQEABzAwNnNpZGUBAAkwNDhrYXJhdGUBAAcwMDBub25lAQAHMDAwbm9uZQEADTAxNXNtYWxsYmVhcmQBAAABL45h2vUBAAZTZW5zZWk/S7hNP5blqT+Lebw/zwOIPz1skz+KwqE/QambP+4Bpv/w8PD/4cSS/5+/OwABAAcwMDBub25l", "AAAAAQEADDA0Mm1lc3N5bG9uZwEADzAyMnJlY2VwdGlvbmlzdAEABzAwMG5vbmUBAAcwMDBub25lAQAHMDAwbm9uZQEAAAEvjmN3FAEAB1JlZCBUaWU/VlfIP7rPDz+1mqg/5mZmPw2PlD+Py6w/TnyhP+kfnf8AAAD/Xz4r/5+/OwABAAcwMDBub25l", "AAAAAQEACTA0NWZyaW5nZQEACzA3MWdyZWVudGVlAQAJMDA4Y2FudmFzAQAHMDAwbm9uZQEABzAwMG5vbmUBAAABL45ltqIBAAVCYW5ncz8ryOo/hwoeP5SZ+D+Ww18/KCH9P5EyST8ryOo/0msq/wAAAP+4hkr/n787AAEADDAwNHN1aXRwYW50cw==", "AAAAAQEAETAyNm1lZGlldmFscGxhaXRzAQAJMDYzYmlraW5pAQAHMDAwbm9uZQEADTAwOXJlZGdsYXNzZXMBAAcwMDBub25lAQAAAS+OZ7M5AQAGQmlraW5pPyDZ/T9Mv4E/sadUP68FRT8EZEY/g+E9PyDZ/T+1USb/mXkv/9O0if+fvzsAAQAHMDAwbm9uZQ==", "AAAAAQEADjAzMmJpZ2N1cmx5ZnJvAQAHMDU3YXJteQEADTAzN2Jpa2VyYm9vdHMBAAcwMDBub25lAQASMDExY2hpbnN0cmFwc3R1YmxlAQAAAS+OajzXAQAFQ3VybHM/Y/jeP5VqmD9tnOA/o7EYP0Ak1z+M8mg/V2v+P71GTv8AAAD/Xz4r/5+/OwABAAcwMTNhcm15"};
        f1670b = new Random();
        f1671c = new int[]{5882062, 15107241, 16708747, 10341242, 14045507};
        f1672d = false;
    }

    public static void m1992a() {
        f1672d = true;
    }

    static AndroidConfig m1998f() {
        AndroidConfig androidConfigVar = new AndroidConfig();
        androidConfigVar.m1797e(1.0f);
        androidConfigVar.m1800f(1.0f);
        androidConfigVar.m1774a(1.0f);
        androidConfigVar.m1781b(1.0f);
        androidConfigVar.m1788c(1.0f);
        androidConfigVar.m1793d(1.0f);
        androidConfigVar.m1803g(1.0f);
        androidConfigVar.m1806h(1.0f);
        androidConfigVar.m1782b(Constants.ANDROID_COLOR.intValue());
        androidConfigVar.m1775a(Constants.f1190a.intValue());
        return androidConfigVar;
    }

    public Engine onCreateEngine() {
        return null;//new PaperEngine(null);
    }
}
