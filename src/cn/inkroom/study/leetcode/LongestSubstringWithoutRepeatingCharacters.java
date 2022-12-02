package cn.inkroom.study.leetcode;

/**
 * 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int[] count = new int[128];
        int left = 0, right = 0;
        int r = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            count[c]++;
            right++;
            while (count[c] > 1) {
                char d = s.charAt(left);
                count[d]--;
                left++;
            }
            r = Math.max(r, right - left);
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(" "));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(""));

    }
}
