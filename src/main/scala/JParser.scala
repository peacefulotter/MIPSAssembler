

object JParser extends Parser {

    def format(code: String, target: String) = code + target

    override def parse(code: String, args: List[String]): Bin = args match {
        case (target: String) :: xs => format(code, target)
        case _ => throw new Exception(code + " " + args + " does not match for parsing J Instruction")
    }
}
