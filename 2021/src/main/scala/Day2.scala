import Utils._

case class Position(x: Int, y: Int)
case class PositionWithAim(x: Int, y: Int, aim: Int)

object Day2:

  def part1(input: List[String]): Int = {
    val finalPosition = calculatePosition(input, Position(0, 0))
    finalPosition.x * finalPosition.y
  }

  def part2(input: List[String]): Int = {
    val finalPosition = calculatePositionWithAim(input, PositionWithAim(0, 0, 0))
    finalPosition.x * finalPosition.y
  }

  private def calculatePosition(input: List[String], position: Position): Position =
    input match {
      case Nil => position
      case _ => calculatePosition(input.tail, updatePosition(input.head, position))
    }

  private def updatePosition(input: String, position: Position): Position =
    input.split(" ").toList match {
      case "forward" :: t => position.copy(x = position.x + t.head.toString().toInt)  // will break on double digits
      case "down" :: t => position.copy(y = position.y + t.head.toString().toInt)
      case "up" :: t => position.copy(y = position.y - t.head.toString().toInt)
      case Nil => position
    }

  private def calculatePositionWithAim(input: List[String], positionWithAim: PositionWithAim): PositionWithAim =
    input match {
      case Nil => positionWithAim
      case _ => calculatePositionWithAim(input.tail, updatePositionWithAim(input.head, positionWithAim))
    }

  private def updatePositionWithAim(input: String, positionWithAim: PositionWithAim): PositionWithAim =
    input.split(" ").toList match {
      case "forward" :: t =>
        val v = t.head.toString().toInt
        positionWithAim.copy(x = positionWithAim.x + v, y = positionWithAim.y + (positionWithAim.aim * v))
      case "down" :: t => positionWithAim.copy(aim = positionWithAim.aim + t.head.toString().toInt)
      case "up" :: t => positionWithAim.copy(aim = positionWithAim.aim - t.head.toString().toInt)
      case Nil => positionWithAim
    }
