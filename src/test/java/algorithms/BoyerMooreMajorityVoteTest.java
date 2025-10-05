package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoyerMooreMajorityVoteTest {

    @Test
    void testMajorityElementExists() {
        PerformanceTracker tracker = new PerformanceTracker();
        BoyerMooreMajorityVote algorithm = new BoyerMooreMajorityVote(tracker);

        int[] arr = {2, 2, 1, 1, 2, 2, 2};
        assertEquals(2, algorithm.findMajorityElement(arr));
    }

    @Test
    void testNoMajorityElement() {
        PerformanceTracker tracker = new PerformanceTracker();
        BoyerMooreMajorityVote algorithm = new BoyerMooreMajorityVote(tracker);

        int[] arr = {1, 2, 3, 4, 5};
        assertNull(algorithm.findMajorityElement(arr));
    }

    @Test
    void testSingleElement() {
        PerformanceTracker tracker = new PerformanceTracker();
        BoyerMooreMajorityVote algorithm = new BoyerMooreMajorityVote(tracker);

        int[] arr = {7};
        assertEquals(7, algorithm.findMajorityElement(arr));
    }

    @Test
    void testEmptyArray() {
        PerformanceTracker tracker = new PerformanceTracker();
        BoyerMooreMajorityVote algorithm = new BoyerMooreMajorityVote(tracker);

        int[] arr = {};
        assertNull(algorithm.findMajorityElement(arr));
    }
}
