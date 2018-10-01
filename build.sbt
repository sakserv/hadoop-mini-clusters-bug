import sbt._
import Dependencies._

val root = (project in file("test"))
  .settings(
    Common.commonSettings,
    libraryDependencies := testClusterDependencies ++ testDependencies ++ sparkDependencies
  )

