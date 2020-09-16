package com.miueon.leetcode.editor.en;

import java.util.List;

/*
* arr[5, 2, 3] aim = 20, result 4
* arr[5, 2, 3] aim = 0, result 0
* arr[3, 5] aim = 2
* */
public class mincoins {
    public int solution(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }

        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        for (int col = 1; col <= aim; col++) {
            dp[N][col] = -1;
        }

        for (int i = N - 1; i >= 0; i--) {
            for (int rest = 0; rest <= aim; rest++) {
                dp[i][rest] = -1;
                if (dp[i + 1][rest] != -1) {
                    dp[i][rest] = dp[i + 1][rest];
                }
                if (rest - arr[i] >= 0 && dp[i][rest - arr[i]] != -1) {
                    if (dp[i][rest] == -1) {
                        dp[i][rest] = dp[i][rest - arr[i]] + 1;
                    } else {
                        dp[i][rest] = Math.min(dp[i][rest], dp[i][rest - arr[i]] + 1);
                    }
                }
            }
        }
        return dp[0][aim];
    }

    public static void main(String[] args) {
        List<Integer> arr = List.of(5, 2, 3);

    }

}
