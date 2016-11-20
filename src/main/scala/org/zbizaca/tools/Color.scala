package org.zbizaca.tools

/**
  * Created by zbizaca on 11/19/16.
  */
object Color {
  final val ID_BITS: Long = 0xFF00000000000000L
  final val TYPE_BITS = 0x00FFFFFFFFFFFFFFL

  def apply(id:Byte,typeBits:Long):Long =
    (id.toLong << 56) & typeBits & TYPE_BITS

  def getId(color: Long): Byte = (color >>> 56).toByte

  def getTypeBits(color: Long): Long = TYPE_BITS & color


}
