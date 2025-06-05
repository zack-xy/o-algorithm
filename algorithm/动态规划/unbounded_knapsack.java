package algorithm.动态规划;

/**
 *
 * 给定n个物品，第i个物品的重量为wgt[i-1]、价值为val[i-1]，和一个容量为cap的背包。
 * 每个物品可以重复选取，问在限定背包容量下能放入物品的最大价值。
 *
 */
public class unbounded_knapsack {

    /**
     *
     * 不放入物品i：与0-1背包问题相同，转移至[i-1, c]
     * 放入物品i：与0-1背包问题不同，转移至[i, c-wgt[i-1]]  (容量变了，但是还停留在i处)
     *
     * 状态转移方程：
     *
     * dp[i,c] = max(dp[i-1, c], dp[i, c-wgt[i-1]] + val[i-1])
     *
     */

    // 完全背包：动态规划
    public int unboundedKnapsackDP(int[] wgt, int[] val, int cap) {
        int n = wgt.length;
        // 初始化dp表
        int[][] dp = new int[n+1][cap+1];
        // 状态转移
        for (int i=1;i<=n;i++) {
            for (int c=1;c<=cap;c++) {
                if (wgt[i-1] > c) {
                    // 超过背包容量，则不选物品i
                    dp[i][c] = dp[i-1][c];
                } else {
                    // 不选和选物品i两个方案中的较大值
                    dp[i][c] = Math.max(dp[i-1][c], dp[i-1][c-wgt[i-1]] + val[i-1]);
                }
            }
        }
        return dp[n][cap];
    }

    // 空间优化
    public int unboundedKnapsackDPComp(int[] wgt, int[] val, int cap) {
        int n = wgt.length;
        // 初始化dp类
        int[] dp = new int[cap+1];
        // 状态转移
        for (int i=1;i<=n;i++) {
            for (int c=1;c<=cap;c++) {
                if (wgt[i-1]>c) {
                    // 若超过背包容量，则不选物品i
                    dp[c] = dp[c];
                } else {
                    // 不选和选物品i两种方案中的较大值
                    dp[c] = Math.max(dp[c], dp[c-wgt[i-1]] + val[i-1]);
                }
            }
        }
        return dp[cap];
    }
}
