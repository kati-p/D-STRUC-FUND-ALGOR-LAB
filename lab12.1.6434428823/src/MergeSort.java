public class MergeSort {

    public void mergeSort(int[] a, int f, int l) {
        int mid;
        if (f < l) {
            mid = (f + l) / 2;
            mergeSort(a,f,mid);
            mergeSort(a,mid + 1,l);
            merge(a, f, mid, mid + 1, l);
        }
    }

    public void merge(int[] a, int lf, int ll, int rf, int rl) {
        int[] tmp = new int[a.length];
        int i = lf;
        int saveF = lf;
        while (lf <= ll && rf <= rl) {
            if (a[lf] > a[rf]) {
                tmp[i] = a[lf];
                i++; lf++;
            } else {
                tmp[i] = a[rf];
                i++; rf++;
            }
        }
        while (lf <= ll) {
            tmp[i] = a[lf];
            i++; lf++;
        }
        while (rf <= rl) {
            tmp[i] = a[rf];
            i++; rf++;
        }
        for (int j = saveF; j <= rl; j++)
            a[j] = tmp[j];
    }
}
