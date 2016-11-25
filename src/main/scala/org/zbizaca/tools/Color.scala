package org.zbizaca.tools

/**
  * Created by zbizaca on 11/19/16.
  */
object Color {
  final val QUERY_ID_BITS: Long = 0xFF00000000000000L
  final val QUERY_ID_SHIFT: Int = 64 - 8
  final val HIT_ID_BITS: Long = 0x00FF000000000000L
  final val HIT_ID_SHIFT: Int = QUERY_ID_SHIFT - 8
  final val ID_BITS: Long = QUERY_ID_BITS | HIT_ID_BITS

  final val LINK_TYPE_BITS = 0x0000FFFFFFFFFFFFL

  def apply(queryId: Byte, hitId: Byte, typeBits: Long): Long =
    (queryId.toLong << QUERY_ID_SHIFT) |
      (hitId.toLong << HIT_ID_SHIFT) |
      typeBits & LINK_TYPE_BITS

  def getQueryId(color: Long): Byte = (color >>> QUERY_ID_SHIFT).toByte

  def getHitId(color: Long): Byte = ((color & HIT_ID_BITS) >>> HIT_ID_SHIFT).toByte

  def getId(color: Long): Int = (color >>> HIT_ID_SHIFT).toInt

  def getLinkTypeBits(color: Long): Long = LINK_TYPE_BITS & color


}
