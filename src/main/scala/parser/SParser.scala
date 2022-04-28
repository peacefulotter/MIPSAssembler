package parser

import types.{Immediate, Register}


/**
 * Parser that uses shamt instead of rs
 */
object SParser extends Parser {

    def shamtWidth = 5

    def format(code: String, rd: String, rt: String, shamt: String): String =
        "000000" + "00000" + rt + rd + shamt + code

    override def parse(code: String, args: List[String], branches: Map[String, Int]): String = args match {
        case (rd: String) :: (rt: String) :: (imm: String) :: _ =>
            format(code, Register.parse(rd), Register.parse(rt), Immediate.parse(imm).takeRight(shamtWidth))
        case _ => throw new Exception(code + " " + args + " does not match for parsing Shamt Instruction")
    }
}
