package algorithm.字符串;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * [242. 有效的字母异位词](https://leetcode.cn/problems/valid-anagram/description/)
 *
 */
public class isAnagram {

    // 排序
    public boolean isAnagram(String s1, String s2) {
        // 将字符串转换成字符数组
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        // 对字符数组进行排序
        Arrays.sort(s1Chars);
        Arrays.sort(s2Chars);
        // 再将字符数组转换成字符串，比较是否相等
        return new String(s1Chars).equals(new String(s2Chars));
    }

    // 统计字符次数
    public boolean isAnagram2(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] s1Chars = s1.toCharArray();
        Map<Character, Integer> s1Map = getMap(s1);
        Map<Character, Integer> s2Map = getMap(s2);
        for (char s1Char : s1Chars) {
            if (!s2Map.containsKey(s1Char) || (int)s2Map.get(s1Char) != (int)s1Map.get(s1Char)) {
                return false;
            }
        }
        return true;
    }

    // 统计指定字符串str中各字符的出现次数，并以Map的形式返回
    private Map<Character, Integer> getMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            map.put(aChar, map.getOrDefault(aChar, 0) + 1);
        }
        return map;
    }

}
