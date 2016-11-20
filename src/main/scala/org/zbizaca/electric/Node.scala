package org.zbizaca.electric

import org.zbizaca.tools.RingBuffer

import scala.collection.mutable._

/**
  * Created by bizacaz on 10/11/16.
  */
class Node(memoryCapacity: Int) {

  val values = new RingBuffer[(Int, Double)](memoryCapacity)

  val links: Map[Link, Long] = Map.empty

  def addLink(link: Link, linkType: Long) = {
    links += (link -> linkType)
  }

  def addPotetntial(color:Long,value:Double) = {
  }

  def getValue(color:Int):Option[(Int,Double)] =
    values.find(_._1 == color)
}
