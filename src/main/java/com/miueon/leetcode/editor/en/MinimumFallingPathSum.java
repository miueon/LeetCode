  //Given a square array of integers A, we want the minimum sum of a falling path 
//through A. 
//
// A falling path starts at any element in the first row, and chooses one elemen
//t from each row. The next row's choice must be in a column that is different fro
//m the previous row's column by at most one. 
//
// 
//
// Example 1: 
//
// 
//Input: [[1,2,3],[4,5,6],[7,8,9]]
//Output: 12
//Explanation: 
//The possible falling paths are:
// 
//
// 
// [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9] 
// [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9] 
// [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9] 
// 
//
// The falling path with the smallest sum is [1,4,7], so the answer is 12. 
//
// 
// Constraints: 
//
// 
// 1 <= A.length == A[0].length <= 100 
// -100 <= A[i][j] <= 100 
// 
// Related Topics Dynamic Programming 
// 👍 734 👎 62

  
  package com.miueon.leetcode.editor.en;

  import java.util.ArrayList;
  import java.util.List;

  public class MinimumFallingPathSum{
        public static final Solution solution = new MinimumFallingPathSum().new Solution();
      public static void main(String[] args) {
          int[][] A = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
          int[][] B = new int[][]{{51, 24}, {-50, 82}};
          System.out.println(solution.minFallingPathSum(B));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minFallingPathSum(int[][] A) {
        int N = A.length;
        int[][] dp = new int[A.length][A.length];
        for (int j = 0; j < N; j++) {
            dp[N - 1][j] = A[N - 1][j];
        }
        int current;
        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j < N ; j++) {
                current = A[i][j];
                if (j > 0 && j < N - 1) {
                    int min1 = Math.min(dp[i + 1][j - 1], dp[i + 1][j]);
                    dp[i][j] = current + Math.min(min1, dp[i + 1][j + 1]);
                } else if (j == 0) {
                    dp[i][j] = current + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
                } else {
                    dp[i][j] = current + Math.min(dp[i + 1][j], dp[i + 1][j - 1]);
                }
            }
        }

       /* int N = A.length;
        int[] dp = new int[N];
        for (int j = 0; j < N; j++) {
            dp[j] = A[N - 1][j];
        }
        for (int i = 0; i < N; i++) {
            System.out.print(dp[i]);
            System.out.print(" ");
        }
        System.out.println();
        int current;
        int min1;
        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j < N ; j++) {
                current = A[i][j];
                if (j > 0 && j < N - 1) {
                    min1 = Math.min(dp[j - 1], dp[j]);
                    dp[j] = current + Math.min(min1, dp[j + 1]);
                } else if (j == 0) {
                    dp[j] = current + Math.min(dp[j], dp[j + 1]);
                } else {
                    dp[j] = current + Math.min(dp[j], dp[j - 1]);
                }
            }
        }*/
        /*for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(dp[i][j]);
                System.out.println(" ");
            }
            System.out.println();
        }*/
       /* for (int i = 0; i < N; i++) {
            System.out.print(dp[i]);
            System.out.print(" ");
        }
        System.out.println();*/

        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }