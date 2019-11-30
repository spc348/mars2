.data
list_length: .word 5
list: .word 1,2,3,4,5
min_string: .asciiz "MIN: "
max_string: .asciiz "MAX: "
newlines: .asciiz "\n"

.text
li $s0, 99999999 # min
li $s1, 0 # max
la $t1, list
li $t2, 0 # array index
addi $t4, $t1, 20  # array length
li $t0, 0
la $t5, list_length
lw $t4, 0($t5)
sll $t4, $t4, 4

loop:
add $t2, $t1, $t0
lw $t3, 0($t2) # t3 should hold value of array element
#blt $t3, $s0, min
#bgt $t3, $s1, max

li $v0, 1
la $a0, ($t5)
syscall

addi $t0, $t0, 4
blt $t0, $t4, loop

end:


