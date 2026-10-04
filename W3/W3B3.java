package edu.princeton.cs.algs4;

import java.util.Scanner;

public class W3B3 {

    // in: chuyên nhận phần tử mới đẩy vào (enqueue)
    // out: lưu dữ liệu đảo ngược để lấy ra đúng thứ tự FIFO (dequeue/peek)
    private final Stack<Integer> in = new Stack<>();
    private final Stack<Integer> out = new Stack<>();

    public void enqueue(int x) {
        in.push(x);
    }

    // Đảo ngược thứ tự bằng cách đổ từ 'in' sang 'out' khi 'out' rỗng
    private void shiftStacks() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }

    public int dequeue() {
        shiftStacks();
        return out.pop();
    }

    public int peek() {
        shiftStacks();
        return out.peek();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int q = scanner.nextInt();
        W3B3 queue = new W3B3();

        while (q-- > 0) {
            int type = scanner.nextInt();
            if (type == 1) {
                // Thao tác 1: Enqueue phần tử x vào cuối hàng đợi
                int x = scanner.nextInt();
                queue.enqueue(x);
            } else if (type == 2) {
                // Thao tác 2: Dequeue phần tử đầu hàng đợi
                queue.dequeue();
            } else if (type == 3) {
                // Thao tác 3: In phần tử đầu hàng đợi
                System.out.println(queue.peek());
            }
        }

        scanner.close();
    }
}
