import parser._

object ParserSelection {

    def select(keyword: String): (Parser, String) = keyword match {

        case "nop"  =>  (NParser, "000000")

        case "addi" =>  (IParser, "001000")
        case "addiu" => (IParser, "001001")
        case "andi" =>  (IParser, "001100")
        case "ori" =>   (IParser, "001101")
        case "xori" =>  (IParser, "001110")
        case "slti" =>  (IParser, "001010")
        case "sltiu" => (IParser, "001011")

        case "beq" =>   (BParser, "000100")
        case "bne" =>   (BParser, "000101")
        case "blt" =>   (BParser, "000110")
        case "bge" =>   (BParser, "000111")

        case "add" =>   (RParser, "100000")
        case "addu" =>  (RParser, "100001")
        case "sub" =>   (RParser, "100010")
        case "subu" =>  (RParser, "100011")
        case "and" =>   (RParser, "100100")
        case "or" =>    (RParser, "100101")
        case "nor" =>   (RParser, "100111")
        case "xor" =>   (RParser, "100110")
        case "sllv" =>  (RParser, "000100")
        case "srlv" =>  (RParser, "000110")
        case "slt" =>   (RParser, "101010")
        case "sltu" =>  (RParser, "101011")
        case "srav" =>  (RParser, "000111")

        case "sll" =>   (SParser, "000000")
        case "srl" =>   (SParser, "000010")
        case "sra" =>   (SParser, "000011")

        case "lw" =>    (MParser, "100011")
        case "sw" =>    (MParser, "101011")

        case "j" =>     (JParser, "000010")
        case "jal" =>   (JParser, "000011")

        case _ => throw new Exception("Keyword " + keyword + " is not supported")

    }
}
