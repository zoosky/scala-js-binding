import sbt._
import sbt.Keys._
import scala.scalajs.sbtplugin.ScalaJSPlugin.ScalaJSKeys
import scala.scalajs.sbtplugin.ScalaJSPlugin.ScalaJSKeys._
import scala.scalajs.sbtplugin
import bintray.Plugin._
import bintray.Keys._
import scala.scalajs.sbtplugin.ScalaJSPlugin.ScalaJSKeys

scalaJSSettings

Build.sameSettings

name := "frontend"

scalacOptions ++= Seq( "-feature", "-language:_" )

ScalaJSKeys.relativeSourceMaps := true

version := "0.0.1"