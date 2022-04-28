package parser

import types.{Binary, Immediate, Register}

/**
 * Parser for memory instructions like lw and sw
 */
object MParser extends Parser {

    override def parse(code: String, args: List[String], branches: Map[String, Int]): String = args match {
        case (rt: String) :: (rs: String) :: (imm: String) :: _ =>
            IParser.format(code, Register.parse(rt), Register.parse(rs), Immediate.parse(imm))
        case _ => throw new Exception(code + " " + args + " does not match for parsing Mem Instruction")
    }
}
