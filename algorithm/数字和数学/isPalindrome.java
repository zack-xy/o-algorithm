package algorithm.数字和数学;

/**
 *
 * [9. 回文数](https://leetcode.cn/problems/palindrome-number/description/)
 *
 */
public class isPalindrome {

    // 我的解法：转换为字符串处理
    public boolean isPalindrome(int x) {
        String str = Integer.toString(x);
        if (str.length() <= 1) return true;
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    // 解法二：反转一半的数字
    public boolean isPalindrome2(int x) {
        // 特殊情况，负数不是回文数
        // 如果正整数最后1位是0，要满足回文数只能是0本身
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;  // 获得末位
            x /= 10;  // 除以10，去掉末位
        }

        // 如果数字长度为奇数时，可以通过 revertedNumber / 10 去除处于中位的数字
        return x == revertedNumber || x == revertedNumber / 10;
    }

}
