package types

object Branch {
    def parse(branch: String, branches: Map[String, Int]): String = Immediate.parse(
        branches.get(branch) match {
            case Some(x) => x.toString
            case None => throw new Exception("Branch " + branch + " has not been declared")
        }
    )
}