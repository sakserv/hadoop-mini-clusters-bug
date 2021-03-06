import sbt._

object Dependencies {

  val sparkVersion       = "2.2.0"
  val miniClusterVersion = "0.1.15"

  // Specific HDP versions
  val hdpVersion          = "2.6.3.0-235"
  val sparkHDPVersion     = s"$sparkVersion.$hdpVersion"

  val sparkDependencies = Seq(
    "org.apache.spark" %% "spark-core" % sparkHDPVersion,
    "org.apache.spark" %% "spark-sql"  % sparkHDPVersion,
    "org.apache.spark" %% "spark-hive" % sparkHDPVersion  exclude("org.spark-project.hive", "hive-metastore") exclude("org.spark-project.hive", "hive-exec")
  )

  val testDependencies = Seq(
    "org.scalatest" %% "scalatest" % "3.0.5" % Test
  )

  val testClusterDependencies = Seq(
    "com.github.sakserv" % "hadoop-mini-clusters"               % miniClusterVersion % Test,
    "com.github.sakserv" % "hadoop-mini-clusters-common"        % miniClusterVersion % Test,
    "com.github.sakserv" % "hadoop-mini-clusters-hivemetastore" % miniClusterVersion % Test,
  )
  
  
  val overrides = Seq(
    "org.datanucleus" % "datanucleus-api-jdo" % "4.2.1",
    "org.datanucleus" % "datanucleus-rdbms"   % "4.1.7",
    "org.datanucleus" % "datanucleus-core"    % "4.1.6"
  )

}
