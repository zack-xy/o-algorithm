package algorithm.回溯算法;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * [131. 分割回文串](https://leetcode.cn/problems/palindrome-partitioning/description/)
 *
 */
public class partition {

    List<List<String>> lists = new ArrayList<>();
    Deque<String> deque = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backTracking(s, 0);
        return lists;
    }

    private void backTracking(String s, int startIndex) {
        // 如果起始位置大于s的大小，说明找到了一组分割方案
        if (startIndex >= s.length()) {
            lists.add(new ArrayList<>(deque));
            return;
        }
        for (int i = startIndex;i<s.length();i++) {
            // 如果是回文子串，则记录
            if (isPalindrome(s, startIndex, i)) {  // [startIndex, i]处字符串是回文子串
                String str = s.substring(startIndex, i + 1);
                deque.addLast(str); // 把回文子串加到可能的结果中
            } else { // 如果不是回文子串
                continue;
            }
            // 代码运行到这里，子串一定是回文子串，如果不是的话，会立即进入下一次循环
            // 起始位置后移，保证不重复
            backTracking(s, i + 1);  // 进入递归
            deque.removeLast();
        }
    }

    // 判断是否是回文串
    private boolean isPalindrome(String s, int startIndex, int end) {
        for (int i=startIndex, j=end;i<j;i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

}
