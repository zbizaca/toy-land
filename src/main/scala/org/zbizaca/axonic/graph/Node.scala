package org.zbizaca.axonic.graph

import org.zbizaca.axonic.tools.RingBuffer

import scala.collection.mutable._

/**
  * Created by bizacaz on 10/11/16.
  */
class Node(memoryCapacity: Int) {

  val results = new RingBuffer[Result](memoryCapacity)

  val links: Map[Long, Long] = Map.empty

  def addLink(linkId: Long, linkType: Long): Unit = {
    links += (linkId -> linkType)
  }

  def addResult(result: Result): List[Long] = {
    results.find(r => r == result) match {
      case _: Some[Result] => List()
      case _ =>
        results.insert(result)
        links
          .filter(link => result.isCompatible(link._2))
          .keys.toList
    }
  }

  def getValue(color: Long): Option[Result] =
    results.find(_.color == color)
}
