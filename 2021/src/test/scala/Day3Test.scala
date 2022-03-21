import org.junit.Test
import org.junit.Assert.*

import Utils.*

class Day3Test:

  val input = stringListOfListsFromResources("day3.txt")

  @Test def testPart1(): Unit =
    assertEquals(3847100, Day3.part1(input))


  @Test def testPart2(): Unit =
    assertEquals(4105235, Day3.part2(input))
