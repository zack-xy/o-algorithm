package algorithm.贪心算法;

import java.util.Arrays;

/**
 *
 * [455. 分发饼干](https://leetcode.cn/problems/assign-cookies/description/)
 *
 *  有不同的胃口的孩子，有不同大小的饼干，每个孩子只能给1块饼干，最多可以让几个孩子吃饱
 *
 */
public class findContentChildren {

    // O(n^2)
    // 我的想法也是大饼干给大孩子
    // 所以进行排序，这里没问题
    // 然后我遍历的是饼干数组，然后再遍历孩子，找最大胃口的，能满足的话，ret++，并且把这个孩子移出去
    public int findContentChildren(int[] g, int[] s) {
        int ret = 0;
        if (s == null || s.length == 0) return ret;
        Arrays.sort(g);
        Arrays.sort(s);
        int gIdx = g.length - 1;
        for (int i = s.length - 1; i >= 0; i--) {
            if (gIdx < 0) break;
            for (int j = gIdx; j >= 0; j--) {
                if (s[i] >= g[j]) {
                    ret++;
                    gIdx = j - 1;
                    break;
                }
            }
        }
        return ret;
    }

    // 贪心，大饼干给大孩子
    // 其实我上面也是这个想法，为什么写出来的代码不一样呢？
    public int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int start = s.length - 1;
        // 遍历孩子的胃口
        for (int index = g.length - 1; index >= 0; index--) {
            if (start >= 0 && g[index] <= s[start]) {
                start--;
                count++;
            }
        }
        return count;
    }



}
