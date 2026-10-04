package edu.princeton.cs.algs4;

public class W3B1 {

    public static void main(String[] args) {
        String filePath = "C:\\UET\\CTDL&GT\\Projects\\Algorithms\\edu\\princeton\\cs\\algs4-data\\algs4-data\\tobe.txt";
        String[] tokens;

        try {
            In in = new In(filePath);
            tokens = in.readAllStrings();
        } catch (Exception e) {
            tokens = "to be or not to - be - - that - - - is".split("\\s+");
        }

        // Stack bằng LinkedList
        StdOut.print("LinkedStack: ");
        Stack<String> s1 = new Stack<>();
        for (String s : tokens) {
            if (!s.equals("-")) s1.push(s);
            else if (!s1.isEmpty()) StdOut.print(s1.pop() + " ");
        }
        StdOut.println("(" + s1.size() + " left)");

        //Stack bằng Resizing Array
        StdOut.print("ResizingArrayStack: ");
        ResizingArrayStack<String> s2 = new ResizingArrayStack<>();
        for (String s : tokens) {
            if (!s.equals("-")) s2.push(s);
            else if (!s2.isEmpty()) StdOut.print(s2.pop() + " ");
        }
        StdOut.println("(" + s2.size() + " left)");

        // Queue bằng LinkedList
        StdOut.print("LinkedQueue: ");
        Queue<String> q1 = new Queue<>();
        for (String s : tokens) {
            if (!s.equals("-")) q1.enqueue(s);
            else if (!q1.isEmpty()) StdOut.print(q1.dequeue() + " ");
        }
        StdOut.println("(" + q1.size() + " left)");

        // Queue bằng Resizing Array
        StdOut.print("ResizingArrayQueue: ");
        ResizingArrayQueue<String> q2 = new ResizingArrayQueue<>();
        for (String s : tokens) {
            if (!s.equals("-")) q2.enqueue(s);
            else if (!q2.isEmpty()) StdOut.print(q2.dequeue() + " ");
        }
        StdOut.println("(" + q2.size() + " left)");
    }
}
