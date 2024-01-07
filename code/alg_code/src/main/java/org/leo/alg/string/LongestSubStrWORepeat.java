package org.leo.alg.string;

import java.util.HashSet;
import java.util.Set;

import org.leo.alg.BaseAlg;

/**
 * @Description 不重复的最长公共子串：https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 * 
 */
public class LongestSubStrWORepeat extends BaseAlg {
    private String s;

    @Override
    protected void prepare() {
        s = "abcabcbb";
    }

    @Override
    protected void run() {
        int result = lengthOfLongestSubstring(s);
        assert result == 3;
        s = " ";
        result = lengthOfLongestSubstring(s);
        assert result == 1;
    }

    /**
     * 时间复杂度O(n)，空间复杂度O(1)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Set<Character> currChars = new HashSet<>();
        int currStart = 0;
        int maxLength = 0;
        int i = 0;
        while (i < s.length()) {
            if (currChars.contains(s.charAt(i))) {
                // 当前元素存在重复，移除当前元素对应的字符
                currChars.remove(s.charAt(currStart));
                // 当前元素不算长度（因为重复）
                int currLength = i - currStart;
                maxLength = maxLength > currLength ? maxLength : currLength;
                // 从滑动窗口移除第一个节点
                currStart++;
            } else {
                // 不重复，将其放入滑动窗口中，并判断下个节点
                currChars.add(s.charAt(i));
                i++;
            }
        }
        // 最后，需要判断滑动窗口中的大小和当前最大长度比较，因为，可能没有走到重复字符的判断中
        int currCharsSize = currChars.size();
        maxLength = maxLength > currCharsSize ? maxLength : currCharsSize;
        return maxLength;
    }

    
}