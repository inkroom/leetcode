package cn.inkroom.study.leetcode;

/**
 * 1004. 最大连续1的个数 III
 * https://leetcode-cn.com/problems/max-consecutive-ones-iii/
 */
public class MaxConsecutiveOnesIII {

    public int longestOnes(int[] nums, int k) {

        int r = 0;

        int left = 0, right = 0;

        while (right < nums.length - 1) {

            right++;


            while (left < nums.length && nums[left] != nums[right]) {

                if (nums[left] == 1) {
                    r = Math.max(r, right - left);
                }
                left++;
            }
        }

        return r;

    }
}
