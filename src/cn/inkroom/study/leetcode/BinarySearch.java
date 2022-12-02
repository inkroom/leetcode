package cn.inkroom.study.leetcode;

/**
 * 704. 二分查找
 * https://leetcode-cn.com/problems/binary-search/
 */
public class BinarySearch {
    public int search(int[] nums, int target) {


        int low = 0, high = nums.length - 1, mid;

        while (low <= high) {

            // low + high 在两数较为接近时，相加可能会产生溢出，以下写法则不会溢出
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {


        System.out.println(new BinarySearch().search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(new BinarySearch().search(new int[]{-1, 0, 3, 5, 9, 12}, 4));
        System.out.println(new BinarySearch().search(new int[]{-1, 0, 3, 5, 9, 12}, 13));


    }
}

