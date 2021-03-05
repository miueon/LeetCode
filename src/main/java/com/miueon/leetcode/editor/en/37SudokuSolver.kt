  //Write a program to solve a Sudoku puzzle by filling the empty cells. 
//
// A sudoku solution must satisfy all of the following rules: 
//
// 
// Each of the digits 1-9 must occur exactly once in each row. 
// Each of the digits 1-9 must occur exactly once in each column. 
// Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes
// of the grid. 
// 
//
// The '.' character indicates empty cells. 
//
// 
// Example 1: 
//
// 
//Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5"
//,".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".","."
//,".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".","."
//,"6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"
//],[".",".",".",".","8",".",".","7","9"]]
//Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4
//","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3
//"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],[
//"9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3",
//"4","5","2","8","6","1","7","9"]]
//Explanation: The input board is shown above and the only valid solution is sho
//wn below:
//
//
// 
//
// 
// Constraints: 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] is a digit or '.'. 
// It is guaranteed that the input board has only one solution. 
// 
// Related Topics Hash Table Backtracking 
// 👍 2539 👎 100

  package com.miueon.leetcode.editor.en
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun solveSudoku(board: Array<CharArray>): Unit {
        val m = 9
        val n = 9
        fun isValid(r: Int, c: Int, ch: Char): Boolean {
            for (i in 0 until 9) {
                if (board[r][i] == ch) {
                    return false
                }
                if (board[i][c] == ch) {
                    return false
                }
                if (board[(r / 3) * 3 + i / 3][(c / 3) * 3 + i % 3] == ch) {
                    return false
                }
            }
            return true
        }
        fun backtrack(i: Int, j: Int): Boolean {
            if (j == n) {
                return backtrack(i+1, 0)
            }
            if (i == m) {
               return true
            }
            if (board[i][j] != '.') {
                return backtrack(i, j+1)
            }
            for (c in 0..8) {
                if (!isValid(i, j, '1' + c)) {
                    continue
                }
                board[i][j] = '1' + c
                if (backtrack(i, j + 1)) {
                    return true
                }
                board[i][j] = '.'
            }
            return false
        }
       backtrack(0, 0)
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 