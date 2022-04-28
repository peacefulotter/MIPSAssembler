package types

object Register {

    def width = 5

    def toBinary(n: Int) = Binary.toBinary(n, width)

    def parse(reg: String): String = reg match {
        case "zero" => toBinary(0)
        case _ => reg.split("").toList match {
            case "r" :: (i: String) :: xs => toBinary(i.toInt)
            case "t" :: (i: String) :: xs => toBinary(i.toInt + 8)
            case _ => throw new Exception("Parsing register " + reg + ", wrong format")
        }
    }
}
