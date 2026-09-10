import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

object RDDCreation {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf()
      .setAppName("Day 4 RDD Creation")
      .setMaster("local[2]")

    val sc = new SparkContext(conf)

    println("=== Day 4: RDD Creation ===")

    // 1. Create RDD from a Scala collection
    val numbers = sc.parallelize(List(10, 20, 30, 40, 50))

    println("\nRDD from Collection:")
    numbers.collect().foreach(println)

    // 2. Create RDD from a text file
    val customers = sc.textFile("data/customers.txt")

    println("\nRDD from Text File:")
    customers.collect().foreach(println)

    // 3. map transformation
    val doubledNumbers = numbers.map(x => x * 2)

    println("\nRDD after map (doubled):")
    doubledNumbers.collect().foreach(println)

// 4. filter transformation
val evenNumbers = numbers.filter(x => x % 2 == 0)

println("\nRDD after filter (even numbers):")
evenNumbers.collect().foreach(println)

// 5. flatMap transformation
val customerNames = customers.flatMap(line => line.split(","))

println("\nRDD after flatMap:")
customerNames.collect().foreach(println)

// 6. Calculate total sales using reduce
val sales = sc.parallelize(List(100, 200, 300, 400, 500))

val totalSales = sales.reduce((a, b) => a + b)

println("\nTotal Sales:")
println(totalSales)

// 7. Inspect RDD partitions
println("\nNumber of partitions:")
println(s"Numbers RDD: ${numbers.getNumPartitions}")
println(s"Customers RDD: ${customers.getNumPartitions}")
println(s"Sales RDD: ${sales.getNumPartitions}")

println("\nDefault Parallelism:")
println(sc.defaultParallelism)

// 8. Large customer file with multiple partitions
val largeCustomers = sc.textFile("data/customers_large.txt", 4)

println("\nLarge Customer RDD:")
largeCustomers.collect().foreach(println)

println("\nLarge Customer RDD partitions:")
println(largeCustomers.getNumPartitions)
    sc.stop()
  }
}
