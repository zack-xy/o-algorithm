package algorithm.回溯算法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * [46. 全排列](https://leetcode.cn/problems/permutations/description/)
 *
 */
public class permute {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return result;
        used = new boolean[nums.length];
        permuteHelper(nums);
        return result;
    }

    private void permuteHelper(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i=0;i<nums.length;i++) {
            if (used[i]) continue;
            used[i] = true;
            path.add(nums[i]);
            permuteHelper(nums);
            path.removeLast();
            used[i] = false;
        }
    }

}
