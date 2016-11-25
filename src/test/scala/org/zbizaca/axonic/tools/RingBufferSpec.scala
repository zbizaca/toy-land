package org.zbizaca.axonic.tools

import org.specs2.mutable.Specification

/**
  * Created by zbizaca on 11/12/16.
  */
class RingBufferSpec extends Specification {
  "Ring Buffer " should {

    "start empty" >> {
      val rb = new RingBuffer[Int](3)
      rb.length must_== 0
    }

    "retain stored elements" >> {
      val rb = new RingBuffer[Int](3)
      rb.insert(1)
      rb.insert(1)
      rb.length must_== 2
    }

    "fill up to capacity" >> {
      val rb = new RingBuffer[Int](3)
      rb.insert(1)
      rb.insert(2)
      rb.insert(3)
      rb.length must_== 3

    }

    "fill over the capacity" >> {
      val rb = new RingBuffer[Int](3)
      rb.insert(1)
      rb.insert(2)
      rb.insert(3)
      rb.insert(4)
      rb.length must_== 3

    }

    "fill to the capacity and iterate" >> {
      val rb = new RingBuffer[Int](3)
      rb.insert(1)
      rb.insert(2)
      rb.insert(3)

      rb.toList must_== List(3, 2, 1)

    }

    "fill over the capacity and iterate" >> {
      val rb = new RingBuffer[Int](3)
      rb.insert(1)
      rb.insert(2)
      rb.insert(3)
      rb.insert(4)
      rb.insert(5)

      rb.toList must_== List(5, 4, 3)

    }
  }
}