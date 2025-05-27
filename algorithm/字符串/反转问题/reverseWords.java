package algorithm.字符串.反转问题;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 *
 * [151. 反转字符串中的单词](https://leetcode.cn/problems/reverse-words-in-a-string/description/)
 *
 */
public class reverseWords {

    // 我的第一次题解：使用栈
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        Stack<String> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == ' ' || i == s.length() - 1) {
                if (i == s.length() - 1) {
                    if (s.charAt(i) != ' ') builder.append(s.charAt(i));
                }
                if (!builder.isEmpty()) {
                    stack.push(builder.toString());
                    builder = new StringBuilder();
                }
            }
            else {
                builder.append(s.charAt(i));
            }
        }
        builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
            if (!stack.isEmpty()) builder.append(" ");
        }
        return builder.toString();
    }

    // 题解一；使用API
    public String reverseWords2(String s) {
        if (s == null || s.length() == 0) return s;
        // 除去开头和末尾的空白字符串
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    // 题解二：原数组上操作
    // 先反转整个数组，再反转每个单词
    public String reverseWords3(String s) {
        StringBuilder sb = trimSpaces(s);

        // 翻转字符串
        reverse(sb, 0, sb.length() - 1);

        // 翻转每个单词
        reverseEachWord(sb);

        return sb.toString();
    }

    // 去除字符串前面、后面、中间的多余空格
    public StringBuilder trimSpaces(String s) {
        int left = 0, right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        // 将字符串间多余的空白字符去除
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);

            // 循环字符，如果字符不是空，加入到sb
            if (c != ' ') {
                sb.append(c);
            } else if (sb.charAt(sb.length() - 1) != ' ') {
                // 代码运行到这里，c是空字符，如果前一个字符不是空字符
                // 说明单词到这个空字符就结束了，把这个空字符塞到sb中
                sb.append(c);
            }

            ++left;
        }
        return sb;
    }

    // 翻转整个字符串
    public void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char tmp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, tmp);
        }
    }

    // 翻转每一个单词
    public void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0, end = 0;

        while (start < n) {
            // 循环至单词的末尾
            while (end < n && sb.charAt(end) != ' ') {
                ++end;
            }
            // 代码运行到这里，[start - end)区间是一个完整的单词(end处是空格)
            // 翻转单词
            reverse(sb, start, end - 1);
            // 更新start，去找下一个单词
            start = end + 1;
            ++end;
        }
    }

}
