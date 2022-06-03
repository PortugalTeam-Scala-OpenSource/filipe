package serialization

import java.text.SimpleDateFormat
import scala.util.Try
import java.time.YearMonth.of

object YearMonth {
  def apply(date: String) = {
    Try {
      val df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
      df.setLenient(false)
      val parsed = df.parse(date)
      of(parsed.getYear, parsed.getMonth)
    }.toOption
  }
}
