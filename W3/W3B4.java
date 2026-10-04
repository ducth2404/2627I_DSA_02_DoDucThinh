import java.util.Scanner;
import java.util.Stack;

public class W3B4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int q = scanner.nextInt();
        StringBuilder s = new StringBuilder();
        Stack<String> history = new Stack<>();

        for (int i = 0; i < q; i++) {
            int type = scanner.nextInt();

            if (type == 1) {
                // Thao tác 1: append chuỗi w
                String w = scanner.next();
                history.push(s.toString());
                s.append(w);
            } else if (type == 2) {
                // Thao tác 2: delete k ký tự cuối
                int k = scanner.nextInt();
                history.push(s.toString());
                s.delete(s.length() - k, s.length());
            } else if (type == 3) {
                // Thao tác 3: in ký tự thứ k (1-based index)
                int k = scanner.nextInt();
                System.out.println(s.charAt(k - 1));
            } else if (type == 4) {
                // Thao tác 4: undo thao tác gần nhất
                if (!history.isEmpty()) {
                    s = new StringBuilder(history.pop());
                }
            }
        }

        scanner.close();
    }
}
