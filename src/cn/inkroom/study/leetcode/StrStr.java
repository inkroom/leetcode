package cn.inkroom.study.leetcode;

/**
 * @author 墨盒
 * @date 19-4-22
 */
public class StrStr {
    public int strStr(String haystack, String needle) {

        if (needle.equals("")) return 0;
        if (needle.length() > haystack.length()) return -1;

        int i = 0, j = 0;
        for ( i = 0; i < haystack.length(); i++) {
            if (j == needle.length()) {
                return i - needle.length();
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            } else {//回到源字符串最开始的位置
                i -= j;
                j = 0;
            }
        }
        if (j == needle.length())
            return i - needle.length();
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new StrStr().strStr("hello", "ll"));
        System.out.println(new StrStr().strStr("aaaaa", "bba"));
        System.out.println(new StrStr().strStr("3423434fddff", "343"));
    }
}
