package com.virtuslab.tools

import java.net.ServerSocket

object NetworkUtil {

  def randomPort(): Int = NetworkUtil.synchronized {
    val serverSocket = new ServerSocket(0)
    val port         = serverSocket.getLocalPort
    serverSocket.close()
    port
  }

}
