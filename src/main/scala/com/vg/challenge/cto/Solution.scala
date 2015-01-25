package com.vg.challenge.cto

import scala.math.Ordered

case class Solution (couponList:List[Int]) extends Comparable[Solution] {

  def compareTo(that: Solution) = this.couponList.sum - that.couponList.sum
}
