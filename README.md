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
<h3>Data Structures</h3>

| Class          | Test Status                                                                                                                                                                                                         |
|:---------------|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| NodeTest       | ![NodeTest](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/NodeTest.json&logo=junit5&label=Tests%20Passing&labelColor=gray)             |
| LinkedListTest | ![LinkedListTest](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/LinkedListTest.json&logo=junit5&label=Tests%20Passing&labelColor=gray) |
| HashMapTest    | ![HashMapTest](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/HashMapTest.json&logo=junit5&label=Tests%20Passing&labelColor=gray)       |
| QueueTest      | ![QueueTest](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/QueueTest.json&logo=junit5&label=Tests%20Passing&labelColor=gray)           |
| StackTest      | ![StackTest](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/StackTest.json&logo=junit5&label=Tests%20Passing&labelColor=gray)           |

<h3>Algorithms - Sorting</h3>
<small>T - Time Complexity</small><br/>
<small>S - Space Complexity</small>

| Class                      |           Type            |          <small>Best Case<br/>(sorted already)</small>           |                          <small>Average Case</small>                           |        <small>Worst case <br/>(sorted in reverse)</small>        | Evolution                                                              | Test Status                                                                                                                                                                                                                  |
|:---------------------------|:-------------------------:|:----------------------------------------------------------------:|:------------------------------------------------------------------------------:|:----------------------------------------------------------------:|:-----------------------------------------------------------------------|:-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| BruteForceInPlaceSortTest  | <small>BruteForce</small> | <small>Ω<sup>T</sup>(n<sup>2</sup>)<br/>Ω<sup>S</sup>(1)</small> |        <small>Θ<sup>T</sup>(n<sup>2</sup>)<br/>Θ<sup>S</sup>(1)</small>        | <small>O<sup>T</sup>(n<sup>2</sup>)<br/>O<sup>S</sup>(1)</small> | <small>Naive brute force 2 loop solution</small>                       | ![Brute Force](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/BruteForceInPlaceSortTest.json&logo=junit5&label=Tests%20Passing&labelColor=gray)  |
| InsertionSortInPlaceTest   | <small>Insertion</small>  |       <small>Ω<sup>T</sup>(n)<br/>Ω<sup>S</sup>(1)</small>       |        <small>Θ<sup>T</sup>(n<sup>2</sup>)<br/>Θ<sup>S</sup>(1)</small>        | <small>O<sup>T</sup>(n<sup>2</sup>)<br/>O<sup>S</sup>(1)</small> | <small>2<sup>nd</sup> loop moves backwards and shifts elements</small> | ![Brute Force](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/InsertionSortInPlaceTest.json&logo=junit5&label=Tests%20Passing&labelColor=gray)   |



<h3>Other</h3>

| Class        | Test Status                                                                                                                                                                                                 |
|:-------------|:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| UtilsTest    | ![UtilsTest](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/LearningRiven/AlgorithmPractice/ci-stats/test-badges/UtilsTest.json&logo=junit5&label=Tests%20Passing&labelColor=gray)   |