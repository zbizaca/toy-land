package org.zbizaca.tools


/**
  * Created by zbizaca on 11/12/16.
  */
case class RingBuffer[T: Manifest](capacity: Int) extends Iterable[T] {
  val buffer: Array[T] = new Array[T](capacity)
  var first = 0
  var next = 0

  def insert(t: T) = {
    buffer(next) = t
    incrementNext
  }

  private def incrementNext = {
    next = next + 1
    if (next >= capacity)
      next = 0

    if (first == next) {
      first = next + 1
      if (first >= capacity)
        first = 0
    }
  }

  override def size:Int = {
    if(next >= first)
      next - first
    else
      capacity
  }


  class RingBufferIterator[T](buffer: RingBuffer[T]) extends Iterator[T] {

    var position = buffer.first - 1

    override def hasNext: Boolean = {
      if (buffer.next >= buffer.first)
        position < buffer.next
      else
        position >= buffer.first ||
          position < buffer.next
    }

    override def next(): T = {
      if (position == buffer.capacity - 1)
        position = 0
      else
        position = position + 1

      buffer.buffer(position)
    }
  }

  override def iterator: Iterator[T] = new RingBufferIterator[T](this)
}


