package algorithm.数组常见题.Leetcode;

import java.util.ArrayList;

public class sortArrayByParity {

    /**
     *
     * [905. 按奇偶排序数组](https://leetcode.cn/problems/sort-array-by-parity/description/)
     *
     */

    // 解法一：直接循环
    public int[] sortArrayByParity(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>(nums.length);
        for (int i=0;i<nums.length;i++) {
            if (nums[i] % 2 == 0) ans.add(nums[i]);
        }
        for (int i=0;i<nums.length;i++) {
            if (nums[i] % 2 != 0) ans.add(nums[i]);
        }
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }

    // 官方代码：2次循环
    public int[] sortArrayByParity2(int[] nums) {
        int n = nums.length, index = 0;
        int[] res = new int[n];
        for (int num : nums) {
            if (num % 2 == 0) {
                res[index++] = num;
            }
        }
        for (int num : nums) {
            if (num % 2 == 1) {
                res[index++] = num;
            }
        }
        return res;
    }

    // 解法二：
    public int[] sortArrayByParity3(int[] nums) {
        int front = 0;
        int end = nums.length - 1;
        while (front < end) {
            if ((nums[front] % 2) != 0 && (nums[end] % 2 == 0)) {
                int temp = nums[front];
                nums[front] = nums[end];
                nums[end] = temp;
            }
            if (nums[front] % 2 == 0) {
                front++;
            }
            if (nums[end] % 2 != 0) {
                end--;
            }
        }
        return nums;
    }
}
