package org.zbizaca.tools

import org.specs2.mutable.Specification

/**
  * Created by zbizaca on 11/12/16.
  */
class RingBufferSpec extends Specification {
  "Ring Buffer " should {

    "start empty" >> {
      val rb = new RingBuffer[Int](3)
      rb.size must_== 0
    }

    "retain stored elements" >> {
      val rb = new RingBuffer[Int](3)
      rb.insert(1)
      rb.insert(1)
      rb.size must_== 2
    }

    "fill up to capacity" >> {
      val rb = new RingBuffer[Int](3)
      rb.insert(1)
      rb.insert(2)
      rb.insert(3)
      rb.size must_== 3

    }

    "fill over the capacity" >> {
      val rb = new RingBuffer[Int](3)
      rb.insert(1)
      rb.insert(2)
      rb.insert(3)
      rb.insert(4)
      rb.size must_== 3

    }

    "fill to the capacity and iterate" >> {
      val rb = new RingBuffer[Int](3)
      rb.insert(1)
      rb.insert(2)
      rb.insert(3)

      rb.buffer.toList must_== List(1, 2, 3)

    }

    "fill over the capacity and iterate" >> {
      val rb = new RingBuffer[Int](3)
      rb.insert(1)
      rb.insert(2)
      rb.insert(3)
      rb.insert(4)

      rb.buffer.toList must_== List(2, 3, 4)

    }
  }
}