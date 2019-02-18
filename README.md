# Sliding-Block-Solver
A sliding block puzzle solver using Java.
Developed using IntelliJ IDEA.

## Introduction

* The game is on a 6x6 board. All the blocks are horizontal or vertical with 2 or 3 length. Our goal is make the main block outside the board.
* Horizontal blocks can only go horizontally and vertical blocks can only go vertically. The main block is always vectical.

## Input

* An array of blocks, which contains three information:
  1. The coordinate of head(the left one of horizontal block and the top one of vertical block)
  2. Whether it is horizontal or vertical(vertical is 0 and horizontal is 1)
  3. Length
  
## Output

* Print a list of step about how to move the head of the block.
* Print "No Answer" if it is unsolvable.
