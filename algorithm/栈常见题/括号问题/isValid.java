package algorithm.栈常见题.括号问题;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class isValid {
    /**
     *
     * [20. 有效的括号](https://leetcode.cn/problems/valid-parentheses/description/)
     *
     */

    /**
     *
     * 算法解释：需要用到哈希表和栈
     *
     */
    // 解法一：哈希表和栈
    public boolean isValid(String s) {
        if (s.length() <= 1) return false;
        Map<Character, Character> smap = new HashMap<>();
        smap.put('(', ')');
        smap.put('{','}');
        smap.put('[',']');

        Stack<Character> stack = new Stack<>();
        for (int i=0;i<s.length();i++) {
            char item = s.charAt(i);
            if (smap.containsKey(item)) {
                stack.push(item);
            } else {
                if (!stack.isEmpty()) {
                    Character left = stack.pop();
                    char rightchar = smap.get(left);
                    if (rightchar != item) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // ❌这个解法不对，漏掉了“()[]{}”这种情况，不能处理
    //    public static boolean isValid2(String s) {
    //        if (s.length() % 2 != 0) return false;
    //        int left = s.length() / 2 - 1;
    //        int right = s.length() / 2;
    //        while (left >= 0 && right < s.length()) {
    //            if (s.charAt(left) == '{' && s.charAt(right) != '}') return false;
    //            if (s.charAt(left) == '[' && s.charAt(right) != ']') return false;
    //            if (s.charAt(left) == '(' && s.charAt(right) != ')') return false;
    //            left--;
    //            right++;
    //        }
    //        return true;
    //    }

}
