  //Given a m * n matrix mat and an integer K, return a matrix answer where each a
//nswer[i][j] is the sum of all elements mat[r][c] for i - K <= r <= i + K, j - K 
//<= c <= j + K, and (r, c) is a valid position in the matrix.
// 
// Example 1: 
//
// 
//Input: mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
//Output: [[12,21,16],[27,45,33],[24,39,28]]
// 
//
// Example 2: 
//
// 
//Input: mat = [[1,2,3],[4,5,6],[7,8,9]], K = 2
//Output: [[45,45,45],[45,45,45],[45,45,45]]
// 
//
// 
// Constraints: 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n, K <= 100 
// 1 <= mat[i][j] <= 100 
// Related Topics Dynamic Programming 
// 👍 382 👎 70

  
  package com.miueon.leetcode.editor.en;
  public class MatrixBlockSum{
        public static final Solution solution = new MatrixBlockSum().new Solution();
      public static void main(String[] args) {
           
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length;
        int n = mat[0].length;

        int [][] ans = new int[m][n];
        // sum of mat[r][c] : r: <i-k, i+k>, c: <j-k, j+k>
        int[][] t = new int[m + 1][n + 1];
        for (int i = 1; i < t.length; i++) {
            for (int j = 1; j < t[0].length; j++) {
                t[i][j] = t[i - 1][j] + t[i][j - 1] + mat[i - 1][j - 1] - t[i - 1][j - 1];
                // each element of this table contains all of the sum of mat[0~i][0~j]
            }
        }
        int r1, r2, c1, c2;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                 r1 = Math.max(0, i-K) + 1;
                 c1 = Math.max(0, j-K) + 1;
                 r2 = Math.min(m, i + K + 1); // +1 is because the table index start from 1,
                 c2 = Math.min(n, j + K + 1);
                ans[i][j] = t[r2][c2] - t[r1 - 1][c2] - t[r2][c1 - 1] + t[r1 - 1][c1 - 1];
            }
            // ans is the sum-table window 右下角的值减去 左下角的值 减去 右上角的值 加上 初始位置的补正
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }