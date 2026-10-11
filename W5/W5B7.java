import java.util.Scanner;

public class W5B7 {

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

    static int findMedian(int[] ar) {
        int target = ar.length / 2;
        int low = 0;
        int high = ar.length - 1;

        while (low <= high) {
            int pivotIndex = partition(ar, low, high);

            if (pivotIndex == target) {
                return ar[pivotIndex];
            } else if (pivotIndex < target) {
                low = pivotIndex + 1;
            } else {
                high = pivotIndex - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] ar = new int[n];

        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }

        System.out.println(findMedian(ar));

        sc.close();
    }
}
