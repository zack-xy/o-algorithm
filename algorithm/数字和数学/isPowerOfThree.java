package algorithm.数字和数学;

public class isPowerOfThree {

    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    /**
     *
     * 在int 型的数据范围内存在最大的 3 的幂，不超过 2^31-1 的最大的 3 的幂是 3^19=1162261467。
     * 所以如果在1~ 2^31-1内的数，如果是3的幂，则一定是1162261467的除数，所以这里可以通过一次除法就获得
     *
     */

    public boolean isPowerOfThree2(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

}
