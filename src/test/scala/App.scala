import org.scalatest.FunSpec
import org.scalatest.Matchers._

import com.vg.challenge.cto.App

class Sample1Spec extends FunSpec {
  describe("App全体") {
    it("仕様1") {
      var actual = App.selectOptimalCoupons(100, List())
      actual should be (List())
    }
    it("仕様2") {
      var actual = App.selectOptimalCoupons(100, List(50,50,100))
      actual should be (List(50))
    }
    it("仕様3") {
      var actual = App.selectOptimalCoupons(470, List(50,50,50,100,100,100,100,100,100,500))
      actual should be (List(50, 100,100,100,100))
    }
    it("仕様4") {
      var actual = App.selectOptimalCoupons(1230, List(50,50,50,50,50,50,100,100,100,100,100,100,500,500))
      actual should be (List(100,100,500,500 ))
    }
  }
}

