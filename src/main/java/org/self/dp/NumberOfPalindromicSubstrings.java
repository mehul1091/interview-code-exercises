package org.self.dp;

public class NumberOfPalindromicSubstrings {

    public static void main(String[] args) {
        int result;

        result = countSubstrings("abc");
        if(result != 3) throw new RuntimeException("expected 3");

        result = countSubstrings("aaa");
        if(result != 6) throw new RuntimeException("expected 6");
    }

    public static int countSubstrings(String s) {
        char[] text = s.toCharArray();

        return solve(text.length-1, text);
    }

    //brute force
    public static int solve(int index, char[] text){

        int count = 0;

        for(int i=index; i>=0; i--){
            //check if palindrome

            int start=0, end=i;
            while(start<=end && start<text.length && end>=i){
                if(text[start] == text[end]){
                    count++;
                    start++;
                    end--;
                }
                else
                    break;
            }
        }

        return count;
    }
}



