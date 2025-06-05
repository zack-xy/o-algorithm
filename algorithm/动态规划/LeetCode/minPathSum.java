package algorithm.动态规划.LeetCode;

/**
 *
 * [64. 最小路径和](https://leetcode.cn/problems/minimum-path-sum/description/)
 *
 * 这个题，和代码 min_path_sum 是同一个题
 *
 * [min_path_sum](../min_path_sum.java)
 *
 */
public class minPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] f = new int[m][n];
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (i==0 && j==0) { // 起始位置
                    f[i][i] = grid[i][j];
                } else {
                    // 这里的处理和min_path_sum文件里minPathSumDP写的稍微不同
                    // 当i-1小于0的时候，i=0
                    // 代码到这里，i和j不可能同时为0
                    int top = i - 1 >= 0 ? f[i-1][j] + grid[i][j] : Integer.MAX_VALUE;
                    int left = j - 1 >=0 ? f[i][j-1] + grid[i][j] : Integer.MAX_VALUE;
                    f[i][j] = Math.min(top, left);
                }
            }
        }
        return f[m-1][n-1];
    }

}
