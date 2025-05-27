package algorithm.字符串;

/**
 *
 * [125. 验证回文串](https://leetcode.cn/problems/valid-palindrome/description/)
 *
 */
public class isPalindrome {

    // 我的题解
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 1) return true;
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<len;i++) {
            if (Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i))) {
                Character c = s.charAt(i);
                if (Character.isLetter(s.charAt(i)) && Character.isUpperCase(c)) {
                    c = Character.toLowerCase(c);
                }
                sb.append(c);
            }
        }
        int left = 0, right = sb.length()-1;
        while (left < right) {
            if (sb.charAt(left) != sb.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    // 其他题解 - 跟上面一样的，只是换一种写法
    public boolean isPalindrome1(String s) {
        if (s == null || s.length() == 0) return true;
        StringBuffer sgood = new StringBuffer(); // 线程安全
        int length = s.length();
        for (int i=0;i<length;i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        int n = sgood.length();
        int left = 0, right = n - 1;
        while (left < right) {
            if (sgood.charAt(left) != sgood.charAt(right)) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }

}
