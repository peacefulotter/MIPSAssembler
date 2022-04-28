package types

object Binary {

    // the zero register
    def zero = toBinary(0, 5)

    def toBinary(n: Int, width: Int) = ("0" * width) + n.toBinaryString takeRight width
}
