package algorithm.数字和数学;

/**
 *
 * [504. 七进制数](https://leetcode.cn/problems/base-7/description/)
 *
 */
public class convertToBase7 {

    public String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        // 先拿到正负号
        boolean sign = num < 0;
        if (sign) num *= -1;
        // 循环取余和整除
        do {
            sb.append(num % 7 + "");
            num /= 7;
        } while (num > 0);
        if (sign) sb.append("-");
        return sb.reverse().toString();
    }

}
