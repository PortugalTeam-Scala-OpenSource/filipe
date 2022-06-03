package serialization

import java.time.YearMonth.of
import scala.util.Try

object YearMonth {
  def apply(date: String) = {
    Try {
      val year = date.split("-")(0).toInt
      val month = date.split("-")(1).toInt

      of(year, month)
    }.toOption
  }
}
