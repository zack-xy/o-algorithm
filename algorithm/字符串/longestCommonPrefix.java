package algorithm.字符串;

/**
 *
 * [14. 最长公共前缀](https://leetcode.cn/problems/longest-common-prefix/description/)
 *
 */
public class longestCommonPrefix {

    // 解法一：依次比较每个字符串每个字符
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int length = strs[0].length();
        int count = strs.length;
        for (int i=0;i<length;i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    // 解法二：依次比较两个字符串的前缀，然后把结果作为参数和字符串继续找前缀
    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        int count = strs.length;
        for (int i=1;i<count;i++) {
            prefix = longestCommonPrefix2(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    // 找两个字符串的前缀
    private static String longestCommonPrefix2(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    public static void main(String[] args) {

    }

}
