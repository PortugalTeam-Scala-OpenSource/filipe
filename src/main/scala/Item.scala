import java.util.Date

case class Item(
    shippingFee: Float,
    taxAmount: Float,
    product: Product
) {
  require(
    shippingFee < 0 || taxAmount < 0,
    s"""
       |Error with product with item 
       |${product.name}
       |The value of ${if (shippingFee < 0) s"Shipping fee: $shippingFee"
    else s"Tax amount: $taxAmount"} must be equal or greater than 0
       |
       |""".stripMargin
  )

  val date = product.creationDate
  def cost: Float = BigDecimal(
    product.price + (product.price * (taxAmount / 100)) + shippingFee
  ).setScale(2, BigDecimal.RoundingMode.HALF_UP).toFloat

}
