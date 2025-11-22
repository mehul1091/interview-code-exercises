package org.self.dp;

import java.util.Arrays;

public class PrintLCSMemoization {
    public static void main(String[] args) {

        System.out.println(longestCommonSubsequence("abcde", "bdgek"));

        System.out.println(longestCommonSubsequence("abc", "abc"));

        System.out.println(longestCommonSubsequence("abc", "def"));
    }

    public static String longestCommonSubsequence(String text1, String text2) {
        char[] txt1 = text1.toCharArray();
        char[] txt2 = text2.toCharArray();

        int[][] dp = new int[txt1.length][txt2.length];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));

        solve(txt1.length-1, txt2.length-1, txt1, txt2, dp);

        String result = new String();

        int index1= txt1.length;
        int index2= txt2.length;

        while(index1>0 && index2>0){

            if(txt1[index1-1] == txt2[index2-1]){
                index1--;
                index2--;
                result = txt2[index2] + result;
            }
            else if(dp[index1][index2-1] > dp[index1-1][index2]){
                index2--;
            }
            else {
                index1--;
            }
        }

        return result;
    }

    public static int solve(int index1, int index2, char[] txt1, char[] txt2, int[][] dp){

        //base case
        if(index1 < 0 || index2 < 0)
            return 0;

        if(dp[index1][index2] != -1)
            return dp[index1][index2];

        if(txt1[index1] == txt2[index2])
            return  dp[index1][index2] = 1 + solve(index1-1, index2-1, txt1, txt2, dp);
        else
            return dp[index1][index2] = 0 + Math.max(solve(index1-1, index2, txt1, txt2, dp), solve(index1, index2-1, txt1, txt2, dp));

    }
}
