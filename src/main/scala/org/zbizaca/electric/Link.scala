package org.zbizaca.electric

/**
  * Created by bizacaz on 10/11/16.
  */
case class Link(n1:Node,n2:Node,initialConductivity:Double) {
  var conductivity:Double = initialConductivity

  n1.addLink(this)
  n2.addLink(this)
}
