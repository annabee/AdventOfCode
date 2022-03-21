import org.junit.Test
import org.junit.Assert.*

import Utils.*

class Day2Test:

  val input = stringListFromResources("day2.txt")

  @Test def testPart1(): Unit =
    assertEquals(1484118, Day2.part1(input))

  @Test def testPart2(): Unit =
    assertEquals(1463827010, Day2.part2(input))
