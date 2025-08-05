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

