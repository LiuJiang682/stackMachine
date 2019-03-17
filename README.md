# Programming-assignment-stack-machine.docx / Version: 1.094 Page 1 of 1
Programming assignment: Stack Machine
The goal of this assignment is to implement a simple stack machine using Polish postfix notation. The
assignment should be carried out in the same way you would perform a programming task at work and all
resulting output should be sent back together with the source code of the program.
 The program should have a simple UI to enter instructions and display results. It can be as simple as a
command line UI that reads from standard input and writes to standard output.
 The initial state is an empty stack. The UI asks for an instruction.
 If the user input is invalid, an error is logged and the input is ignored. The user is prompted for the
next instruction.
 If the user input is valid, the instruction is executed and the top element of the stack is printed.
 The program keeps asking for new instructions until terminated with the QUIT instruction.
 Every instruction operates on the top n elements of the stack, n depending on the type of instruction.
The n elements are removed from the stack and the result is pushed back to the top of the stack.
 If there are not enough elements on the stack for a particular instruction, an error is logged and the
instruction is ignored. The user is prompted for the next instruction.
 The program supports the following commands:
o PUSH <xyz> or <xyz>
where <xyz> is a valid decimal number
Pushes the numeric value <xyz> to the top of the stack
o POP
Removes the top element from the stack
o CLEAR
Removes all elements from the stack
o ADD
Adds the top 2 elements on the stack and pushes the result back to the stack
o MUL
Multiplies the top 2 elements on the stack and pushes the result back to the stack
o NEG
Negates the top element on the stack and pushes the result back to the stack
o INV
Inverts the top element on the stack and pushes the result back to the stack
o UNDO
The last instruction is undone leaving the stack in the same state as before that instruction
o PRINT
Prints all elements that are currently on the stack
o QUIT
Exits the program


Usage:
1. Download the zip file
2. Unzip the file with password: airwallex
3. Open the command prompt 
4. cd path-to-unzip-file-directory
5. mvn clean install
6. mvn package assembly:single
7. java -jar target/RpnCalculator-0.0.1-SNAPSHOT-jar-with-dependencies.jar

Note: I am not sure how the position 15 comes from in the Example 8 of the tech-programming-test-rpn-1.1.7.pdf, I assume it is the position of the trouble operator in order of input from user. I program it at this way. Please take note at this.
