

Works with the most MIPS instructions and supports all formats (I, R, J).
Supports for new instructions can be easily added by editing ParserSelection.scala

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