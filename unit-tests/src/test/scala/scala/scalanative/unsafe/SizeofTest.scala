package scala.scalanative
package unsafe

import org.junit.Test
import org.junit.Assert._

import scalanative.unsigned._

class SizeofTest {

  @Test def testByte(): Unit = {
    assertTrue(sizeof[Byte] == 1.toUWord)
  }

  @Test def testUByte(): Unit = {
    assertTrue(sizeof[UByte] == 1.toUWord)
  }

  @Test def testShort(): Unit = {
    assertTrue(sizeof[Short] == 2.toUWord)
  }

  @Test def testUShort(): Unit = {
    assertTrue(sizeof[UShort] == 2.toUWord)
  }

  @Test def testInt(): Unit = {
    assertTrue(sizeof[Int] == 4.toUWord)
  }

  @Test def testUInt(): Unit = {
    assertTrue(sizeof[UInt] == 4.toUWord)
  }

  @Test def testLong(): Unit = {
    assertTrue(sizeof[Long] == 8.toUWord)
  }

  @Test def testULong(): Unit = {
    assertTrue(sizeof[ULong] == 8.toUWord)
  }

  @Test def testPtr(): Unit = {
    assertTrue(sizeof[Ptr[_]] == sizeof[Word])
  }

  @Test def testCStruct1Byte(): Unit = {
    assertTrue(sizeof[CStruct1[Byte]] == 1.toUWord)
  }

  @Test def testCStruct2ByteByte(): Unit = {
    assertTrue(sizeof[CStruct2[Byte, Byte]] == 2.toUWord)
  }

  @Test def testCStruct2ByteInt(): Unit = {
    assertTrue(sizeof[CStruct2[Byte, Int]] == 8.toUWord)
  }

  @Test def testCStruct3ByteShortByte(): Unit = {
    assertTrue(sizeof[CStruct3[Byte, Short, Byte]] == 6.toUWord)
  }

  @Test def testCStruct4ByteShortByteInt(): Unit = {
    assertTrue(sizeof[CStruct4[Byte, Short, Byte, Int]] == 12.toUWord)
  }

  @Test def testInnerStructCStruct2ByteCStruct2LongByte(): Unit = {
    if (sizeof[Word].toInt == 8) {
      assertTrue(sizeof[CStruct2[Byte, CStruct2[Long, Byte]]] == 24.toUWord)
    } else {
      // TODO(shadaj)
    }
  }

  @Test def testInnerStructCStruct3ByteLongCStruct3IntIntByte(): Unit = {
    if (sizeof[Word].toInt == 8) {
      assertTrue(
        sizeof[CStruct3[Byte, Long, CStruct3[Int, Int, Byte]]] == 32.toUWord)
    } else {
      // TODO(shadaj)
    }
  }

  @Test def testInnerStructCStruct3ByteLongCStruct3IntIntCStruct4ByteIntShortByte()
      : Unit = {
    if (sizeof[Word].toInt == 8) {
      assertTrue(
        sizeof[CStruct3[
          Byte,
          Long,
          CStruct3[Int, Int, CStruct4[Byte, Int, Short, Byte]]]] == 40.toUWord)
    } else {
      // TODO(shadaj)
    }
  }

  type _32   = Nat.Digit2[Nat._3, Nat._2]
  type _128  = Nat.Digit3[Nat._1, Nat._2, Nat._8]
  type _1024 = Nat.Digit4[Nat._1, Nat._0, Nat._2, Nat._4]

  @Test def testCArrayByteNat32(): Unit = {
    assertTrue(sizeof[CArray[Byte, _32]] == 32.toUWord)
  }

  @Test def testCArrayByteNat128(): Unit = {
    assertTrue(sizeof[CArray[Byte, _128]] == 128.toUWord)
  }

  @Test def testCArrayByteNat1024(): Unit = {
    assertTrue(sizeof[CArray[Byte, _1024]] == 1024.toUWord)
  }

  @Test def testCArrayCStruct3ByteIntByteNat32(): Unit = {
    assertTrue(
      sizeof[CArray[CStruct3[Byte, Int, Byte], _32]] == (12 * 32).toUWord)
  }
}