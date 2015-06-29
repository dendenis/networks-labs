package labs

import java.util.zip.CRC32
import scala.io._
/**
 * Created by dkirsanov on 25.06.15.
 */
object CRC32 {

  def main(args: Array[String]) {
    val crc=new CRC32
    crc.update("The quick brown fox jumps over the lazy dog".getBytes)
    println(crc.getValue.toHexString)
  }

}
