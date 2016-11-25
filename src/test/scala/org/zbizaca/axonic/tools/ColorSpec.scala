package org.zbizaca.axonic.tools

import org.specs2.mutable.Specification

/**
  * Created by zbizaca on 11/19/16.
  */
class ColorSpec extends Specification {

  "Color operations" should {

    "create color from parts" >> {
      val color = 0x070BCDABCDABCDEFL

      val queryId = Color.getQueryId(color)
      val hitId = Color.getHitId(color)
      val typeBits = Color.getLinkTypeBits(color)

      Color(queryId, hitId, typeBits) must_== color
    }


    "extract Query ID" >> {
      val color = 0x07ABCDABCDABCDEFL

      val id = Color.getQueryId(color)
      id must_== 7
    }

    "extract Hit ID" >> {
      val color = 0x070ACDABCDABCDEFL

      val id = Color.getHitId(color)
      id must_== 10
    }

    "extract the total ID" >> {
      val color = 0x070ACDABCDABCDEFL

      val id = Color.getId(color)
      id must_== 0x070A
    }

    "extract type bits" >> {
      val color = 0x07ABCDABCDABCDEFL

      val bits = Color.getLinkTypeBits(color)

      bits must_== 0x0000CDABCDABCDEFL
    }
  }

}
