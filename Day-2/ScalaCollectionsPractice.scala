object ScalaCollectionsPractice extends App {

  // 1. List - map
  val sales = List(100, 200, 150, 300, 250)

  val updatedSales = sales.map(x => x + 50)
  println("Updated Sales: " + updatedSales)

  // 2. List - filter
  val highSales = sales.filter(x => x > 200)
  println("High Sales: " + highSales)

  // 3. List - flatMap
  val products = List(
    List("Laptop", "Mouse"),
    List("Phone", "Charger"),
    List("Keyboard")
  )

  val allProducts = products.flatMap(x => x)
  println("All Products: " + allProducts)

  // 4. List - reduce
  val totalSales = sales.reduce((a, b) => a + b)
  println("Total Sales: " + totalSales)

  // 5. Vector
  val customers = Vector("Maha", "Priya", "Rahul")
  println("Customer at index 1: " + customers(1))

  // 6. Map - product prices and quantities
  val prices = Map(
    "Laptop" -> 50000,
    "Phone" -> 20000,
    "Mouse" -> 500
  )

  val quantities = Map(
    "Laptop" -> 2,
    "Phone" -> 3,
    "Mouse" -> 5
  )

  val total = prices.map {
    case (product, price) => price * quantities(product)
  }.sum

  println("Total Product Value: " + total)

  // 7. For-comprehension
  val orders = List("Laptop", "Phone", "Mouse")

  val combinations = for {
    customer <- customers
    order <- orders
  } yield (customer, order)

  println("Customer-Order Combinations: " + combinations)

  // 8. Daily Sales Summary
  println("\nDaily Sales Summary")
  println("Total Sales: " + totalSales)
  println("Number of Sales: " + sales.length)
  println("Sales Above 200: " + highSales)
}
