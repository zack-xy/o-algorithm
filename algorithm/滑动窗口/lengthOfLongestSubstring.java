package algorithm.滑动窗口;

import java.util.HashMap;

/**
 *
 * [3. 无重复字符的最长子串](https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/)
 *
 */
public class lengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                // 这里为什么要Math.max ？
                // 防止left回退
                // 比如"abba"
                // 当处理第二个 'b' 时，left 会移动到 2（合理）
                // 但当处理第二个 'a' 时，如果直接赋值，left 会回退到 1（错误），而 Math.max 能保持 left=2（正确）
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            map.put(s.charAt(right), right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

}
