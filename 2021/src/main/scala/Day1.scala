import scala.annotation.tailrec
import Utils._

object Day1:
  
  def part1(input: List[Int]): Int =
    input match {
      case Nil => 0
      case h :: Nil => 0
      case h :: t =>
        (if (h < t.head) 1 else 0) + part1(t)
    }

  def part2(input: List[Int]): Int =
    input.toVector.sliding(4).map { 
      case Seq(a, b, c, d) => if ((b + c + d) > (a + b + c)) 1 else 0
      case _ => 0
    }.sum
