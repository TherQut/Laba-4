import java.util.NoSuchElementException;

public class CustomMinPQueue {
    private int[] pq;
    private int n;

    public CustomMinPQueue(int initCapacity) {
        pq = new int[initCapacity + 1];
        n = 0;
    }

    public int sumLeastElements() {
        if (n < 2) return 0;
        int a = 1;
        int b = 2;
        int cost;
        if (n > 2 && greater(b, b+1))
                b++;

        cost = sumElements(a,b);
        delMin();
        return cost;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public int min() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }

    public void insert(int x) {
        if (n >= pq.length - 1) {
            System.out.println("Error. Queue is full!");
            return;
        }
        pq[++n] = x;
        swim(n);
    }

    public int delMin() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        int min = pq[1];
        exch(1, n--);
        sink(1);
        pq[n+1] = 0;
        return min;
    }

    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private boolean greater(int i, int j) {
        return pq[i] > pq[j];
    }

    private void exch(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    private int sumElements(int a, int b) {
        System.out.print("Складываю " + pq[a] + " + " + pq[b]);
        pq[b] += pq[a];
        pq[a] = 0;
        System.out.println(" = " + pq[b]);
        return pq[b];
    }
}
