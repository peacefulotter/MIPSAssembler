

Works with the most MIPS instructions and supports all formats (I, R, J).
Supports for new instructions can be easily added by editing ParserSelection.scala

## How to Use

### From List

```scala
val lines = List("MY_INSTRUCTION_1", "MY_INSTRUCTION_2", ...)
val bin = Assembler.parseToBinary(lines) // For binary string output
val hex = Assembler.parseToHex(lines) // For hex string output
```

### From File

Write MIPS commands in a file under the `res` folder.

```scala
val resource = Source.fromResource("MY_FILE.txt")
val hex = resource.getLines.toList.map(Assembler.parseLineHex)
val writer = new PrintWriter(new File("res/output.txt" ))
hex.foreach( instr => writer.write(instr + "\n") )
writer.close()
```

#### List of supported instructions

 - addi
 - andi
 - ori
 - xori
 - slli
 - srli
 - slti
 - sltiu
 - beq
 - bne
 - blt
 - bge
 - bltu
 - bgeu
 - add
 - sub
 - and
 - or
 - xor
 - sll
 - srl
 - slt
 - sltu
 - lw
 - sw

#### List of supported formats

 - Registers: t, r and zero (ex: t1, r6)
 - Immediate: int and hex (ex: 42, 0x666)
 - LW and SW commands are used the same way as a typical I instruction, it does NOT support the following format:
   - `lw/sw t2 0x4(t3)`
   - Instead use: `lw/sw t2 t3 0x4`