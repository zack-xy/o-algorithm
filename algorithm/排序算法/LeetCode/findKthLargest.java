package algorithm.排序算法.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * [215. 数组中的第K个最大元素](https://leetcode.cn/problems/kth-largest-element-in-an-array/description/)
 *
 */
public class findKthLargest {

    // 快排，将数据分为3个部分
    private int quickSelect(List<Integer> nums, int k) {
        Random rand = new Random();
        int pivot = nums.get(rand.nextInt(nums.size())); // 生成一个整数随机数[0, nums.size())
        // 将大于，小于，等于pivot的元素划分至big，small，euqal中
        List<Integer> big = new ArrayList<>();  // 这里面存的是比pivot大的数
        List<Integer> equal = new ArrayList<>();  // 这里面存的是和pivot一样大的数
        List<Integer> small = new ArrayList<>();  // 这里面存的是比pivot小的数
        for (int num : nums) {
            if (num > pivot) big.add(num);
            else if (num < pivot) small.add(num);
            else equal.add(num);
        }
        // 第k大元素在big中，递归划分 // 如果比pivot大的数的数量大于k，那么k在big中
        if (k<=big.size()) return quickSelect(big, k);
        // 第k大元素在small中，递归划分
        // 程序运行到此处，说明k不在big中
        // 数据总量 - 比pivot小的量 = big + equal < k 说明k在small中
        // ⚠️这里第二个参数传入的就不能是k了，因为第一个参数传入的是small
        // k > big + equal的数量
        // 所以相当于在small中找第k-big-equal大的值
        // k - (big + equal) = k - (nums.size() - small.size) = k - nums.size() + small.size
        if (nums.size() - small.size() < k) return quickSelect(small, k - nums.size() + small.size());
        // 代码运行到这里，k既不在big中也不再small中，在equal中
        // 第k大元素在equal中，直接返回pivot
        return pivot;
    }

    // 快速排序
    public int findKthLargest(int[] nums, int k) {
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        return quickSelect(numList, k);
    }

    // 貌似下面的时间更快，为什么？
    public static int findKthLargest2(int[] nums, int k) {
        int n = nums.length;
        // 这个递归函数的意义已经被转化为 =》第n-k小的数，也就是排除n-k个最小的数
        return quickSelect2(nums, 0, n-1, n-k);
    }

    /**
     *
     * 这个函数的意义是找k个最小的数
     *
     * @param nums 目标数
     * @param l  左边界
     * @param r  右边界
     * @param k  第k大
     * @return
     */
    private static int quickSelect2(int[] nums, int l, int r, int k) {
        if (l == r) return nums[k];
        int x = nums[l], i = l - 1, j = r + 1;  // 以l为基准？
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            // i从左到右，j从右到左，双指针相撞
            // 代码运行到这里，在i<j的条件下，nums[i] > x, nums[j] < x
            // 也就是左侧是比x大的，右侧比x小，此时，交换i，j的数据，保证左边都是小于x的，右边都是大于x的
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        // 代码运行到这里，i和j相撞
        // 如果k小于等于j索引，j是右侧索引
        // j的左侧都是小于x的值，j的右侧都是大于x的值
        // 如果k<=j说明k在j中，递归找l -> j中
        if (k<=j) return quickSelect2(nums, l, j, k);
        // 否则，说明k在 j+1 -> r中
        else return quickSelect2(nums, j+1, r, k);
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int ret = findKthLargest2(nums, 4);
        System.out.println(ret);
    }

}
