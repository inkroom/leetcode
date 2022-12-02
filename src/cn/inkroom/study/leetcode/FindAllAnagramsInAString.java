package cn.inkroom.study.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 */
public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> r = new ArrayList<>();


        int[] count = new int[58];
        int[] wcount = new int[58];
        int valid = 0, tvalid = 0;
        for (int i = 0; i < p.length(); i++) {
            count[p.charAt(i) - 65]++;
            if (count[p.charAt(i) - 65] == 1) {
                valid++;
            }
        }

        int left = 0, right = 0;
        while (right < s.length()) {

            char c = s.charAt(right);
            right++;

            if (count[c - 65] > 0) {
                wcount[c - 65]++;
                if (wcount[c - 65] == count[c - 65]) {
                    tvalid++;
                }
            }

            while (right - left >= p.length()) {


                if (tvalid == valid) {
                    r.add(left);
                }
                c = s.charAt(left);
                left++;

                if (count[c - 65] > 0) {
                    if (wcount[c - 65] == count[c - 65]) {
                        tvalid--;
                    }
                    wcount[c - 65]--;
                }

            }

        }


        return r;

    }

}
