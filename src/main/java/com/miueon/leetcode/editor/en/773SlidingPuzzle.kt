  //On a 2x3 board, there are 5 tiles represented by the integers 1 through 5, and
// an empty square represented by 0. 
//
// A move consists of choosing 0 and a 4-directionally adjacent number and swapp
//ing it. 
//
// The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]
//]. 
//
// Given a puzzle board, return the least number of moves required so that the s
//tate of the board is solved. If it is impossible for the state of the board to b
//e solved, return -1. 
//
// Examples: 
//
// 
//Input: board = [[1,2,3],[4,0,5]]
//Output: 1
//Explanation: Swap the 0 and the 5 in one move.
// 
//
// 
//Input: board = [[1,2,3],[5,4,0]]
//Output: -1
//Explanation: No number of moves will make the board solved.
// 
//
// 
//Input: board = [[4,1,2],[5,0,3]]
//Output: 5
//Explanation: 5 is the smallest number of moves that solves the board.
//An example path:
//After move 0: [[4,1,2],[5,0,3]]
//After move 1: [[4,1,2],[0,5,3]]
//After move 2: [[0,1,2],[4,5,3]]
//After move 3: [[1,0,2],[4,5,3]]
//After move 4: [[1,2,0],[4,5,3]]
//After move 5: [[1,2,3],[4,5,0]]
// 
//
// 
//Input: board = [[3,2,4],[1,5,0]]
//Output: 14
// 
//
// Note: 
//
// 
// board will be a 2 x 3 array as described above. 
// board[i][j] will be a permutation of [0, 1, 2, 3, 4, 5]. 
// 
// Related Topics Breadth-first Search 
// 👍 901 👎 30

  package com.miueon.leetcode.editor.en

  import java.util.*
  import kotlin.collections.HashSet

  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun slidingPuzzle(board: Array<IntArray>): Int {
        val m =2
        val n = 3
        val start = CharArray(m*n){'0'}
        val target = "123450"
        for (i in 0 until m) {
            for (j in 0 until n) {
                start[j+ n*i] = ('0'+ board[i][j])
            }
        }
        val neighbor = listOf<List<Int>>(
            listOf(1,3),
            listOf(0,4,2),
            listOf(1,5),
            listOf(0,4),
            listOf(3,1,5),
            listOf(4,2)
        )

        val q:Queue<String> = LinkedList()
        val visited = HashSet<String>()
        q.offer(String(start))
        visited.add(String(start))

        var step = 0
        while (q.isNotEmpty()) {
            val sz = q.size
            for (i in 0 until sz) {
                val cur = q.poll()
                if (cur.equals(target)) {
                    return step
                }
                var idx = 0
                while (cur[idx] != '0') {
                    idx++
                }
                for (adj in neighbor[idx]) {
                    val new_board = cur.toCharArray()
                    val temp = new_board[idx]
                    new_board[idx] = new_board[adj]
                    new_board[adj] = temp
                    val s_board = String(new_board)
                    if (!visited.contains(s_board)) {
                        q.offer(s_board)
                        visited.add(s_board)
                    }
                }
            }
            step++
        }
        return -1
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 