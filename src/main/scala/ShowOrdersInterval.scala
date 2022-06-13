import java.time.YearMonth

object ShowOrdersInterval {

  def getOrders(initialDate: YearMonth, endDate: YearMonth, listOrders: Seq[Order]): Seq[Order] = listOrders.filter {
    order: Order =>
      val auxIni: Boolean = ((order.date.getYear.intValue * 12 + order.date.getMonth.getValue) - (initialDate.getYear.intValue() * 12 + initialDate.getMonth.getValue)) >= 0
      val auxEnd: Boolean = ((order.date.getYear.intValue * 12 + order.date.getMonth.getValue) - (endDate.getYear.intValue() * 12 + endDate.getMonth.getValue)) <= 0

      if (auxIni && auxEnd)
        true
      else
        false
  }
}
