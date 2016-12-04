package org.zbizaca.axonic.graph

/**
  * Represents a network based on Nodes and Links
  * and an energy propagator
  *
  * Created by zbizaca on 10/12/16.
  */
trait Graph {


  def addResult(nodeId: Long, result: Result): Boolean = {
    getNode(nodeId) match {
      case Some(node: Node) =>
        markForProcessing(node.addResult(result))
        true
      case _ => false
    }
  }


  protected def getNode(modeId: Long): Option[Node] = None

  protected def markForProcessing(linkPackages: List[LinkPackage])
}
