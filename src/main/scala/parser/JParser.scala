package parser

object JParser extends Parser {

    def format(code: String, target: String) = code + target

    override def parse(code: String, args: List[String], branches: Map[String, Int]): String = args match {
        case (target: String) :: _ => format(code, target)
        case _ => throw new Exception(code + " " + args + " does not match for parsing J Instruction")
    }
}
