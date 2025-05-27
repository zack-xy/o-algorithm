package algorithm.位运算;

/**
 *  位运算实现加法
 *
 * [371. 两整数之和](https://leetcode.cn/problems/sum-of-two-integers/description/)
 *
 */
public class getSum {

    // 加法涉及到进位问题
    // 如果不考虑进位的话
    // 0 + 0 = 0，0 + 1 = 1，1 + 0 = 1，1 + 1 = 0，这个形式就是异或 a ^ b
    // sign是进位
    /**
     *
     * 以a=3 (011), b=5 (101) 为例
     *
     *  第一轮：
     *     a ^ b = 110 (6)   // 按位异或只是操作了1位的无进位相加
     *     sign = (011 & 101) << 1 = 010 (2)
     *
     *  第二轮：
     *      a ^ b = 110 ^ 010 (4)
     *      sign = (110 & 010) << 1 = 100 (4)
     *
     *  第三轮：
     *      a ^ b = 100 ^ 100 = 000 (0)
     *      sign = (100 & 100) << 1 = 1000 (8)
     *
     *  第四轮：
     *      a ^ b = 000 ^ 1000 = 1000 (8)
     *      sign = (000 & 1000) << 1 = 0000 (0, 终止)
     *      结果：a = 8 (3+5)
     */
    public int getSum(int a, int b) {
        while (b != 0) {
            int sign = ( a & b ) << 1;
            a = a ^ b;
            b = sign;
        }
        return a;
    }

    public static void main(String[] args) {
        int a = 1; // 0001
        int b = 1; // 0010
        System.out.println((a & b) << 1);
    }
}
