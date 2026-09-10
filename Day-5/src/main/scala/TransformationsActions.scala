import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object TransformationsActions {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf()
      .setAppName("Day 5 Transformations and Actions")
      .setMaster("local[2]")

    val sc = new SparkContext(conf)

    println("=== Day 5: Transformations and Actions ===")

    // 1. Create an RDD
    val numbers = sc.parallelize(List(10, 20, 30, 40, 50))

    // 2. map transformation
    val doubled = numbers.map(x => x * 2)

    println("\nMap - Doubled numbers:")
    doubled.collect().foreach(println)

// 3. filter transformation
val evenNumbers = numbers.filter(x => x % 2 == 0)

println("\nFilter - Even numbers:")
evenNumbers.collect().foreach(println)

// 4. flatMap transformation
val words = sc.parallelize(List("Spark is fast", "Scala is powerful"))

val splitWords = words.flatMap(line => line.split(" "))

println("\nFlatMap - Individual words:")
splitWords.collect().foreach(println)

// 5. distinct transformation
val duplicateNumbers = sc.parallelize(List(10, 20, 20, 30, 30, 30, 40))

println("\nDistinct - Unique numbers:")
duplicateNumbers.collect().distinct.sorted.foreach(println)


// 6. union transformation
val firstSet = sc.parallelize(List(1, 2, 3))
val secondSet = sc.parallelize(List(4, 5, 6))

val combined = firstSet.union(secondSet)

println("\nUnion - Combined numbers:")
combined.collect().foreach(println)

// 7. Spark actions

println("\nCount:")
println(numbers.count())

println("\nFirst:")
println(numbers.first())

println("\nTake first 3:")
numbers.take(3).foreach(println)

println("\nReduce - Total:")
println(numbers.reduce((a, b) => a + b))

// 8. Lazy evaluation
println("\nLazy Evaluation:")

val lazyRDD = numbers.map { x =>
  println(s"Processing: $x")
  x * 10
}

println("Transformation created - nothing processed yet.")

println("Now calling an action:")
lazyRDD.collect().foreach(println)


// 9. Log Analyzer - Count ERROR messages
val logs = sc.textFile("data/app.log")

val errorLogs = logs.filter(line => line.startsWith("ERROR"))

println("\nERROR log count:")
println(errorLogs.count())


// 10. Log Analyzer - Count WARN messages
val warnLogs = logs.filter(line => line.startsWith("WARN"))

println("\nWARN log count:")
println(warnLogs.count())

// 11. Log Analyzer - Display ERROR messages
println("\nERROR logs:")
errorLogs.collect().foreach(println)

// 12. Log Analyzer - Count all log levels
val infoCount = logs.filter(line => line.startsWith("INFO")).count()
val errorCount = logs.filter(line => line.startsWith("ERROR")).count()
val warnCount = logs.filter(line => line.startsWith("WARN")).count()

println("\nLog Summary:")
println(s"INFO: $infoCount")
println(s"WARN: $warnCount")
println(s"ERROR: $errorCount")

     sc.stop()
  }
}
