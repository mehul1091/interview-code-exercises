package org.self.dp;

import java.util.Arrays;

public class CountWaysToMakeCoinChange {

    public static void main(String[] args) {
        CountWaysToMakeCoinChange ques = new CountWaysToMakeCoinChange();
        int result = ques.change(3, new int[]{2});
        System.out.println(result);

        result = ques.change(3, new int[]{3});
        System.out.println(result);

    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));

        return dp[n-1][amount] = solve(n-1, amount, coins, dp);

    }

    public int solve(int index, int target, int[] arr, int[][] dp){

        //base case
        if(index == 0){
            if(target % arr[0] == 0)
                return 1;
            else
                return 0;
        }

        if(dp[index][target] != -1)
            return dp[index][target];

        //not pick
        int notpick = solve(index-1, target, arr, dp);

        //pick
        int pick = 0;
        if(target-arr[index] >= 0)
            pick = solve(index, target-arr[index], arr, dp);

        return dp[index][target] = (notpick + pick);
    }
}
