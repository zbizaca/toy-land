package org.zbizaca.tools

import org.specs2.mutable.Specification

/**
  * Created by zbizaca on 11/19/16.
  */
class ColorSpec extends Specification{

  "Color operations" should {
    "extract id" >> {
      val color = 0x07ABCDABCDABCDEFL

      val id = Color.getId( color)
      id must_== 7
    }
    "extract type bits" >> {
      val color = 0x07ABCDABCDABCDEFL

      val bits = Color.getTypeBits(color)

      bits must_== 0x00ABCDABCDABCDEFL
    }
  }

}
