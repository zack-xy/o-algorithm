package algorithm.字符串.反转问题;

import java.util.Stack;

/**
 *
 * [917. 仅仅反转字母](https://leetcode.cn/problems/reverse-only-letters/description/)
 *
 *   a-z：97-122
 *   A-Z：65-90
 */
public class reverseOnlyLetters {

    public String reverseOnlyLetters(String s) {
        if (s == null || s.length() == 0) return s;
        int left = 0, right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            if (isLetter(chars[left]) && isLetter(chars[right])) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
            if (!isLetter(chars[left])) left++;
            if (!isLetter(chars[right])) right--;
        }
        return new String(chars);
    }

    private boolean isLetter(char c) {
        return (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
    }


    // 其他解法二：使用栈
    public String reverseOnlyLetters2(String s) {

        Stack<Character> letters = new Stack<>();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) letters.push(c);
        }

        StringBuilder ans = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) ans.append(letters.pop());
            else ans.append(c);
        }

        return ans.toString();

    }

    // 其他解法三：双指针的另一种写法
    public String reverseOnlyLetters3(String s) {
        if (s == null || s.length() == 0) return s;
        StringBuilder ans = new StringBuilder();
        int j = s.length() - 1;
        for (int i=0;i<s.length();i++) {
            if (Character.isLetter(s.charAt(i))) {
                while (!Character.isLetter(s.charAt(j))) j--;
                ans.append(s.charAt(j--));
            } else {
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }
}
