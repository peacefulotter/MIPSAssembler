package parser

import types.{Immediate, Register}

object RParser extends Parser {

    def format(code: String, rd: String, rs: String, rt: String): String =
        "000000" + rs + rt + rd + "00000" + code

    override def parse(code: String, args: List[String], branches: Map[String, Int]): String = args match {
        case (rd: String) :: (rs: String) :: (rt: String) :: _ =>
            format(code, Register.parse(rd), Register.parse(rs), Register.parse(rt))
        case _ => throw new Exception(code + " " + args + " does not match for parsing R Instruction")
    }
}
