package org.leo.alg.string;

import java.util.HashSet;
import java.util.Set;

import org.leo.alg.BaseAlg;

/**
 * @Description 最长回文子串 https://leetcode.cn/problems/longest-palindromic-substring/
 * 
 */
public class LongestPalindrome extends BaseAlg {
    private String s;

    @Override
    protected void prepare() {
        s = "abcabcbb";
    }

    @Override
    protected void run() {
        String result = longestPalindrome(s);
        assert result == 3;
        s = " ";
        result = longestPalindrome(s);
        assert result == 1;
    }

    /**
     * 最长回文子串
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty() || s.length() == 1) {
            return s;
        }

        // 中心扩容法
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < s.length() -1; i++) {
            int maxEvenLen = expand(s, i, i);
            int maxOddLen = expand(s, i, i+1);
            int currMax = maxEvenLen > maxOddLen ? maxEvenLen:maxOddLen;
            if ((endIndex - startIndex + 1) < currMax) {
                maxLength = currMax;
                startIndex = i - (maxLength - 1)/2;
            }
        }

        return s.substring(startIndex, startIndex + maxLength);
    }

    public int expand(String s, int left, int right) {
        while (left > 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    
}