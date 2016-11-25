package org.zbizaca.electric

/**
  * Represents a network based on Nodes and Links
  * and an energy propagator
  *
  * Created by zbizaca on 10/12/16.
  */
trait Network {

  def addPotential(nodeId: Long, potential:Result) = {
    getNode(nodeId).map { node =>
      node.addResult(potential)
    }
  }

  protected def getNode(modeId: Long): Option[Node] = None

  protected def processLink(linkId: Long, potential: Result)
}


case class StaticNetwork(
                          nodes: scala.collection.mutable.Map[Long, Node],
                          links: scala.collection.mutable.Map[Long, Link],
                          modifiedLinks: collection.mutable.Stack[Long],
                          modifiedNodes: collection.mutable.Stack[Long],
                          nodeCapacity: Int
                        ) extends Network {

  override protected def getNode(nodeId: Long): Option[Node] =
    nodes.get(nodeId)

  override protected def processLink(linkId: Long, potential: Result): Unit = {

  }
}
