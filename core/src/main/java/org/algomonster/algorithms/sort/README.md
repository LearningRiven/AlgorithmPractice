# Sorting Algorithms

## Contents
* [Home](/)
* [Data Structures](/org/algomonster/algomonsteratastructures)
* Algorithms
    * [-***Sorting Algorithms***-](/org/algomonster/algomonsterlgorithms/sort)
* [Problems](/org/algomonster/algomonsterroblems)
    * [Parking System Instructions](/org/algomonster/algomonsterroblems/instructions/ParkingSystem.md)

| Class             |    Type    |                                                                                                      Test Status                                                                                                       | <sub>Space</sub> | <sub>Best</sub>  | <sub>Average</sub> | <sub>Worst</sub> |
|:------------------|:----------:|:----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:----------------:|:----------------:|:------------------:|:----------------:|
| BruteForceTest    | BruteForce |    ![Brute Force](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/BruteForceTest.json&logo=junit5&label=Tests%20Passing&labelColor=gray)    |       Θ(1)       | Θ(n<sup>2</sup>) |  Θ(n<sup>2</sup>)  | Θ(n<sup>2</sup>) |
| InsertionSortTest | Insertion  | ![Insertion Sort](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/InsertionSortTest.json&logo=junit5&label=Tests%20Passing&labelColor=gray) |       Θ(1)       |       Θ(n)       |  Θ(n<sup>2</sup>)  | Θ(n<sup>2</sup>) |
| SelectionSortTest | Selection  | ![Selection Sort](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/SelectionSortTest.json&logo=junit5&label=Tests%20Passing&labelColor=gray) |       Θ(1)       | Θ(n<sup>2</sup>) |  Θ(n<sup>2</sup>)  | Θ(n<sup>2</sup>) |
| BubbleSortTest    |   Bubble   |    ![Bubble Sort](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/BubbleSortTest.json&logo=junit5&label=Tests%20Passing&labelColor=gray)    |       Θ(1)       |       Θ(n)       |  Θ(n<sup>2</sup>)  | Θ(n<sup>2</sup>) |
| MergeSortTest     | MergeSort  |    ![Bubble Sort](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/MergeSortTest.json&logo=junit5&label=Tests%20Passing&labelColor=gray)     |       Θ(n)       |     Θ(nlogn)     |      Θ(nlogn)      |     Θ(nlogn)     |
| QuickSortTest     | QuickSort (Lomuto/Mo3) |     ![Quick Sort](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/QuickSortTest.json&logo=junit5&label=Tests%20Passing&labelColor=gray)     |       Θ(n)       |     Θ(nlogn)     |      Θ(nlogn)      | Θ(n<sup>2</sup>) |

<sub>*** O - Upper Bound, Θ - Tight Bound (exact asymptotic growth), Ω - Lower Bound</sub>

## Sorting - Benefit Analysis Over Brute Force

|       Type       | Benefits                                                                                                                     |
|:----------------:|:-----------------------------------------------------------------------------------------------------------------------------|
|    Insertion     | Adaptive:  Θ(n) time best-case (nearly-sorted); Fewer shifts O(n) best vs. brute's O(n<sup>2</sup>) swaps; Stable.           |
|    Selection     | Non-Adaptive:  0(n) swaps best-case vs. brute's O(n<sup>2</sup>); Always n(n-1)/2 compares (~half of brute); Unstable.       |
| Bubble (flagged) | Adaptive:  0(n) time best-case vs. brute's O(n<sup>2</sup>); O(n<sup>2</sup>/4) average, and O(n<sup>2</sup>) worst; Stable. |
|    Merge Sort    | Non-Adaptive:  0(nlogn) time best-case vs. brute's O(n<sup>2</sup>); 0(nlogn) average, and 0(nlogn) worst; Stable.           |         
|    Quick Sort    | Adaptive:  0(nlogn) time best-case vs. brute's O(n<sup>2</sup>); 0(nlogn) average, and 0(n<sup>2</sup>) worst; Not Stable.   |

## Simple Vs Complex

##### Just my own way of defining algorithms, to me a simple algorithm is an algorithm that is standalone, a complex algorithm will be constructed from multiple simple ones
* Simple Algorithms
  * InsertionSort
  * SelectionSort
  * BubbleSort
  * MergeSort
  * QuickSort
* Complex Algorithm
  * No code examples, but for example the native java sort is complex, it uses hoare with 2 pointers + tim sort for its quicksort

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

### Quick Sort Specifics
  * Quicksort is usually the go-to algorithm for most implementations, even the java sort method uses a variation of it (dual pivot with Tim Sort)
  * The key things to understand about it is that its efficiency comes down to whether your partitions are balanced or not
    * If you have a solid pivot, you can have a O(nlogn) implementation, but worst case is still O(n<sup>2</sup>)
    * The effect of a bad pivot really comes down to how many partitions you make during the recursion
  * Common strategies for selecting pivots and an analysis

|   Strategy   |          Pros           | Cons                                     |                Time (Avg/Worst)                 |
|:------------:|:-----------------------:|:-----------------------------------------|:-----------------------------------------------:|
|    Lomuto    |         Simple          | Bad Runtime on already sorted            |                O(n log n)/O(n²)                 |
| Mo3 + Lomuto | Balanced, Deterministic | O(1) extra work                          |              O(n log n)/Rare O(n²)              |
|    Random    |    Robust and Secure    | Non deterministic (use seed for testing) |         O(n log n)/Probabilistic O(n²)          |
|    Hoare     |   Fewer swaps, faster   | Complex because of pointers              |                O(n log n)/O(n²)                 |         

