import org.junit.Test
import org.junit.Assert.*

import Utils.*

class Day1Test:

  val input = intListFromResources("day1.txt")

  @Test def testPart1(): Unit =
    assertEquals(1475, Day1.part1(input))

  @Test def testPart2(): Unit =
    assertEquals(1516, Day1.part2(input))
