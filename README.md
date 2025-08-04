# Intro
#### This project is mostly for me to refresh my knowledge on common software engineering techniques, with a twist of trying out some technologies in order to understand them better. 

## Goals
- Review concepts that are typically covered in Data Structures and Algorithms
- Utilize AI in order to speed up my overall progress
- Utilize industry standard tools such as JaCoCo and SonarQube in order to have a solid testing strategy
- Design a workflow on github in order to automate my development process
- Maintain security by using gpg encryption when pushing updates to github

# Technologies/Credits
- **Core Development**
  - <img src="https://img.shields.io/badge/Java-21-blue?style=flat&logo=openjdk&logoColor=red" height="20">
  - <img src="https://img.shields.io/badge/Maven-3.9%2B-red?style=flat&logo=apachemaven&logoColor=red" height="20">
  - <img src="https://img.shields.io/badge/IntelliJ-2024.3-blueviolet?style=flat&logo=intellijidea&logoColor=black" height="20">

- **Testing & Coverage**
  - <img src="https://img.shields.io/badge/JUnit-5.10.3-green?style=flat&logo=junit5&logoColor=green" height="20">
  - <img src="https://img.shields.io/badge/JaCoCo-0.8.12-yellow?style=flat&logo=openjdk&logoColor=red" height="20">

- **Code Quality**
  - <img src="https://img.shields.io/badge/SonarCloud-Integrated-orange?style=flat&logo=sonarqubecloud&logoColor=blue" height="20">

- **AI Assistance Provided By**
  - <img src="https://img.shields.io/badge/Grok-4-black?style=flat&logo=x&logoColor=black" height="20">

- **Security**
  - <img src="https://img.shields.io/badge/Gpg4Win-black?style=flat&logo=gnuprivacyguard&logoColor=white" height="20">
  

# **Sonar Cube Stats**
![Overall Coverage (SonarCloud)](https://sonarcloud.io/api/project_badges/measure?project=LearningRiven_AlgorithmPractice&metric=reliability_rating)\
![Overall Coverage (SonarCloud)](https://sonarcloud.io/api/project_badges/measure?project=LearningRiven_AlgorithmPractice&metric=security_rating)\
![Overall Coverage (SonarCloud)](https://sonarcloud.io/api/project_badges/measure?project=LearningRiven_AlgorithmPractice&metric=alert_status)\
![Overall Coverage (SonarCloud)](https://sonarcloud.io/api/project_badges/measure?project=LearningRiven_AlgorithmPractice&metric=vulnerabilities)\
![Overall Coverage (SonarCloud)](https://sonarcloud.io/api/project_badges/measure?project=LearningRiven_AlgorithmPractice&metric=coverage)

# Packages
## Data Structures

##### The Goal with this package was to explore the common data structures used. I chose to recreate them from scratch in order to make sure I understand exactly the purpose of each and how they work.


| Class          | Test Status                                                                                                                                                                                                         |
|:---------------|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| NodeTest       | ![NodeTest](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/NodeTest.json&logo=junit5&label=Tests%20Passing&labelColor=gray)             |
| LinkedListTest | ![LinkedListTest](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/LinkedListTest.json&logo=junit5&label=Tests%20Passing&labelColor=gray) |
| HashMapTest    | ![HashMapTest](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/HashMapTest.json&logo=junit5&label=Tests%20Passing&labelColor=gray)       |
| QueueTest      | ![QueueTest](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/QueueTest.json&logo=junit5&label=Tests%20Passing&labelColor=gray)           |
| StackTest      | ![StackTest](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/StackTest.json&logo=junit5&label=Tests%20Passing&labelColor=gray)           |

## Algorithms

##### The Goal with this package is to first create a brute force approach for both sorting and searching through structures. Then as I added a new algorithm for either, I analyzed the costs and benefits associated with each approach when compared to the Brute Force approach I initially chose

### Sorting - Algorithm Implementations/Tests

| Class             |    Type    |                                                                                                      Test Status                                                                                                       | <sub>Space</sub> | <sub>Best</sub>  | <sub>Average</sub> |      <sub>Worst</sub>      |
|:------------------|:----------:|:----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:----------------:|:----------------:|:------------------:|:--------------------------:|
| BruteForceTest    | BruteForce |    ![Brute Force](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/BruteForceTest.json&logo=junit5&label=Tests%20Passing&labelColor=gray)    |       Θ(1)       | Θ(n<sup>2</sup>) |  Θ(n<sup>2</sup>)  |      Θ(n<sup>2</sup>)      |
| InsertionSortTest | Insertion  | ![Insertion Sort](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/InsertionSortTest.json&logo=junit5&label=Tests%20Passing&labelColor=gray) |       Θ(1)       |       Θ(n)       |  Θ(n<sup>2</sup>)  |      Θ(n<sup>2</sup>)      |
| SelectionSortTest | Selection  | ![Selection Sort](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/SelectionSortTest.json&logo=junit5&label=Tests%20Passing&labelColor=gray) |       Θ(1)       | Θ(n<sup>2</sup>) |  Θ(n<sup>2</sup>)  |      Θ(n<sup>2</sup>)      |
| BubbleSortTest    |   Bubble   |    ![Bubble Sort](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/BubbleSortTest.json&logo=junit5&label=Tests%20Passing&labelColor=gray)    |       Θ(1)       |      Θ(n)        |  Θ(n<sup>2</sup>)  |      Θ(n<sup>2</sup>)      |

<sub>*** O - Upper Bound, Θ - Tight Bound (exact asymptotic growth), Ω - Lower Bound</sub>

### Sorting - Benefit Analysis Over Brute Force

|       Type       | Benefits                                                                                                                     |
|:----------------:|:-----------------------------------------------------------------------------------------------------------------------------|
|    Insertion     | Adaptive:  Θ(n) time best-case (nearly-sorted); Fewer shifts O(n) best vs. brute's O(n<sup>2</sup>) swaps; Stable.           |
|    Selection     | Non-Adaptive:  0(n) swaps best-case vs. brute's O(n<sup>2</sup>); Always n(n-1)/2 compares (~half of brute); Unstable.       |
| Bubble (flagged) | Adaptive:  0(n) time best-case vs. brute's O(n<sup>2</sup>); O(n<sup>2</sup>/4) average, and O(n<sup>2</sup>) worst; Stable. |

## Other

| Class        | Test Status                                                                                                                                                                                                 |
|:-------------|:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| UtilsTest    | ![UtilsTest](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/UtilsTest.json&logo=junit5&label=Tests%20Passing&labelColor=gray)   |