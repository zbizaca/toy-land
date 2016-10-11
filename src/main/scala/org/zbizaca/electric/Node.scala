package org.zbizaca.electric

import scala.collection.mutable.ListBuffer

/**
  * Created by bizacaz on 10/11/16.
  */
class Node {
  var level: Double = 0.0
  val links: ListBuffer[Link] = new ListBuffer[Link]()

  def addLink(link:Link) = {
    links += link
  }
}
