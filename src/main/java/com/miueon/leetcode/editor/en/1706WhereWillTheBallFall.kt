  //You have a 2-D grid of size m x n representing a box, and you have n balls. Th
//e box is open on the top and bottom sides. 
//
// Each cell in the box has a diagonal board spanning two corners of the cell th
//at can redirect a ball to the right or to the left. 
//
// 
// A board that redirects the ball to the right spans the top-left corner to the
// bottom-right corner and is represented in the grid as 1. 
// A board that redirects the ball to the left spans the top-right corner to the
// bottom-left corner and is represented in the grid as -1. 
// 
//
// We drop one ball at the top of each column of the box. Each ball can get stuc
//k in the box or fall out of the bottom. A ball gets stuck if it hits a "V" shape
//d pattern between two boards or if a board redirects the ball into either wall o
//f the box. 
//
// Return an array answer of size n where answer[i] is the column that the ball 
//falls out of at the bottom after dropping the ball from the ith column at the to
//p, or -1 if the ball gets stuck in the box. 
//
// 
// Example 1: 
//
// 
//
// 
//Input: grid = [[1,1,1,-1,-1],[1,1,1,-1,-1],[-1,-1,-1,1,1],[1,1,1,1,-1],[-1,-1,
//-1,-1,-1]]
//Output: [1,-1,-1,-1,-1]
//Explanation: This example is shown in the photo.
//Ball b0 is dropped at column 0 and falls out of the box at column 1.
//Ball b1 is dropped at column 1 and will get stuck in the box between column 2 
//and 3 and row 1.
//Ball b2 is dropped at column 2 and will get stuck on the box between column 2 
//and 3 and row 0.
//Ball b3 is dropped at column 3 and will get stuck on the box between column 2 
//and 3 and row 0.
//Ball b4 is dropped at column 4 and will get stuck on the box between column 2 
//and 3 and row 1.
// 
//
// Example 2: 
//
// 
//Input: grid = [[-1]]
//Output: [-1]
//Explanation: The ball gets stuck against the left wall.
// 
//
// Example 3: 
//
// 
//Input: grid = [[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1],[1,1,1,1,1,1],[-1,-1,-1,-1,-1
//,-1]]
//Output: [0,1,2,3,4,-1]
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 100 
// grid[i][j] is 1 or -1. 
// 
// Related Topics Dynamic Programming 
// 👍 220 👎 21

  package com.miueon.leetcode.editor.en
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun findBall(grid: Array<IntArray>): IntArray {

        val m = grid.size
        val n = grid[0].size
        val res = IntArray(n){0}
        for (i in 0 until n) {
            var i1 = i
            var i2:Int
            for (j in 0 until m) {

                i2 = i1 + grid[j][i1]
                if (i2 < 0 || i2 >= n || grid[j][i2] != grid[j][i1]) {
                    i1 = -1

                    break
                }
                i1 = i2
            }
            res[i] = i1
        }
        return res
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
 