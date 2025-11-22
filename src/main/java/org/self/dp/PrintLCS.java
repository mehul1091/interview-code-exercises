package org.self.dp;

public class PrintLCS {

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "bdgek"));

        System.out.println(longestCommonSubsequence("abc", "abc"));

        System.out.println(longestCommonSubsequence("abc", "def"));
    }

    public static String longestCommonSubsequence(String text1, String text2) {

        char[] txt1 = text1.toCharArray();
        char[] txt2 = text2.toCharArray();

        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n+1][m+1];

        //1st row row=0, for empty subsequence
        for(int row=0; row<n+1; row++){
            dp[row][0] = 0;
        }

        //1st col=0, for empty subsequence
        for(int col=0; col<m+1; col++){
            dp[0][col] = 0;
        }

        //start from 1,1
        for(int row=1; row<n+1; row++){

            for(int col=1; col<m+1; col++){

                int match=Integer.MIN_VALUE;
                if(txt1[row-1] == txt2[col-1]){
                    match = 1 + dp[row-1][col-1];
                }

                int notmatch = 0 + Math.max(dp[row][col-1], dp[row-1][col]);

                dp[row][col] = Math.max(notmatch, match);

            }
        }

        String result = new String();

        int index1=n;
        int index2=m;

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
}
