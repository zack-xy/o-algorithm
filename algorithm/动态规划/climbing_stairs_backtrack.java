package algorithm.动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 给定一个共有n阶的楼梯，你每步可以上1阶或者2阶，请问有多少种方案可以爬到楼顶
 *
 */
public class climbing_stairs_backtrack {

    // 回溯
    public void backtrack(List<Integer> choices, int state, int n, List<Integer> res) {
        // 当爬到第n阶时，方案数量加1
        if (state == n) res.set(0, res.get(0) + 1);
        // 遍历所有选择
        for (Integer choice : choices) {
            // 剪枝：不允许超过第n阶
            if (state + choice > n) continue;
            // 尝试：做出选择，更新状态
            backtrack(choices, state + choice, n, res);
            // 回退
        }
    }

    // 爬楼梯 - 回溯
    public int climbingStairsBacktrack(int n) {
        List<Integer> choices = Arrays.asList(1, 2);   // 可选择向上爬1阶或者2阶
        int state = 0;  // 从第0阶开始爬
        List<Integer> res = new ArrayList<>();
        res.add(0);   // 使用res[0]记录方案数量
        backtrack(choices, state, n, res);
        return res.get(0);
    }


    /**
     *
     *  当我们站在i阶楼梯上时，上一步只可能是i-1阶楼梯或者i-2阶楼梯，因为每次只能迈1或者2步
     *  假设上到i阶楼梯的方案数是dp[i]
     *  那么dp[i] = dp[i-1] + dp[i-2]
     *
     *  由此可知，原问题的解可以由子问题的解构建得来
     *  那么以dp[n]为起始点，递归地将一个较大问题拆解为两个较小问题的和
     *  直到到达最小子问题dp[1]和dp[2]时返回
     *  dp[1]和dp[2]的解是已知的,dp[1]=1,dp[2]=2
     *
     *  ⚠️这里的问题是：比如n=9
     *  会先求dp[8]和dp[7]
     *  为求dp[8]=dp[7]+dp[6]
     *  dp[7]=dp[6]+dp[5] .....
     *  这里面dp[7]，dp[6]....会被反复计算，造成计算资源浪费
     *  时间复杂度是O(2^n)
     *
     */

    public int dfs(int i) {
        if (i == 1 || i == 2) return i;
        // df[i] = dp[i-1] + dp[i-2]
        int count = dfs(i - 1) + dfs(i - 2);
        return count;
    }


    public int climbingStairsDFS(int n) {
        return dfs(n);
    }

    /**
     *  优化：为了解决上面的问题，希望重叠的子问题只被计算一次
     *  使用mem记录子问题的值
     *  就是dp[i]的值等于mem[i]
     *
     */

    // 记忆化搜索
    int dfsMem(int i, int[] mem) {
        // 已知dp[1]和dp[2]，返回之
        if (i == 1 || i == 2) return i;
        // 若存在记录dp[i],则直接返回之
        if (mem[i] != -1) return mem[i];
        // dp[i] = dp[i-1] + dp[i-2]
        int count = dfsMem(i-1, mem) + dfsMem(i-2, mem);
        // 记录dp[i]
        mem[i] = count;
        return count;
    }

    // 爬楼梯：记忆化搜索
    public int climbingStairsDFSMem(int n) {
        // mem[i]记录爬到第i阶的方案总数,-1代表无记录
        int[] mem = new int[n+1];
        Arrays.fill(mem, -1);
        return dfsMem(n, mem);
    }


    /**
     *
     *  记忆化搜索是一种”从顶至底“的方法，从大问题出发，分解成为小问题，回溯收集小问题的解，构建出大问题的解
     *  动态规划是”从底至顶“的方法，从最小问题的解开始，迭代构建更大问题的解，直到得到原问题的解
     *  (动态规划不包含回溯过程，使用循环迭代，无需使用递归)
     *
     */

    // 爬楼梯：动态规划
    public int climbingStairsDP(int n) {
        if (n == 1 || n == 2) return n;
        // 初始化dp表，用于存储子问题的解
        int[] dp = new int[n+1];
        // 初始状态：预设最小子问题的解
        dp[1] = 1;
        dp[2] = 2;
        // 状态转移：从较小子问题逐步求解较大子问题
        for (int i=3; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    // 空间优化
    public int climbingStairsDPComp(int n) {
        if (n == 1 || n == 2) return n;
        // 用两个变量存储前两个状态的解
        int a = 1, b = 2;
        for (int i=3;i<=n;i++) {
            int tmp = b;
            b = a + b;
            a = tmp;
        }
        return b;
    }
}
