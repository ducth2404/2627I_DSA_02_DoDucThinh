package edu.princeton.cs.algs4;

import java.util.Arrays;

public class B1W4 {

    //Insertion Sort
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

    //Thời gian chạy trung bình
    public static double benchmark(int[] original, int trials) {
        long totalDurationNano = 0;
        for (int t = 0; t < trials; t++) {
            int[] copy = original.clone();
            long start = System.nanoTime();
            insertionSort(copy);
            long end = System.nanoTime();
            totalDurationNano += (end - start);
        }
        return (totalDurationNano / (double) trials) / 1_000_000.0;
    }

    // Sinh mảng ngẫu nhiên
    public static int[] generateRandom(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            // Sinh số ngẫu nhiên trong khoảng [-1_000_000, 1_000_000] để tránh tràn số
            a[i] = StdRandom.uniformInt(-1000000, 1000001);
        }
        return a;
    }

    // Sinh mảng đã sắp xếp tăng dần
    public static int[] generateSorted(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
        return a;
    }

    // Sinh mảng sắp xếp giảm dần
    public static int[] generateReversed(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = n - i;
        }
        return a;
    }

    // Sinh mảng toàn các giá trị bằng nhau
    public static int[] generateIdentical(int n) {
        int[] a = new int[n];
        Arrays.fill(a, 42);
        return a;
    }

    public static void main(String[] args) {
        String folderPath = "C:\\UET\\CTDL&GT\\Projects\\Algorithms\\edu\\princeton\\cs\\algs4-data\\algs4-data\\";

        String[] files = {"1Kints.txt", "2Kints.txt", "4Kints.txt", "8Kints.txt", "16Kints.txt", "32Kints.txt"};

        StdOut.println("===============================================================");
        StdOut.println("1. KHẢO SÁT CÁC FILE TEST TRONG BỘ ALGS4-DATA (TB 3 LẦN CHẠY)");
        StdOut.println("===============================================================");
        StdOut.printf("%-15s %-15s %-20s%n", "Tên file", "Kích thước (N)", "Thời gian TB (ms)");
        StdOut.println("---------------------------------------------------------------");

        for (String file : files) {
            try {
                In in = new In(folderPath + file);
                int[] data = in.readAllInts();
                double avgTime = benchmark(data, 3);
                StdOut.printf("%-15s %-15d %-20.4f%n", file, data.length, avgTime);
            } catch (Exception e) {
                StdOut.printf("%-15s Không tìm thấy file hoặc sai đường dẫn%n", file);
            }
        }

        // Các kích thước dữ liệu sinh nhân tạo
        int[] sizes = {1000, 2000, 4000, 8000, 16000, 32000};

        StdOut.println("\n=========================================================================================");
        StdOut.println("2 -> 5. KHẢO SÁT CÁC TRƯỜNG HỢP DỮ LIỆU SINH TỰ ĐỘNG");
        StdOut.println("=========================================================================================");
        StdOut.printf("%-10s | %-16s | %-16s | %-16s | %-16s%n",
                "Size (N)", "Random (5 lần)", "Sorted (3 lần)", "Reversed (3 lần)", "Equal (3 lần)");
        StdOut.println("-----------------------------------------------------------------------------------------");

        for (int n : sizes) {
            // Dữ liệu ngẫu nhiên (sinh mới mỗi lần chạy)
            long sumNanoRandom = 0;
            for (int t = 0; t < 5; t++) {
                int[] arr = generateRandom(n);
                long start = System.nanoTime();
                insertionSort(arr);
                sumNanoRandom += (System.nanoTime() - start);
            }
            double timeRandom = (sumNanoRandom / 5.0) / 1_000_000.0;

            // Sắp xếp xuôi
            double timeSorted = benchmark(generateSorted(n), 3);

            //Sắp xếp ngược
            double timeReversed = benchmark(generateReversed(n), 3);

            // Toàn bộ bằng nhau
            double timeEqual = benchmark(generateIdentical(n), 3);

            StdOut.printf("%-10d | %-16.4f | %-16.4f | %-16.4f | %-16.4f%n",
                    n, timeRandom, timeSorted, timeReversed, timeEqual);
        }
    }
}
