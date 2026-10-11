import java.util.Scanner;

public class W5B6 {

    static int partition(int[] ar, int low, int high) {
        int pivot = ar[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (ar[j] <= pivot) {
                int temp = ar[i];
                ar[i] = ar[j];
                ar[j] = temp;

                i++;
            }
        }

        int temp = ar[i];
        ar[i] = ar[high];
        ar[high] = temp;

        return i;
    }

    static void printArray(int[] ar) {
        for (int x : ar) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    static void quickSort(int[] ar, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(ar, low, high);

            // In mang sau moi lan partition
            printArray(ar);

            quickSort(ar, low, pivotIndex - 1);
            quickSort(ar, pivotIndex + 1, high);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] ar = new int[n];

        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }

        quickSort(ar, 0, n - 1);

        sc.close();
    }
}
