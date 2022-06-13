import java.time.YearMonth
import scala.util.Try

object menu {

  case class Interval(start: Int, end: Int)

  def parseInterval: String => Try[Seq[Interval]] =
    intervals =>
      Try {
        intervals
          .split(" ")
          .map { interval =>
            val startEnd = interval.split("-").map(_.toInt)
            Interval(startEnd(0), startEnd(1))
          }.toSeq
      }

  case class Arguments(initialDate: YearMonth, endDate: YearMonth, interval: Seq[Interval])

  case class Arguments2(initialDate: YearMonth, endDate: YearMonth)

  def parseArgs(args: Array[String]): Option[Arguments] = {

    val result: Option[Arguments] = (for {
      arg0 <- Try(args(0))
      arg1 <- Try(args(1))
      arg2 <- Try(args(2))
      intervals <- parseInterval(arg2)
    } yield {
      for {
        initalDate <- serialization.YearMonth apply arg0
        endDate <- serialization.YearMonth apply arg1
      } yield {
        Arguments(initalDate, endDate, intervals)
      }
    }).toOption.flatten

    result
  }

  def parseArgs2(args: Array[String]): Option[Arguments2] = {

    val result: Option[Arguments2] = (for {
      arg0 <- Try(args(0))
      arg1 <- Try(args(1))
    } yield {
      for {
        initalDate <- serialization.YearMonth apply arg0
        endDate <- serialization.YearMonth apply arg1
      } yield {
        Arguments2(initalDate, endDate)
      }
    }).toOption.flatten

    result
  }
}
