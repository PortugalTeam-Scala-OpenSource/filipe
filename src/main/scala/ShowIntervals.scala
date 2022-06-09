import menu.Interval
import ShowOrdersInterval.getOrders

import java.time.YearMonth
import java.util
import java.util.regex.Pattern
import scala.util.Try

object ShowIntervals {

  sealed trait MonthsSinceNow

  def totalMonths(date: YearMonth, initalDate: YearMonth): Int = {
    val month = ((date.getYear.intValue * 12 + date.getMonth.getValue) - (initalDate.getYear.intValue() * 12 + initalDate.getMonth.getValue))
    //        println("Order: " + date + " - IniDate: " + initalDate + " Diference: " + month)
    month
  }

  def getIntervalsWithIntervals(initalDate: YearMonth, endDate: YearMonth, intervalsArg: Seq[Interval], list: Seq[Order]): String = {

    val listOrders = getOrders(initalDate, endDate, list)





    "ola"
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

    /*        c.toSeq.sortBy {
              case (monthsSinceNow, orders) => monthsSinceNow.toString
            }*/

    c.map(obj => {
      obj._1 match {
        case LessThanOneMonth => ("<1: " + obj._2)
        case OneToThreeMonths => ("1-3: " + obj._2)
        case FourToSixMonths => ("4-6: " + obj._2)
        case SevenToTwelveMonths => ("7-12: " + obj._2)
        case MoreThanTwelveMonths => (">12: " + obj._2)
      }
    }).mkString("\n")
  }

}
