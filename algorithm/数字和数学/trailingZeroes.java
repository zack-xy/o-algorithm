package algorithm.数字和数学;

/**
 *
 * [面试题 16.05. 阶乘尾数](https://leetcode.cn/problems/factorial-zeros-lcci/description/)
 *
 *
 *
 */
public class trailingZeroes {

    /**
     *
     * 可以统计有多少个 0，实际上是统计 2 和 5 一起出现多少对，
     * 不过因为 2 出现的次数一定大于 5 出现的次数，因此我们只需要检查 5 出现的次数就好了，
     * 那么在统计过程中，我们只需要统计 5、10、15、 25、 ... 5^n 这样 5 的整数倍项就好了，
     * 最后累加起来，就是多少个 0。
     *
     */
    // 算法通过不断计算n中包含多少个5的幂次（5, 25, 125,...）来统计总共有多少个5的因子
    // 5，25，125.....分别是1次幂，2次幂，3次幂
    // 1次幂会贡献1个0，2次幂会贡献2个零，3次幂会贡献3个零
    public static int trailingZeroes(int n) {
        int cnt = 0;
        for (long num = 5; n / num > 0; num *= 5) {
            cnt += n / num;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int ret = trailingZeroes(28);
        System.out.println(ret);
    }
}
