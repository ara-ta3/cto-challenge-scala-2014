package com.vg.challenge.cto

object App extends App {

  def selectOptimalCoupons(amount:Int, myCouponList:List[Int]):List[Int] = {
    var retList = filterUnablableCoupons(amount, myCouponList)
    createSolution(retList)
    println(retList)
    List()
  }

  def filterUnablableCoupons(amount:Int, couponList:List[Int]):List[Int] = couponList.filter(_ <= amount)

  def createSolution(couponList:List[Int]):List[Solution] = {
    var ret = List[Solution]()

    List()
  }

  selectOptimalCoupons(100, List())
  selectOptimalCoupons(100, List(50,50,100))
  selectOptimalCoupons(100, List(50,50,50,100,100,100,100,100,100,500))
  selectOptimalCoupons(100, List(50,50,50,50,50,50,100,100,100,100,100,100,500,500))
}
