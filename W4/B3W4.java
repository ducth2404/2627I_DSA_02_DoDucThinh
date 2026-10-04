package edu.princeton.cs.algs4;

import java.util.Scanner;

public class B3W4 {

    // Hàm chèn phần tử cuối cùng vào mảng đã sắp xếp phía trước
    public static void insertIntoSorted(int[] arr) {
        int n = arr.length;
        int key = arr[n - 1]; // Phần tử cuối danh sách cần chèn
        int i = n - 2;

        // Dịch các phần tử lớn hơn key sang phải 1 vị trí
        while (i >= 0 && arr[i] > key) {
            arr[i + 1] = arr[i];
            printArray(arr); // In trạng thái mảng tại mỗi bước dịch
            i--;
        }

        // Đặt key vào đúng vị trí tìm được
        arr[i + 1] = key;
        printArray(arr); // In trạng thái mảng sau khi chèn xong
    }

    // Hàm in toàn bộ mảng ra màn hình, các phần tử cách nhau bởi dấu cách
    public static void printArray(int[] arr) {
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + (j == arr.length - 1 ? "" : " "));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số lượng phần tử N
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        // Nhập mảng N phần tử
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Thực hiện chèn và in các bước
        insertIntoSorted(arr);

        scanner.close();
    }
}
