package com.virtuslab.tools

import java.util.concurrent.atomic.AtomicBoolean

import com.github.sakserv.minicluster.impl.HiveLocalMetaStore
import org.apache.hadoop.hive.conf.HiveConf
import org.scalatest.{BeforeAndAfterAll, Suite}

object HiveMetastoreSpec {

  val host = "localhost"
  val port = NetworkUtil.randomPort()
  val derbyDB = "target/mini-cluster/metastore_db"
  val warehouseDirectory = "target/mini-cluster/warehouse_dir"
  val scratchDir = "target/mini-cluster/scratch_dir"
  val uri = s"thrift://$host:$port"

  private val instance = new HiveLocalMetaStore.Builder()
    .setHiveMetastoreHostname(host)
    .setHiveMetastorePort(port)
    .setHiveMetastoreDerbyDbDir(derbyDB)
    .setHiveScratchDir(scratchDir)
    .setHiveWarehouseDir(warehouseDirectory)
    .setHiveConf(new HiveConf())
    .build()

  private val started = new AtomicBoolean(false)

  def start() = {
    if(started.compareAndSet(false, true) ) {
      instance.start()
    }
  }
}

trait HiveMetastoreSpec extends BeforeAndAfterAll { this: Suite =>
  override protected def beforeAll(): Unit = {
    super.beforeAll()
    HiveMetastoreSpec.start()
  }
}
