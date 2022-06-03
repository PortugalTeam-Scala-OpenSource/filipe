import java.text.SimpleDateFormat
import java.time.YearMonth

case class Product(
    name: String,
    category: String,
    weight: Float,
    price: Float,
    creationDate: YearMonth
) {

  require(
    name.isEmpty || name.isBlank || category.isBlank || category.isBlank || weight <= 0 || price <= 0,
    s"Wrong  fields input for product $name "
  )

}
