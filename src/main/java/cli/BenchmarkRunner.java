package cli;

import algorithms.InsertionSort;
import algorithms.ShellSort;
import algorithms.BoyerMooreMajorityVote;
import algorithms.MinHeap;
import metrics.PerformanceTracker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BenchmarkRunner {

    private static final int[] INPUT_SIZES = {100, 500, 1000, 5000, 10000};
    private static final int NUM_TRIALS = 5;
    private static final String OUTPUT_DIR = "docs/performance-plots/";

    public static void main(String[] args) {
        runBenchmark("insertion_sort", new InsertionSort(new PerformanceTracker()));
        runBenchmark("shell_sort", new ShellSort(new PerformanceTracker()));
        runBenchmark("boyer_moore", new BoyerMooreMajorityVote(new PerformanceTracker()));
        runBenchmark("min_heap", new MinHeap(new PerformanceTracker()));
    }

    private static void runBenchmark(String algorithmName, Object sorterObj) {
        PerformanceTracker tracker = new PerformanceTracker();
        String outputFile = OUTPUT_DIR + algorithmName + "_results.csv";

        File file = new File(outputFile);
        file.getParentFile().mkdirs();

        try (FileWriter writer = new FileWriter(file)) {
            writer.write("input_size,trial,comparisons,swaps,time_ns\n");

            Random random = new Random();

            for (int size : INPUT_SIZES) {
                for (int trial = 1; trial <= NUM_TRIALS; trial++) {
                    int[] arr = generateRandomArray(size, random);
                    tracker.reset();

                    long startTime = System.nanoTime();

                    if (sorterObj instanceof InsertionSort) {
                        ((InsertionSort) sorterObj).sort(arr);
                    } else if (sorterObj instanceof ShellSort) {
                        ((ShellSort) sorterObj).sort(arr);
                    } else if (sorterObj instanceof BoyerMooreMajorityVote) {
                        ((BoyerMooreMajorityVote) sorterObj).findMajorityElement(arr);
                    } else if (sorterObj instanceof MinHeap) {
                        MinHeap heap = (MinHeap) sorterObj;
                        for (int num : arr) heap.insert(num);
                        while (heap.extractMin() != null) {}
                    }

                    long endTime = System.nanoTime();
                    long duration = endTime - startTime;

                    writer.write(String.format("%d,%d,%d,%d,%d\n",
                            size, trial,
                            tracker.getComparisons(),
                            tracker.getSwaps(),
                            duration));

                    System.out.printf("%s | Size: %d | Trial: %d | Time: %dns | Comparisons: %d | Swaps: %d%n",
                            algorithmName, size, trial, duration, tracker.getComparisons(), tracker.getSwaps());
                }
            }

            System.out.println("\nBenchmark for " + algorithmName + " completed. Results saved to " + outputFile);

        } catch (IOException e) {
            System.err.println("Error writing CSV file: " + e.getMessage());
        }
    }

    private static int[] generateRandomArray(int size, Random random) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(10_000);
        }
        return arr;
    }
}
