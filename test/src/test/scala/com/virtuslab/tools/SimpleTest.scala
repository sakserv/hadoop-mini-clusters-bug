package com.virtuslab.tools

import org.apache.spark.sql.SaveMode
import org.scalatest.{FlatSpec, Matchers}

class SimpleTest  extends FlatSpec with Matchers with SparkSpec {

  it should "simple hive insert" in {
    import spark.implicits._

    val row = TestRow("test1")
    val list = Seq(row).toDF

    list.write.mode(SaveMode.Overwrite).saveAsTable("src")
  }

}

case class TestRow(value:String)