package algorithm.数组常见题.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class findMissingRanges {
    /**
     *
     * [163.缺失的区间](https://leetcode.cn/problems/missing-ranges/description/)
     * 这道题和 [228. 汇总区间](https://leetcode.cn/problems/summary-ranges/description/)
     * 正好相反
     *
     *  给定一个排序的整数数组nums，其中元素的范围在闭区间[lower，upper]内，返回不包含在数组中的区间范围的列表
     *
     */
    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        int prev =  lower - 1; // 使用long避免整数溢出

        for (int i=0;i<=nums.length;i++) {
            int curr = (i<nums.length) ? nums[i] : upper + 1;

            if (prev + 1 <= curr - 1) {
                result.add(formatRange(prev + 1, curr - 1));
            }

            prev = curr;
        }

        return result;
    }

    private static String formatRange(int start, int end) {
        return start == end ? String.valueOf(start) : start + "->" + end;
    }

    // 测试代码
    /**
     * 测试用例:
     * nums = [0, 1, 3, 50, 75] lower=0, upper=99
     * 输出：["2","4->49","51->74","76->99"]
     *
     *
     *
     */
    public static void main(String[] args) {
        List<String> list = findMissingRanges(new int[]{0,1,3,50,75}, 0, 99);
        for (String s : list) {
            System.out.println(s);
        }
    }

}
