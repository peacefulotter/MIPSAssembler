
object ParserSelection {

    def select(keyword: String): (Parser, String) = keyword match {

        case "addi" =>  (IParser, "001000")
        case "andi" =>  (IParser, "001100")
        case "ori" =>   (IParser, "001101")
        case "xori" =>  (IParser, "001110")
        case "slli" =>  (IParser, "010000")
        case "srli" =>  (IParser, "010001")
        case "slti" =>  (IParser, "010010")
        case "sltiu" => (IParser, "010011")

        case "beq" =>   (IParser, "000100")
        case "bne" =>   (IParser, "000101")
        case "blt" =>   (IParser, "000110")
        case "bge" =>   (IParser, "000111")
        case "bltu" =>  (IParser, "110000")
        case "bgeu" =>  (IParser, "110001")

        case "add" =>   (RParser, "100000")
        case "sub" =>   (RParser, "100010")
        case "and" =>   (RParser, "100100")
        case "or" =>    (RParser, "100101")
        case "xor" =>   (RParser, "100110")
        case "sll" =>   (RParser, "000000")
        case "srl" =>   (RParser, "000010")
        case "slt" =>   (RParser, "101010")
        case "sltu" =>  (RParser, "101011")

        case "lw" =>    (IParser, "100011")
        case "sw" =>    (IParser, "101011")

        case "j" =>     (JParser, "000010")

        case _ => throw new Exception("Keyword " + keyword + " cannot be parsed")
    }
}
