package algorithm.数字和数学;

/**
 *
 * 给定一个正整数n(n<10^9)，判断它是否为素数。
 *
 */
public class isPrime {

    public boolean isPrime(int num) {
        int max = (int) Math.sqrt(num);
        for (int i = 2; i <= max; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
