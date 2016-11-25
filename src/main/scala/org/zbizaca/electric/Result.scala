package org.zbizaca.electric

import org.zbizaca.tools.Color

/**
  * Created by zbizaca on 11/24/16.
  */
case class Result(color: Long, nodeId: Long, score: Double) {

  def isCompatible(other: Result): Boolean =
    (Color.getLinkTypeBits(this.color) & Color.getLinkTypeBits(other.color)) != 0

  def getId: Int = Color.getHitId(color)

  def getQueryId: Byte = Color.getQueryId(color)
}
