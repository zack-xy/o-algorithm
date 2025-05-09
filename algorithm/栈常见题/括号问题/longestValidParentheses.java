package algorithm.栈常见题.括号问题;


import java.util.Deque;
import java.util.LinkedList;

public class longestValidParentheses {
    /**
     *
     * [32. 最长有效括号](https://leetcode.cn/problems/longest-valid-parentheses/description/)
     *
     */

    // 解法一：暴力
    public int longestValidParentheses(String s) {
        int max = 0;
        for (int i=0;i<s.length();i++) {
            for (int j=i+1;j<=s.length();j++) {
                if(valid(s.substring(i,j))) {
                    if (j - i > max) {
                        max = j - i;
                    }
                }
            }
        }
        return max;
    }

    private boolean valid(String str) {
        int flag = 0;
        for (int i=0;i<str.length();i++) {
            if (str.charAt(i) == '(') flag++;
            if (str.charAt(i) == ')') flag--;
            if (flag < 0) return false;
        }
        return flag == 0;
    }

    // 解法二：动态规划
    // TODO 动态规划
    public int longestValidParentheses2(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i=1;i<s.length();i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i-1) == '(') {
                    dp[i]=(i>=2 ? dp[i-2] : 0) + 2;
                } else if (i-dp[i-1]>0&&s.charAt(i-dp[i-1]-1)=='(') {
                    dp[i]=dp[i-1]+((i-dp[i-1]) >= 2 ? dp[i-dp[i-1]-2]:0) + 2;
                }
                maxans=Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    // 解法三：栈
    // TODO 待理解
    public static int longestValidParentheses3(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i-stack.peek());
                }
            }
        }
        return maxans;
    }

    // 解法四：不需要额外空间
    // TODO 待理解
    public static int longestValidParentheses4(String s) {
        int left=0,right=0,maxlength=0;
        for(int i=0;i<s.length();i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i=s.length()-1;i>=0;i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxlength;
    }

    public static void main(String[] args) {
        longestValidParentheses3(")()())");
    }
}
