//The n-queens puzzle is the problem of placing n queens on an n×n chessboard su
//ch that no two queens attack each other. 
//
// 
//
// Given an integer n, return the number of distinct solutions to the n-queens p
//uzzle. 
//
// Example: 
//
// 
//Input: 4
//Output: 2
//Explanation: There are two distinct solutions to the 4-queens puzzle as shown 
//below.
//[
// [".Q..",  // Solution 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // Solution 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
// Related Topics Backtracking 
// 👍 523 👎 154


package com.miueon.leetcode.editor.en;

public class NQueensIi {
    public static final Solution solution = new NQueensIi().new Solution();

    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int totalNQueens(int n) {
            /*if (n < 1) {
                return 0;
            }
            int[] record = new int[n];
            return process(0, record, n);*/

            if (n < 1 || n > 32) {
                return 0;
            }
            int upperLim = n == 32? -1: (1 << n) -1;
            return process(upperLim, 0, 0, 0);
        }

        public int process(int upperLim, int colLim, int leftDiaLim, int rightDiaLim) {
            if (colLim == upperLim) {
                return 1;
            }
            int pos = 0;
            int mostRightOne = 0; // 提取 pos 2进制串最右边为1 的
            pos = upperLim & (~(colLim | leftDiaLim | rightDiaLim));
            int res = 0;
            while (pos != 0) {
                mostRightOne = pos & (~pos + 1);
                pos = pos - mostRightOne; // 尝试最右边的
                res += process(upperLim, colLim | mostRightOne, (leftDiaLim | mostRightOne) << 1,
                        (rightDiaLim | mostRightOne) >>> 1);
            }
            return res;
        }

       /* public int process(int i, int[] record, int n) {
            if (i == n) {
                return 1;
            }
            int res = 0;
            for (int j = 0; j < n; j++) {
                if (isValid(record, i, j)) {
                    record[i] = j;
                    res += process(i + 1, record, n);
                }
            }
            return res;
        }

        public boolean isValid(int[] record, int i, int j) {
            for (int k = 0; k < i; k++) {
                if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
                    return false;
                }
            }
            return true;
        }*/


    }
//leetcode submit region end(Prohibit modification and deletion)

}