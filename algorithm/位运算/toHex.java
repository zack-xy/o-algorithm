package algorithm.位运算;

/**
 *
 * [405. 数字转换为十六进制数](https://leetcode.cn/problems/convert-a-number-to-hexadecimal/description/)
 *
 */
public class toHex {

    // TODO 不太懂位运算
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 7; i >= 0; i --) {
            int val = (num >> (4 * i)) & 0xf;
            if (sb.length() > 0 || val > 0) {
                char digit = val < 10 ? (char) ('0' + val) : (char) ('a' + val - 10);
                sb.append(digit);
            }
        }
        return sb.toString();
    }
}
