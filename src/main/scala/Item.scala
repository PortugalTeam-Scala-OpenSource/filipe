import java.time.YearMonth

case class Item(
                 shippingFee: Float,
                 taxAmount: Float,
                 product: Product
               ) {
  require(
    shippingFee >= 0f || taxAmount >= 0f,
    s"""
       |Error with product with item 
       |${product.name}
       |The value of ${
      if (shippingFee < 0f) s"Shipping fee: $shippingFee"
      else s"Tax amount: $taxAmount"
    } must be equal or greater than 0
       |
       |""".stripMargin
  )

  val date: YearMonth = product.creationDate

  def cost: Float = BigDecimal(
    product.price + (product.price * (taxAmount / 100)) + shippingFee
  ).setScale(2, BigDecimal.RoundingMode.HALF_UP).toFloat
}
