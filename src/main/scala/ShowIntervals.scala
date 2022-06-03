import java.time.YearMonth

object ShowIntervals {

  sealed trait MonthsSinceNow

  def getIntervals(initalDate: YearMonth, listOrders: Seq[Order]): String = {

    case object LessThanOneMonth extends MonthsSinceNow
    case object OneToThreeMonths extends MonthsSinceNow
    case object FourToSixMonths extends MonthsSinceNow
    case object SevenToTwelveMonths extends MonthsSinceNow
    case object MoreThanTwelveMonths extends MonthsSinceNow

    object MonthsSinceNow {
      def totalMonths(date: YearMonth): Int = {
        date.getYear * 12 + date.getMonthValue
      }

      def apply(order: Order): MonthsSinceNow = {
        val delta = totalMonths(order.date)
        delta match {
          case delta if delta < 1                 => LessThanOneMonth
          case delta if delta == 1 || delta <= 3  => OneToThreeMonths
          case delta if delta == 4 || delta <= 6  => FourToSixMonths
          case delta if delta == 7 || delta <= 12 => SevenToTwelveMonths
          case delta if delta > 12                => MoreThanTwelveMonths
        }
      }
    }

    val orders: Seq[Order] = listOrders

    val a: Seq[MonthsSinceNow] =
      orders.map(order => MonthsSinceNow.apply(order))

    val b: Map[MonthsSinceNow, Seq[MonthsSinceNow]] = a.groupBy(identity)

    val c: Map[MonthsSinceNow, Int] = b.map { case (monthsSinceNow, orders) =>
      (monthsSinceNow, orders.size)
    }

    c.map(obj => {
      obj._1 match {
        case LessThanOneMonth     => ("<1: " + obj._2)
        case OneToThreeMonths     => ("1-3: " + obj._2)
        case FourToSixMonths      => ("4-6: " + obj._2)
        case SevenToTwelveMonths  => ("7-12: " + obj._2)
        case MoreThanTwelveMonths => (">12: " + obj._2)
      }
    }).mkString("\n")
  }

}
