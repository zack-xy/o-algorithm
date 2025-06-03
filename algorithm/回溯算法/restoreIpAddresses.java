package algorithm.回溯算法;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * [93. 复原 IP 地址](https://leetcode.cn/problems/restore-ip-addresses/description/)
 *
 */
public class restoreIpAddresses {

    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        // 这个是IP的特性决定的
        if (s.length()<4 || s.length()>12) return result;
        backTrack(s, 0, 0);
        return result;
    }

    // startIndex：搜索的起始位置，pointNum:添加小数点的数量
    private void backTrack(String s, int startIndex, int pointNum) {
        if (pointNum == 3) { // 小数点数量为3时，分隔结束
            // 判断第四段子字符串是否合法，如果合法就放进result中
            if (isValid(s, startIndex, s.length() - 1)) {
                result.add(s);
            }
            return;
        }
        for (int i=startIndex;i<s.length();i++) {
            if (isValid(s, startIndex, i)) {
                // 在str的后面插入一个小数点
                s = s.substring(0, i+1) + "." + s.substring(i+1);
                pointNum++;
                // 插入小数点之后下一个子串的起始位置为i+2
                backTrack(s, i+2, pointNum);
                pointNum--;
                s = s.substring(0, i+1) + s.substring(i+2); // 撤销操作
            } else {
                break;
            }
        }
    }

    // 判断字符串s在左闭右闭区间[start, end]所组成的数字是否合法
    private Boolean isValid(String s, int start, int end) {
        if (start > end) return false;
        // 0开头的数字不合法
        if (s.charAt(start) == '0' && start != end) return false;
        int num = 0;
        for (int i=start;i<=end;i++) {
            // 遇到非数字字符不合法
            if (s.charAt(i) > '9' || s.charAt(i) < '0') return false;
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) return false;  // 如果大于255不合法
        }
        return true;
    }

}
