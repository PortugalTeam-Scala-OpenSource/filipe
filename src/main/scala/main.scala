import scala.util.{Failure, Success, Try}

object main {
  def main(args: Array[String]): Unit = {

    val result: Try[Unit] = for {
      arg0 <- Try(args(0))
      arg1 <- Try(args(1))
    } yield {
      for {
        initalDate <- serialization.YearMonth apply arg0
        endDate <- serialization.YearMonth apply arg1
      } yield {
        println(ShowIntervals.getIntervals(initalDate, new doOrders().makeOrders()))
      }
    }

    result match {
      case Failure(exception) => println(s"Error: ${exception.getMessage}")
      case Success(value) =>
        if (value.toString != "()") println(s"Value: ${value}")
    }
  }
}
