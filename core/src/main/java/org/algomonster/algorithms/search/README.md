## Intro
Searching algorithms

## Contents
* [Home](/)
* [Algorithms](/core/src/main/java/org/algomonster/algorithms)
    * [Exercises Algorithms](/core/src/main/java/org/algomonster/algorithms/exercises)
    * [-***Search Algorithms***-](/core/src/main/java/org/algomonster/algorithms/search)
    * [Sorting Algorithms](/core/src/main/java/org/algomonster/algorithms/sort)
* [Data Structures](/core/src/main/java/org/algomonster/datastructures)
* [Problems](/core/src/main/java/org/algomonster/problems)
    * [Parking System Instructions](/core/src/main/java/org/algomonster/problems/instructions/ParkingSystem.md)
* [Spring](/spring-integration/src/main/java/org/algomonster/spring)

## Testing

| Class            | Test Status                                                                                                                                                                                                            |
|:-----------------|:-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| BinarySearchTest | ![BinarySearchTest](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/BinarySearchTest.json&logo=junit5&label=BinarySearchControllerTest%20Passing&labelColor=gray)                |

## Templates

### Binary Search
```
Null Checking
Create default result variable
Store the start/end index
Loop while start <= end
    Calculate the middle
    
    Check if the value matches
        Here we found the element, depending on needs you can store the index/value and either break or continue
    Else check if current value is bigger than target
        Cut the right side of array (end = middle - 1)
    Else current value must be smaller than target
        Cut the left side of the array (start = middle + 1)

return result
```