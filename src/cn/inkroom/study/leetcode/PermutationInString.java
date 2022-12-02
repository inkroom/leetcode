package cn.inkroom.study.leetcode;

/**
 * 567. 字符串的排列
 * https://leetcode-cn.com/problems/permutation-in-string/
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {

        //这道题窗口应该是固定大小的，没必要蠕动了
        int left = 0, right = 0, valid = 0, tvalid = 0;

        int[] count = new int[58];
        int[] wcount = new int[58];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 65]++;
            if (count[s1.charAt(i) - 65] == 1) {
                valid++;
            }
        }


        String t = null;

        while (right < s2.length()) {

            char c = s2.charAt(right);
            if (count[c - 65] != 0) {
                wcount[c - 65]++;
                if (wcount[c - 65] == count[c - 65]) {
                    tvalid++;
                }
            }

            right++;

            while (right - left >= s1.length()) {
                if (tvalid == valid) {
                    return true;
                }
                c = s2.charAt(left);
                left++;

                if (count[c - 65] > 0) {
                    if (wcount[c - 65] == count[c - 65]) {
                        tvalid--;
                    }
                    wcount[c - 65]--;
                }
            }
        }

        return false;


    }
}
