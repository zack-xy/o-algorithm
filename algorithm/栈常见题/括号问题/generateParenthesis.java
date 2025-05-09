package algorithm.栈常见题.括号问题;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {
    /**
     *
     * [22. 括号生成](https://leetcode.cn/problems/generate-parentheses/description/)
     *
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     *
     */

    // 解法一：暴力生成，然后验证是否有效
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        generateAll(new char[2*n], 0, combinations);
        return combinations;
    }

    // 这个递归是怎么生成所有的组合的？
    // current用来塞字符，pos用来标记是否塞满了
    // 递归尝试塞'('和')'
    private void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current)) {
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    // 这个函数是怎么校验有效性的？
    private boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    // 解法二：回溯法
    // TODO 回溯法
    public static List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    // 这个递归是什么意思呢？
    /**
     * @param ans 要返回的最终结果
     * @param cur 处理的子字符串
     * @param open 标识左括号的个数
     * @param close 标识右括号的个数
     * @param max 括号的组数，也就是n
     */
    private static void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) { // 如果左括号小于max，增加一个左括号
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) { // 如果右括号和左括号不平衡，增加一个右括号
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    // 解法三：按括号序列的长度递归
    // TODO 没太看懂
    public List<String> generateParenthesis3(int n) {
        return generate(n);
    }

    ArrayList[] cache = new ArrayList[100];

    // 这个函数又是啥意思？
    private List<String> generate(int n) {
        if (cache[n] != null) return cache[n];
        ArrayList<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c) {
                for (String left : generate(c)) {
                    for (String right : generate(n-1-c)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        cache[n] = ans;
        return ans;
    }


    public static void main(String[] args) {
        generateParenthesis g = new generateParenthesis();
        System.out.println(g.generateParenthesis3(3));
    }
}
