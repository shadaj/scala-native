// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 1)
package scala.scalanative
package runtime

import scala.scalanative.native.{
  CBool,
  CChar,
  CInt,
  CLongLong,
  CShort,
  CSize,
  CUnsignedChar,
  CUnsignedInt,
  CUnsignedLong,
  CUnsignedShort,
  Ptr,
  extern
}

// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 32)

// see http://en.cppreference.com/w/cpp/atomic

@extern
object Atomic {

  // Memory
  def alloc(sz: CSize): Ptr[Byte] = extern

  def free(ptr: Ptr[Byte]): Unit = extern

  // Init
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 45)
  def init_byte(atm: CAtomicByte, initValue: Byte): Unit = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 45)
  def init_short(atm: CAtomicShort, initValue: CShort): Unit = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 45)
  def init_int(atm: CAtomicInt, initValue: CInt): Unit = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 45)
  def init_long(atm: CAtomicLong, initValue: CLongLong): Unit = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 45)
  def init_ubyte(atm: CAtomicUnsignedByte, initValue: Byte): Unit = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 45)
  def init_ushort(atm: CAtomicUnsignedShort, initValue: CUnsignedShort): Unit =
    extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 45)
  def init_uint(atm: CAtomicUnsignedInt, initValue: CUnsignedInt): Unit =
    extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 45)
  def init_ulong(atm: CAtomicUnsignedLong, initValue: CUnsignedLong): Unit =
    extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 45)
  def init_char(atm: CAtomicChar, initValue: CChar): Unit = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 45)
  def init_uchar(atm: CAtomicUnsignedChar, initValue: CUnsignedChar): Unit =
    extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 45)
  def init_csize(atm: CAtomicCSize, initValue: CSize): Unit = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 47)

  // Load
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 50)
  def load_byte(ptr: CAtomicByte): Byte = extern

  def store_byte(ptr: CAtomicByte, v: Byte): Unit = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 50)
  def load_short(ptr: CAtomicShort): CShort = extern

  def store_short(ptr: CAtomicShort, v: CShort): Unit = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 50)
  def load_int(ptr: CAtomicInt): CInt = extern

  def store_int(ptr: CAtomicInt, v: CInt): Unit = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 50)
  def load_long(ptr: CAtomicLong): CLongLong = extern

  def store_long(ptr: CAtomicLong, v: CLongLong): Unit = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 50)
  def load_ubyte(ptr: CAtomicUnsignedByte): Byte = extern

  def store_ubyte(ptr: CAtomicUnsignedByte, v: Byte): Unit = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 50)
  def load_ushort(ptr: CAtomicUnsignedShort): CUnsignedShort = extern

  def store_ushort(ptr: CAtomicUnsignedShort, v: CUnsignedShort): Unit = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 50)
  def load_uint(ptr: CAtomicUnsignedInt): CUnsignedInt = extern

  def store_uint(ptr: CAtomicUnsignedInt, v: CUnsignedInt): Unit = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 50)
  def load_ulong(ptr: CAtomicUnsignedLong): CUnsignedLong = extern

  def store_ulong(ptr: CAtomicUnsignedLong, v: CUnsignedLong): Unit = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 50)
  def load_char(ptr: CAtomicChar): CChar = extern

  def store_char(ptr: CAtomicChar, v: CChar): Unit = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 50)
  def load_uchar(ptr: CAtomicUnsignedChar): CUnsignedChar = extern

  def store_uchar(ptr: CAtomicUnsignedChar, v: CUnsignedChar): Unit = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 50)
  def load_csize(ptr: CAtomicCSize): CSize = extern

  def store_csize(ptr: CAtomicCSize, v: CSize): Unit = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 54)

  // Compare and Swap
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 57)
  def compare_and_swap_strong_byte(value: CAtomicByte,
                                   expected: CAtomicByte,
                                   desired: Byte): CBool = extern

  def compare_and_swap_weak_byte(value: CAtomicByte,
                                 expected: CAtomicByte,
                                 desired: Byte): CBool = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 57)
  def compare_and_swap_strong_short(value: CAtomicShort,
                                    expected: CAtomicShort,
                                    desired: CShort): CBool = extern

  def compare_and_swap_weak_short(value: CAtomicShort,
                                  expected: CAtomicShort,
                                  desired: CShort): CBool = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 57)
  def compare_and_swap_strong_int(value: CAtomicInt,
                                  expected: CAtomicInt,
                                  desired: CInt): CBool = extern

  def compare_and_swap_weak_int(value: CAtomicInt,
                                expected: CAtomicInt,
                                desired: CInt): CBool = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 57)
  def compare_and_swap_strong_long(value: CAtomicLong,
                                   expected: CAtomicLong,
                                   desired: CLongLong): CBool = extern

  def compare_and_swap_weak_long(value: CAtomicLong,
                                 expected: CAtomicLong,
                                 desired: CLongLong): CBool = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 57)
  def compare_and_swap_strong_ubyte(value: CAtomicUnsignedByte,
                                    expected: CAtomicUnsignedByte,
                                    desired: Byte): CBool = extern

  def compare_and_swap_weak_ubyte(value: CAtomicUnsignedByte,
                                  expected: CAtomicUnsignedByte,
                                  desired: Byte): CBool = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 57)
  def compare_and_swap_strong_ushort(value: CAtomicUnsignedShort,
                                     expected: CAtomicUnsignedShort,
                                     desired: CUnsignedShort): CBool = extern

  def compare_and_swap_weak_ushort(value: CAtomicUnsignedShort,
                                   expected: CAtomicUnsignedShort,
                                   desired: CUnsignedShort): CBool = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 57)
  def compare_and_swap_strong_uint(value: CAtomicUnsignedInt,
                                   expected: CAtomicUnsignedInt,
                                   desired: CUnsignedInt): CBool = extern

  def compare_and_swap_weak_uint(value: CAtomicUnsignedInt,
                                 expected: CAtomicUnsignedInt,
                                 desired: CUnsignedInt): CBool = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 57)
  def compare_and_swap_strong_ulong(value: CAtomicUnsignedLong,
                                    expected: CAtomicUnsignedLong,
                                    desired: CUnsignedLong): CBool = extern

  def compare_and_swap_weak_ulong(value: CAtomicUnsignedLong,
                                  expected: CAtomicUnsignedLong,
                                  desired: CUnsignedLong): CBool = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 57)
  def compare_and_swap_strong_char(value: CAtomicChar,
                                   expected: CAtomicChar,
                                   desired: CChar): CBool = extern

  def compare_and_swap_weak_char(value: CAtomicChar,
                                 expected: CAtomicChar,
                                 desired: CChar): CBool = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 57)
  def compare_and_swap_strong_uchar(value: CAtomicUnsignedChar,
                                    expected: CAtomicUnsignedChar,
                                    desired: CUnsignedChar): CBool = extern

  def compare_and_swap_weak_uchar(value: CAtomicUnsignedChar,
                                  expected: CAtomicUnsignedChar,
                                  desired: CUnsignedChar): CBool = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 57)
  def compare_and_swap_strong_csize(value: CAtomicCSize,
                                    expected: CAtomicCSize,
                                    desired: CSize): CBool = extern

  def compare_and_swap_weak_csize(value: CAtomicCSize,
                                  expected: CAtomicCSize,
                                  desired: CSize): CBool = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 65)

  // Add and Sub
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // add
  def atomic_add_byte(ptr: CAtomicByte, value: Byte): Byte = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // sub
  def atomic_sub_byte(ptr: CAtomicByte, value: Byte): Byte = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // or
  def atomic_or_byte(ptr: CAtomicByte, value: Byte): Byte = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // and
  def atomic_and_byte(ptr: CAtomicByte, value: Byte): Byte = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // xor
  def atomic_xor_byte(ptr: CAtomicByte, value: Byte): Byte = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // add
  def atomic_add_short(ptr: CAtomicShort, value: CShort): CShort = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // sub
  def atomic_sub_short(ptr: CAtomicShort, value: CShort): CShort = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // or
  def atomic_or_short(ptr: CAtomicShort, value: CShort): CShort = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // and
  def atomic_and_short(ptr: CAtomicShort, value: CShort): CShort = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // xor
  def atomic_xor_short(ptr: CAtomicShort, value: CShort): CShort = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // add
  def atomic_add_int(ptr: CAtomicInt, value: CInt): CInt = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // sub
  def atomic_sub_int(ptr: CAtomicInt, value: CInt): CInt = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // or
  def atomic_or_int(ptr: CAtomicInt, value: CInt): CInt = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // and
  def atomic_and_int(ptr: CAtomicInt, value: CInt): CInt = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // xor
  def atomic_xor_int(ptr: CAtomicInt, value: CInt): CInt = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // add
  def atomic_add_long(ptr: CAtomicLong, value: CLongLong): CLongLong = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // sub
  def atomic_sub_long(ptr: CAtomicLong, value: CLongLong): CLongLong = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // or
  def atomic_or_long(ptr: CAtomicLong, value: CLongLong): CLongLong = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // and
  def atomic_and_long(ptr: CAtomicLong, value: CLongLong): CLongLong = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // xor
  def atomic_xor_long(ptr: CAtomicLong, value: CLongLong): CLongLong = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // add
  def atomic_add_ubyte(ptr: CAtomicUnsignedByte, value: Byte): Byte = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // sub
  def atomic_sub_ubyte(ptr: CAtomicUnsignedByte, value: Byte): Byte = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // or
  def atomic_or_ubyte(ptr: CAtomicUnsignedByte, value: Byte): Byte = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // and
  def atomic_and_ubyte(ptr: CAtomicUnsignedByte, value: Byte): Byte = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // xor
  def atomic_xor_ubyte(ptr: CAtomicUnsignedByte, value: Byte): Byte = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // add
  def atomic_add_ushort(ptr: CAtomicUnsignedShort,
                        value: CUnsignedShort): CUnsignedShort = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // sub
  def atomic_sub_ushort(ptr: CAtomicUnsignedShort,
                        value: CUnsignedShort): CUnsignedShort = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // or
  def atomic_or_ushort(ptr: CAtomicUnsignedShort,
                       value: CUnsignedShort): CUnsignedShort = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // and
  def atomic_and_ushort(ptr: CAtomicUnsignedShort,
                        value: CUnsignedShort): CUnsignedShort = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // xor
  def atomic_xor_ushort(ptr: CAtomicUnsignedShort,
                        value: CUnsignedShort): CUnsignedShort = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // add
  def atomic_add_uint(ptr: CAtomicUnsignedInt,
                      value: CUnsignedInt): CUnsignedInt = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // sub
  def atomic_sub_uint(ptr: CAtomicUnsignedInt,
                      value: CUnsignedInt): CUnsignedInt = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // or
  def atomic_or_uint(ptr: CAtomicUnsignedInt,
                     value: CUnsignedInt): CUnsignedInt = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // and
  def atomic_and_uint(ptr: CAtomicUnsignedInt,
                      value: CUnsignedInt): CUnsignedInt = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // xor
  def atomic_xor_uint(ptr: CAtomicUnsignedInt,
                      value: CUnsignedInt): CUnsignedInt = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // add
  def atomic_add_ulong(ptr: CAtomicUnsignedLong,
                       value: CUnsignedLong): CUnsignedLong = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // sub
  def atomic_sub_ulong(ptr: CAtomicUnsignedLong,
                       value: CUnsignedLong): CUnsignedLong = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // or
  def atomic_or_ulong(ptr: CAtomicUnsignedLong,
                      value: CUnsignedLong): CUnsignedLong = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // and
  def atomic_and_ulong(ptr: CAtomicUnsignedLong,
                       value: CUnsignedLong): CUnsignedLong = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // xor
  def atomic_xor_ulong(ptr: CAtomicUnsignedLong,
                       value: CUnsignedLong): CUnsignedLong = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // add
  def atomic_add_char(ptr: CAtomicChar, value: CChar): CChar = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // sub
  def atomic_sub_char(ptr: CAtomicChar, value: CChar): CChar = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // or
  def atomic_or_char(ptr: CAtomicChar, value: CChar): CChar = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // and
  def atomic_and_char(ptr: CAtomicChar, value: CChar): CChar = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // xor
  def atomic_xor_char(ptr: CAtomicChar, value: CChar): CChar = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // add
  def atomic_add_uchar(ptr: CAtomicUnsignedChar,
                       value: CUnsignedChar): CUnsignedChar = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // sub
  def atomic_sub_uchar(ptr: CAtomicUnsignedChar,
                       value: CUnsignedChar): CUnsignedChar = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // or
  def atomic_or_uchar(ptr: CAtomicUnsignedChar,
                      value: CUnsignedChar): CUnsignedChar = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // and
  def atomic_and_uchar(ptr: CAtomicUnsignedChar,
                       value: CUnsignedChar): CUnsignedChar = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // xor
  def atomic_xor_uchar(ptr: CAtomicUnsignedChar,
                       value: CUnsignedChar): CUnsignedChar = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // add
  def atomic_add_csize(ptr: CAtomicCSize, value: CSize): CSize = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // sub
  def atomic_sub_csize(ptr: CAtomicCSize, value: CSize): CSize = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // or
  def atomic_or_csize(ptr: CAtomicCSize, value: CSize): CSize = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // and
  def atomic_and_csize(ptr: CAtomicCSize, value: CSize): CSize = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 70)
  // xor
  def atomic_xor_csize(ptr: CAtomicCSize, value: CSize): CSize = extern
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 75)

  // Types
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 78)
  type CAtomicByte = Ptr[Byte]
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 78)
  type CAtomicShort = Ptr[CShort]
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 78)
  type CAtomicInt = Ptr[CInt]
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 78)
  type CAtomicLong = Ptr[CLongLong]
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 78)
  type CAtomicUnsignedByte = Ptr[Byte]
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 78)
  type CAtomicUnsignedShort = Ptr[CUnsignedShort]
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 78)
  type CAtomicUnsignedInt = Ptr[CUnsignedInt]
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 78)
  type CAtomicUnsignedLong = Ptr[CUnsignedLong]
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 78)
  type CAtomicChar = Ptr[CChar]
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 78)
  type CAtomicUnsignedChar = Ptr[CUnsignedChar]
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 78)
  type CAtomicCSize = Ptr[CSize]
// ###sourceLocation(file: "/home/remi/perso/Projects/scala-native/nativelib/src/main/scala/scala/scalanative/runtime/Atomic.scala.gyb", line: 80)
}
