package org.zbizaca.electric

import scala.collection.mutable._

/**
  * Created by bizacaz on 10/11/16.
  */
class Node {

  var level: Double = 0.0
  val links: Map[Link,Double] = Map[Link,Double]()

  def addLink(link: Link,connectionLevel:Double) = {
    links += (link -> connectionLevel)
  }



}
