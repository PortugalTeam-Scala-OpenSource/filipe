import java.time.YearMonth

case class Order(
                  customerName: String,
                  contact: Int,
                  shippingAddress: String,
                  date: YearMonth,
                  items: List[Item]
                ) {
  require(
    items.forall { item =>
      val yearMonthOfItem = YearMonth.of(item.date.getYear, item.date.getMonth)
      yearMonthOfItem.getYear <= date.getYear && (if (yearMonthOfItem.getYear == date.getYear) yearMonthOfItem.getMonthValue <= date.getMonthValue else true)
    },
    s"\nItem creation date must be before order date\nError with order: $customerName  Date: $date $items\n"
  )
  val total: Float = items.map(_.cost).sum
}
