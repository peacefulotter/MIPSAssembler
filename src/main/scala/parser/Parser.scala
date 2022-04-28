package parser

trait Parser {
    def parse(code: String, args: List[String], branches: Map[String, Int]): String
}
