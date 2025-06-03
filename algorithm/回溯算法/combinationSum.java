package algorithm.回溯算法;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * [39. 组合总和](https://leetcode.cn/problems/combination-sum/description/)
 *
 */
public class combinationSum {

    List<List<Integer>> res = new ArrayList<>(); // 记录答案
    List<Integer> path = new ArrayList<>();  // 记录当前正在访问的路径

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, 0, target);
        return res;
    }

    /**
     * @param c 数组
     * @param u 索引值
     * @param target 目标值
     */
    public void dfs(int[] c, int u, int target) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=u;i<c.length;i++) {
            if (c[i] <= target) {
                path.add(c[i]);
                // 当前层将target减掉了一部分，也就是子结构只要找是否满足(target - c[i])就可以了
                dfs(c, i, target - c[i]);  // 因为可以重复利用，所以还是i （为什么不是0？前置处理过了，不需要再重新返回去）
                path.remove(path.size()-1); // 回溯
            }
        }
    }
}
