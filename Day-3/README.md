# Day 3 - Spark Setup and First Application

## Topics Covered

- Spark project setup using sbt
- SparkSession
- SparkContext
- Reading a text file
- Driver
- Executor
- Cluster Manager
- Local mode
- Running Spark with 2 and 4 cores

## Practice

### 1. Spark Project Setup
Created a Scala Spark project using sbt with Spark Core and Spark SQL dependencies.

### 2. SparkSession and SparkContext
Created a SparkSession and accessed the SparkContext from it.

### 3. Reading a Text File
Read `data/sample.txt` using Spark's `textFile()` and displayed its contents using `collect()`.

### 4. Driver, Executor and Cluster Manager

- **Driver:** Coordinates the Spark application.
- **Executor:** Executes tasks and processes data.
- **Cluster Manager:** Provides and manages resources for Spark applications.

### 5. Local Mode

Tested the application using:

- `local[2]` - uses 2 CPU cores
- `local[4]` - uses 4 CPU cores

## Files

- `src/main/scala/SparkSetup.scala`
- `data/sample.txt`
- `build.sbt`


