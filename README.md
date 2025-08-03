## Intro
<p>My attempt at working through the content offered on algo.monster, a platform that prepares you for technical interviews.</p>
<p>Another aspect of this project is to use x.ai Grok in order to assist me in developing, mimicking a real world scenario we are moving towards where AI assisted programming is becoming popular</p>

## Technologies/Credits
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
  

## **Sonar Cube Stats**
![Overall Coverage (SonarCloud)](https://sonarcloud.io/api/project_badges/measure?project=LearningRiven_AlgorithmPractice&metric=reliability_rating)\
![Overall Coverage (SonarCloud)](https://sonarcloud.io/api/project_badges/measure?project=LearningRiven_AlgorithmPractice&metric=security_rating)\
![Overall Coverage (SonarCloud)](https://sonarcloud.io/api/project_badges/measure?project=LearningRiven_AlgorithmPractice&metric=alert_status)\
![Overall Coverage (SonarCloud)](https://sonarcloud.io/api/project_badges/measure?project=LearningRiven_AlgorithmPractice&metric=vulnerabilities)\
![Overall Coverage (SonarCloud)](https://sonarcloud.io/api/project_badges/measure?project=LearningRiven_AlgorithmPractice&metric=coverage)

## Test Results By Package
### Data Structures

| Class          | Test Status                                                                                                                                                                                                         |
|:---------------|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| NodeTest       | ![NodeTest](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/NodeTest.json&logo=junit5&label=Tests%20Passing&labelColor=gray)             |
| LinkedListTest | ![LinkedListTest](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/LinkedListTest.json&logo=junit5&label=Tests%20Passing&labelColor=gray) |
| HashMapTest    | ![HashMapTest](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/HashMapTest.json&logo=junit5&label=Tests%20Passing&labelColor=gray)       |
| QueueTest      | ![QueueTest](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/QueueTest.json&logo=junit5&label=Tests%20Passing&labelColor=gray)           |
| StackTest      | ![StackTest](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/StackTest.json&logo=junit5&label=Tests%20Passing&labelColor=gray)           |

### Algorithms - Sorting

| Class            |    Type    |                                                                                                                                         Test Status                                                                                                                                         | Space |       Best       |     Average      |      Worst       | Benefits<br/><sub>(When compared to brute)</sub>                                                                                                          |
|:-----------------|:----------:|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:-----:|:----------------:|:----------------:|:----------------:|:----------------------------------------------------------------------------------------------------------------------------------------------------------|
| BruteForceTest   | BruteForce |                                      ![Brute Force](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/BruteForceTest.json&logo=junit5&label=Tests%20Passing&labelColor=gray)                                       | Θ(1)  | Θ(n<sup>2</sup>) | Θ(n<sup>2</sup>) | Θ(n<sup>2</sup>) | <sub>Non-Adaptive <br/> Up to O(n<sup>2</sup>) swaps worst-case<br/> Always O(n<sup>2</sup>) compares. <br/> Unstable.</sub>                              |
| InsertionSortTest| Insertion  |                                   ![Insertion Sort](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/InsertionSortTest.json&logo=junit5&label=Tests%20Passing&labelColor=gray)                                    | Θ(1)  |       Θ(n)       | Θ(n<sup>2</sup>) | Θ(n<sup>2</sup>) | <sub>Adaptive <br/> Θ(n) time best-case (nearly-sorted) <br/> Fewer shifts O(n) best vs. brute's O(n<sup>2</sup>) swaps. <br/> Stable.</sub>              |
| SelectionSortTest| Selection  |                                   ![Selection Sort](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/SelectionSortTest.json&logo=junit5&label=Tests%20Passing&labelColor=gray)                                    | Θ(1)  | Θ(n<sup>2</sup>) | Θ(n<sup>2</sup>) | Θ(n<sup>2</sup>) | <sub>Non-Adaptive <br/> 0 swaps best-case (O(n) max) vs. brute's O(n<sup>2</sup>); <br/> always n(n-1)/2 compares (~half of brute). <br/> Unstable.</sub> |

<sub>O - Upper Bound, Θ - Tight Bound (exact asymptotic growth), Ω - Lower Bound</sub>

### Other

| Class        | Test Status                                                                                                                                                                                                 |
|:-------------|:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| UtilsTest    | ![UtilsTest](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/UtilsTest.json&logo=junit5&label=Tests%20Passing&labelColor=gray)   |