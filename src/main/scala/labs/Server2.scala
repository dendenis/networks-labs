package labs

import java.io._
import java.net.{InetAddress,ServerSocket,Socket,SocketException}
import java.util.Random

/**
 * Created by dkirsanov on 24.06.15.
 */

object Client2 {

  def main(args: Array[String]) {
    try {
      val ia = InetAddress.getByName("localhost")
      val socket = new Socket(ia, 9999)
      val out = new ObjectOutputStream(
        new DataOutputStream(socket.getOutputStream()))
      val in = new ObjectInputStream(socket.getInputStream())

      while(true) {
        val a = readLine()
        out.writeObject(a)
        out.flush()

        val x = in.readObject().asInstanceOf[String]

        println("responce = " + x)
      }
      out.close()
      in.close()
      socket.close()
    }
    catch {
      case e: IOException =>
        e.printStackTrace()
    }
  }

}

object Server2 {

  def main(args: Array[String]): Unit = {
    try {
      val listener = new ServerSocket(9999);
      while (true)
        new ServerThread(listener.accept()).start();
      listener.close()
    }
    catch {
      case e: IOException =>
        System.err.println("Could not listen on port: 9999.");
        System.exit(-1)
    }
  }

}

case class ServerThread(socket: Socket) extends Thread("ServerThread") {

  override def run(): Unit = {
    try {
      val out = new ObjectOutputStream(socket.getOutputStream)
      val in = new ObjectInputStream(
        new DataInputStream(socket.getInputStream))
      while (true) {
        val a = in.readObject().asInstanceOf[String]
        println(a)
        out.writeObject(a)
        Thread.sleep(100)
        out.flush()
      }


      out.close()
      in.close()
      socket.close()
    }
    catch {
      case e: SocketException =>
        () // avoid stack trace when stopping a client with Ctrl-C
      case e: IOException =>
        e.printStackTrace()
    }
  }

}