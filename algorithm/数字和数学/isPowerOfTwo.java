package algorithm.数字和数学;

/**
 *
 * [231. 2 的幂](https://leetcode.cn/problems/power-of-two/description/)
 *
 */
public class isPowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

    // 解法二：位运算
    // 如果存在非负整数 k 使得 n=2^k，则 n 的二进制表示为 1 后面跟 k 个0。
    // 由此可见，正整数 n 是2 的幂，当且仅当 n 的二进制表示中只有最高位是 1，其余位都是 0，此时满足 n & (n−1)=0
    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & (n-1)) == 0;
    }

}
