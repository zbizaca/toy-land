package org.zbizaca.electric

/**
  * Propagates energy accros a link.
  *
  * Created by zbizaca on 10/12/16.
  */
trait EnergyPropagator {
  /**
    * Propagates energy accross a link
    *
    * @param link
    * @return true if any enrgy was tranvered
    */
  def propagate(link: Link): Boolean

}
