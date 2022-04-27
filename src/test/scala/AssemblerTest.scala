
import org.scalatest.funsuite.AnyFunSuite

import java.io.{File, PrintWriter}
import scala.io.Source



class AssemblerTest extends AnyFunSuite {
    test("assembler multiple lines") {
        val lines = List("add r1 r2 r3", "addi r2 r2 -5", "lw r4 zero 4", "sw r6 t2 8")
        println(lines)
        val bin = Assembler.parseToBinary(lines)
        println(bin)
        val hex = Assembler.parseToHex(lines)
        println(hex)
    }

    test("assembler with file") {
        val resource = Source.fromResource("test.txt")
        val hex = resource.getLines.toList.map(Assembler.parseLineHex)
        val writer = new PrintWriter(new File("res/output.txt" ))
        hex.foreach( instr => writer.write(instr + "\n") )
        writer.close()
    }
}
