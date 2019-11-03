.data

list: .word 1,2,3,4,5
min_string: .asciiz "MIN: "
max_string: .asciiz "MAX: "
newlines: .asciiz "\n"

.text
li $t1, 0 # array address
li $t2, 0 # array index
li $s0, 99999999 # min
li $s1, 0 # max
li $t4, 0

la $t1, list

loop:
addi $t2, $t2, 4
beq $t2, $t4, end
lw $t3, list($t2)

blt $t3, $s0, min
bgt $t3, $s1, max


min:
move $t3, $s0
j loop
max:


end:
li $v0, 4
la $a0, min_string
syscall

li $v0, 1
la $a0, ($s0)
syscall

li $v0, 4
la $a0, newlines
syscall

li $v0, 4
la $a0, max_string
syscall

li $v0, 1
la $a0, ($s1)
syscall
