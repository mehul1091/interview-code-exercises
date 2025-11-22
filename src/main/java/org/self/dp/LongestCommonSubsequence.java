package org.self.dp;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "bdgek";

        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        String res = longestCommonSubsequence.printLongestCommonSubsequence(s1, s2);

        System.out.println(res);
    }

    public String printLongestCommonSubsequence(String text1, String text2) {

        char[] txt1 = text1.toCharArray();
        char[] txt2 = text2.toCharArray();

        //this is IMP
        int[][] dp = new int[txt1.length + 1][txt2.length + 1];

        //base case - Initialization of the DP Array:
        //The first row and column should be initialized to 0,
        //as they represent the case where one of the strings is empty.

        // Initialize the first row and column to 0
        for (int i = 0; i <= txt1.length; i++) {
            dp[i][0] = 0; // First column
        }
        for (int j = 0; j <= txt2.length; j++) {
            dp[0][j] = 0; // First row
        }

        //start from 1,1
        for (int row = 1; row < txt1.length + 1; row++) {

            for (int col = 1; col < txt2.length + 1; col++) {

                if (txt1[row - 1] == txt2[col - 1])
                    dp[row][col] = 1 + dp[row - 1][col - 1];//fetch diagonal
                else
                    dp[row][col] = 0 + Math.max(dp[row][col - 1], dp[row - 1][col]);
            }
        }

        //find length
        //use dp filled array to compute result
        int lcsLength = dp[txt1.length][txt2.length];
        String result = new String();

        int index1 = txt1.length, index2 = txt2.length;
        while (index1 > 0 && index2 > 0) {

            if (txt1[index1 - 1] == txt2[index2 - 1]) {

                //add char to result
                result = txt1[index1 - 1] + result;

                //move to diagonal
                index1--;
                index2--;
            } else {
                if (dp[index1][index2 - 1] > dp[index1 - 1][index2]) {
                    index2--;
                } else
                    index1--;
            }
        }

        return result.toString();
    }

}
