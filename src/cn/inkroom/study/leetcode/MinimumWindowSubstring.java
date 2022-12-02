package cn.inkroom.study.leetcode;

/**
 * 76. 最小覆盖子串
 * https://leetcode-cn.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {

        int left = 0, right = 0;

        //58足以装下大小写字母
        int[] count = new int[58];
        int[] wcount = new int[58];

        int valid = 0, tvalid = 0;

        int rleft = 0, length = Integer.MAX_VALUE;
        //统计字符出现次数
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 65]++;
            if (count[t.charAt(i) - 65] == 1) {
                tvalid++;
            }
        }

        while (right < s.length()) {

            char c = s.charAt(right);
            right++;

            if (count[c - 65] != 0) {//是需要包含的字符
                wcount[c - 65]++;
                if (wcount[c - 65] == count[c - 65]) {
                    valid++;
                }
            }

            while (valid == tvalid) {
                //首先记录目前找到的最小的符合条件的子串
                if ((right - left) < length) {
                    rleft = left;
                    length = right - left;
                }
                //收缩left，直到window不符合条件
                c = s.charAt(left);

                if (count[c - 65] != 0) {//需要包含的字符
                    if (wcount[c - 65] == count[c - 65])//依然只能移除一次
                        valid--;
                    wcount[c - 65]--;
                }
                left++;
            }
        }


        return length == Integer.MAX_VALUE ? "" : s.substring(rleft, rleft + length);


    }

    public static void main(String[] args) {
//        System.out.println('A'-65);
//        System.out.println('z' - 65);


        System.out.println(new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));

        System.out.println(new MinimumWindowSubstring().minWindow("a", "aa"));
        System.out.println(new MinimumWindowSubstring().minWindow("bbaaz", "aba"));
        System.out.println(new MinimumWindowSubstring().minWindow("cgklivwehljxrdzpfdqsapogwvjtvbzahjnsejwnuhmomlfsrvmrnczjzjevkdvroiluthhpqtffhlzyglrvorgnalk", "mqfff"));

    }

}

// 以下逻辑正确，但是最后一个测试用例超时

//class Solution {
//    public String minWindow(String s, String t) {
//
//        int left = 0, right = 0;
//
//        String window;
//
//        String r = null;
//
//
//        //58足以装下大小写字母
//        int[] count = new int[58];
//
//        //统计字符出现次数
//        for (int i = 0; i < t.length(); i++) {
//            count[t.charAt(i) - 65]++;
//        }
//
//        while (right < s.length()) {
//
//            right++;
//            window = s.substring(left, right);
//
//
//            while (contains(count, t, window)) {
//                if (r == null || r.length() > window.length()) {
//                    r = window;
//                }
//                //收缩left，直到window不符合条件
//                left++;
//                window = s.substring(left, right);
//            }
//
//
//        }
//
//
//        return r == null ? "" : r;
//
//
//    }
//
//    /**
//     * 判断window中是否包含t中所有字母，允许多出其他字符
//     *
//     * @param t
//     * @param window
//     * @return
//     */
//    private boolean contains(int[] count, String t, String window) {
//
//        //要求应该理解成，某个字符在t中出现的次数应该不少于该字符在window中出现的次数
//        if (window.length() < t.length()) return false;
//
//        //58足以装下大小写字母
//        int[] wcount = new int[58];
//
//        //统计字符出现次数
//
//        for (int i = 0; i < window.length(); i++) {
//            wcount[window.charAt(i) - 65]++;
//        }
//
//        //比对数量
//        for (int i = 0; i < count.length; i++) {
//            if (count[i] > wcount[i]) return false;
//        }
//
//        return true;
//
//    }
//}