import java.math.BigInteger

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
}