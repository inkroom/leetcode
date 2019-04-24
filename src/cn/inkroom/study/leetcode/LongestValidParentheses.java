package cn.inkroom.study.leetcode;

/**
 * @author 墨盒
 * @date 19-4-23
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {

        int max = 0;
        int every = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                    builder.append(c);
                    every++;
                    break;
                case ')':
                    if (builder.length() == 0) {
                        max = every > max ? every : max;
                        every = 0;
                    } else if (builder.charAt(builder.length() - 1) != '(') {//结束合格子串
                        max = every > max ? every : max;
                        every = 0;
                        //清空当前栈，并立马开始下一次判断
                        builder = new StringBuilder();
//                        builder.append(c);
                    } else {//符合条件的数据
                        //此时应该将当前值入栈，开始下一个子串判断
                        every++;
                        builder.deleteCharAt(builder.length() - 1);
                    }
                    break;
            }
        }
        every = every - builder.length();
        return every > max ? every : max;

    }


    public static void main(String[] args) {
//TODO 19-4-23 未解决
        System.out.println(new LongestValidParentheses().longestValidParentheses("()(()"));

//        System.out.println(new LongestValidParentheses().longestValidParentheses("(()"));
//        System.out.println(new LongestValidParentheses().longestValidParentheses(")()())"));

    }
}
