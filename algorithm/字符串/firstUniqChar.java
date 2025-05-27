package algorithm.字符串;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * [387. 字符串中的第一个唯一字符](https://leetcode.cn/problems/first-unique-character-in-a-string/description/)
 *
 */
public class firstUniqChar {

    // 我的题解一：循环
    public static int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        if (s.length() == 1) return 0;
        int ret = -1;
        for (int i=0;i<s.length();i++){
            for (int j=0;j<s.length();j++) {
                if (j == i) {
                    if (i == s.length() - 1) ret = i;
                    else continue;
                }
                if (s.charAt(i) == s.charAt(j)) break;
                if (j == s.length() - 1) {
                    ret = i;
                }
            }
            if (ret != -1) return ret;
        }
        return -1;
    }

    // 解法二：两次遍历，哈希映射
    public int firstUniqChar2(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> frequency = new HashMap<>();
        for (int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        for (int i=0;i<s.length();i++) {
            if (frequency.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }



    public static void main(String[] args) {
        System.out.println(firstUniqChar("dddccdbba"));
    }
}
