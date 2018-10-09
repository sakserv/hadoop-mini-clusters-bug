import sbt._
import Keys._

object Common {

  val commonSettings = Seq(
    version := "1.0.0-SNAPSHOT",
    scalaVersion := "2.11.12",
    organization := "com.virtuslab",
    scalacOptions ++= Seq("-unchecked",
                          "-deprecation",
                          "-feature",
                          "-language:implicitConversions",
                          "-language:reflectiveCalls",
                          "-Ywarn-unused-import",
                          "-Xfatal-warnings"),
    javacOptions ++= Seq("-source", "1.8", "-target", "1.8"),
    fork := true,
    fork in Test := true,
    testOptions in Test ++= Seq(Tests.Argument(TestFrameworks.ScalaTest, "-oD"),
                                Tests.Argument(TestFrameworks.ScalaTest, "-W", "120", "60")),
    javaOptions in Test ++= Seq("-Xms1G", "-Xmx6G", "-XX:+CMSClassUnloadingEnabled"),
    resolvers ++= Seq(
      "Hortonworks release" at "http://repo.hortonworks.com/content/repositories/releases/",
      "Hortonworks public" at "http://repo.hortonworks.com/content/groups/public"
    ), 
    dependencyOverrides := Dependencies.overrides
  )

}
