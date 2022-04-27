object Binary {
    def toBinary(n: Int, width: Int) = ("0" * width) + n.toBinaryString takeRight width
}
