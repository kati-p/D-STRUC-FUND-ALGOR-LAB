public class Heap {

    public Heap(){};

    public void buildHeap(int[] a, int n){
        for (int i = n/2; i >= 1; i--)
            reHeap(a,i,n);
    }

    public void reHeap(int[] a, int root, int n) {
        int maxch;
        while(root <= n/2) {
            if (root * 2 == n)
                maxch = root * 2;
            else {
                if (a[root*2] > a[root*2+1])
                    maxch = root*2;
                else
                    maxch = root*2+1;
            }
            if (a[maxch] > a[root]) {
                int tmp = a[root];
                a[root] = a[maxch];
                a[maxch] = tmp;
                root = maxch;
            }
        }
    }

    public void printHeap(int[] a, int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

    }
}