#### Lomuto

Very simple approach, but is ruined by already sorted lists, you are guaranteed a O(n<sup>2</sup>) solution

##### Pseudo Code - Recursive Function
```` 
   sortHelper(list, start, end)  
        base condition - when start is >= end
        pivot = get last element from list

        partition
            get the pivot value
            keep track of the less than boundary (start - 1)
            loop from the start to the end
                if the value is <= the pivot
                     then update the less than boundary and swap the pointer to it
            swap the pivot to the spot right after the boundary, mark it down as the new pivot

        recurse (exclude the pivot since its already in the right spot)
            sortHelper(list, start, new pivot - 1)
            sortHelper(list, new pivot + 1, end) 
````

#### Mo3 with Lomuto

Better than the standard, but there are faster ways to do it. Mo3 naturally flows from Lomuto for general teaching purposes when discussing ideas on enhancing/improving.

##### Pseudo Code - Only the pivot selection process

````
Start with Lomuto

get the pivot value
    determine the middle slot (start + ((end - start)/2)) works
    compare the value in the start slot to the middle, swap if bigger
    compare the value in the start slot to the end, swap if bigger
    compare the value in the middle slot to the end, swap if bigger
    
    //after above you are guaranteed that the median is in the middle
    swap the median with the end
    
Continue with standard Lomuto
````

#### Random Number using Math.random

Overall a solid approach, again helps teach the algorithm better by introducing ideas around randomness and security

##### Pivot Selection Pseudo Code
````
Start with Lomuto

get the pivot value
    select a random number from the starting index to the ending index
    swap that number with the end
    
Continue with standard Lomuto
````

#### Hoare

Overall faster than the other methods, only lacking in the security aspect of the random number approach.

This is the base the java sort method uses (it uses a more complicated dual pointer + Tim Sort approach)

##### Hoare pseudo code for pivot selection and partitioning
````
use the end index for the pivot (like with lomuto) 
create 2 pointers to track your current position in the start/end pointers
    startPtr endPtr

loop while startPtr < endPtr
    Update the startPointer for the left of the pointer in a loop while startPtr value < pivot value and startPtr value < pivot value
        startPtr++
    Update the endPointer for the right of the pivot while startPtr < endPtr and endPtr value >= pivot value
        endPtr--
    Perform a swap if the pointers have not met yet (startPtr != endPtr)
    
(Optional if you want to mimic Lomuto with this) Put the pivot in its correct position by swapping the start pointer and the pivot, the start pointer is the new pivot now

sort the left side via recursion using list, start, startptr
sort the right side via recursion using list, startptr + 1, end (skips the pivot since its in the correct spot)
````

### Divide and Conquer Testing

#### In order to practice cloud integration, and prove that quicksort is by far the best algorithm for most cases, I created an AWS S3 bucket and populated it with large datasets
* Best Case - 100k values already sorted
* Average Case - Randomly generated 100k values with both positives and negatives
* Worst Case - 100k values inversely sorted

#### In a real world scenario you can see that in all 3 scenarios are actually faster with the quicksort algorithm, below is a screenshot of the timings
![S3 Merge vs QuickSort Comparison](/images/S3MergeVsQuick.png)

#### For easier viewing here is a table of the timings I have seen

| Test Case | Quick Sort | Merge Sort |
|:----------|------------|------------|
| Worst     | 12ms       | 70ms       |
| Average   | 16ms       | 79ms       |
| Best      | 37ms       | 57ms       |

#### We do how ever see a clear patterns
* Merge Sort underperforms when compared to my Quick Sort implementation
* My Quicksort implementation is much worse when working with already sorted data and the best when its inversely sorted
* The average time for Quicksort is closer to its best case (inversely sorted) instead of the worst case

#### This is just a simple demonstration though, we have to admit some flaws with my testing, atleast enough to call it inconclusive (more of a demo of using S3 in order to test), here is how I could make this more robust
* Work with a much larger dataset, 100k rows with modern computing hardware simply isnt enough to test the actual algorithm while mitigating certain hardware processes
* Run my tests multiple times and take the average, sample size of 1 is not enough to make a thoughtful decision


| Class           | Test Status                                                                                                                                                                                                           |
|:----------------|:----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| S3AlgorithmTest | ![S3AlgorithmTest](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/S3AlgorithmTest.json&logo=junit5&label=Tests%20Passing&labelColor=gray) |




### Ranking Them
  1. QuickSort - Fastest average on random data, in-place, but unstable and O(n²) worst (mitigate with random pivots). Lacks in stability and worst-case guarantees. 
  2. Mergesort - Reliable O(n log n) always, stable, but O(n) space and non-adaptive. Complements QuickSort when stability/guarantees matter
  3. In Place Algorithms
     1. Insertion Sort - Best for small/partially sorted + stable needed; adaptive (O(n) best), but O(n²) worst on reverse (many shifts).
     2. Selection Sort - Minimizes swaps (good for expensive writes), but non-adaptive, unstable, and always O(n²) compares. Use only if swaps costly and stability irrelevant.
     3. Bubble Sort - Rarely good, only on small datasets and only for simplicity. Avoid for reverse/large because the flag doesn't save much.