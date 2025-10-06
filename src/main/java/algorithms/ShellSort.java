package algorithms;

import metrics.PerformanceTracker;

public class ShellSort {

    private final PerformanceTracker tracker;

    public ShellSort(PerformanceTracker tracker) {
        this.tracker = tracker;
    }

    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        int n = arr.length;

        // different gap sequence
        int[] gaps = generateKnuthSequence(n);

        for (int gap : gaps) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;

                tracker.incrementComparisons();
                while (j >= gap && arr[j - gap] > temp) {
                    tracker.incrementComparisons();
                    arr[j] = arr[j - gap];
                    tracker.incrementSwaps();
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
    }

    private int[] generateKnuthSequence(int size) {
        int h = 1;
        int count = 0;
        while (h < size) {
            h = 3 * h + 1;
            count++;
        }

        int[] gaps = new int[count];
        h = 1;
        for (int i = 0; i < count; i++) {
            gaps[i] = h;
            h = 3 * h + 1;
        }

        for (int i = 0; i < gaps.length / 2; i++) {
            int temp = gaps[i];
            gaps[i] = gaps[gaps.length - i - 1];
            gaps[gaps.length - i - 1] = temp;
        }

        return gaps;
    }
}
