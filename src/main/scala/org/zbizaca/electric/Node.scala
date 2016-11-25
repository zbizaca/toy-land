package org.zbizaca.electric

import org.zbizaca.tools.{Color, RingBuffer}

import scala.collection.mutable._

/**
  * Created by bizacaz on 10/11/16.
  */
class Node(memoryCapacity: Int) {

  val results = new RingBuffer[Result](memoryCapacity)

  val links: Map[Long, LinkConnector] = Map.empty

  def addLink(linkId: Long, linkConnector: LinkConnector): Unit = {
    links += (linkId -> linkConnector)
  }

  def addResult(result: Result): List[Long] = {
    results.find(r => r == result) match {
      case _ : Some[Result] => List()
      case _ =>
        results.insert(result)
        List()
    }
  }

  def getValue(color: Long): Option[Result] =
    results.find(_.color == color)
}
