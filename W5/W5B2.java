import java.util.Random;

public class W5B2 {

    public static void sort(Comparable[] a) {
        int n = a.length;
        Comparable[] aux = new Comparable[n];

        while (true) {
            int lo = 0;
            boolean merged = false;

            while (lo < n - 1) {
                int mid = lo;

                // Tim run thu nhat
                while (mid < n - 1
                        && lessOrEqual(a[mid], a[mid + 1])) {
                    mid++;
                }

                if (mid == n - 1) {
                    break;
                }

                // Tim run thu hai
                int hi = mid + 1;

                while (hi < n - 1
                        && lessOrEqual(a[hi], a[hi + 1])) {
                    hi++;
                }

                merge(a, aux, lo, mid, hi);

                merged = true;
                lo = hi + 1;
            }

            if (!merged) {
                break;
            }
        }
    }

    private static void merge(
            Comparable[] a, Comparable[] aux,
            int lo, int mid, int hi) {

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (lessOrEqual(aux[i], aux[j])) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }
    }

    private static boolean lessOrEqual(
            Comparable v, Comparable w) {
        return v.compareTo(w) <= 0;
    }

    // Tao du lieu ngau nhien
    private static Integer[] randomArray(int n) {
        Random random = new Random();
        Integer[] a = new Integer[n];

        for (int i = 0; i < n; i++) {
            a[i] = random.nextInt(n);
        }

        return a;
    }

    public static void main(String[] args) {
        int n = 100000;

        Integer[] a = randomArray(n);

        long start = System.nanoTime();
        sort(a);
        long end = System.nanoTime();

        System.out.printf(
                "Natural MergeSort: %.3f ms%n",
                (end - start) / 1_000_000.0);

        // Kiem tra ket qua
        boolean sorted = true;

        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {
                sorted = false;
                break;
            }
        }

        System.out.println("Mang da sap xep dung: " + sorted);
    }
}
