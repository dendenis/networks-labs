package labs

import java.util.zip.CRC32
import scala.io._
/**
 * Created by dkirsanov on 25.06.15.
 * x^{32} + x^{26} + x^{23} + x^{22} + x^{16} + x^{12} + x^{11} + x^{10} + x^8 + x^7 + x^5 + x^4 + x^2 + x + 1
 */
object CRC32 {

  def main(args: Array[String]) {
    val crc=new CRC32
    val msg = readLine("enter msg: ")
    crc.update(msg.getBytes)
    println(crc.getValue.toHexString)
  }

}
