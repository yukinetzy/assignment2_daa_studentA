package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class MinHeapTest {

    @Test
    void testInsertAndExtractMin() {
        PerformanceTracker tracker = new PerformanceTracker();
        MinHeap heap = new MinHeap(tracker);

        heap.insert(5);
        heap.insert(3);
        heap.insert(4);

        assertEquals(3, heap.extractMin());
        assertEquals(4, heap.extractMin());
        assertEquals(5, heap.extractMin());
        assertNull(heap.extractMin());
    }

    @Test
    void testDecreaseKey() {
        PerformanceTracker tracker = new PerformanceTracker();
        MinHeap heap = new MinHeap(tracker);

        heap.insert(10);
        heap.insert(20);
        heap.insert(30);
        heap.decreaseKey(2, 5);

        assertEquals(5, heap.extractMin());
    }

    @Test
    void testMerge() {
        PerformanceTracker tracker1 = new PerformanceTracker();
        MinHeap heap1 = new MinHeap(tracker1);

        heap1.insert(4);
        heap1.insert(6);

        PerformanceTracker tracker2 = new PerformanceTracker();
        MinHeap heap2 = new MinHeap(tracker2);

        heap2.insert(3);
        heap2.insert(7);

        heap1.merge(heap2);
        assertEquals(Arrays.asList(3, 4, 6, 7), heap1.getHeap());
    }
}
