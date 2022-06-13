package serialization

import java.time.YearMonth
import java.time.YearMonth.of
import scala.util.Try

object YearMonth {
  def apply(date: String): Option[YearMonth] = {
    Try {
      val year = date.split("-")(0).toInt
      val month = date.split("-")(1).toInt

      of(year, month)
    }.toOption
  }
}
