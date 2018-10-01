package com.virtuslab.tools

import org.scalatest.{BeforeAndAfterAll, Suite}

trait ClusterSpec extends BeforeAndAfterAll { this: Suite =>
  override protected def beforeAll(): Unit = {
    super.beforeAll()
    HiveMetastoreSpec.start()
  }
}
