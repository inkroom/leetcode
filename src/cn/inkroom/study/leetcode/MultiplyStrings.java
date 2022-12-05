package cn.inkroom.study.leetcode;

import org.assertj.core.api.Assertions;

/**
 * @author 墨盒
 * @date 19-4-24
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {


        //首先新建数组以存储结果,,长度最多二者相加.不过高位可能有0

        //由于字符串存储，因此高位在0，平时手算时，从数字低位算起，因此程序应该从length-1算起

        int n1 = num1.length();
        int n2 = num2.length();
        int[] res = new int[n1 + n2];// 从低位往高存，例如 987 数组里是 789


        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                int r = (num1.charAt(n1 - 1 - i) - '0') * (num2.charAt(n2 - 1 - j) - '0');
                r = r + res[i + j];
                if (r > 9) {
                    res[i + j] = r % 10;// 之前已经加过了，所以不能重复 +=
                    res[i + j + 1] += r / 10;
                } else {
                    res[i + j] = r;
                }
                for (int k = i + j; k < res.length - 1; k++) {//往高位进位，可能存在一直向上进位

                    if (res[k] > 9) {
                        res[k + 1] += res[k] / 10;
                        res[k] = res[k] % 10;
                    }

                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            builder.append(res[i]);
        }


        // 去掉高位无用的0
        for (int i = builder.length() - 1; i > 0; i--) {
            if (builder.charAt(i) == '0') {
                builder.deleteCharAt(i);
            } else {
                break;
            }

        }

        return builder.reverse().toString();
    }


    public static void main(String[] args) {
        MultiplyStrings multiplyStrings = new MultiplyStrings();

//        Assertions.assertThat(multiplyStrings.multiply("123", "456")).isEqualTo("56088");
//        Assertions.assertThat(multiplyStrings.multiply("0", "0")).isEqualTo("0");
        Assertions.assertThat(multiplyStrings.multiply("1", "0")).isEqualTo("0");

        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < 100000; j++) {
//                System.out.println("i=" + i + "  j=" + j + "  " + (i * j));
                Assertions.assertThat(multiplyStrings.multiply(String.valueOf(i), String.valueOf(j))).isEqualTo(String.valueOf(i * j));

            }
        }


    }
}
