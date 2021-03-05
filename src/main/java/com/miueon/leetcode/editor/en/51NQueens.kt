//The n-queens puzzle is the problem of placing n queens on an n x n chessboard
//such that no two queens attack each other. 
//
// Given an integer n, return all distinct solutions to the n-queens puzzle. 
//
// Each solution contains a distinct board configuration of the n-queens' placem
//ent, where 'Q' and '.' both indicate a queen and an empty space, respectively. 
//
// 
// Example 1: 
//
// 
//Input: n = 4
//Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//Explanation: There exist two distinct solutions to the 4-queens puzzle as show
//n above
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: [["Q"]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 9 
// 
// Related Topics Backtracking 
// 👍 2686 👎 98

package com.miueon.leetcode.editor.en

import java.util.*
import kotlin.collections.ArrayList

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun solveNQueens(n: Int): List<List<String>> {
        val res = ArrayList<ArrayList<String>>()
        val board = Array(n) {
            CharArray(n) { '.' }
        }

        fun isValid(board: Array<CharArray>, row: Int, col: Int): Boolean {
            for (i in 0 until n) {
                if (board[i][col] == 'Q') {
                    return false
                }
            }
            // 检查右上方是否有皇后互相冲突
            var i = row - 1
            var j = col + 1
            while (i >= 0 && j < n) {
                if (board[i][j].toByte() == 'Q'.toByte()) return false
                i--
                j++
            }
            // 检查左上方是否有皇后互相冲突
            i = row - 1
            j = col - 1
            while (i >= 0 && j >= 0) {
                if (board[i][j].toByte() == 'Q'.toByte()) return false
                i--
                j--
            }
            return true
        }

        fun backtrack(board: Array<CharArray>, row: Int) {
            if (row == board.size) {
                val bd = LinkedList<String>()
                for (chars in board) {
                    bd.add(String(chars))
                }
                res.add(ArrayList(bd))
                return
            }
            for (col in 0 until n) {
                if (!isValid(board, row, col)) {
                    continue
                }
                board[row][col] = 'Q'

                backtrack(board, row + 1)
                board[row][col] = '.'
            }
        }
        backtrack(board, 0)
        return res
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 