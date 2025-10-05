package algorithms;

import metrics.PerformanceTracker;

public class BoyerMooreMajorityVote {

    private final PerformanceTracker tracker;

    public BoyerMooreMajorityVote(PerformanceTracker tracker) {
        this.tracker = tracker;
    }

    public Integer findMajorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            tracker.incrementComparisons();
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }

        count = 0;
        for (int num : nums) {
            tracker.incrementComparisons();
            if (num == candidate) {
                count++;
            }
        }
        return count > nums.length / 2 ? candidate : null;
    }
}
