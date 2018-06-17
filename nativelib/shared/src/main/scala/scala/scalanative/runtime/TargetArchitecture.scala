package scala.scalanative
package runtime

import native._

sealed abstract class Bits(count: Int) {
  override def toString = count.toString
}
case object ThirtyTwo extends Bits(32)
case object SixtyFour extends Bits(64)

/**
 * Represents the platform the built code will be run on.
 */
sealed abstract class TargetArchitecture(val bits: Bits,
                                         val isIntel: Boolean,
                                         val id: Int) {
  def is32 = bits == ThirtyTwo
}

object TargetArchitecture {
  case object i386   extends TargetArchitecture(ThirtyTwo, true, 1)
  case object i686   extends TargetArchitecture(ThirtyTwo, true, 2)
  case object x86_64 extends TargetArchitecture(SixtyFour, true, 3)
  case object armv7l extends TargetArchitecture(ThirtyTwo, false, 4)

  val current = Seq(i386, i686, x86_64, armv7l).find(
    _.id == TargetArchitectureNative.__targetArchitecture)
}

@extern
object TargetArchitectureNative {
  @name("scalanative_targetArchitecture")
  def __targetArchitecture(): Int = extern
}