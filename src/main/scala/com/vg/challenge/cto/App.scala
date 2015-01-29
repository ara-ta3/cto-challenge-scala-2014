package com.vg.challenge.cto

object App extends App {

  def selectOptimalCoupons(amount:Int, myCouponList:List[Int]):List[Int] = {
    var retList = filterUnablableCoupons(amount, myCouponList)
    useCoupons(amount, retList)
  }

  def filterUnablableCoupons(amount:Int, couponList:List[Int]):List[Int] = couponList.filter(_ <= amount)

  def useCoupons(amount:Int, couponList:List[Int]):List[Int] = {
    var sorted:List[Int] = couponList.sorted(Ordering[Int].reverse)
    var rest:Int = amount
    var retCoupons:List[Int] = List()

    while( rest > 0 && !sorted.isEmpty ) {
      var used = sorted.head
      sorted = sorted.tail
      if ( rest - used > 0 ) {
        rest -= used 
        retCoupons = used :: retCoupons
      }
    }

    retCoupons
  }
}
