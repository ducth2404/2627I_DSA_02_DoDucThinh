package edu.princeton.cs.algs4;

import java.util.Arrays;
import java.util.Random;

public class B2W4 {

    private static final Random rng = new Random();

    // Selection Sort
    public static void selectionSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = a[minIdx];
            a[minIdx] = a[i];
            a[i] = temp;
        }
    }

    // Insertion Sort
    public static void insertionSort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    // Benchmark Selection Sort
    public static double benchmarkSelection(int[] original, int trials) {
        long totalNano = 0;
        for (int t = 0; t < trials; t++) {
            int[] copy = original.clone();
            long start = System.nanoTime();
            selectionSort(copy);
            totalNano += (System.nanoTime() - start);
        }
        return (totalNano / (double) trials) / 1_000_000.0;
    }

    // Benchmark Insertion Sort
    public static double benchmarkInsertion(int[] original, int trials) {
        long totalNano = 0;
        for (int t = 0; t < trials; t++) {
            int[] copy = original.clone();
            long start = System.nanoTime();
            insertionSort(copy);
            totalNano += (System.nanoTime() - start);
        }
        return (totalNano / (double) trials) / 1_000_000.0;
    }

    // Hàm sinh dữ liệu
    public static int[] generateRandom(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = rng.nextInt(2000001) - 1000000;
        return a;
    }

    public static int[] generateSorted(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = i;
        return a;
    }

    public static int[] generateReversed(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = n - i;
        return a;
    }

    public static int[] generateIdentical(int n) {
        int[] a = new int[n];
        Arrays.fill(a, 42);
        return a;
    }

    public static void main(String[] args) {
        String folderPath = "C:\\UET\\CTDL&GT\\Projects\\Algorithms\\edu\\princeton\\cs\\algs4-data\\algs4-data\\";
        String[] files = {"1Kints.txt", "2Kints.txt", "4Kints.txt", "8Kints.txt", "16Kints.txt", "32Kints.txt"};

        StdOut.println("=========================================================================================");
        StdOut.println("1. KHẢO SÁT FILE TEST: SELECTION SORT VS INSERTION SORT (TB 3 LẦN)");
        StdOut.println("=========================================================================================");
        StdOut.printf("%-15s %-10s %-25s %-25s%n", "Tên file", "N", "Selection Sort (ms)", "Insertion Sort (ms)");
        StdOut.println("-----------------------------------------------------------------------------------------");

        for (String file : files) {
            try {
                In in = new In(folderPath + file);
                int[] data = in.readAllInts();
                double tSelection = benchmarkSelection(data, 3);
                double tInsertion = benchmarkInsertion(data, 3);
                StdOut.printf("%-15s %-10d %-25.4f %-25.4f%n", file, data.length, tSelection, tInsertion);
            } catch (Exception e) {
                StdOut.printf("%-15s Không tìm thấy file hoặc sai đường dẫn%n", file);
            }
        }

        int[] sizes = {1000, 2000, 4000, 8000, 16000, 32000};

        StdOut.println("\n=========================================================================================");
        StdOut.println("2 -> 5. KHẢO SÁT DỮ LIỆU SINH TỰ ĐỘNG (Thời gian: Selection / Insertion theo ms)");
        StdOut.println("=========================================================================================");
        StdOut.printf("%-8s | %-18s | %-18s | %-18s | %-18s%n",
                "Size (N)", "Random (5 lần)", "Sorted (3 lần)", "Reversed (3 lần)", "Equal (3 lần)");
        StdOut.println("-----------------------------------------------------------------------------------------");

        for (int n : sizes) {
            // Kiểm tra trên 5 mẫu ngẫu nhiên giống nhau
            long sumNanoSel = 0;
            long sumNanoIns = 0;
            for (int t = 0; t < 5; t++) {
                int[] arr = generateRandom(n);
                int[] copy1 = arr.clone();
                int[] copy2 = arr.clone();

                long s1 = System.nanoTime();
                selectionSort(copy1);
                sumNanoSel += (System.nanoTime() - s1);

                long s2 = System.nanoTime();
                insertionSort(copy2);
                sumNanoIns += (System.nanoTime() - s2);
            }
            double tRandSel = (sumNanoSel / 5.0) / 1_000_000.0;
            double tRandIns = (sumNanoIns / 5.0) / 1_000_000.0;

            // Sorted
            int[] sortedArr = generateSorted(n);
            double tSortSel = benchmarkSelection(sortedArr, 3);
            double tSortIns = benchmarkInsertion(sortedArr, 3);

            // Reversed
            int[] revArr = generateReversed(n);
            double tRevSel = benchmarkSelection(revArr, 3);
            double tRevIns = benchmarkInsertion(revArr, 3);

            // Equal
            int[] eqArr = generateIdentical(n);
            double tEqSel = benchmarkSelection(eqArr, 3);
            double tEqIns = benchmarkInsertion(eqArr, 3);

            StdOut.printf("%-8d | %8.2f / %-7.2f | %8.2f / %-7.2f | %8.2f / %-7.2f | %8.2f / %-7.2f%n",
                    n, tRandSel, tRandIns, tSortSel, tSortIns, tRevSel, tRevIns, tEqSel, tEqIns);
        }
    }
}
