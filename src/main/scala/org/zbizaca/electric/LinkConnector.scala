package org.zbizaca.electric

/**
  * Created by zbizaca on 11/24/16.
  */
case class LinkConnector(likType: Long, capacity: Double) {
  def isCompatible(typeBits: Long): Boolean =
    (typeBits & likType) != 0
}
