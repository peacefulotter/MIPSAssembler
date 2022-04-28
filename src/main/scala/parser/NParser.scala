package parser

object NParser extends Parser {
    override def parse(code: String, args: List[String], branches: Map[String, Int]): String = "0" * 32
}
