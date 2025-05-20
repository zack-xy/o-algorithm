package algorithm.二分查找;

/**
 *
 * [剑指 Offer 53 - I. 在排序数组中查找数字 I ]
 * [LCR 172. 统计目标成绩的出现次数](https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/description/)
 *
 */
public class countTarget {


    // 找到一个边界，然后线性计数
    public static int countTarget(int[] scores, int target) {
        int left = 0, right = scores.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (scores[mid] >= target) right = mid - 1;
            else left = mid + 1;
        }
        // 如果target存在，这里left是左侧边界
        // 如果target不存在,left是第一个比target大的值的位置
        // 如果target不存在，并且没有比target大的值，left就是数组长度，这时就会超越数组索引
        if (left > scores.length - 1 || scores[left] != target) return 0;
        int count = 0;
        while (left < scores.length && scores[left] == target) {
            left++;
            count++;
        }
        return count;
    }

    // 二分查找
    public int countTarget2(int[] scores, int target) {
        // 搜索右边界 right
        int i=0,j=scores.length-1;
        while(i<=j) {
            int m = i + ((j-i)>>1);
            if (scores[m]<=target) i = m + 1;
            else j = m - 1;
        }
        int right = i;
        // 若数组中无target，则提前返回
        if (j>=0 && scores[j] != target) return 0;
        // 搜索左边界 right
        i = 0;
        j = scores.length - 1;
        while (i <= j) {
            int m = i + ((j-i)>>1);
            if (scores[m]<target) i = m + 1;
            else j = m - 1;
        }
        int left = j;
        return right - left - 1;
    }

    // 代码简化
    public int countTarget3(int[] scores, int target) {
        return helper(scores, target) - helper(scores, target - 1);
    }

    private int helper(int[] scores, int target) {
        int i=0, j=scores.length-1;
        while(i<=j) {
            int m = i + ((j-i)>>1);
            if(scores[m]<=target) i=m+1;
            else j=m-1;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] scores = {1};
        int ret = countTarget(scores, 1);
        System.out.println(ret);
    }

}
