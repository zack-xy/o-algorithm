package algorithm.位运算;

/**
 *
 * [338. 比特位计数](https://leetcode.cn/problems/counting-bits/description/)
 *
 */
public class countBits {

    // 利用右移
    public int[] countBits(int n) {
        int[] bits = new int[n+1];
        for (int i=0;i<=n;i++) {
            for (int j=0;j<32;j++) {
                bits[i] += (i>>j) & 1;
            }
        }
        return bits;
    }

    // 利用n&(n-1)
    public int[] countBits2(int n) {
        int[] bits = new int[n+1];
        for (int i=0;i<=n;i++) {
            bits[i] = countOnes(i);
        }
        return bits;
    }

    private int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            x &= (x - 1);
            ones++;
        }
        return ones;
    }
}
