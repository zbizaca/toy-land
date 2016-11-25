package org.zbizaca.axonic.graph

import org.zbizaca.axonic.tools.Color

/**
  * Created by zbizaca on 11/24/16.
  */
case class Result(color: Long, nodeId: Long, score: Double) {

  def isCompatible(linkType:Long):Boolean =
    (color & linkType) == linkType

  def getId: Int = Color.getHitId(color)

  def getQueryId: Byte = Color.getQueryId(color)
}
