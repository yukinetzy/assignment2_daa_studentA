package algorithms;

import metrics.PerformanceTracker;
import java.util.ArrayList;
import java.util.List;

public class MinHeap {

    private final List<Integer> heap;
    private final PerformanceTracker tracker;

    public MinHeap(PerformanceTracker tracker) {
        this.heap = new ArrayList<>();
        this.tracker = tracker;
    }

    public void insert(int val) {
        heap.add(val);
        tracker.incrementSwaps();
        siftUp(heap.size() - 1);
    }

    public Integer extractMin() {
        if (heap.isEmpty()) return null;
        int min = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        tracker.incrementSwaps();

        if (!heap.isEmpty()) {
            heap.set(0, last);
            siftDown(0);
        }
        return min;
    }

    public void decreaseKey(int index, int newValue) {
        if (index < 0 || index >= heap.size() || newValue >= heap.get(index)) return;
        heap.set(index, newValue);
        tracker.incrementSwaps();
        siftUp(index);
    }

    public void merge(MinHeap other) {
        for (int val : other.heap) {
            insert(val);
        }
    }

    private void siftUp(int index) {
        while (index > 0) {
            tracker.incrementComparisons();
            int parent = (index - 1) / 2;
            if (heap.get(index) < heap.get(parent)) {
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    private void siftDown(int index) {
        int left, right, smallest;
        while (true) {
            left = 2 * index + 1;
            right = 2 * index + 2;
            smallest = index;

            if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
                smallest = left;
            }
            if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
                smallest = right;
            }

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
        tracker.incrementSwaps();
    }

    public List<Integer> getHeap() {
        return heap;
    }
}
