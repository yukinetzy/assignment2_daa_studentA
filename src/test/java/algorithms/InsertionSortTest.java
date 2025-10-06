package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InsertionSortTest {

    @Test
    public void testBasicSorting() {
        PerformanceTracker tracker = new PerformanceTracker();
        InsertionSort sorter = new InsertionSort(tracker);
        int[] arr = {5, 2, 9, 1, 5, 6};
        sorter.sort(arr);
        Assertions.assertArrayEquals(new int[]{1, 2, 5, 5, 6, 9}, arr);
    }

    @Test
    public void testNearlySortedArray() {
        PerformanceTracker tracker = new PerformanceTracker();
        InsertionSort sorter = new InsertionSort(tracker);
        int[] arr = {1, 2, 3, 5, 4, 6};
        sorter.sort(arr);
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, arr);
    }

    @Test
    public void testEmptyArray() {
        PerformanceTracker tracker = new PerformanceTracker();
        InsertionSort sorter = new InsertionSort(tracker);
        int[] arr = {};
        sorter.sort(arr);
        Assertions.assertArrayEquals(new int[]{}, arr);
    }
}
