# Sorting Algorithms

## Contents
- [Home](https://github.com/LearningRiven/AlgorithmPractice/tree/main)
- [Data Structures](https://github.com/LearningRiven/AlgorithmPractice/tree/main/src/main/java/org/algomonster/datastructures)
- Algorithms
    - Sorting Algorithms (you are here)

| Class             |    Type    |                                                                                                      Test Status                                                                                                       | <sub>Space</sub> | <sub>Best</sub>  | <sub>Average</sub> | <sub>Worst</sub> |
|:------------------|:----------:|:----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:----------------:|:----------------:|:------------------:|:----------------:|
| BruteForceTest    | BruteForce |    ![Brute Force](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/BruteForceTest.json&logo=junit5&label=Tests%20Passing&labelColor=gray)    |       Θ(1)       | Θ(n<sup>2</sup>) |  Θ(n<sup>2</sup>)  | Θ(n<sup>2</sup>) |
| InsertionSortTest | Insertion  | ![Insertion Sort](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/InsertionSortTest.json&logo=junit5&label=Tests%20Passing&labelColor=gray) |       Θ(1)       |       Θ(n)       |  Θ(n<sup>2</sup>)  | Θ(n<sup>2</sup>) |
| SelectionSortTest | Selection  | ![Selection Sort](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/SelectionSortTest.json&logo=junit5&label=Tests%20Passing&labelColor=gray) |       Θ(1)       | Θ(n<sup>2</sup>) |  Θ(n<sup>2</sup>)  | Θ(n<sup>2</sup>) |
| BubbleSortTest    |   Bubble   |    ![Bubble Sort](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/BubbleSortTest.json&logo=junit5&label=Tests%20Passing&labelColor=gray)    |       Θ(1)       |       Θ(n)       |  Θ(n<sup>2</sup>)  | Θ(n<sup>2</sup>) |
| MergeSortTest     | MergeSort  |    ![Bubble Sort](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/MergeSortTest.json&logo=junit5&label=Tests%20Passing&labelColor=gray)     |       Θ(n)       |     Θ(nlogn)     |      Θ(nlogn)      |     Θ(nlogn)     |

<sub>*** O - Upper Bound, Θ - Tight Bound (exact asymptotic growth), Ω - Lower Bound</sub>

## Sorting - Benefit Analysis Over Brute Force

|       Type       | Benefits                                                                                                                             |
|:----------------:|:-------------------------------------------------------------------------------------------------------------------------------------|
|    Insertion     | Adaptive:  Θ(n) time best-case (nearly-sorted); Fewer shifts O(n) best vs. brute's O(n<sup>2</sup>) swaps; Stable.                   |
|    Selection     | Non-Adaptive:  0(n) swaps best-case vs. brute's O(n<sup>2</sup>); Always n(n-1)/2 compares (~half of brute); Unstable.               |
| Bubble (flagged) | Adaptive:  0(n) time best-case vs. brute's O(n<sup>2</sup>); O(n<sup>2</sup>/4) average, and O(n<sup>2</sup>) worst; Stable.         |
|    Merge Sort    | Non-Adaptive:  0(nlogn) time best-case vs. brute's O(n<sup>2</sup>); 0(nlogn) average, and 0(nlogn) worst; Stable. |

## Simple Vs Complex

##### Just my own way of defining algorithms, to me a simple algorithm is an algorithm that is standalone, a complex algorithm will be constructed from multiple simple ones
* Simple Algorithms
  * InsertionSort
  * SelectionSort
  * BubbleSort
  * MergeSort
  * QuickSort
* Complex Algorithm
  * No examples yet, but any algorithm that may use the simple ones above

## Comparing the algorithms against each other

### Overview
  * Divide and Conquer algorithms will beat out the in-place algorithms. Strictly based on time analysis.
  * The only time to consider using in-place is when you are limited on space

### General Decision Making
  * Terminology
    * Adaptive vs Non-Adaptive - An algorithm that can adapt to the dataset we are feeding is Adaptive, i.e changes performance based on the amount of work needed. Non-Adaptive doesn't care about the state of the data passed in.
      * Example: 1,2,3,4,5 is already sorted, an adaptive algorithm will do less comparisons/swaps because it can exit early, shines on real data examples
    * Stable vs Not-Stable - An algorithm that is stable is an algorithm that maintains order of objects with the same value
      * Example: Sorting students based on grades, you might already have sorted the students in alphabetical order, so if 2 students have the same grade, you want to keep that order
    * Algorithm Comparisons - The amount of comparisons that an algorithm might make, different from overall runtime but a small optimization variable
    * Algorithm Swapping - The amount of times an algorithm will perform a swap, again a small time savings compared to overall run time complexity, but good for that extra push.
  * Decision Making
    * Unlimited Space
      * Stability Matters - Mergesort
      * Stability is Irrelevant - Quicksort
    * Limited Space
      * When stability matters, avoid selection sort, decide between Insertion and Bubble
      * Algorithm Choice
        * Insertion Sort - If the dataset is small and almost ordered (or preordered) and stability is necessary
        * Insertion Sort - If the dataset is large and ordered in reverse and stability is necessary
        * Selection Sort - If stability doesn't matter
        * Bubble Sort - If you want to have a fun easy algorithm, loses out to the other two in practice because of the amount of swaps in average/worst case scenarios
          * Insertion does a better job overall if stability matters because of the amount of swaps/compares
          * Selection does a better job overall if stability is irrelevant because of the amount of swaps/compares

### Ranking Them
  1. QuickSort - Fastest average on random data, in-place, but unstable and O(n²) worst (mitigate with random pivots). Lacks in stability and worst-case guarantees. 
  2. Mergesort - Reliable O(n log n) always, stable, but O(n) space and non-adaptive. Complements QuickSort when stability/guarantees matter
  3. In Place Algorithms
     1. Insertion Sort - Best for small/partially sorted + stable needed; adaptive (O(n) best), but O(n²) worst on reverse (many shifts).
     2. Selection Sort - Minimizes swaps (good for expensive writes), but non-adaptive, unstable, and always O(n²) compares. Use only if swaps costly and stability irrelevant.
     3. Bubble Sort - Rarely good, only on small datasets and only for simplicity. Avoid for reverse/large because the flag doesn't save much.