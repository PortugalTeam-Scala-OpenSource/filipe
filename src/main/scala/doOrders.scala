import java.time.YearMonth

class doOrders() {

  def makeOrders(): Seq[Order] = {

    val product: Product =
      new Product("Rtx 3050", "PC", 0.5f, 599.99f, YearMonth.of(2021, 12))
    val item: Item = new Item(12.2f, 5.5f, product)

    val product2: Product = new Product(
      "Samsung x",
      "Components",
      2.55f,
      29.99f,
      YearMonth.of(2021, 6)
    )
    val item2: Item = new Item(10.2f, 51.5f, product2)

    val product3: Product = new Product(
      "Corsair Y",
      "Keyboard",
      1.55f,
      199.99f,
      YearMonth.of(2022, 4)
    )
    val item3: Item = new Item(10.2f, 51.5f, product3)

    val product4: Product =
      new Product("Dell XPS", "Laptop", 2.55f, 599.99f, YearMonth.of(2022, 12))
    val item4: Item = new Item(20.99f, 23.5f, product4)

    val order1 = Order(
      "John",
      123456789,
      "blabla - porto - 4000",
      YearMonth.of(2022, 1),
      List(item)
    )
    val order2 = Order(
      "Liam",
      123456789,
      "blabla - porto - 4000",
      YearMonth.of(2021, 1),
      List(item2)
    )
    val order3 = Order(
      "Oliver",
      123456789,
      "blabla - porto - 4000",
      YearMonth.of(2021, 2),
      List(item, item2)
    )
    val order4 = Order(
      "Henry",
      123456789,
      "blabla - porto - 4000",
      YearMonth.of(2021, 3),
      List(item, item2)
    )
    val order5 = Order(
      "James",
      123456789,
      "blabla - porto - 4000",
      YearMonth.of(2021, 4),
      List(item2, item)
    )
    val order6 = Order(
      "Elijah",
      123456789,
      "blabla - porto - 4000",
      YearMonth.of(2021, 5),
      List(item, item3)
    )
    val order7 = Order(
      "Noah",
      123456789,
      "blabla - porto - 4000",
      YearMonth.of(2021, 6),
      List(item3)
    )
    val order8 = Order(
      "William",
      123456789,
      "blabla - porto - 4000",
      YearMonth.of(2021, 7),
      List(item2, item3)
    )
    val order9 = Order(
      "Filipe",
      123456789,
      "blabla - porto - 4000",
      YearMonth.of(2021, 8),
      List(item, item2, item3)
    )
    val order10 = Order(
      "Benjamin",
      123456789,
      "blabla - porto - 4000",
      YearMonth.of(2021, 9),
      List(item3, item2)
    )
    val order11 = Order(
      "Lucas",
      123456789,
      "blabla - porto - 4000",
      YearMonth.of(2021, 10),
      List(item3, item)
    )
    val order12 = Order(
      "Theodore",
      123456789,
      "blabla - porto - 4000",
      YearMonth.of(2021, 11),
      List(item4)
    )

    Seq(
      order1,
      order2,
      order3,
      order4,
      order5,
      order6,
      order7,
      order8,
      order9,
      order10,
      order11,
      order12
    )
  }
}
