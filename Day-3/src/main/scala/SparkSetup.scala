import org.apache.spark.sql.SparkSession

object SparkSetup {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder()
      .appName("Day 3 Spark Setup")
      .master("local[4]")
      .getOrCreate()

    val sc = spark.sparkContext

    println("Spark Application Started")
    println("Spark Version: " + spark.version)
    println("Spark Master: " + sc.master)

    val lines = sc.textFile("data/sample.txt")

    println("File Contents:")
    lines.collect().foreach(println)

    spark.stop()
  }
}
