import math.Ordering.Implicits.seqOrdering
import scala.Byte._
import scala.collection.MapView

object Day3:

  def part1(input: List[List[String]]): Int =
    val gammaValue = gamma(input)
    val epsilonValue = reverseBinary(gammaValue)
    Integer.parseInt(gammaValue.mkString, 2) * Integer.parseInt(epsilonValue.mkString, 2)

  private def gamma(input: List[List[String]]): List[String] =
    input.transpose.map(_.groupBy(identity)
      .view.mapValues(_.length)
      .maxBy(_._2)
      ._1)

  private def reverseBinary(input: List[String]): List[String] =
    val ones = List.fill(input.length)("1")
    input
      .zip(ones)
      .map{ case (l, r) => l.toInt ^ r.toInt }
      .map(_.toString)

  def part2(input: List[List[String]]): Int =
    val oxygen = recurseOxygen(input, 0).head
    val co2 = recurseC02(input, 0).head
    Integer.parseInt(oxygen.mkString, 2) * Integer.parseInt(co2.mkString, 2)

  def recurseOxygen(input: List[List[String]], index: Int): List[List[String]] = {
    input.length match {
      case 1 => input
      case _   =>
        val transposed = input.transpose
        val keep = pickMostCommon(transposed(index))
        val indicesToKeep = transposed(index).zipWithIndex.filter(_._1.equals(keep)).map(_._2)
        val elementsToKeep = input.indices.collect { case i if indicesToKeep.contains(i) => input(i) }.toList
        recurseOxygen(elementsToKeep, index + 1)
    }
  }

  def recurseC02(input: List[List[String]], index: Int): List[List[String]] = {
    input.length match {
      case 1 => input
      case _   =>
        val transposed = input.transpose
        val keep = pickLeastCommon(transposed(index))
        val indicesToKeep = transposed(index).zipWithIndex.filter(_._1.equals(keep)).map(_._2)
        val elementsToKeep = input.indices.collect { case i if indicesToKeep.contains(i) => input(i) }.toList
        recurseC02(elementsToKeep, index + 1)
    }
  }

  private def pickMostCommon(input: List[String]): String = {
    val occcur = input.groupBy(identity)
      .view.mapValues(_.length)
      
    if (occcur.values.toList.length > 1 && occcur.values.toList.head == occcur.values.toList.tail.head) then "1"
    else occcur.maxBy(_._2)._1
  }


  private def pickLeastCommon(input: List[String]): String = {
    val occcur = input.groupBy(identity)
      .view.mapValues(_.length)

    if (occcur.values.toList.length > 1 && occcur.values.toList.head == occcur.values.toList.tail.head) then "0"
    else occcur.minBy(_._2)._1
  }

