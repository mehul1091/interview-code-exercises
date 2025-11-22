package org.self.dp.oneD;

import java.util.Arrays;

public class FrogJumpWithkDP4 {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 5, 20, 0, 15};
        int k = 2;
        System.out.println(frogJump(arr, k));//15

        arr = new int[]{15, 4, 1, 14, 15};//2
        k = 3;
        System.out.println(frogJump(arr, k));
    }

    public static int frogJump(int[] heights, int k) {
        int n = heights.length;
        //recursion
//        return solve(n-1, heights, k);

        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        //memoization
//        return solveWithMemoization(n-1, heights, k, dp);

        return solveWithTabulation(heights, k);
    }

    public static int solveWithTabulation(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];

        //base case
        dp[0] = 0;

        for(int index=1; index<n; index++){

            int result = Integer.MAX_VALUE;
            for(int step=1; step<=k; step++){

                if(index-step >= 0){
                    int option = Math.abs(arr[index] - arr[index-step]) + dp[index-step];
                    result = Math.min(result, option);
                }
            }

            dp[index] = result;
        }

        return dp[n-1];
    }

    public static int solveWithMemoization(int index, int[] arr, int k, int[] dp){

        //base case
        if(index == 0)
            return 0;

        if(dp[index] != -1)
            return dp[index];

        int result = Integer.MAX_VALUE;
        for (int step = 1; step <= k; step++) {

            if(index - step >= 0){
                int option = Math.abs(arr[index] - arr[index-step]) + solveWithMemoization(index-step, arr, k, dp);
                result = Math.min(option, result);
            }

        }

        return dp[index] = result;
    }



    //recursion
    public static int solve(int index, int[] arr, int k){

        //base case
        if(index == 0)
            return 0;

        int result = Integer.MAX_VALUE;
        for(int step = 1; step <= k; step++){

            if(index-step >= 0){
                int option = Math.abs(arr[index] - arr[index-step]) + solve(index-step, arr, k);

                result = Math.min(result, option);
            }
        }

        return result;
    }
}
