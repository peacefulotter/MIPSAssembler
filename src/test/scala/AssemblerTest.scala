
import org.scalatest.funsuite.AnyFunSuite



class AssemblerTest extends AnyFunSuite {
    test("assembler multiple lines") {
        val lines = List("add r1 r2 r3", "addi r2 r2 -5", "lw r4 zero 4", "sw r6 t2 8")
        println(lines)
        val bin = Assembler.parseToBin(lines)
        println(bin)
        val hex = Assembler.parseToHex(lines)
        println(hex)
    }

    test("assembler lw sw") {
        val lines = List("nop", "addi t0 zero 0xFF", "sw t0 zero 0x8", "lw t0 zero 0x8")
        println(lines)
        val bin = Assembler.parseToBin(lines)
        println(bin)
        val hex = Assembler.parseToHex(lines)
        println(hex)
    }

    test("assembler with file") {
        Assembler.parseFile("test.txt", "output.txt")
    }
}
