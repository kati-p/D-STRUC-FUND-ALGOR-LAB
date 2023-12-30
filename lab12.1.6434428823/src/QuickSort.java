public class QuickSort {

    public void quickSort(int[] a, int f, int l) {
        int splitPoint;
        if (f < l) {
            splitPoint = split(a, f, l);
            quickSort(a, f, splitPoint - 1);
            quickSort(a, splitPoint + 1, l);
        }
    }

    public int split(int[] a, int f, int l) {
        int pivot = a[f];
        int saveF = f;
        f++;
        do {
            boolean lessThanPivot = true;
            while (f <= l && lessThanPivot) {
                if (a[f] > pivot)
                    f++;
                else
                    lessThanPivot = false;
            }
            boolean moreThanPivot = true;
            while ( f <= l && moreThanPivot) {
                if (a[l] < pivot)
                    l--;
                else
                    moreThanPivot = false;
            }
            if (f < l) {
                int tmp = a[f];
                a[f] = a[l];
                a[l] = tmp;
                f++; l--;
            }
        } while (f < l);
        int tmp = a[saveF];
        a[saveF] = a[l];
        a[l] = tmp;
        return l;
    }
}
