object main {
  def main(args: Array[String]): Unit = {

    val arguments = menu.parseArgs(args)
    if (arguments.isEmpty) {
      val arguments2 = menu.parseArgs2(args)
      if (arguments2.isEmpty) {
        println("Error with arguments")
        return
      } else {
        println(ShowIntervals.getIntervals(arguments2.get.initialDate, arguments2.get.endDate, new doOrders().makeOrders()))
        return
      }
    }
    println(ShowIntervals.getIntervalsWithIntervals(arguments.get.initialDate, arguments.get.endDate, arguments.get.interval, new doOrders().makeOrders()))
  }
}
