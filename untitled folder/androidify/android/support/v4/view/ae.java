package android.support.v4.view;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

public abstract class ae {
    private DataSetObservable f296a;

    public ae() {
        this.f296a = new DataSetObservable();
    }

    public float m503a(int i) {
        return 1.0f;
    }

    public abstract int m504a();

    public int m505a(Object obj) {
        return -1;
    }

    public Object m506a(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    public Object m507a(ViewGroup viewGroup, int i) {
        return m506a((View) viewGroup, i);
    }

    public void m508a(DataSetObserver dataSetObserver) {
        this.f296a.registerObserver(dataSetObserver);
    }

    public void m509a(Parcelable parcelable, ClassLoader classLoader) {
    }

    public void m510a(View view) {
    }

    public void m511a(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void m512a(ViewGroup viewGroup) {
        m510a((View) viewGroup);
    }

    public void m513a(ViewGroup viewGroup, int i, Object obj) {
        m511a((View) viewGroup, i, obj);
    }

    public abstract boolean m514a(View view, Object obj);

    public Parcelable m515b() {
        return null;
    }

    public void m516b(DataSetObserver dataSetObserver) {
        this.f296a.unregisterObserver(dataSetObserver);
    }

    public void m517b(View view) {
    }

    public void m518b(View view, int i, Object obj) {
    }

    public void m519b(ViewGroup viewGroup) {
        m517b((View) viewGroup);
    }

    public void m520b(ViewGroup viewGroup, int i, Object obj) {
        m518b((View) viewGroup, i, obj);
    }
}
