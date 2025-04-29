package algorithm.数组常见题.双指针;

public class removeElement {
    /**
     *
     * [27. 移除元素](https://leetcode.cn/problems/remove-element/description/)
     *
     */

    // 解法一：双指针
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length;fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    // 解法二：对撞双指针
    public int removeElement2(int[] nums, int val) {
        int right = nums.length - 1;
        int left = 0;

        for (left = 0; left <= right;) {
           if ((nums[left] == val) && (nums[right] != val)) {
               int tmp = nums[left];
               nums[left] = nums[right];
               nums[right] = tmp;
           }
           if (nums[left] != val) left++;
           if (nums[right] ==val) right--;
        }
        return left;
    }
}
