
trait Parser {
    type Bin = String;
    def parse(code: String, args: List[String]): Bin
}
