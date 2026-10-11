public class PriorityQueue {

    private int[] Q;
    private int size;
    private int capacity;

    public PriorityQueue(int K) {
        capacity = K;
        Q = new int[K];
        size = 0;
    }

    // Them mot so vao hang doi
    public void insert(int x) {
        if (size == capacity) {
            throw new IllegalStateException(
                    "Priority Queue da day!");
        }

        Q[size] = x;
        size++;
    }

    // Xoa va tra ve so nho nhat
    public int deleteMin() {
        if (size == 0) {
            throw new IllegalStateException(
                    "Priority Queue rong!");
        }

        int minIndex = 0;

        // Tim vi tri phan tu nho nhat
        for (int i = 1; i < size; i++) {
            if (Q[i] < Q[minIndex]) {
                minIndex = i;
            }
        }

        int min = Q[minIndex];

        // Dich cac phan tu phia sau sang trai
        for (int i = minIndex; i < size - 1; i++) {
            Q[i] = Q[i + 1];
        }

        size--;

        return min;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(10);

        pq.insert(7);
        pq.insert(3);
        pq.insert(9);
        pq.insert(1);
        pq.insert(5);

        while (!pq.isEmpty()) {
            System.out.println(pq.deleteMin());
        }
    }
}
