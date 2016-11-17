package org.zbizaca.electric

import org.specs2.mutable.Specification

/**
  * Created by bizacaz on 10/11/16.
  */
class LinkSpec extends Specification {

  "Build wireing from Nodes and Links" should {

    "Connect Links and Nodes" >> {

      val n1 = new Node(5)
      val n2 = new Node(5)
      val link = new Link(n1, n2, 1.0)

      link.n1 must_== n1
      link.n2 must_== n2
      n1.links.isDefinedAt(link) must beTrue
      n2.links.isDefinedAt(link) must beTrue
    }

    "Propage energy through the link" >> {

      val n1 = new Node(3)
      val n2 = new Node(3)
      val link = new Link(n1, n2, 1.0)

      1 must_== 1
    }
  }

}
