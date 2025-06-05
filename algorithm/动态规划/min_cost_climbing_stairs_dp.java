package algorithm.动态规划;

/**
 *
 * 爬楼梯最小代价
 *
 * 给定一个楼梯，你每步可以上1阶或者2阶，每一阶楼梯上都贴有一个非负整数，表示你在该台阶所需要付出的代价。
 * 给定一个非负整数数组cost，其中cost[i]表示在第i个台阶需要付出的代价，cost[0]为地面(起始点)。
 * 请计算最少需要付出多少代价才能到达顶部？
 *
 *
 *
 */
public class min_cost_climbing_stairs_dp {

    /**
     *
     * 设dp[i]为爬到第i阶累计付出的代价
     * dp[i]的代价只能是dp[i-1] + cost[i]或dp[i-2] + cost[i]
     * 那么dp[i]最小值(最小代价)就是
     * dp[i] = min(dp[i-1], dp[i-2]) + cost[i]
     *
     */

    // 爬楼梯最小代价：动态规划
    public int minCostClimbingStaursDP(int[] cost) {
        int n = cost.length - 1;
        if (n == 1 || n == 2) return cost[n];
        // 初始化dp表，用于存储子问题的解
        int[] dp = new int[n+1];
        // 初始状态：预设最小子问题的解
        dp[1] = cost[1];
        dp[2] = cost[2];
        // 状态转移：从较小子问题逐步求解较大子问题
        for (int i=3;i<=n;i++) {
            dp[i]=Math.min(dp[i-1], dp[i-2]) + cost[i];
        }
        return dp[n];
    }

    // 空间优化
    // 爬楼梯最小代价：空间优化后的动态规划
    public int minCostClimbingStairsDPComp(int[] cost) {
        int n = cost.length - 1;
        if (n == 1 || n == 2) return cost[n];
        int a = cost[1], b = cost[2];
        for (int i=3;i<=n;i++) {
            int tmp = b;
            b = Math.min(a, tmp) + cost[i];
            a = tmp;
        }
        return b;
    }

}
