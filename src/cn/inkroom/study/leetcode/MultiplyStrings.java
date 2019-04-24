package cn.inkroom.study.leetcode;

/**
 * @author 墨盒
 * @date 19-4-24
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {


        //首先新建数组以存储结果,,长度最多二者相加.不过高位可能有0

        //由于字符串存储，因此高位在0，平时手算时，从数字低位算起，因此程序应该从length-1算起

        if (num1.length() == 0 || num2.length() == 0) return "";
        int n1 = num1.length();
        int n2 = num2.length();
        int[] res = new int[num1.length() + num2.length()];

        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                //将字符转成数字
                int single = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int temp = single + res[i + j + 1];//低位可能有进位，需要累加
                res[i + j] = temp / 10;
                res[i + j + 1] = temp % 10;
            }
        }

        //由于计算出来可能出现高位为0，需要去掉
        int start = 0;
        while (start < res.length && res[start] == 0) {
            start++;
        }

        //最后由于计算之后的位，高位在字符串前，因此需要丢弃前半截0
        StringBuilder builder = new StringBuilder();
        for (; start < res.length; start++) {
            builder.append(res[start]);
        }
        return builder.toString();

    }

    public static void main(String[] args) {
        System.out.println(123 * 456);
        System.out.println(new MultiplyStrings().multiply("123", "456"));
    }
}
