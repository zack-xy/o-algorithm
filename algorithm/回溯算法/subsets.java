package algorithm.回溯算法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * [78. 子集](https://leetcode.cn/problems/subsets/description/)
 *
 */
public class subsets {

    // 存放符合条件结果的集合
    static List<List<Integer>> result = new ArrayList<>();
    // 用来存放符合条件结果
    static LinkedList<Integer> path = new LinkedList<>();

    public static List<List<Integer>> subsets(int[] nums) {
        // 空集合也是一个子集
        if (nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        subsetsHelper(nums, 0);
        return result;
    }

    private static void subsetsHelper(int[] nums, int startIndex) {
        // 遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合
        result.add(new ArrayList<>(path));  // 为什么要先把路径放到结果里呢？
        if (startIndex >= nums.length) return;
        for (int i=startIndex;i<nums.length;i++) {
            path.add(nums[i]);
            subsetsHelper(nums, i+1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> ret = subsets(nums);
        System.out.println(ret.toString());
    }

}
