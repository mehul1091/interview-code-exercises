package org.self.dp.substring;

public class LongestCommonSubstringDP27Recursion implements LongestCommonSubstringDP27{

    private LongestCommonSubstringDP27Recursion impl;

    @Override
    public int printLengthOfLongestCommonSubstring(String s1, String s2) {
        char[] txt1 = s1.toCharArray();
        char[] txt2 = s2.toCharArray();

        return impl.solve(txt1.length-1, txt2.length-1, txt1, txt2, 0);

    }

    public static int solve(int index1, int index2, char[] txt1, char[] txt2, int result){

        //base case
        if(index1<0 || index2<0)
            return result;

        //not match
        int notmatch = Math.max(
                solve(index1-1, index2, txt1, txt2, 0),
                solve(index1, index2-1, txt1, txt2, 0));


        //match
        if(txt1[index1] == txt2[index2]){
            result = solve(index1-1, index2-1, txt1, txt2, result+1);
        }

        return Math.max(result, notmatch);
    }


}
