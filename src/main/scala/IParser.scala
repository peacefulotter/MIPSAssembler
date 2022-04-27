

object IParser extends Parser {

    def format(code: String, rt: String, rs: String, imm: String) =
        code + rs + rt + imm

    override def parse(code: String, args: List[String]): Bin = args match {
        case (rt: String) :: (rs: String) :: (imm: String) :: xs =>
            format(code, Register.parse(rt), Register.parse(rs), Immediate.parse(imm))
        case _ => throw new Exception(code + " " + args + " does not match for parsing I Instruction")
    }
}
