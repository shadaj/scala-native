package scala.scalanative
package posix.sys

import scala.scalanative.native.{CInt, CUnsignedInt, UWord, extern}

@extern
object types {

  type pid_t = CInt

  type pthread_attr_t = UWord

  type pthread_barrier_t = UWord

  type pthread_barrierattr_t = UWord

  type pthread_cond_t = UWord

  type pthread_condattr_t = UWord

  type pthread_key_t = UWord

  type pthread_mutex_t = UWord

  type pthread_mutexattr_t = UWord

  type pthread_once_t = UWord

  type pthread_rwlock_t = UWord

  type pthread_rwlockattr_t = UWord

  type pthread_spinlock_t = UWord

  type pthread_t = UWord

  type clockid_t = CInt
}
