import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers._

class HelloSpec extends AnyFlatSpec {

  "Hello.sayHello" should "say hello" in {
    val name = "John"
    name shouldBe "John"
  }
}