public class Main {
    public static void main(String[] args) {
        int[] a1 = {15, 9, 7, 16, 31, 2, 20, 25, 17, 12};
        QuickSort qs = new QuickSort();
        qs.quickSort(a1, 0, a1.length - 1);
        System.out.println("Quick sort a1 : ");
        for (int n : a1)
            System.out.print(n + " ");
        System.out.println("\n");
        int[] a2 = {5, 2, 12, 9, 1, 8, 7, 18};
        MergeSort ms = new MergeSort();
        ms.mergeSort(a2, 0, a2.length - 1);
        System.out.println("Merge sort a2 : ");
        for (int n : a2)
            System.out.print(n + " ");
        System.out.println();
    }
}