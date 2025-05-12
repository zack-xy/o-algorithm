package algorithm.栈常见题.表达式计算;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * [227. 基本计算器 II](https://leetcode.cn/problems/basic-calculator-ii/description/)
 *
 * 解题基本思路：
 * 乘除优先于加减计算，所以使用一个栈，保存乘除运算后的整数值
 * 加减号后的数字，直接压入栈中，乘除号后的数字，直接与栈顶元素计算，然后替换栈顶元素作为计算结果
 *
 * 额外的变量记录数字前面的运算符
 *  +号：数字入栈
 *  -号：数字相反数入栈
 *  乘除号：计算数字与栈顶元素，将栈顶元素替换为计算结果
 *
 *
 *
 */
public class calculate {

    public static int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i=0;i<n;++i) {
            // 如果字符是数字
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';  // 字符转换为数字，这里为什么有一个num*10，为了实现位权累加
            }
            // 如果 【字符不是数字并且不是空字符】 或者 【是最后一个字符】
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);  // 如果是+号，数字入栈
                        break;
                    case '-':             // 如果是-号，数字相反数入栈
                        stack.push(-num);
                        break;
                    case '*':            // 如果是*号，弹栈运算；将结果入栈
                        stack.push(stack.pop() * num);
                        break;
                    default:             // 如果是/号，弹栈运算；将结果入栈
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(calculate("3+25*2"));

        String str = "123";
        System.out.println(str.charAt(1));
    }
    

}


