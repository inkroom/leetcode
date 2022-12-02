package cn.inkroom.study.leetcode;

import org.assertj.core.api.Assertions;

import java.util.HashSet;
import java.util.Set;

/**
 * 219. 存在重复元素 II
 * https://leetcode-cn.com/problems/contains-duplicate-ii/
 */
public class ContainsDuplicateII {
    /**
     * 这道题官方解法居然是直接用HashSet，我。。。。。无话可说
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        // 算了算了，屈服了，双重循环超时，这题就是这样设计的
        Set<Integer> set = new HashSet<>();

        int left = 0, right = 0;

        while (right < nums.length - 1) {
            set.add(nums[right]);
            right++;
            while (right - left > k) {
                set.remove(nums[left]);
                left++;
            }
            if (set.contains(nums[right])) return true;

        }
        return false;
    }

    public static void main(String[] args) {

        Assertions.assertThat(new ContainsDuplicateII().containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3)).isTrue();
        Assertions.assertThat(new ContainsDuplicateII().containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1)).isTrue();

        Assertions.assertThat(new ContainsDuplicateII().containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2)).isFalse();
//        System.out.println(new ContainsDuplicateII().containsNearbyDuplicate(new int[]{1, 2, 1}, 0));
        Assertions.assertThat(new ContainsDuplicateII().containsNearbyDuplicate(new int[]{0, 1, 2, 3, 2, 5}, 3)).isTrue();

        Assertions.assertThat(new ContainsDuplicateII().containsNearbyDuplicate(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 9}, 3)).isTrue();

    }
}
