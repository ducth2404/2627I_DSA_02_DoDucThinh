import java.util.Scanner;

public class W5B1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int left = 0;
        int right = n - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == v) {
                result = mid;
                break;
            } else if (arr[mid] < v) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
        sc.close();
    }
}
