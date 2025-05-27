package algorithm.字符串.反转问题;

/**
 *
 * [344. 反转字符串](https://leetcode.cn/problems/reverse-string/description/)
 *
 */
public class reverseString {

    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < s.length && right > 0 && left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }


    public void reverseString2(char[] s) {
        if (s == null || s.length == 0) return;
        int n = s.length;
        for (int left = 0, right = n - 1; left < right; ++left, --right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }

}
