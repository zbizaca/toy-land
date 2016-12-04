package org.zbizaca.axonic.graph


case class StaticGraph(
                        nodes: Map[Long, Node],
                        nodeCapacity: Int
                      ) extends Graph {

  private var modifiedLinks: List[LinkPackage] = List.empty

  override protected def getNode(nodeId: Long): Option[Node] =
    nodes.get(nodeId)

  override protected def markForProcessing(linkPackages: List[LinkPackage]): Unit = synchronized {
    modifiedLinks ++= linkPackages
  }

  private def grapModified(): List[LinkPackage] = synchronized {
    val modified = modifiedLinks
    modifiedLinks = Nil
    modified
  }

  private def processLinksStep(): Int = {

    val modified = grapModified()

    modified.foreach { p =>
      nodes.get(p.nodeId).foreach { node =>
        val list = node.addResult(p.result)
        if (list isEmpty)
          checkResultForCompleteness(p.result)
        else
          markForProcessing(list)
      }
    }

    modifiedLinks.size
  }

  protected def checkResultForCompleteness(result: Result): Unit = {

  }
}
