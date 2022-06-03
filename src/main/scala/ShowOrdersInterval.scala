import java.time.YearMonth

object ShowOrdersInterval {

  def getOrders(
      initialDate: YearMonth,
      endDate: YearMonth,
      listOrders: Seq[Order]
  ): Seq[Order] =
    listOrders.filter(order =>
      order.date.getYear >= initialDate.getYear
        && order.date.getMonthValue >= initialDate.getMonthValue
        && order.date.getYear <= endDate.getYear
        && order.date.getMonthValue <= endDate.getMonthValue
    )
}
