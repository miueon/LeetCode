  //Given a 2D board containing 'X' and 'O' (the letter O), capture all regions su
//rrounded by 'X'. 
//
// A region is captured by flipping all 'O's into 'X's in that surrounded region
//. 
//
// Example: 
//
// 
//X X X X
//X O O X
//X X O X
//X O X X
// 
//
// After running your function, the board should be: 
//
// 
//X X X X
//X X X X
//X X X X
//X O X X
// 
//
// Explanation: 
//
// Surrounded regions shouldn’t be on the border, which means that any 'O' on th
//e border of the board are not flipped to 'X'. Any 'O' that is not on the border 
//and it is not connected to an 'O' on the border will be flipped to 'X'. Two cell
//s are connected if they are adjacent cells connected horizontally or vertically.
// 
// Related Topics Depth-first Search Breadth-first Search Union Find 
// 👍 2492 👎 744

  package com.miueon.leetcode.editor.en
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun solve(board: Array<CharArray>): Unit {
        if (board.isEmpty()) {
            return
        }
        val m = board.size
        val n = board[0].size

        val uf = Union(m * n +1)
        val dummy:Int = m*n
        for (i in 0 until m) {
            if (board[i][0] == 'O') {
                uf.union(i*n, dummy)
            }
            if (board[i][n - 1] == 'O') {
                uf.union(i*n + n -1, dummy)
            }
        }

        for (j in 0 until n) {
            if (board[0][j] == 'O') {
                uf.union(j, dummy)
            }
            if (board[m - 1][j] == 'O') {
                uf.union((m-1)*n + j, dummy)
            }
        }

        val d = Array(4){IntArray(2)}
        d[0] = intArrayOf(1, 0)
        d[1] = intArrayOf(0, 1)
        d[2] = intArrayOf(0, -1)
        d[3] = intArrayOf(-1, 0)

        for (i in 1 until m - 1) {
            for (j in 1 until n - 1) {
                if (board[i][j] == 'O') {
                    for (k in 0..3) {
                        val x = i + d[k][0]
                        val y = j + d[k][1]
                        if (board[x][y] == 'O') {
                            uf.union(x * n + y, i* n +j)
                        }
                    }
                }
            }
        }

        for (i in 1 until m - 1) {
            for (j in 1 until n - 1) {
                if (!uf.connected(dummy, i * n + j)) {
                    board[i][j] = 'X'
                }
            }
        }
    }
    class Union(len: Int) {
        val parent:MutableList<Int> = ArrayList()
        fun union(a: Int, b: Int) {
            val ra = find(a)
            val rb = find(b)
            parent[ra] = rb
        }

        fun find(a: Int): Int {
            var x = a
            while (parent[x] != x) {
                parent[x] = parent[parent[x]]
                x = parent[x]
            }
            return x
        }

        fun connected(a: Int, b: Int) = find(a) == find(b)

        init {
            for (i in 0 until len) {
                parent[i] = i
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 