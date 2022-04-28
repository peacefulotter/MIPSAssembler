package types

object Immediate {

    def width = 16

    def toBinary(n: Int): String = Binary.toBinary(n, width)

    def getInt(imm: String): Int = Integer.parseInt(imm, 16)

    def parse(imm: String): String = toBinary(imm.startsWith("0x") match {
        case true => getInt(imm.drop(2))
        case false => imm.toInt
    })
}
