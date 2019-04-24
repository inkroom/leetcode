package cn.inkroom.study.leetcode;

import java.util.Arrays;

/**
 * @author 墨盒
 * @date 19-4-23
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {


//        if (nums.length < 2) {
//            return new int[]{-1, -1};
//        }
//        if (target < nums[0] && target > nums[nums.length - 1]) {
//            return new int[]{-1, -1};
//        }
        int start = 0;
        int end = nums.length -1 ;


        int[] res = new int[]{-1, -1};
        while (start <= end) {
            int middle = (end + start) / 2;
            if (target > nums[middle]) {//向 右移
                start = middle + 1;
            } else if (target < nums[middle]) {
                end = middle - 1;
            } else {
                int temp = middle;
                //找到元素，因为无法知道到底是第几次出现，只能知道要出现都是在这个位置附近，因此往前后推进寻找
                while (middle >= start && nums[middle] == target)
                    middle--;
                res[0] = middle + 1;
                middle = temp;
                //往右找
                while (middle <= end && nums[middle] == target) {
                    middle++;
                }
                res[1] = middle - 1;
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindFirstAndLastPositionOfElementInSortedArray().searchRange(new int[]{2, 2}, 3)));

        System.out.println(Arrays.toString(new FindFirstAndLastPositionOfElementInSortedArray().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));

        System.out.println(Arrays.toString(new FindFirstAndLastPositionOfElementInSortedArray().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
    }
}
