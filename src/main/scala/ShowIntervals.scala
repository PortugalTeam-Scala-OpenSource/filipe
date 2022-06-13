import ShowOrdersInterval.getOrders
import menu.Interval

import java.time.YearMonth

object ShowIntervals {

  sealed trait MonthsSinceNow

  def totalMonths(date: YearMonth, initalDate: YearMonth): Int = {
    val month = (date.getYear.intValue * 12 + date.getMonth.getValue) - (initalDate.getYear.intValue() * 12 + initalDate.getMonth.getValue)
    month
  }

  def monthsSinceNow(date: YearMonth): Int = {
    val now = YearMonth.now()
    totalMonths(date, now)
  }

  def getIntervalsWithIntervals(initalDate: YearMonth, endDate: YearMonth, intervalsArg: Seq[Interval], list: Seq[Order]): String = {

    val listOrders = getOrders(initalDate, endDate, list)

    val amountOfOrdersPerInterval = listOrders.map(order => totalMonths(order.date, initalDate)).groupBy(identity).map { case (key, value) => (key, value.size) }.toSeq.sorted

    val b: Map[Interval, Int] = amountOfOrdersPerInterval.flatMap { case (monthsSinceInitialDate, amountOfOrders) =>
      intervalsArg.collect {
        case interval@Interval(startDate, endDate)
          if monthsSinceInitialDate >= startDate && monthsSinceInitialDate <= endDate =>
          (interval, amountOfOrders)
      }
    }.groupMapReduce(_._1)(_._2)(_ + _)

    val str = b.toSeq
      .map { case (Interval(startDate, endDate), amount) =>
        startDate + "-" + endDate + ": " + amount
      }.sorted.mkString("\n")

    str
  }

  def getIntervals(initalDate: YearMonth, endDate: YearMonth, list: Seq[Order]): String = {

    val listOrders = getOrders(initalDate, endDate, list)

    case object LessThanOneMonth extends MonthsSinceNow
    case object OneToThreeMonths extends MonthsSinceNow
    case object FourToSixMonths extends MonthsSinceNow
    case object SevenToTwelveMonths extends MonthsSinceNow
    case object MoreThanTwelveMonths extends MonthsSinceNow

    object MonthsSinceNow {
      def apply(order: Order): MonthsSinceNow = {
        val delta = totalMonths(order.date, initalDate)
        delta match {
          case delta if delta < 1 => LessThanOneMonth
          case delta if delta == 1 || delta <= 3 => OneToThreeMonths
          case delta if delta == 4 || delta <= 6 => FourToSixMonths
          case delta if delta == 7 || delta <= 12 => SevenToTwelveMonths
          case delta if delta > 12 => MoreThanTwelveMonths
        }
      }
    }

    val orders: Seq[Order] = listOrders

    val a: Seq[MonthsSinceNow] =
      orders.map(order => MonthsSinceNow.apply(order))

    val b: Map[MonthsSinceNow, Seq[MonthsSinceNow]] = a.groupBy(identity)

    val c: Map[MonthsSinceNow, Int] = b.map {
      case (monthsSinceNow, orders) => (monthsSinceNow, orders.size)
    }

    c.map(obj => {
      obj._1 match {
        case LessThanOneMonth => "<1: " + obj._2
        case OneToThreeMonths => "1-3: " + obj._2
        case FourToSixMonths => "4-6: " + obj._2
        case SevenToTwelveMonths => "7-12: " + obj._2
        case MoreThanTwelveMonths => ">12: " + obj._2
      }
    }).mkString("\n")
  }
}