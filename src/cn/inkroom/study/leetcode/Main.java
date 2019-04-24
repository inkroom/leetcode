package cn.inkroom.study.leetcode;

public class Main {


    public boolean isValid(String s) {

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                case '{':
                case '[':
                    builder.append(s.charAt(i));
                    break;
                case ')':
                case '}':
                case ']':
                    if (!check(builder, s.charAt(i))) {
                        return false;
                    }
            }
        }
        return builder.length() == 0;
    }

    public boolean check(StringBuilder builder, char c) {

        if (builder.length() == 0) {
            return false;
        }
        switch (c) {
            case ')':
                if (builder.charAt(builder.length() - 1) != '(') {
                    return false;
                }
                builder.deleteCharAt(builder.length() - 1);
                return true;
            case '}':
                if (builder.charAt(builder.length() - 1) != '{') {
                    return false;
                }
                builder.deleteCharAt(builder.length() - 1);
                return true;
            case ']':
                if (builder.charAt(builder.length() - 1) != '[') {
                    return false;
                }
                builder.deleteCharAt(builder.length() - 1);
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // write your code here

        System.out.println(new Main().isValid("()[]{}"));
        System.out.println(new Main().isValid("()"));
        System.out.println(new Main().isValid("([]{}"));
        System.out.println(new Main().isValid("(]{}"));
        System.out.println(new Main().isValid("(]{}[)"));

    }
}
