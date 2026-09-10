# Day 4 – RDD Creation

## Topics Covered

- Creating RDDs from Scala collections
- Creating RDDs from text files
- `map` transformation
- `filter` transformation
- `flatMap` transformation
- `reduce` action
- Checking RDD partitions
- Checking default parallelism
- Creating an RDD with multiple partitions

## RDD Examples

### 1. Collection RDD
Created an RDD using `sc.parallelize()`.

### 2. Text File RDD
Created an RDD using `sc.textFile()`.

### 3. map
Doubled each number in the RDD.

### 4. filter
Selected only even numbers.

### 5. flatMap
Split customer records into individual values.

### 6. reduce
Calculated total sales.

### 7. Partitions
Used `getNumPartitions` to inspect the number of partitions.

### 8. Multiple Partitions
Loaded a larger customer file with 4 requested partitions.

## Spark Concepts

- **Transformation:** `map`, `filter`, and `flatMap`
- **Action:** `collect` and `reduce`
- Transformations are **lazy** and are executed when an action is called.
- Partitions allow Spark to process data in parallel.
