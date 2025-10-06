package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShellSortTest {

    @Test
    void testEmptyArray() {
        int[] arr = {};
        PerformanceTracker tracker = new PerformanceTracker();
        new ShellSort(tracker).sort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void testSingleElement() {
        int[] arr = {1};
        PerformanceTracker tracker = new PerformanceTracker();
        new ShellSort(tracker).sort(arr);
        assertArrayEquals(new int[]{1}, arr);
    }

    @Test
    void testSortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        PerformanceTracker tracker = new PerformanceTracker();
        new ShellSort(tracker).sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testReverseArray() {
        int[] arr = {5, 4, 3, 2, 1};
        PerformanceTracker tracker = new PerformanceTracker();
        new ShellSort(tracker).sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testSameElements() {
        int[] arr = {2, 2, 2, 2};
        PerformanceTracker tracker = new PerformanceTracker();
        new ShellSort(tracker).sort(arr);
        assertArrayEquals(new int[]{2, 2, 2, 2}, arr);
    }
}
