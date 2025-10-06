# Assignment 2: Algorithmic Analysis and Peer Code Review

## Project Overview
This project implements four algorithms for the Design and Analysis of Algorithms course.  
The aim is to implement, analyze, optimize, and validate algorithm performance, as well as conduct a peer code review.

Implemented algorithms:
- **Insertion Sort** — optimized for nearly sorted data
- **Shell Sort** — with multiple gap sequences (Shell's, Knuth's, Sedgewick's)
- **Boyer-Moore Majority Vote** — single-pass majority element detection
- **Min Heap** — with decrease-key and merge operations



## Project Structure
assignment2_daa [insertion-sort-analysis]/
├── docs/
│ └── performance-plots/
│ ├── boyer_moore_results.csv
│ ├── insertion_sort_results.csv
│ ├── min_heap_results.csv
│ └── shell_sort_results.csv
├── src/
│ └── main/java/
│ ├── algorithms/
│ │ ├── BoyerMooreMajorityVote.java
│ │ ├── InsertionSort.java
│ │ ├── Main.java
│ │ ├── MinHeap.java
│ │ └── ShellSort.java
│ ├── cli/
│ │ └── BenchmarkRunner.java
│ └── metrics/
│ └── PerformanceTracker.java
├── test/java/algorithms/
│ ├── BoyerMooreMajorityVoteTest.java
│ ├── InsertionSortTest.java
│ ├── MinHeapTest.java
│ └── ShellSortTest.java
└── README.md



## How to Run

### Build & Run in IDE
1. Open the project in IntelliJ IDEA (or another Java IDE).
2. Let the IDE import Maven dependencies via the **Maven panel**.
3. Build the project: **Build → Build Project**.
4. Run the benchmark:
    - Open `BenchmarkRunner.java`
    - Right-click → **Run 'BenchmarkRunner.main()'**
5. Run tests:
    - Open test classes in `src/test/java/algorithms/`
    - Right-click → **Run Tests**

## Performance and Complexity Analysis

| Algorithm                 | Best Case               | Average Case            | Worst Case              | Space Complexity |
|---------------------------|-------------------------|-------------------------|-------------------------|------------------|
| Insertion Sort            | Θ(n)                    | Θ(n²)                   | Θ(n²)                   | O(1)             |
| Shell Sort                | depends on gap sequence | depends on gap sequence | depends on gap sequence | O(1)             |
| Boyer-Moore Majority Vote | Θ(n)                    | Θ(n)                    | Θ(n)                    | O(1)             |
| Min Heap                  | Θ(log n)                | Θ(log n)                | Θ(log n)                | O(n)             |

## Usage Instructions
- Use your IDE to run `BenchmarkRunner.java` for benchmarking.
- Results will be saved in `/docs/performance-plots/` as CSV files and performance plots.
- Tests can be run from the IDE by right-clicking the test classes.

## Author
**Atalykov Sultan**

## License
This project is for academic purposes only.
