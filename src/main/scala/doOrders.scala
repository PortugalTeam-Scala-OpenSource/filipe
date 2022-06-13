import java.time.YearMonth

class doOrders() {

  def makeOrders(): Seq[Order] = {

    val product: Product = Product("Rtx 3050", "PC", 0.5f, 599.99f, YearMonth.of(2021, 12))
    val item: Item = Item(12.2f, 5.5f, product)

    val product2: Product = Product("Samsung x", "Components", 2.55f, 29.99f, YearMonth.of(2021, 6))
    val item2: Item = Item(10.2f, 51.5f, product2)

    val product3: Product = Product("Corsair Y", "Keyboard", 1.55f, 199.99f, YearMonth.of(2022, 4))
    val item3: Item = Item(10.2f, 51.5f, product3)

    val product4: Product = Product("Dell XPS", "Laptop", 2.55f, 599.99f, YearMonth.of(2022, 12))
    val item4: Item = Item(20.99f, 23.5f, product4)

    val product5: Product = Product("Dell XPS", "Laptop", 2.55f, 599.99f, YearMonth.of(1990, 12))
    val item5: Item = Item(20.99f, 23.5f, product5)

    val order = Order("John",
      123456789,
      "blabla - porto - 4000",
      YearMonth.of(1995, 1),
      List(item5)
    )

    val order1 = Order("John",
      123456789,
      "blabla - porto - 4000",
      YearMonth.of(2022, 1),
      List(item)
    )

    val order2 = Order(
      "Liam",
      123456789,
      "blabla - porto - 4000",
      YearMonth.of(2021, 8),
      List(item2)
    )

    val order3 = Order(
      "Oliver",
      123456789,
      "blabla - porto - 4000",
      YearMonth.of(2022, 2),
      List(item, item2)
    )

    val order4 = Order(
      "Henry",
      123456789,
      "blabla - porto - 4000",
      YearMonth.of(2022, 3),
      List(item, item2)
    )

    val order5 = Order(
      "James",
      123456789,
      "blabla - porto - 4000",
      YearMonth.of(2022, 4),
      List(item2, item)
    )

    val order6 = Order(
      "Elijah",
      123456789,
      "blabla - porto - 4000",
      YearMonth.of(2022, 5),
      List(item, item3)
    )

    val order7 = Order(
      "Noah",
      123456789,
      "blabla - porto - 4000",
      YearMonth.of(2022, 6),
      List(item3)
    )

    val order8 = Order(
      "William",
      123456789,
      "blabla - porto - 4000",
      YearMonth.of(2022, 7),
      List(item2, item3)
    )

    val order9 = Order(
      "Filipe",
      123456789,
      "blabla - porto - 4000",
      YearMonth.of(2022, 8),
      List(item, item2, item3)
    )

    val order10 = Order(
      "Benjamin",
      123456789,
      "blabla - porto - 4000",
      YearMonth.of(2022, 9),
      List(item3, item2)
    )

    val order11 = Order(
      "Lucas",
      123456789,
      "blabla - porto - 4000",
      YearMonth.of(2022, 10),
      List(item3, item)
    )

    val order12 = Order(
      "Theodore",
      123456789,
      "blabla - porto - 4000",
      YearMonth.of(2023, 12),
      List(item4)
    )

    val list = Seq(order, order1, order2, order3, order4, order5, order6, order7, order8, order9, order10, order11, order12)

    list
  }
}
