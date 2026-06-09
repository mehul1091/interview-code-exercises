package org.self.slidingwindow.jun8;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstAtMostTwoDistinctCharsLC159 {

    public static void main(String[] args) {
        String s = "eceba";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s));//3

        System.out.println(lengthOfLongestSubstringTwoDistinct("ccaabbb"));//5
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {

        // Edge case
        if (s == null || s.length() == 0) {
            return 0;
        }

        int start = 0, end = 0;
        int MAX_LEN = 0;

        HashMap<Character, Integer> freq = new HashMap<>();

        while(end < s.length()){

            char ch = s.charAt(end);

            // Expand window if we have < 2 distinct chars OR the char is already in our window
            if(freq.size() < 2 || freq.containsKey(ch)){
                //expand window from right if size of map < 2
                freq.put(ch, freq.getOrDefault(ch, 0) + 1);
                int len = end - start + 1;
                MAX_LEN = Math.max(MAX_LEN, len);
                end++;
            }
            else{
                //shrink window when map size >= 2
                // Shrink window from the left when we hit a 3rd distinct character
                while(freq.size() >= 2){
                    ch = s.charAt(start);

                    if(freq.get(ch) > 1 && freq.containsKey(ch))
                        freq.put(ch, freq.get(ch) - 1);
                    else
                        freq.remove(ch);

                    start++;
                }
            }
        }

        return MAX_LEN;
    }

}
