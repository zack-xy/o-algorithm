package algorithm.字符串;

/**
 *
 * [8. 字符串转换整数 (atoi)](https://leetcode.cn/problems/string-to-integer-atoi/description/)
 *
 *  这里不涉及算法，涉及日常编程的边界问题和数据处理
 *
 */
public class myAtoi {

    public int myAtoi(String s) {
        int len = s.length();
        char[] charArray = s.toCharArray();

        // 1. 去除前导空格
        int index = 0;
        while (index < len && charArray[index] == ' ') {
            index++;
        }

        // 2. 如果已经遍历完成(针对极端用例 "          ")
        if (index == len) return 0;

        // 3. 如果出现符号字符，仅第1个有效，并记录正负
        int sign = 1;
        char firstChar = charArray[index];
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }

        // 4. 将后续出现的数字字符进行转换
        // 不能使用long类型
        int res = 0;
        while (index < len) {
            char currChar = charArray[index];
            // 先判断不合法情况
            if (currChar > '9' || currChar < '0') {
                break;
            }

            // 解决溢出问题的经典处理方式
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10))  {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            // 合法情况下，才考虑转换，每一步都把符号位乘进去
            res = res * 10 + sign * (currChar - '0');
            index++;
        }
        return res;
    }
}
