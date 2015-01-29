package com.vg.challenge.cto

object App extends App {

  def selectOptimalCoupons(amount:Int, myCouponList:List[Int]):List[Int] = {
    var retList = filterUnablableCoupons(amount, myCouponList)
    retList = useCoupons(amount, retList)
    println(retList)
    retList
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

  selectOptimalCoupons(100, List())
  selectOptimalCoupons(100, List(50,50,100))
  selectOptimalCoupons(470, List(50,50,50,100,100,100,100,100,100,500))
  selectOptimalCoupons(1230, List(50,50,50,50,50,50,100,100,100,100,100,100,500,500))
}
