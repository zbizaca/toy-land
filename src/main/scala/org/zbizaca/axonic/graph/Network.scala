package org.zbizaca.axonic.graph

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
