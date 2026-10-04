package edu.princeton.cs.algs4;

import java.util.Scanner;

public class B5W4 {

    public static void insertionSortPart2(int[] ar) {
        int n = ar.length;
        for (int i = 1; i < n; i++) {
            int key = ar[i];
            int j = i - 1;

            while (j >= 0 && ar[j] > key) {
                ar[j + 1] = ar[j];
                j--;
            }
            ar[j + 1] = key;

            // In trạng thái mảng sau mỗi lần chèn
            printArray(ar);
        }
    }

    public static void printArray(int[] ar) {
        for (int j = 0; j < ar.length; j++) {
            System.out.print(ar[j] + (j == ar.length - 1 ? "" : " "));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (!in.hasNextInt()) return;
        int s = in.nextInt();

        int[] ar = new int[s];
        for (int i = 0; i < s; i++) {
            ar[i] = in.nextInt();
        }

        insertionSortPart2(ar);
        in.close();
    }
}
