package org.zbizaca.environment

import scala.util.Random

/**
  * Created by zbizaca on 4/24/16.
  */
class NoiselessOperation(dim: Int, op: (Array[Double]) => Double) extends SingleStepGenerator {
  val inputs = Array.fill[Double](dim) {
    Random.nextDouble()
  }
  val this.op = op

  override def dimension(): Int = dim

  override def generate(): Array[Double] = {
    inputs(dim - 1) = op(inputs)
    inputs
  }
}
