package algorithm.数字和数学;

/**
 *
 * [342. 4的幂](https://leetcode.cn/problems/power-of-four/description/)
 *
 */
public class isPowerOfFour {

    public boolean isPowerOfFour(int n) {
        if (n <= 0)
            return false;
        while (n % 4 == 0)
            n /= 4;
        return n == 1;
    }
}
