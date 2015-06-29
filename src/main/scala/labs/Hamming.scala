//package labs
//
///**
// * Created by dkirsanov on 29.06.15.
// */
//class Hamming extends Iterator[BigInt] {
//  import scala.collection.mutable.Queue
//  val qs = Seq.fill(3)(new Queue[BigInt])
//  def enqueue(n: BigInt) = qs zip Seq(2, 3, 5) foreach { case (q, m) => q enqueue n * m }
//  def next = {
//    val n = qs map (_.head) min;
//    qs foreach { q => if (q.head == n) q.dequeue }
//    enqueue(n)
//    n
//  }
//  def hasNext = true
//  qs foreach (_ enqueue 1)
//}
//
//class Hamming extends Iterator[BigInt] {
//  import scala.collection.mutable.Queue
//  val q2 = new Queue[BigInt]
//  val q3 = new Queue[BigInt]
//  val q5 = new Queue[BigInt]
//  def enqueue(n: BigInt) = {
//    q2 enqueue n * 2
//    q3 enqueue n * 3
//    q5 enqueue n * 5
//  }
//  def next = {
//    val n = q2.head min q3.head min q5.head
//    if (q2.head == n) q2.dequeue
//    if (q3.head == n) q3.dequeue
//    if (q5.head == n) q5.dequeue
//    enqueue(n)
//    n
//  }
//  def hasNext = true
//  List(q2, q3, q5) foreach (_ enqueue 1)
//}
//
//object RunHamming{
//
//  def main(args: Array[String]) {
//
//  }
//}