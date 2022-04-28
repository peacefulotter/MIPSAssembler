import java.io.{File, PrintWriter}
import java.math.BigInteger
import scala.io.Source

object Assembler {

    type Hex = String;
    type Bin = String;

    def parseToBin(lines: List[String]): List[Hex] = {

        def parseLine(line: String, branches: Map[String, Int]): Bin = {
            val words = line
                .toLowerCase
                .replaceAll("[^a-z0-9: _]", "")
                .split(" ")
                .map(l => l.trim)
            val (parser, code) = ParserSelection.select( words.head )
            parser.parse(code, words.tail.toList, branches)
        }

        def parseLines(lines: List[String], branches: Map[String, Int], i: Int): List[Bin] = lines match {
            case x :: xs => x.takeRight(1) match {
                case ":" => parseLines(xs, branches + (x.dropRight(1) -> i), i)
                case _ => parseLine(x, branches) :: parseLines(xs, branches, i + 1)
            }
            case Nil => Nil
        }

        parseLines(lines, Map(), 0)
    }

    def toHex(bin: String): Hex = new BigInteger(bin, 2).toString(16)
    def parseToHex(lines: List[String]): List[Hex] = parseToBin(lines).map(toHex)

    def parseFile(inputFilename: String, outputFilename: String) = {
        val resource = Source.fromResource(inputFilename)
        val lines = resource.getLines.toList.filter(l => l.nonEmpty)
        val hex = parseToHex(lines)
        val writer = new PrintWriter(new File("res/" + outputFilename))
        hex.foreach( instr => writer.write(instr + "\n") )
        writer.close()
    }
}