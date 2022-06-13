import java.time.YearMonth

case class Product(
                    name: String,
                    category: String,
                    weight: Float,
                    price: Float,
                    creationDate: YearMonth
                  ) {
  require(
    name.nonEmpty || !name.isBlank || !category.isBlank || category.nonEmpty || weight > 0.00f || price > 0.00f,
    s"Wrong  fields input for product $name Date: $creationDate "
  )
}
