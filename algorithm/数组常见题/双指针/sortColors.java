package algorithm.数组常见题.双指针;

public class sortColors {

    /**
     *
     * [75. 颜色分类](https://leetcode.cn/problems/sort-colors/description/)
     * 要求原地排序
     * 也就是升序排序数组
     */

    // 解法一：基于冒泡排序的双指针（快慢指针）
    public void sortColors(int[] nums) {
        int n = nums.length;
        int left = 0;
        // 将所有的0交换到数组的最前面
        for (int right=0;right<n;right++) {
            if (nums[right] == 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
        }

        // 将所有的1交换到2的前面
        for (int right=left;right<n;++right) {
            if (nums[right] == 1) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                ++left;
            }
        }
    }

    // 解法二：三指针，一次循环
    public void sortColors2(int[] nums) {
        int left=0,right=nums.length-1;
        int index=0;
        while(index<=right) {
            // 这里为什么是index++？
            // 因为如果index前面存在位置，会被交换到right，这里只需要处理0和1的情况
            // 前面要是有2，都被交换到后面了
            if(nums[index]==0) swap(nums, index++, left++);
            // 这里为什么是index？
            // 因为交换到index位置的可能是1或者2，需要继续处理
            else if(nums[index]==2) swap(nums, index, right--);
            else index++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
