import scala.util.{Failure, Success, Try}

object main {
  def main(args: Array[String]): Unit = {

    val result: Try[Unit] = for {
      arg0 <- Try(args(0))
      arg1 <- Try(args(1))
      arg2 <- Try(args(2))
    } yield {
      for {
        initalDate <- serialization.YearMonth apply arg0
        endDate <- serialization.YearMonth apply arg1
        intervals = arg2
      } yield {
        println(ShowIntervals.getIntervalsWithIntervals(initalDate, endDate, intervals, new doOrders().makeOrders()))
      }
    }

    result match {
      case Failure(exception) => {
        val result2: Try[Unit] = for {
          arg0 <- Try(args(0))
          arg1 <- Try(args(1))
        } yield {
          for {
            initalDate <- serialization.YearMonth apply arg0
            endDate <- serialization.YearMonth apply arg1
          } yield {
            println(ShowIntervals.getIntervals(initalDate, endDate, new doOrders().makeOrders()))
          }
        }
        result2 match {
          case Failure(exception) => println(s"Error1: ${exception.getMessage}")
          case Success(value) =>
            if (value.toString != "()") println(s"Value result2: ${value}")
        }
      }
      case Success(value) =>
        if (value.toString != "()") println(s"Value: ${value}")
    }
  }
}
