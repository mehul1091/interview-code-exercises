package org.self.dp.substring;

import java.util.Arrays;

public class LongestCommonSubstringDP27Memoization {

    public static int printLengthOfLongestCommonSubstring(String text1, String text2){
        char[] txt1 = text1.toCharArray();
        char[] txt2 = text2.toCharArray();

        int[][] dp = new int[txt1.length][txt2.length];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));

        return solve(txt1.length-1, txt2.length-1, txt1, txt2, 0, dp);
    }

    public static int solve(int index1, int index2, char[] txt1, char[] txt2, int result, int[][] dp){

        //base case
        if(index1<0 || index2<0)
            return result;

        if(dp[index1][index2] != -1)
            return dp[index1][index2];

        //not match
        int notmatch = Math.max(
                solve(index1, index2-1, txt1, txt2, 0, dp),
                solve(index1-1, index2, txt1, txt2, 0, dp)
        );

        //match
        if(txt1[index1] == txt2[index2]){
            result = solve(index1-1, index2-1, txt1, txt2, result+1, dp);
        }

        return dp[index1][index2] = Math.max(notmatch, result);
    }
}
