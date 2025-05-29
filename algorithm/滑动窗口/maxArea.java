package algorithm.滑动窗口;

/**
 *
 * [11. 盛最多水的容器](https://leetcode.cn/problems/container-with-most-water/description/)
 *
 */
public class maxArea {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while (i < j) {
            res = height[i] < height[j] ?
            Math.max(res, (j-i) * height[i++]) :
            Math.max(res, (j-i) * height[j--]);
        }
        return res;
    }
}
