package algorithm.位运算;

/**
 *
 * [190. 颠倒二进制位](https://leetcode.cn/problems/reverse-bits/description/)
 *
 */
public class reverseBits {

    // 解法：访问到最低位放到相应位置，n右移动1位，相加，直到n为0
    public int reverseBits(int n) {
        int reversed = 0, power = 31;
        while (n != 0) {
            reversed += (n & 1) << power;  // 运算符优先级 & --> << --> +=
            n >>>= 1;
            power--;
        }
        return reversed;
    }

    // 解法二
    public int reverseBits2(int n) {
        n = ( n >>> 16) | ( n << 16);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        return n;
    }
}
