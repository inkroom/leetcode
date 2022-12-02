package cn.inkroom.study.leetcode;

/**
 * 66. 加一
 * https://leetcode-cn.com/problems/plus-one/
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {

        int last = 1;

        for (int i = digits.length - 1; i >= 0; i--) {

            if (digits[i] + last >= 10) {
                digits[i] = (digits[i]  + last) % 10;
                if (i == 0) {//最高位，数组长度需要加1

                    int[] r = new int[digits.length + 1];
                    System.arraycopy(digits, 0, r, 1, digits.length);
                    r[0] = 1;
                    return r;
                }
                last = 1;
            } else {
                digits[i] += last;
                break;
            }


        }
        return digits;


    }

    private static void out(int[] digest) {
        for (int i = 0; i < digest.length; i++) {
            System.out.print(digest[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {


        out(new PlusOne().plusOne(new int[]{1, 2, 3}));
        out(new PlusOne().plusOne(new int[]{9, 9, 9}));


    }
}
