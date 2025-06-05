package algorithm.动态规划.LeetCode;

import java.util.List;

/**
 *
 * [120. 三角形最小路径和](https://leetcode.cn/problems/triangle/description/)
 *
 */
public class minimumTotal {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();   // 有多少行
        int ans = Integer.MAX_VALUE;
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i=1;i<n;i++) {
            for (int j=0;j<i+1;j++) { // 第i行总共有i+1个元素（i从0开始）
                int val = triangle.get(i).get(j);
                f[i][j] = Integer.MAX_VALUE;
                if (j != 0) { // 只要不是第一列的，都可以从左上方得到值 （这里包含了最后一列）
                    f[i][j] = Math.min(f[i][j], f[i-1][j-1] + val);
                }
                if (j != i) { // 只要不是最后一列的，都可以从右上方得到值 （这里包含了第一列）
                    f[i][j] = Math.min(f[i][j], f[i-1][j] + val);
                }
                // 如果是中间的，那么上面两个判断都会走，会从中选取一个较小的值
            }
        }
        // 结果在最后一行，遍历最后一行的数据，从中选取最小值
        for (int i=0;i<n;i++) {
            ans = Math.min(ans, f[n-1][i]);
        }
        return ans;
    }

}
