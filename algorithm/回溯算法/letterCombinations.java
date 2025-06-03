package algorithm.回溯算法;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * [17. 电话号码的字母组合](https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/)
 *
 */
public class letterCombinations {

    List<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return list;
        // 初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTracking(digits, numString, 0);
        return list;
    }

    // 每次迭代获取一个字符串，所以会设计大量的字符串拼接，所有这里选择更为高效的 StringBuild
    StringBuilder temp = new StringBuilder();

    // 比如digits如果为“23”，num为0，则str表示2对应的abc
    public void backTracking(String digits, String[] numString, int num) {
        // 遍历全部一次记录一次得到的字符串
        if (num == digits.length()) {
            list.add(temp.toString());
            return;
        }
        // str表示当前num对应的字符串
        String str = numString[digits.charAt(num) - '0'];
        for (int i=0;i<str.length();i++) {
            temp.append(str.charAt(i));
            backTracking(digits, numString, num+1);
            // 剔除末尾的继续尝试
            temp.deleteCharAt(temp.length()-1);
        }
    }

}
