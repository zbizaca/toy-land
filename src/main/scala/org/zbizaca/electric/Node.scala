package org.zbizaca.electric

import org.zbizaca.tools.RingBuffer

import scala.collection.mutable._

/**
  * Created by bizacaz on 10/11/16.
  */
class Node(capacity:Int) {

  val values = new RingBuffer[(Double,Double)](capacity)

  val links: Map[Link,Double] = Map[Link,Double]()

  def addLink(link: Link,connectionLevel:Double) = {
    links += (link -> connectionLevel)
  }



}
