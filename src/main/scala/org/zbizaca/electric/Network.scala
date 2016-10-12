package org.zbizaca.electric

/**
  * Represents a network based on Nodes and Links
  * and an energy propagator
  *
  * Created by zbizaca on 10/12/16.
  */
trait Network {

  def addNode(node: Node): Long

  def addLink(nodeId1: Long,
              nodeId2: Long,
              capacity: Double,
              connectivity1: Double,
              connectivity2: Double)

  def readNode(nodeId:Long):Double
}
