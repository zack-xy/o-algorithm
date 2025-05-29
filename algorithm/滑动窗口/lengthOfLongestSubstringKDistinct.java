package algorithm.滑动窗口;

import java.util.Collections;
import java.util.HashMap;

/**
 *
 * [340. 至多包含 K 个不同字符的最长子串](https://leetcode.cn/problems/longest-substring-with-at-most-k-distinct-characters/description/)
 *
 */
public class lengthOfLongestSubstringKDistinct {

    public  int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s.length() < k + 1) return s.length();
        int left = 0, right = 0;
        HashMap<Character, Integer> hasmap = new HashMap<>();
        int maxLen = k;
        while (right < s.length()) {
            if (hasmap.size() < k + 1) hasmap.put(s.charAt(right), right++);
            // 如果大小达到了k个
            if (hasmap.size() == k + 1) {
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
