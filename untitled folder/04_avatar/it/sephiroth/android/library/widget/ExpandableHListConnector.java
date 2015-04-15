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
    private ExpandableListAdapter a;
    private ArrayList b;
    private int c;
    private int d;
    private final DataSetObserver e;

    class GroupMetadata implements Parcelable, Comparable {
        public static final Creator CREATOR;
        int a;
        int b;
        int c;
        long d;

        static {
            CREATOR = new ac();
        }

        private GroupMetadata() {
        }

        static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.a = i;
            groupMetadata.b = i2;
            groupMetadata.c = i3;
            groupMetadata.d = j;
            return groupMetadata;
        }

        public int a(GroupMetadata groupMetadata) {
            if (groupMetadata != null) {
                return this.c - groupMetadata.c;
            }
            throw new IllegalArgumentException();
        }

        public /* synthetic */ int compareTo(Object obj) {
            return a((GroupMetadata) obj);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            parcel.writeLong(this.d);
        }
    }

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        this.d = Integer.MAX_VALUE;
        this.e = new ad(this);
        this.b = new ArrayList();
        a(expandableListAdapter);
    }

    private void a(boolean z, boolean z2) {
        int i;
        int i2;
        GroupMetadata groupMetadata;
        int a;
        int i3 = 0;
        Object obj = this.b;
        int size = obj.size();
        this.c = 0;
        if (z2) {
            i = size - 1;
            i2 = 0;
            while (i >= 0) {
                int i4;
                groupMetadata = (GroupMetadata) obj.get(i);
                a = a(groupMetadata.d, groupMetadata.c);
                if (a != groupMetadata.c) {
                    if (a == -1) {
                        obj.remove(i);
                        size--;
                    }
                    groupMetadata.c = a;
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
            i2 = (groupMetadata.b == -1 || z) ? this.a.getChildrenCount(groupMetadata.c) : groupMetadata.b - groupMetadata.a;
            this.c += i2;
            a += groupMetadata.c - i;
            i = groupMetadata.c;
            groupMetadata.a = a;
            i2 += a;
            groupMetadata.b = i2;
            i3++;
            a = i2;
        }
    }

    int a(long j, int i) {
        int groupCount = this.a.getGroupCount();
        if (groupCount == 0) {
            return -1;
        }
        if (j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        Object obj = null;
        ExpandableListAdapter a = a();
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

    ExpandableListAdapter a() {
        return this.a;
    }

    ae a(int i) {
        int i2 = 0;
        ArrayList arrayList = this.b;
        int size = arrayList.size();
        int i3 = size - 1;
        if (size == 0) {
            return ae.a(i, 2, i, -1, null, 0);
        }
        size = i3;
        int i4 = 0;
        while (i4 <= size) {
            i2 = ((size - i4) / 2) + i4;
            GroupMetadata groupMetadata = (GroupMetadata) arrayList.get(i2);
            if (i > groupMetadata.b) {
                i4 = i2 + 1;
            } else if (i < groupMetadata.a) {
                size = i2 - 1;
            } else if (i == groupMetadata.a) {
                return ae.a(i, 2, groupMetadata.c, -1, groupMetadata, i2);
            } else if (i <= groupMetadata.b) {
                return ae.a(i, 1, groupMetadata.c, i - (groupMetadata.a + 1), groupMetadata, i2);
            }
        }
        GroupMetadata groupMetadata2;
        if (i4 > i2) {
            groupMetadata2 = (GroupMetadata) arrayList.get(i4 - 1);
            size = (i - groupMetadata2.b) + groupMetadata2.c;
            i2 = i4;
        } else if (size < i2) {
            i2 = size + 1;
            groupMetadata2 = (GroupMetadata) arrayList.get(i2);
            size = groupMetadata2.c - (groupMetadata2.a - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return ae.a(i, 2, size, -1, null, i2);
    }

    ae a(af afVar) {
        int i = 0;
        ArrayList arrayList = this.b;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return ae.a(afVar.a, afVar.d, afVar.a, afVar.b, null, 0);
        }
        size = i2;
        int i3 = 0;
        while (i3 <= size) {
            i = ((size - i3) / 2) + i3;
            GroupMetadata groupMetadata = (GroupMetadata) arrayList.get(i);
            if (afVar.a > groupMetadata.c) {
                i3 = i + 1;
            } else if (afVar.a < groupMetadata.c) {
                size = i - 1;
            } else if (afVar.a == groupMetadata.c) {
                return afVar.d == 2 ? ae.a(groupMetadata.a, afVar.d, afVar.a, afVar.b, groupMetadata, i) : afVar.d == 1 ? ae.a((groupMetadata.a + afVar.b) + 1, afVar.d, afVar.a, afVar.b, groupMetadata, i) : null;
            }
        }
        if (afVar.d != 2) {
            return null;
        }
        GroupMetadata groupMetadata2;
        if (i3 > i) {
            groupMetadata2 = (GroupMetadata) arrayList.get(i3 - 1);
            return ae.a((afVar.a - groupMetadata2.c) + groupMetadata2.b, afVar.d, afVar.a, afVar.b, null, i3);
        } else if (size >= i) {
            return null;
        } else {
            i = size + 1;
            groupMetadata2 = (GroupMetadata) arrayList.get(i);
            return ae.a(groupMetadata2.a - (groupMetadata2.c - afVar.a), afVar.d, afVar.a, afVar.b, null, i);
        }
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.a != null) {
            this.a.unregisterDataSetObserver(this.e);
        }
        this.a = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.e);
    }

    void a(ArrayList arrayList) {
        if (arrayList != null && this.a != null) {
            int groupCount = this.a.getGroupCount();
            int size = arrayList.size() - 1;
            while (size >= 0) {
                if (((GroupMetadata) arrayList.get(size)).c < groupCount) {
                    size--;
                } else {
                    return;
                }
            }
            this.b = arrayList;
            a(true, false);
        }
    }

    boolean a(ae aeVar) {
        if (aeVar.b == null) {
            return false;
        }
        this.b.remove(aeVar.b);
        a(false, false);
        notifyDataSetChanged();
        this.a.onGroupCollapsed(aeVar.b.c);
        return true;
    }

    public boolean areAllItemsEnabled() {
        return this.a.areAllItemsEnabled();
    }

    ArrayList b() {
        return this.b;
    }

    boolean b(int i) {
        af a = af.a(2, i, -1, -1);
        ae a2 = a(a);
        a.b();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.a();
        return a3;
    }

    boolean b(ae aeVar) {
        if (aeVar.a.a < 0) {
            throw new RuntimeException("Need group");
        } else if (this.d == 0) {
            return false;
        } else {
            if (aeVar.b != null) {
                return false;
            }
            GroupMetadata groupMetadata;
            if (this.b.size() >= this.d) {
                groupMetadata = (GroupMetadata) this.b.get(0);
                int indexOf = this.b.indexOf(groupMetadata);
                b(groupMetadata.c);
                if (aeVar.c > indexOf) {
                    aeVar.c--;
                }
            }
            groupMetadata = GroupMetadata.a(-1, -1, aeVar.a.a, this.a.getGroupId(aeVar.a.a));
            this.b.add(aeVar.c, groupMetadata);
            a(false, false);
            notifyDataSetChanged();
            this.a.onGroupExpanded(groupMetadata.c);
            return true;
        }
    }

    public int getCount() {
        return this.a.getGroupCount() + this.c;
    }

    public Filter getFilter() {
        ExpandableListAdapter a = a();
        return a instanceof Filterable ? ((Filterable) a).getFilter() : null;
    }

    public Object getItem(int i) {
        Object group;
        ae a = a(i);
        if (a.a.d == 2) {
            group = this.a.getGroup(a.a.a);
        } else if (a.a.d == 1) {
            group = this.a.getChild(a.a.a, a.a.b);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        a.a();
        return group;
    }

    public long getItemId(int i) {
        ae a = a(i);
        long groupId = this.a.getGroupId(a.a.a);
        if (a.a.d == 2) {
            groupId = this.a.getCombinedGroupId(groupId);
        } else if (a.a.d == 1) {
            groupId = this.a.getCombinedChildId(groupId, this.a.getChildId(a.a.a, a.a.b));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        a.a();
        return groupId;
    }

    public int getItemViewType(int i) {
        int groupType;
        ae a = a(i);
        af afVar = a.a;
        if (this.a instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.a;
            groupType = afVar.d == 2 ? heterogeneousExpandableList.getGroupType(afVar.a) : heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(afVar.a, afVar.b);
        } else {
            groupType = afVar.d == 2 ? 0 : 1;
        }
        a.a();
        return groupType;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View groupView;
        boolean z = true;
        ae a = a(i);
        if (a.a.d == 2) {
            groupView = this.a.getGroupView(a.a.a, a.b(), view, viewGroup);
        } else if (a.a.d == 1) {
            if (a.b.b != i) {
                z = false;
            }
            groupView = this.a.getChildView(a.a.a, a.a.b, z, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        a.a();
        return groupView;
    }

    public int getViewTypeCount() {
        if (!(this.a instanceof HeterogeneousExpandableList)) {
            return 2;
        }
        HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.a;
        return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
    }

    public boolean hasStableIds() {
        return this.a.hasStableIds();
    }

    public boolean isEmpty() {
        ExpandableListAdapter a = a();
        return a != null ? a.isEmpty() : true;
    }

    public boolean isEnabled(int i) {
        boolean z = true;
        ae a = a(i);
        af afVar = a.a;
        if (afVar.d == 1) {
            z = this.a.isChildSelectable(afVar.a, afVar.b);
        }
        a.a();
        return z;
    }
}
