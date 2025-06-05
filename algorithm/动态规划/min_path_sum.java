package algorithm.动态规划;

/**
 *
 * 最小路径和
 *
 * 给定一个n x m 的二维网格 grid，网格中的每个单元格包含一个非负整数，表示该单元格的代价。
 * 机器人从左上角单元格为起始点，每次只能向下或者向右移动一步，直至达到右下角单元格。
 * 请返回从左上角到右下角的最小路径和
 *
 *
 */
public class min_path_sum {

    // 解法一：暴力搜索
    /**
     * 递归参数：状态[i,j]
     * 返回值：从[0,0]到[i,j]的最小路径和dp[i,j]
     * 终止条件：当i=0且j=0时，返回代价grid[0,0]
     * 剪枝：当i<0时或者j<0时索引越界，此时返回代价+∞，代表不可行
     *
     *
     */
    public int minPathSumDFS(int[][] grid, int i, int j) {
        // 若为左上角单元格，则终止搜索
        if (i==0 && j==0) return grid[0][0];
        // 若行列索引越界，则返回+∞代价
        if (i<0 || j<0) return Integer.MAX_VALUE;
        // 计算从左上角(i-1, j)和(i, j-1)的最小路径代价
        int up = minPathSumDFS(grid, i-1, j);
        int left = minPathSumDFS(grid, i, j-1);
        // 返回从左上角到(i,j)的最小路径代价
        return Math.min(left, up) + grid[i][j];
    }

    // 解法二：记忆化搜索
    public int minPathSumDFSMem(int[][] grid, int[][]mem, int i, int j) {
        // 若为左上角单元格，则终止搜索
        if (i==0 && j==0) return grid[0][0];
        // 若行列索引越界，则返回 +∞ 代价
        if (i<0 || j<0) return Integer.MAX_VALUE;
        // 若已有记录，则直接返回
        if (mem[i][j] != -1) return mem[i][j];
        // 左边和上边单元格的最小路径代价
        int up = minPathSumDFSMem(grid, mem, i-1, j);
        int left = minPathSumDFSMem(grid, mem, i, j-1);
        // 记录并返回左上角到(i,j)的最小路径代价
        mem[i][j] = Math.min(up, left) + grid[i][j];
        return mem[i][j];
    }

    // 解法三：动态规划

    /**
     *
     *  对于状态[i, j]，只能从上边格子[i-1, j]和左边格子[i, j-1]转移而来。
     *  因此最优子结构为：到达[i,j]的最小路径和由[i, j-1]的最小路径和[i-1, j]的最小路径中较小的一个决定
     *
     *  状态转移方程为：
     *
     *     dp[i, j] = min(dp[i-1, j], dp[i, j-1]) + grid[i, j]
     *
     *
     */
    public int minPathSumDP(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        // 初始化dp表
        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];
        // 状态转移：首行
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        // 状态转移：首列
        for (int i=1;i<n;i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        // 状态转移：其余行和列
        for (int i=1;i<n;i++) {
            for (int j=i;j<m;j++) {
                dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + grid[i][j];
            }
        }
        return dp[n-1][m-1];
    }

    // 解法四：动态规划的空间优化
    // 因为每个格子只与其左边和上边的格子有关，因此可以只用一个单行数组实现dp表
    public int minPathSumDPComp(int[][] grid) {
        int n=grid.length, m=grid[0].length;
        // 初始化dp表
        int[] dp = new int[m];
        // 状态转移：首行
        dp[0]=grid[0][0];
        for(int j=1;j<m;j++) {
            dp[j]=dp[j-1]+grid[0][j];
        }
        // 状态转移：其余行
        for (int i=1;i<n;i++) {
            // 状态转移：首列
            dp[0] = dp[0] + grid[i][0];
            // 状态转移：其余列
            for (int j=1;j<m;j++) {
                dp[j] = Math.min(dp[j-1], dp[j]) + grid[i][j];
            }
        }
        return dp[m-1];
    }
}
