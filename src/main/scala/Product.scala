import java.time.YearMonth

case class Product(
                    name: String,
                    category: String,
                    weight: Float,
                    price: Float,
                    creationDate: YearMonth
                  ) {

/*  if (name.isEmpty) println("is empty")
  if (name.isBlank) println("name blankc")
  if (category.isBlank) println("Category")
  if (category.isEmpty) println("Category empty")
  if (weight <= 0f) println("weight")
  if (price <= 0f) println("price")

  println(name, category, weight, price, creationDate)*/

  require(
    name.nonEmpty || !name.isBlank || !category.isBlank || category.nonEmpty || weight > 0.00f || price > 0.00f,
    s"Wrong  fields input for product $name Date: $creationDate "
  )

}
