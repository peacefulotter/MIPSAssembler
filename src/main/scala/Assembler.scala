import java.io.{File, PrintWriter}
import java.math.BigInteger
import scala.io.Source

object Assembler {

    type Hex = String;
    type Bin = String;

    def parseLine(line: String): Bin = {
        val words = line.split(" ");
        val (parser, code) = ParserSelection.select( words.head )
        parser.parse( code, words.tail.toList )
    }

    def parseLineHex(line: String): Hex = toHex(parseLine(line))

    def parseToBinary(lines: List[String]): List[Bin] = lines match {
        case x :: xs => parseLine(x) :: parseToBinary(xs)
        case Nil => Nil
    }

    def toHex(bin: String): Hex = new BigInteger(bin, 2).toString(16)

    def parseToHex(lines: List[String]): List[Hex] =
        parseToBinary(lines).map(toHex)

    def parseFile(inputFilename: String, outputFilename: String) = {
        val resource = Source.fromResource(inputFilename)
        val hex = resource.getLines.toList.map(Assembler.parseLineHex)
        val writer = new PrintWriter(new File("res/" + outputFilename))
        hex.foreach( instr => writer.write(instr + "\n") )
        writer.close()
    }
}