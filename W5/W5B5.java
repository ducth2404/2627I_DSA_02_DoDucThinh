import java.util.*;

public class W5B5 {

    static int[] partition(int[] ar) {
        int pivot = ar[0];

        int[] result = new int[ar.length];
        int index = 0;

        // Dua cac phan tu nho hon pivot vao truoc
        for (int x : ar) {
            if (x < pivot) {
                result[index++] = x;
            }
        }

        // Dua pivot vao giua
        result[index++] = pivot;

        // Dua cac phan tu lon hon pivot vao sau
        for (int x : ar) {
            if (x > pivot) {
                result[index++] = x;
            }
        }

        return result;
    }

    static void printArray(int[] ar) {
        for (int i : ar) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] ar = new int[n];

        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }

        ar = partition(ar);
        printArray(ar);

        sc.close();
    }
}
