package labs

/**
 * Created by dkirsanov on 04.03.15.
 */

import java.io._
import java.net._

import scala.io._

object Server1 extends App{


  def runServer() = {
    println("init serv")
    val server = new ServerSocket(9999)
    while (true) {
      val s = server.accept()
      val in = new BufferedSource(s.getInputStream).getLines()
      val out = new PrintStream(s.getOutputStream)
      val msg = in.next()
      println(msg)
      out.println(msg)
      out.flush()
      s.close()
    }
  }

  runServer()
}

object Client1 extends App{

  def runClient() = {
    println("init cli")
    while (true) {
      val s = new Socket(InetAddress.getByName("localhost"), 9999)
      val in = new BufferedSource(s.getInputStream()).getLines()
      val out = new PrintStream(s.getOutputStream())
      val msg = readLine("Enter message: ")
      out.println(msg)
      out.flush()
      println("Received: " + in.next())
      s.close()
    }

  }
  runClient()
}

