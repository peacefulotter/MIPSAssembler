object Immediate {

    def width = 16

    def toBinary(n: Int) = Binary.toBinary(n, width)

    def getInt(imm: String) = Integer.parseInt(imm, 16)

    def parse(imm: String) = toBinary( imm.startsWith("0x") match {
        case true => getInt(imm)
        case false => imm.toInt
    } )
}
