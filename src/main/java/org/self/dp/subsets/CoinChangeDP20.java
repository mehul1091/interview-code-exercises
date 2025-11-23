package org.self.dp.subsets;

public class CoinChangeDP20 {
    public static void main(String[] args) {
        CoinChangeDP20 cl = new CoinChangeDP20();
        int res = cl.coinChange(new int[]{1,2,5}, 11);
        System.out.println(res);
    }


    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int res = solve(n - 1, amount, coins);

        if (res == 1e9)
            return -1;
        else
            return res;
    }

    //recursion
    public int solve(int index, int amountLeft, int[] coins) {

        //base case
        //Impossible path → return sentinel value
        if (index < 0)
            return (int) 1e9;

        //invalid path
        //Impossible path → return sentinel value
        if (amountLeft < 0)
            return (int) 1e9;

        if (index == 0) {
            if (amountLeft % coins[0] == 0) {
                return amountLeft / coins[0];
            } else
                return (int) 1e9;
        }

        //not pick
        int notpick = solve(index - 1, amountLeft, coins);

        //pick
        int pick = (int) 1e9;
        if (amountLeft - coins[index] >= 0)
            pick = 1 + solve(index, amountLeft - coins[index], coins);

        return Math.min(notpick, pick);

    }

    //Memoization
    public int solve(int index, int amountLeft, int[] coins, int[][] dp){

        //base case
        //If you have no coins left and amount is still positive,
        // if(index < 0)
        //     return 0;

        //invalid path
        //Impossible path → return sentinel value
        if(index < 0)
            return (int) 1e9;

        //invalid path
        //Impossible path → return sentinel value
        if(amountLeft < 0)
            return (int) 1e9;

        if(index == 0){
            if( amountLeft % coins[0] == 0){
                return dp[index][amountLeft] = amountLeft / coins[0];
            }
            else
                return dp[index][amountLeft] = (int) 1e9;
        }

        if(dp[index][amountLeft] != -1)
            return dp[index][amountLeft];

        //not pick
        int notpick = solve(index-1, amountLeft, coins, dp);

        //pick
        int pick = (int) 1e9;
        if(amountLeft - coins[index] >= 0)
            pick = 1 + solve(index, amountLeft - coins[index], coins, dp);

        return dp[index][amountLeft] = Math.min(notpick, pick);

    }

    //tabulation
    public int solveTabulation(int[] coins, int amount) {

        //tabulation

        int n = coins.length;

        int[][] dp = new int[n][amount+1];

        //for amount=0, populate for all coins
        for(int i=0; i<n; i++){
            dp[i][0] = 0;
        }

        //for coin[0] check if amount can be fulfilled
        for(int amt=1; amt<=amount; amt++){
            if(amt % coins[0] == 0)
                dp[0][amt] = amt/coins[0];
            else
                dp[0][amt] = (int) 1e9;
        }

        //start from 1,1
        for(int index=1; index<n; index++){

            for(int amt=1; amt<amount+1; amt++){

                //not pick
                int notpick = dp[index-1][amt];

                //pick
                int pick = (int) 1e9;
                if(amt - coins[index] >= 0)
                    pick = 1 + dp[index][amt - coins[index]];

                dp[index][amt] = Math.min(notpick, pick);
            }
        }

        return (dp[n-1][amount] == (int) 1e9) ? -1 : dp[n-1][amount];
    }

    //space optimized
    public int solveSpaceOptimized(int[] coins, int amount) {

        //space optimized

        int n = coins.length;

        // int[][] dp = new int[n][amount+1];
        int[] dpPrev = new int[amount+1];

        //for amount=0, populate for all coins
        // for(int i=0; i<n; i++){
        //     dp[i][0] = 0;
        // }

        dpPrev[0] = 0;

        //for coin[0] check if amount can be fulfilled
        for(int amt=1; amt<=amount; amt++){
            if(amt % coins[0] == 0)
                dpPrev[amt] = amt/coins[0];
            else
                dpPrev[amt] = (int) 1e9;
        }

        //start from 1,1
        for(int index=1; index<n; index++){

            int[] dpCurr = new int[amount+1];
            dpCurr[0] = 0;

            for(int amt=1; amt<amount+1; amt++){

                //not pick
                int notpick = dpPrev[amt];

                //pick
                int pick = (int) 1e9;
                if(amt - coins[index] >= 0)
                    pick = 1 + dpCurr[amt - coins[index]];

                dpCurr[amt] = Math.min(notpick, pick);
            }

            dpPrev = dpCurr;
        }

        return (dpPrev[amount] == (int) 1e9) ? -1 : dpPrev[amount];
    }
}
