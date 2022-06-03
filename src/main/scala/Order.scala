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
      (yearMonthOfItem.getYear <= date.getYear && (if (yearMonthOfItem.getYear == date.getYear) yearMonthOfItem.getMonthValue <= date.getMonthValue else true))
    },
    s"""
       |Item creation date must be before order date
       |Error with order: ${customerName}  Date: ${date} ${items}
       |""".stripMargin
  )

  val total: Float = items.map(_.cost).sum

}
