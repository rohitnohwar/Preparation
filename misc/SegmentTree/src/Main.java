class SegmentTree {
    int[] arr;
    int[] seg;
    SegmentTree(int[] arr) {
        this.arr = arr;
        this.seg = new int[this.arr.length];
        build(0, 0, arr.length - 1);
    }
    void build (int index, int low, int high) {
        if (low == high) {
            seg[index] = arr[low];
        }

        int mid = (low + high) / 2;

        build(2 * index + 1, low, mid);
        build(2 * index + 2, mid + 1, high);

        seg[index] = Math.max(arr[2 * index + 1], seg[2 * index + 2]);
    }

    public int query(int index, int low, int high, int l, int r) {
        if (low >= l && high <= r) return seg[index];
        if (high < l || low > r) return Integer.MIN_VALUE;

        int mid = (low + high) / 2;
        int leftQuery = query(2 * index + 1, low, mid, l, r);
        int rightQuery = query(2 * index + 2, mid + 1, high, l, r);

        return Math.max(leftQuery, rightQuery);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}