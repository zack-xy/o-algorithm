package algorithm.滑动窗口;

import java.util.Collections;
import java.util.HashMap;

/**
 *
 * [159. 至多包含两个不同字符的最长子串](https://leetcode.cn/problems/longest-substring-with-at-most-two-distinct-characters/description/)
 *
 */
public class lengthOfLongestSubstringTwoDistinct {

    public  int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() < 3) return s.length();
        int left = 0, right = 0;
        HashMap<Character, Integer> hasmap = new HashMap<>();
        int maxLen = 2;

        while (right < s.length()) {
            // 先放right，然后right++
            if (hasmap.size() < 3) hasmap.put(s.charAt(right), right++);

            // 如果大小达到了3个
            if (hasmap.size() == 3) {
                // 最左侧要删除的位置
                int del_idx = Collections.min(hasmap.values());
                hasmap.remove(s.charAt(del_idx));
                // 窗口left的新位置
                left = del_idx + 1;
            }

            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;
    }
}
