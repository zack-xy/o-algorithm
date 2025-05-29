package algorithm.滑动窗口;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * [438. 找到字符串中所有字母异位词](https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/)
 *
 */
public class findAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i=0;i<pLen;i++) {
            sCount[s.charAt(i)-'a']++;
            pCount[p.charAt(i)-'a']++;
        }
        if (Arrays.equals(sCount, pCount)) ans.add(0);

        for (int left = 0; left < sLen - pLen; left++) {
            sCount[s.charAt(left)-'a']--;
            int right = left + pLen;
            sCount[s.charAt(right)-'a']++;

            if (Arrays.equals(sCount, pCount)) ans.add(left+1);
        }
        return ans;
    }
}
