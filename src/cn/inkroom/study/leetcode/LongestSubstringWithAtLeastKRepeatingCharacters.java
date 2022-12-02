package cn.inkroom.study.leetcode;

/**
 * 395. 至少有 K 个重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {

    // TODO: 2021/11/25 待完成
    public int longestSubstring(String s, int k) {

        int[] count = new int[58];


        int left = 0, right = 0;
        int r = 0, length = 0;

        while (right < s.length()) {

            char c = s.charAt(right);
            right++;
            count[c - 65]++;


        }

        return -1;

    }
}
