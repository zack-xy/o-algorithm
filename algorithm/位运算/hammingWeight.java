package algorithm.位运算;

/**
 *
 * [191. 位1的个数](https://leetcode.cn/problems/number-of-1-bits/description/)
 *
 */
public class hammingWeight {

    // 解法一：右移
    public int hammingWeight(int n) {
        int count = 0;
        for (int i=0; i<32; i++) {
            count += (n >> i) & 1;
        }
        return count;
    }

    // 解法二： n & (n-1)
    public int hammingWeight1(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n-1);
            count++;
        }
        return count;
    }
}
