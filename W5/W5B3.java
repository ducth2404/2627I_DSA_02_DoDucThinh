import java.util.Random;

public class W5B3 {

    private static final Random random = new Random();

    // QuickSort co shuffle
    public static void sortWithShuffle(Comparable[] a) {
        shuffle(a);
        sort(a, 0, a.length - 1);
    }

    // QuickSort khong shuffle
    public static void sortWithoutShuffle(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int j = partition(a, lo, hi);

        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    // Chon phan tu dau tien lam pivot
    private static int partition(
            Comparable[] a, int lo, int hi) {

        Comparable pivot = a[lo];
        int i = lo + 1;
        int j = hi;

        while (true) {
            while (i <= hi && less(a[i], pivot)) {
                i++;
            }

            while (j > lo && less(pivot, a[j])) {
                j--;
            }

            if (i >= j) {
                break;
            }

            exch(a, i, j);
            i++;
            j--;
        }

        exch(a, lo, j);
        return j;
    }

    private static void shuffle(Comparable[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            exch(a, i, j);
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // Tao mang ngau nhien
    private static Integer[] randomArray(int n) {
        Integer[] a = new Integer[n];

        for (int i = 0; i < n; i++) {
            a[i] = random.nextInt(n);
        }

        return a;
    }

    // Kiem tra mang da sap xep dung chua
    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 10000;

        Integer[] data = randomArray(n);

        Integer[] a1 = data.clone();
        Integer[] a2 = data.clone();

        long start = System.nanoTime();
        sortWithShuffle(a1);
        long timeShuffle = System.nanoTime() - start;

        start = System.nanoTime();
        sortWithoutShuffle(a2);
        long timeNoShuffle = System.nanoTime() - start;

        System.out.println("So phan tu: " + n);

        System.out.printf(
                "QuickSort co shuffle: %.3f ms%n",
                timeShuffle / 1_000_000.0);

        System.out.printf(
                "QuickSort khong shuffle: %.3f ms%n",
                timeNoShuffle / 1_000_000.0);

        System.out.println(
                "Ket qua co shuffle dung: " + isSorted(a1));

        System.out.println(
                "Ket qua khong shuffle dung: " + isSorted(a2));
    }
}
