import org.scalatest.FunSpec
import org.scalatest.Matchers._

import com.vg.cto.Challenge
import org.scalatest.prop.TableDrivenPropertyChecks

class ChallengeSpec extends FunSpec with TableDrivenPropertyChecks {
  val Cases = Table(
    ("Amount", "CouponList", "Expected"),
    (100,List(), List()),
    (100,List(50,50,100), List(100)),
    (470,List(50,50,50,100,100,100,100,100,100,500), List(50,100,100,100,100)),
    (1230,List(50,50,50,50,50,50,100,100,100,100,100,100,500,500), List(100,100,500,500))
  )
  describe("App全体") {
    forAll(Cases) { (amount:Int, coupons:List[Int], expected:List[Int]) =>
      it("仕様" + amount + " " + coupons + " " + expected) {
        var actual = Challenge.selectOptimalCoupons(amount, coupons)
        actual should be (expected)
      }
    }
  }
}

