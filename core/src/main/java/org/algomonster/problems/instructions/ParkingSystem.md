# Parking System

## Intro
Create a parking lot tracking application

## Contents
* [Home](/)
* [Algorithms](/core/src/main/java/org/algomonster/algorithms)
  * [Exercises Algorithms](/core/src/main/java/org/algomonster/algorithms/exercises)
  * [Search Algorithms](/core/src/main/java/org/algomonster/algorithms/search)
  * [Sorting Algorithms](/core/src/main/java/org/algomonster/algorithms/sort)
* [Data Structures](/core/src/main/java/org/algomonster/datastructures)
* [Problems](/core/src/main/java/org/algomonster/problems)
  * [-***Parking System Instructions***-](/core/src/main/java/org/algomonster/problems/instructions/ParkingSystem.md)
* [Spring](/spring-integration/src/main/java/org/algomonster/spring)


### Problem Description
In this problem, we're asked to design a simple parking system for a parking lot with three different types of parking spaces: big, medium, and small. 
Each type of parking space has a fixed number of slots that can be occupied by cars of that specific size. The parking system needs to be able to handle two operations:

Initializing the parking system with the number of slots for each type of parking space.
Adding a car to the parking lot, which is subject to there being an available slot for the car's type.
When a car tries to park, the parking system checks if there is an available slot for that particular size of the car. 
If an appropriate slot is available, the car parks (i.e., the count of available slots of that type reduces by one), and the system returns true. 
If no slot is available for that car's type, the system returns false.

The key to solving the problem is to keep track of the number of available slots for each car type in an efficient way that allows quick updates and queries.

### Specification Breakdown
* We are to create a simple parking system that supports 3 parking space types
  * Big
  * Medium
  * Small
* Each type of parking space has a fixed number of slots that can handle cars of that specific size
  * Questions
    * Can a small car park in medium/big?
    * Can a medium car park in big?
  * Assumptions
    * Initially we will only support that specific car type in slot i.e small can only park in small
      * Will be enhanced if specs change
* Must support the following
  * Initialize the parking lot with the number of slots for each type of parking space
  * When a car is added
    * If there is space in that specific slot, we reduce by 1 and return true
    * If there is no space in that specific slot, we return false

### Design
* Properties
  * EnumMap<CarType, Integer> slots;
* Initialization
  * ParkingSystem(int small, int medium, int big)
  * Initialize the slots array, populate the corresponding slots with the values
    * If any value is < 0 make it 0
* attemptPark(CarType type)
  * get the index its tied to from the enum
  * if the value > 0, subtract 1 and return true
  * return false otherwise
* enum CarType
  * SMALL(0)
  * MEDIUM(1)
  * BIG(2)
  * index
  * Constructor that takes index and sets it
  * getter to fetch the index