package edu.princeton.cs.algs4;

import java.util.Scanner;

public class W3B2 {

    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Gặp ngoặc mở -> push vào stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // Gặp ngoặc đóng -> kiểm tra với đỉnh stack
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) return "NO";

                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return "NO";
                }
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int t = scanner.nextInt();
        while (t-- > 0) {
            String s = scanner.next();
            System.out.println(isBalanced(s));
        }

        scanner.close();
    }
}
