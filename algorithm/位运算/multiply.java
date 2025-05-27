package algorithm.位运算;

/**
 *
 * [面试题 08.05. 递归乘法](https://leetcode.cn/problems/recursive-mulitply-lcci/description/)
 *
 */
public class multiply {

    // 解法一：A个B相加，击败0%，😓
    // 题目要求递归函数，这是个迭代
    public int multiply(int A, int B) {
        if (A == 0 || B == 0) return 0;
        if (A == 1 || B == 1) return A == 1 ? B : A;
        if (A == -1 || B == -1) return A == -1 ? -B : -A;
        int ret = 0;
        for (int i=0;i<A;i++) {
            ret+=B;
        }
        return ret;
    }

    // 解法二：位运算
    public static int multiply2(int A, int B) {
        int min = Math.min(A, B);
        int max = Math.max(A, B);
        int ans = 0;
        for (int i=0;min!=0;i++) {
            // 位为1时才更新ans，否则max一直更新
            // 位为1的时候说明是奇数，也就是不是2的倍数
            if ((min & 1) == 1) {
                ans += max;
            }
            min >>= 1;  // 右移1相当于除以2
            max += max; // max翻倍
        }
        return ans;
    }

    public static void main(String[] args) {
       int ret = multiply2(9,17);
        System.out.println(ret);
    }

}
