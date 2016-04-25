package org.zbizaca.environment

/**
  * Created by zbizaca on 4/24/16.
  */
trait SingleStepGenerator {
  def dimension(): Int
  def generate():Array[Double]
}
