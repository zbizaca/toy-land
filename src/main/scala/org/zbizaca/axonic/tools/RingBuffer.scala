package org.zbizaca.axonic.tools

import scala.collection.mutable.ListBuffer


/**
  * Created by zbizaca on 11/12/16.
  */
case class RingBuffer[T: Manifest](capacity: Int) extends Iterable[T] {
  val buffer: Array[T] = new Array[T](capacity)
  var first = 0
  var length = 0

  def insert(t: T) = {
    buffer((first + length) % capacity) = t
    incrementNext()
  }

  private def incrementNext() = {
    if (length == capacity) {
      first = first + 1
      if (first == capacity)
        first = 0
    } else
      length = length + 1
  }

  override def size = length

  override def toList: List[T] = {
    val builder = new ListBuffer[T]()
    foreach(t => builder.append(t))
    builder.toList
  }


  class ForwardIterator[T](buffer: RingBuffer[T]) extends Iterator[T] {

    var position = buffer.first
    val last = position + buffer.length

    override def hasNext: Boolean = position < last


    override def next(): T = {
      val current = position % buffer.capacity
      position = position + 1
      buffer.buffer(current)
    }
  }


  class BackwardIteraot[T](buffer: RingBuffer[T]) extends Iterator[T] {

    var position = buffer.first + buffer.length - 1


    override def hasNext: Boolean = position >= buffer.first

    override def next(): T = {
      val current = position % buffer.capacity
      position = position - 1
      buffer.buffer(current)
    }
  }

  override def iterator: Iterator[T] = new BackwardIteraot[T](this)

  def forwardIterator: Iterator[T] = new ForwardIterator[T](this)

  def backwardIterator: Iterator[T] = new BackwardIteraot[T](this)


}


