import scala.io.Source

object Utils {

  def intListFromResources(fileName: String): List[Int] =
    Source.fromInputStream(getClass.getResourceAsStream(fileName))
      .getLines().map(_.toInt).toList

  def stringListFromResources(fileName: String): List[String] =
    Source.fromInputStream(getClass.getResourceAsStream(fileName))
      .getLines().map(_.toString).toList

  def stringListOfListsFromResources(fileName: String): List[List[String]] = {
    Source.fromInputStream(getClass.getResourceAsStream(fileName))
      .getLines()
      .map(_.toString).toList
      .map(elem => elem.toCharArray.toList.map(e => e.toString))
  }
}
