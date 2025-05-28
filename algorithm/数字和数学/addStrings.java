package algorithm.数字和数学;

/**
 *
 * [415. 字符串相加](https://leetcode.cn/problems/add-strings/description/)
 *
 */
public class addStrings {

    // ❌错误的题解
    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0) return num2;
        if (num2 == null || num2.length() == 0) return num1;
        int r1 = num1.length() - 1, r2 = num2.length() - 1;
        StringBuffer sb = new StringBuffer();
        int carry = 0;
        while (r1 >= 0 && r2 >= 0) {
            int sum = (num1.charAt(r1) - '0') + (num2.charAt(r2) - '0') + carry;
            if (sum >= 10) {
                carry = 1;
                sb.append(sum % 10);
            } else {
                carry = 0;
                sb.append(sum);
            }
            r1--;
            r2--;
        }
        while (r1 >= 0) {
            int sum = (num1.charAt(r1) - '0') + carry;
            if (sum >= 10) {
                carry = 1;
                sb.append(sum % 10);
            } else {
                carry = 0;
                sb.append(sum);
            }
            r1--;
        }
        while (r2 >= 0) {
            int sum = (num1.charAt(r2) - '0') + carry;
            if (sum >= 10) {
                carry = 1;
                sb.append(sum % 10);
            } else {
                carry = 0;
                sb.append(sum);
            }
            r2--;
        }
        while (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public String addStrings2(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i>=0 ? num1.charAt(i) - '0' : 0;
            int y = j>=0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }

}
