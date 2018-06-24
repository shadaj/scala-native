package scala.scalanative
package sbtplugin

import ScalaNativePluginInternal._

import sbt._

import scala.scalanative.build.TargetArchitecture

object ScalaNativePlugin extends AutoPlugin {
  override def requires: Plugins = plugins.JvmPlugin

  object autoImport {
    val TargetArchitecture = scala.scalanative.build.TargetArchitecture

    val ScalaNativeCrossVersion = sbtplugin.ScalaNativeCrossVersion

    val nativeVersion = nir.Versions.current

    val nativeClang =
      taskKey[File]("Location of the clang compiler.")

    val nativeClangPP =
      taskKey[File]("Location of the clang++ compiler.")

    val nativeCompileOptions =
      taskKey[Seq[String]](
        "Additional options are passed to clang during compilation.")

    val nativeLinkingOptions =
      taskKey[Seq[String]](
        "Additional options that are passed to clang during linking.")

    val nativeLinkStubs =
      settingKey[Boolean]("Whether to link `@stub` methods, or ignore them.")

    val nativeLink =
      taskKey[File]("Generates native binary without running it.")

    val nativeMode =
      settingKey[String]("Compilation mode, either \"debug\" or \"release\".")

    val nativeGC =
      settingKey[String]("GC choice, either \"none\", \"boehm\" or \"immix\".")

    val targetArchitecture =
      settingKey[TargetArchitecture]("The target architecture to build for")
  }

  @deprecated("use autoImport instead", "0.3.7")
  val AutoImport = autoImport

  override def globalSettings: Seq[Setting[_]] =
    ScalaNativePluginInternal.scalaNativeGlobalSettings

  override def projectSettings: Seq[Setting[_]] =
    ScalaNativePluginInternal.scalaNativeProjectSettings
}
