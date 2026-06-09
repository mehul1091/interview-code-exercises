package org.self.slidingwindow.jun8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LongestSubstAtMostTwoDistinctCharsTestsLC159 {

    private final LongestSubstAtMostTwoDistinctCharsLC159 solution = new LongestSubstAtMostTwoDistinctCharsLC159();



    @Test
    void emptyString() {
        assertEquals(0, solution.lengthOfLongestSubstringTwoDistinct(""));
    }

    @Test
    void singleCharacter() {
        assertEquals(1, solution.lengthOfLongestSubstringTwoDistinct("a"));
    }

    @Test
    void allSameCharacters() {
        assertEquals(5, solution.lengthOfLongestSubstringTwoDistinct("aaaaa"));
    }

    @Test
    void entireStringValid() {
        assertEquals(6, solution.lengthOfLongestSubstringTwoDistinct("ababab"));
    }

    @Test
    void thirdCharacterForcesShrink() {
        assertEquals(4, solution.lengthOfLongestSubstringTwoDistinct("abaccc"));
    }

    @Test
    void classicSlidingWindowCase() {
        assertEquals(10,
                solution.lengthOfLongestSubstringTwoDistinct(
                        "abcbbbbcccbdddadacb"));
    }

    @Test
    void longestAtBeginning() {
        assertEquals(6, solution.lengthOfLongestSubstringTwoDistinct("aabbbbcd"));
    }

    @Test
    void longestAtEnd() {
        assertEquals(7, solution.lengthOfLongestSubstringTwoDistinct("abcdddddd"));
    }

    @Test
    void repeatedThreeDistinctCharacters() {
        assertEquals(2, solution.lengthOfLongestSubstringTwoDistinct("abcabcabc"));
    }

    @Test
    void shrinkMultipleTimes() {
        assertEquals(4, solution.lengthOfLongestSubstringTwoDistinct("aabbcc"));
    }

    @Test
    void boundaryCase() {
        assertEquals(3, solution.lengthOfLongestSubstringTwoDistinct("baa"));
    }




    // 1. Standard Example 1
    @Test
    void tc1() {
        assertEquals(3,
                solution.lengthOfLongestSubstringTwoDistinct("eceba"));
    }

    // 2. Standard Example 2 (Tests correct map deletion when 3rd char appears)
    @Test
    void tc2() {
        assertEquals(5,
                solution.lengthOfLongestSubstringTwoDistinct("ccaabbb"));
    }

    // 3. Base Case: Empty string
    @Test
    void tc3() {
        assertEquals(0,
                solution.lengthOfLongestSubstringTwoDistinct(""));
    }

    // 4. Base Case: Single character (1 distinct char is <= 2)
    @Test
    void tc4() {
        assertEquals(1,
                solution.lengthOfLongestSubstringTwoDistinct("a"));
    }

    // 5. Exactly two characters
    @Test
    void tc5() {
        assertEquals(2,
                solution.lengthOfLongestSubstringTwoDistinct("ab"));
    }

    // 6. Exactly three characters (forces a split immediately)
    @Test
    void tc6() {
        assertEquals(2,
                solution.lengthOfLongestSubstringTwoDistinct("abc"));
    }

    // 7. Single Distinct Character Trap: All same characters
    @Test
    void tc7() {
        assertEquals(6,
                solution.lengthOfLongestSubstringTwoDistinct("aaaaaa"));
    }

    // 8. Single Distinct Character Trap: Long string of 1 distinct character
    @Test
    void tc8() {
        assertEquals(8,
                solution.lengthOfLongestSubstringTwoDistinct("bbbbbbbb"));
    }

    // 9. Tricky Pattern: Entire string is valid (only 2 distinct chars total)
    @Test
    void tc9() {
        assertEquals(9,
                solution.lengthOfLongestSubstringTwoDistinct("ababababa"));
    }

    // 10. Tricky Pattern: Constant shifting (max valid substring is always length 2)
    @Test
    void tc10() {
        assertEquals(2,
                solution.lengthOfLongestSubstringTwoDistinct("abcabcabc"));
    }

    // 11. Tricky Pattern: Tests if the left pointer shrinks correctly
    @Test
    void tc11() {
        assertEquals(3,
                solution.lengthOfLongestSubstringTwoDistinct("abac"));
    }

    // 12. Tricky Pattern: Left pointer shrink check
    @Test
    void tc12() {
        assertEquals(3,
                solution.lengthOfLongestSubstringTwoDistinct("baccb"));
    }

    // 13. Performance Test: Massive single-character string (O(N) check)
    @Test
    void tc13() {
        assertEquals(100000,
                solution.lengthOfLongestSubstringTwoDistinct("a".repeat(100000)));
    }

    // 14. Performance Test: Massive alternating string (O(N) check)
    @Test
    void tc14() {
        assertEquals(100000,
                solution.lengthOfLongestSubstringTwoDistinct("ab".repeat(50000)));
    }

    // 15. Performance Test: Forces constant map deletions
    @Test
    void tc15() {
        assertEquals(2,
                solution.lengthOfLongestSubstringTwoDistinct("abc".repeat(33333) + "a"));
    }

    // 16. Special Characters: Spaces count as distinct characters
    @Test
    void tc16() {
        assertEquals(5,
                solution.lengthOfLongestSubstringTwoDistinct("a a a"));
    }

    // 17. Special Characters: All unique characters
    @Test
    void tc17() {
        assertEquals(2,
                solution.lengthOfLongestSubstringTwoDistinct("code"));
    }
}