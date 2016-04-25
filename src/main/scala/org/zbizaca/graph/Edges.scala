package org.zbizaca.graph

import scala.collection.mutable
import scala.collection.mutable._

/**
  * Created by zbizaca on 4/25/16.
  */
class Edges[ED] {
  class Edge( val sourceId:Long,val destId:Long ) {

  }

  val data : Map[Long,Edge] = new mutable.LinkedHashMap[Long,Edge]()
}
