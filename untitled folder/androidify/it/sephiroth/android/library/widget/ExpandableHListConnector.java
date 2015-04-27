package it.sephiroth.android.library.widget;

import android.database.DataSetObserver;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.HeterogeneousExpandableList;
import java.util.ArrayList;
import java.util.Collections;

class ExpandableHListConnector extends BaseAdapter implements Filterable {
    private ExpandableListAdapter f1899a;
    private ArrayList f1900b;
    private int f1901c;
    private int f1902d;
    private final DataSetObserver f1903e;

    class GroupMetadata implements Parcelable, Comparable {
        public static final Creator CREATOR;
        int f1895a;
        int f1896b;
        int f1897c;
        long f1898d;

        static {
            CREATOR = new ac();
        }

        private GroupMetadata() {
        }

        static GroupMetadata m2231a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.f1895a = i;
            groupMetadata.f1896b = i2;
            groupMetadata.f1897c = i3;
            groupMetadata.f1898d = j;
            return groupMetadata;
        }

        public int m2232a(GroupMetadata groupMetadata) {
            if (groupMetadata != null) {
                return this.f1897c - groupMetadata.f1897c;
            }
            throw new IllegalArgumentException();
        }

        public /* synthetic */ int compareTo(Object obj) {
            return m2232a((GroupMetadata) obj);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f1895a);
            parcel.writeInt(this.f1896b);
            parcel.writeInt(this.f1897c);
            parcel.writeLong(this.f1898d);
        }
    }

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        this.f1902d = Integer.MAX_VALUE;
        this.f1903e = new ad(this);
        this.f1900b = new ArrayList();
        m2239a(expandableListAdapter);
    }

    private void m2234a(boolean z, boolean z2) {
        int i;
        int i2;
        GroupMetadata groupMetadata;
        int a;
        int i3 = 0;
        Object obj = this.f1900b;
        int size = obj.size();
        this.f1901c = 0;
        if (z2) {
            i = size - 1;
            i2 = 0;
            while (i >= 0) {
                int i4;
                groupMetadata = (GroupMetadata) obj.get(i);
                a = m2235a(groupMetadata.f1898d, groupMetadata.f1897c);
                if (a != groupMetadata.f1897c) {
                    if (a == -1) {
                        obj.remove(i);
                        size--;
                    }
                    groupMetadata.f1897c = a;
                    if (i2 == 0) {
                        i4 = 1;
                        i--;
                        i2 = i4;
                    }
                }
                i4 = i2;
                i--;
                i2 = i4;
            }
            if (i2 != 0) {
                Collections.sort(obj);
            }
        }
        i = 0;
        a = 0;
        while (i3 < size) {
            groupMetadata = (GroupMetadata) obj.get(i3);
            i2 = (groupMetadata.f1896b == -1 || z) ? this.f1899a.getChildrenCount(groupMetadata.f1897c) : groupMetadata.f1896b - groupMetadata.f1895a;
            this.f1901c += i2;
            a += groupMetadata.f1897c - i;
            i = groupMetadata.f1897c;
            groupMetadata.f1895a = a;
            i2 += a;
            groupMetadata.f1896b = i2;
            i3++;
            a = i2;
        }
    }

    int m2235a(long j, int i) {
        int groupCount = this.f1899a.getGroupCount();
        if (groupCount == 0) {
            return -1;
        }
        if (j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        Object obj = null;
        ExpandableListAdapter a = m2236a();
        if (a == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (a.getGroupId(i3) != j) {
                Object obj2 = min == groupCount + -1 ? 1 : null;
                Object obj3 = i2 == 0 ? 1 : null;
                if (obj2 != null && obj3 != null) {
                    break;
                } else if (obj3 != null || (r0 != null && obj2 == null)) {
                    min++;
                    obj = null;
                    i3 = min;
                } else if (obj2 != null || (r0 == null && obj3 == null)) {
                    i2--;
                    obj = 1;
                    i3 = i2;
                }
            } else {
                return i3;
            }
        }
        return -1;
    }

    ExpandableListAdapter m2236a() {
        return this.f1899a;
    }

    ae m2237a(int i) {
        int i2 = 0;
        ArrayList arrayList = this.f1900b;
        int size = arrayList.size();
        int i3 = size - 1;
        if (size == 0) {
            return ae.m2320a(i, 2, i, -1, null, 0);
        }
        size = i3;
        int i4 = 0;
        while (i4 <= size) {
            i2 = ((size - i4) / 2) + i4;
            GroupMetadata groupMetadata = (GroupMetadata) arrayList.get(i2);
            if (i > groupMetadata.f1896b) {
                i4 = i2 + 1;
            } else if (i < groupMetadata.f1895a) {
                size = i2 - 1;
            } else if (i == groupMetadata.f1895a) {
                return ae.m2320a(i, 2, groupMetadata.f1897c, -1, groupMetadata, i2);
            } else if (i <= groupMetadata.f1896b) {
                return ae.m2320a(i, 1, groupMetadata.f1897c, i - (groupMetadata.f1895a + 1), groupMetadata, i2);
            }
        }
        GroupMetadata groupMetadata2;
        if (i4 > i2) {
            groupMetadata2 = (GroupMetadata) arrayList.get(i4 - 1);
            size = (i - groupMetadata2.f1896b) + groupMetadata2.f1897c;
            i2 = i4;
        } else if (size < i2) {
            i2 = size + 1;
            groupMetadata2 = (GroupMetadata) arrayList.get(i2);
            size = groupMetadata2.f1897c - (groupMetadata2.f1895a - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return ae.m2320a(i, 2, size, -1, null, i2);
    }

    ae m2238a(af afVar) {
        int i = 0;
        ArrayList arrayList = this.f1900b;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return ae.m2320a(afVar.f1915a, afVar.f1918d, afVar.f1915a, afVar.f1916b, null, 0);
        }
        size = i2;
        int i3 = 0;
        while (i3 <= size) {
            i = ((size - i3) / 2) + i3;
            GroupMetadata groupMetadata = (GroupMetadata) arrayList.get(i);
            if (afVar.f1915a > groupMetadata.f1897c) {
                i3 = i + 1;
            } else if (afVar.f1915a < groupMetadata.f1897c) {
                size = i - 1;
            } else if (afVar.f1915a == groupMetadata.f1897c) {
                return afVar.f1918d == 2 ? ae.m2320a(groupMetadata.f1895a, afVar.f1918d, afVar.f1915a, afVar.f1916b, groupMetadata, i) : afVar.f1918d == 1 ? ae.m2320a((groupMetadata.f1895a + afVar.f1916b) + 1, afVar.f1918d, afVar.f1915a, afVar.f1916b, groupMetadata, i) : null;
            }
        }
        if (afVar.f1918d != 2) {
            return null;
        }
        GroupMetadata groupMetadata2;
        if (i3 > i) {
            groupMetadata2 = (GroupMetadata) arrayList.get(i3 - 1);
            return ae.m2320a((afVar.f1915a - groupMetadata2.f1897c) + groupMetadata2.f1896b, afVar.f1918d, afVar.f1915a, afVar.f1916b, null, i3);
        } else if (size >= i) {
            return null;
        } else {
            i = size + 1;
            groupMetadata2 = (GroupMetadata) arrayList.get(i);
            return ae.m2320a(groupMetadata2.f1895a - (groupMetadata2.f1897c - afVar.f1915a), afVar.f1918d, afVar.f1915a, afVar.f1916b, null, i);
        }
    }

    public void m2239a(ExpandableListAdapter expandableListAdapter) {
        if (this.f1899a != null) {
            this.f1899a.unregisterDataSetObserver(this.f1903e);
        }
        this.f1899a = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.f1903e);
    }

    void m2240a(ArrayList arrayList) {
        if (arrayList != null && this.f1899a != null) {
            int groupCount = this.f1899a.getGroupCount();
            int size = arrayList.size() - 1;
            while (size >= 0) {
                if (((GroupMetadata) arrayList.get(size)).f1897c < groupCount) {
                    size--;
                } else {
                    return;
                }
            }
            this.f1900b = arrayList;
            m2234a(true, false);
        }
    }

    boolean m2241a(ae aeVar) {
        if (aeVar.f1912b == null) {
            return false;
        }
        this.f1900b.remove(aeVar.f1912b);
        m2234a(false, false);
        notifyDataSetChanged();
        this.f1899a.onGroupCollapsed(aeVar.f1912b.f1897c);
        return true;
    }

    public boolean areAllItemsEnabled() {
        return this.f1899a.areAllItemsEnabled();
    }

    ArrayList m2242b() {
        return this.f1900b;
    }

    boolean m2243b(int i) {
        af a = af.m2326a(2, i, -1, -1);
        ae a2 = m2238a(a);
        a.m2330b();
        if (a2 == null) {
            return false;
        }
        boolean a3 = m2241a(a2);
        a2.m2323a();
        return a3;
    }

    boolean m2244b(ae aeVar) {
        if (aeVar.f1911a.f1915a < 0) {
            throw new RuntimeException("Need group");
        } else if (this.f1902d == 0) {
            return false;
        } else {
            if (aeVar.f1912b != null) {
                return false;
            }
            GroupMetadata groupMetadata;
            if (this.f1900b.size() >= this.f1902d) {
                groupMetadata = (GroupMetadata) this.f1900b.get(0);
                int indexOf = this.f1900b.indexOf(groupMetadata);
                m2243b(groupMetadata.f1897c);
                if (aeVar.f1913c > indexOf) {
                    aeVar.f1913c--;
                }
            }
            groupMetadata = GroupMetadata.m2231a(-1, -1, aeVar.f1911a.f1915a, this.f1899a.getGroupId(aeVar.f1911a.f1915a));
            this.f1900b.add(aeVar.f1913c, groupMetadata);
            m2234a(false, false);
            notifyDataSetChanged();
            this.f1899a.onGroupExpanded(groupMetadata.f1897c);
            return true;
        }
    }

    public int getCount() {
        return this.f1899a.getGroupCount() + this.f1901c;
    }

    public Filter getFilter() {
        ExpandableListAdapter a = m2236a();
        return a instanceof Filterable ? ((Filterable) a).getFilter() : null;
    }

    public Object getItem(int i) {
        Object group;
        ae a = m2237a(i);
        if (a.f1911a.f1918d == 2) {
            group = this.f1899a.getGroup(a.f1911a.f1915a);
        } else if (a.f1911a.f1918d == 1) {
            group = this.f1899a.getChild(a.f1911a.f1915a, a.f1911a.f1916b);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        a.m2323a();
        return group;
    }

    public long getItemId(int i) {
        ae a = m2237a(i);
        long groupId = this.f1899a.getGroupId(a.f1911a.f1915a);
        if (a.f1911a.f1918d == 2) {
            groupId = this.f1899a.getCombinedGroupId(groupId);
        } else if (a.f1911a.f1918d == 1) {
            groupId = this.f1899a.getCombinedChildId(groupId, this.f1899a.getChildId(a.f1911a.f1915a, a.f1911a.f1916b));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        a.m2323a();
        return groupId;
    }

    public int getItemViewType(int i) {
        int groupType;
        ae a = m2237a(i);
        af afVar = a.f1911a;
        if (this.f1899a instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.f1899a;
            groupType = afVar.f1918d == 2 ? heterogeneousExpandableList.getGroupType(afVar.f1915a) : heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(afVar.f1915a, afVar.f1916b);
        } else {
            groupType = afVar.f1918d == 2 ? 0 : 1;
        }
        a.m2323a();
        return groupType;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View groupView;
        boolean z = true;
        ae a = m2237a(i);
        if (a.f1911a.f1918d == 2) {
            groupView = this.f1899a.getGroupView(a.f1911a.f1915a, a.m2324b(), view, viewGroup);
        } else if (a.f1911a.f1918d == 1) {
            if (a.f1912b.f1896b != i) {
                z = false;
            }
            groupView = this.f1899a.getChildView(a.f1911a.f1915a, a.f1911a.f1916b, z, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        a.m2323a();
        return groupView;
    }

    public int getViewTypeCount() {
        if (!(this.f1899a instanceof HeterogeneousExpandableList)) {
            return 2;
        }
        HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.f1899a;
        return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
    }

    public boolean hasStableIds() {
        return this.f1899a.hasStableIds();
    }

    public boolean isEmpty() {
        ExpandableListAdapter a = m2236a();
        return a != null ? a.isEmpty() : true;
    }

    public boolean isEnabled(int i) {
        boolean z = true;
        ae a = m2237a(i);
        af afVar = a.f1911a;
        if (afVar.f1918d == 1) {
            z = this.f1899a.isChildSelectable(afVar.f1915a, afVar.f1916b);
        }
        a.m2323a();
        return z;
    }
}
