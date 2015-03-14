package com.vg.cto

object Challenge extends App {

  def selectOptimalCoupons(amount:Int, myCouponList:List[Int]):List[Int] = useCoupons(amount, filterUnusableCoupons(amount, myCouponList))

  def filterUnusableCoupons(amount:Int, couponList:List[Int]):List[Int] = couponList.filter(_ <= amount)

  def useCoupons(amount:Int, couponList:List[Int]):List[Int] = use(amount, couponList.sorted(Ordering[Int].reverse), List())

  private def use(rest:Int, sorted:List[Int], usedCoupons:List[Int]):List[Int] = {
    if (rest <= 0 || sorted.isEmpty) usedCoupons
    else {
      val used:Int = sorted.head
      if (rest - used >= 0) use(rest - used , sorted.tail, used :: usedCoupons)
      else use(rest, sorted.tail, usedCoupons)
    }
  }
}
