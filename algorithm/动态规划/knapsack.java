package algorithm.动态规划;

/**
 *
 * 给定n个物品，第i个物品的重量为wgt[i-1]、价值为val[i-1]，和一个容量为cap的背包
 * 每个物品只能选择一次，问在限定背包容量下能放入物品的最大价值
 *
 *
 */
public class knapsack {

    // 解法一：暴力搜索
    public int knapsackDFS(int[] wgt, int[] val, int i, int c) {
        // 已选完所有物品或背包无剩余容量，则返回价值 0
        if (i==0 || c==0) return 0;
        // 若超过背包容量，则只能选择不放入背包
        if (wgt[i-1]>c) return knapsackDFS(wgt, val, i-1, c);
        // 计算不放入和放入物品i的最大价值
        int no = knapsackDFS(wgt, val, i-1, c);
        int yes = knapsackDFS(wgt, val, i-1, c - wgt[i-1]) + val[i-1];
        // 返回两种方案中价值更大的那一个
        return Math.max(no, yes);
    }


    // 解法二：记忆化搜索
    public int knapsackDFSMem(int[] wgt, int[] val, int[][] mem, int i, int c) {
        // 若已选完所有物品或背包无剩余容量，则返回价值0
        if (i==0 || c==0) return 0;
        // 若已有记录，则直接返回
        if (mem[i][c] != -1) return mem[i][c];
        // 若超过背包容量，则只能选择不放入背包
        if (wgt[i-1]>c) return knapsackDFSMem(wgt, val, mem, i-1, c);
        // 计算不放入和放入物品i的最大价值
        int no = knapsackDFSMem(wgt, val, mem, i-1, c);
        int yes = knapsackDFSMem(wgt, val, mem, i-1, c - wgt[i-1]) + val[i-1];
        // 记录并返回两种方案中价值更大的那一个
        mem[i][c] = Math.max(no, yes);
        return mem[i][c];
    }

    // 解法三：动态规划
    public int knapsackDP(int[] wgt, int[] val, int cap) {
        int n = wgt.length;  // 物品的数量
        // 初始化dp表
        int[][] dp = new int[n+1][cap+1]; // 第一个索引表示物品编号，第二个索引表示背包容量
        // 状态转移
        for (int i=1;i<=n;i++) {
            for (int c=1;c<=cap;c++) {
                if (wgt[i-1]>c) {
                    // 若超过背包容量，则不选物品i
                    dp[i][c] = dp[i-1][c];
                } else {
                    // 不选和选物品i这两种方案的较大值
                    dp[i][c] = Math.max(dp[i-1][c], dp[i-1][c-wgt[i-1]] + val[i-1]);
                }
            }
        }
        return dp[n][cap];
    }

    // 解法四：空间优化
    public int knapsackDPComp(int[] wgt, int[] val, int cap) {
        int n = wgt.length;
        // 初始化dp表
        int[] dp = new int[cap+1];
        // 状态转移
        for (int i=1;i<=n;i++) {
            // 倒序遍历
            for (int c=cap;c<=1;c--) {
                if (wgt[i-1]<=c) {
                    // 不选和选物品i这两种方案的较大值
                    dp[c] = Math.max(dp[c], dp[c-wgt[i-1]] + val[i-1]);
                }
            }
        }
        return dp[cap];
    }
}
