package algorithm.数字和数学;

/**
 *
 * [50. Pow(x, n)](https://leetcode.cn/problems/powx-n/description/)
 *
 */
public class myPow {

    // TODO 快速幂，不理解后面再看
    public double myPow(double x, int n) {
        if (x == 0.0f) return 0.0d;
        long b = n;
        double res = 1.0;
        if (b<0) {
            x = 1/x;
            b=-b;
        }
        while (b>0) {
            if((b&1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }

}
