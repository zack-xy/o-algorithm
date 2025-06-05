package algorithm.动态规划.LeetCode;

import java.util.Arrays;

/**
 *
 * [62. 不同路径](https://leetcode.cn/problems/unique-paths/description/)
 *
 */
public class uniquePaths {

    // 解法一：暴力递归
    public int uniquePaths(int m, int n) {
        return search(m,n);
    }

    public int search(int m, int n) {
        // 如果只有1列或者只有1行，只有一条路径
        if (m==1 || n==1) return 1;
        // 每次只能有2种移动：向右 或者 向下，所以总路径数的 = 向右路径数 + 向下路径数
        return search(m-1, n) + search(m, n-1);
    }

    // 解法二：记忆化搜索
    public int uniquePaths2(int m, int n) {
        int[][] f = new int[m][n];  // 记录走到[m,n]位置的路径数
        f[0][0] = 1;
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (i>0 && j>0) {  // 走到[i,j]位置，只能从上面和左边过来
                    f[i][j] = f[i-1][j] + f[i][j-1];
                } else if (i>0) {  // j = 0 的情况
                    f[i][j] = f[i-1][j];
                } else if (j > 0) {  // i = 0 的情况
                    f[i][j] = f[i][j-1];
                }
            }
        }
        return f[m-1][n-1];
    }

    // 解法三：滚动数组优化
    // m是行，n是列
    // dp数组i位置的数据是 上值+左值
    // 上值，也就是变换之前的值即dp[i]
    // 左值就是前1个的值，也就是dp[i-1]
    // 所以dp数组i位置的变换是：dp[i] = dp[i] + dp[i-1]
    public int uniquePaths3(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // 初始化填充1
        for (int i=1;i<m;++i) { // dp数组会变换m-1次，因为上一行填充了1次
            for (int j=1;j<n;++j) { // dp数组的第一项都是1，跳过，所以循环从1开始
                // 等式右边的dp[j]是上一次计算后的，加上左边的dp[j-1]即为当前结果
                dp[j] = dp[j] + dp[j-1];
            }
        }
        return dp[n-1];
    }
}
