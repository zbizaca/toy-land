package org.zbizaca.electric

/**
  * Created by bizacaz on 10/11/16.
  */
case class Link(n1: Node, n2: Node, linkType: Double, initialConductivity: Double = 1.0) {
  var conductivity: Double = initialConductivity

  n1.addLink(this, initialConductivity)
  n2.addLink(this, initialConductivity)
}
