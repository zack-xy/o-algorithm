package algorithm.数字和数学;

import java.util.Arrays;

/**
 *
 * 相关题目[判断是否为质数](./isPrime)
 *
 *  [204. 计数质数](https://leetcode.cn/problems/count-primes/description/)
 *
 */
public class countPrimes {

    // 解法一：直接判断质数，计数
    public int countPrimes(int n) {
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    // 判断1个数是否是质数
    private boolean isPrime(int num) {
        int max = (int) Math.sqrt(num);
        for (int i = 2; i <= max; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 解法二：埃氏筛
    public int countPrimes2(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                ans += 1;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }
}
