package algorithm.栈常见题.表达式计算;

import java.util.Stack;

/**
 *
 * [150. 逆波兰表达式求值](https://leetcode.cn/problems/evaluate-reverse-polish-notation/description/)
 * 
 * 给一个字符串，表示一个逆波兰表达式，求这个逆波兰表达式的值
 * 
 */
public class evalRPN {

    // 解法一：栈
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (!Character.isDigit(token.charAt(0)) && token.length() == 1) {
                // 不是数字，是运算符，从栈中取两个数进行运算
                int b = stack.pop();
                int a = stack.pop();
                switch (token) {
                    // 根据运算符的种类进行计算，将计算结果入栈
                    case "+": stack.push(a+b); break;
                    case "-": stack.push(a-b); break;
                    case "*": stack.push(a*b); break;
                    case "/": stack.push(a/b); break;
                }
            } else {
                // 整数直接入栈
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    // 解法二：数组模拟栈
    public static int evalRPN2(String[] tokens) {
        int n = tokens.length;
        int[] stack = new int[(n+1)/2]; // 初始化一个tokens长度一半的数组
        int index = -1;
        for (int i=0;i<n;i++) {
            String token = tokens[i];
            switch (token) {
                case "+":
                    index--;
                    stack[index] += stack[index+1];
                    break;
                case "-":
                    index--;
                    stack[index] -= stack[index+1];
                    break;
                case "*":
                    index--;
                    stack[index] *= stack[index+1];
                    break;
                case "/":
                    index--;
                    stack[index] /= stack[index+1];
                    break;
                default:  // 不是操作符，是数字的话
                    index++;
                    stack[index] = Integer.parseInt(token);
            }
        }
        return stack[index];
    }

    public static void main(String[] args) {
        String[] tokens = new String[]{"2","1","+","3","*"};

        System.out.println(evalRPN2(tokens));
    }
}
