package algorithm.数组常见题.Leetcode;

import java.util.Arrays;

public class rotate {

    /**
     *
     * [189. 轮转数组](https://leetcode.cn/problems/rotate-array/description/)
     *
     */

    // 解法一：直解
    // 先把后k位放在新数组中，再把前几位放在新数组中
    // 再把新数组挨个赋值给老数组
    public void rotate(int[] nums, int k) {
        if (k > nums.length) {
            while (k > nums.length) k = k - nums.length;
        }
        if (k == nums.length) return;
        int point = nums.length - k - 1;
        int[] newNums = new int[nums.length];
        for (int i=point+1,j=0;i<nums.length;i++) {
            newNums[j++] = nums[i];
        }
        for (int i=0,j=k;i<=point;i++) {
            newNums[j++] = nums[i];
        }
        for (int i=0;i<newNums.length;i++) {
            nums[i] = newNums[i];
        }
    }

    // 解法二：反转2次数组
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // 官方题解 - 额外数组 取余操作
    public void rotate3(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i=0;i<n;++i) {
            newArr[(i+k)%n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums,0, n);
    }

    // 官方题解 - 环状替换，就是连续换位置，但是需要一个格外变量记录换了多少个
    public static void rotate4(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0;start < count;++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }

    // 最大公约数
    private static int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6};
        rotate4(nums, 4);
        System.out.println(Arrays.toString(nums));
    }
}
