package org.zbizaca.graph

/**
  * Created by zbizaca on 4/25/16.
  */
class Graph[VD, ED] {
  val vertices: Vertices[VD] = new Vertices[VD]
  val edges: Edges[ED] = new Edges[ED]
}
