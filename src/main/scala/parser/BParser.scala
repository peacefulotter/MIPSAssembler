package parser

import types.{Branch, Register}

/**
 * Parser for branch operations
 * Similar to the I Parser - uses its format method - but calling Branch.parse for the imm value
 */
object BParser extends Parser {
    override def parse(code: String, args: List[String], branches: Map[String, Int]): String = args match {
        case (rt: String) :: (rs: String) :: (imm: String) :: _ =>
            IParser.format(code, Register.parse(rt), Register.parse(rs), Branch.parse(imm, branches))
        case _ => throw new Exception(code + " " + args + " does not match for parsing Branch Instruction")
    }
}
