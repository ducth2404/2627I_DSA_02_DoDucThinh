import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class W3B5 {

    public static int equalStacks(Queue<Integer> q1, Queue<Integer> q2, Queue<Integer> q3,
                                  int h1, int h2, int h3) {
        // Lặp cho đến khi chiều cao 3 stack bằng nhau
        while (!(h1 == h2 && h2 == h3)) {
            // Stack nào cao nhất thì gắp đĩa ở đỉnh của stack đó ra
            if (h1 >= h2 && h1 >= h3) {
                h1 -= q1.poll();
            } else if (h2 >= h1 && h2 >= h3) {
                h2 -= q2.poll();
            } else {
                h3 -= q3.poll();
            }

            // Nếu 1 trong 3 stack rỗng hoàn toàn thì chiều cao chung chỉ có thể là 0
            if (h1 == 0 || h2 == 0 || h3 == 0) {
                return 0;
            }
        }

        return h1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        Queue<Integer> q3 = new LinkedList<>();

        int h1 = 0, h2 = 0, h3 = 0;

        for (int i = 0; i < n1; i++) {
            int val = scanner.nextInt();
            q1.add(val);
            h1 += val;
        }

        for (int i = 0; i < n2; i++) {
            int val = scanner.nextInt();
            q2.add(val);
            h2 += val;
        }

        for (int i = 0; i < n3; i++) {
            int val = scanner.nextInt();
            q3.add(val);
            h3 += val;
        }

        System.out.println(equalStacks(q1, q2, q3, h1, h2, h3));

        scanner.close();
    }
}
