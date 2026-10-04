package edu.princeton.cs.algs4;

import java.util.Scanner;

public class B7W4 {

    public static int[] countingSort(int[] arr) {
        // Mảng đếm tần suất cho các giá trị từ 0 đến 99
        int[] freq = new int[100];
        for (int val : arr) {
            freq[val]++;
        }
        return freq;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (!in.hasNextInt()) return;
        int n = in.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int[] result = countingSort(arr);

        // In 100 giá trị tần suất cách nhau bởi dấu cách
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i == result.length - 1 ? "" : " "));
        }
        System.out.println();

        in.close();
    }
}
