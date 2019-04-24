package cn.inkroom.study.leetcode;

/**
 * @author 墨盒
 * @date 19-4-22
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {

        int j = 0;
        int i = 0;
        for (j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }

//    public int removeElement(int[] nums, int val) {
//        int i = 0;
//        int n = nums.length;
//        while (i < n) {
//            if (nums[i] == val) {
//                nums[i] = nums[n - 1];
//                // reduce array size by one
//                n--;
//            } else {
//                i++;
//            }
//        }
//        return n;
//    }

    public static void main(String[] args) {
        System.out.println(new RemoveElement().removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(new RemoveElement().removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));

    }
}
