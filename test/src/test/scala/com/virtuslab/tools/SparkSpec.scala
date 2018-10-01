package com.virtuslab.tools

import org.apache.spark.sql.SparkSession
import org.scalatest.Suite

trait SparkSpec extends ClusterSpec  { this: Suite =>

  implicit val spark: SparkSession = SparkSession
      .builder()
      .config("hive.metastore.uris", HiveMetastoreSpec.uri)
      .master("local")
      .appName("Spark test")
      .enableHiveSupport()
      .getOrCreate()

}
