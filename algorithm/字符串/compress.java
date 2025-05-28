package algorithm.字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * [443. 压缩字符串](https://leetcode.cn/problems/string-compression/description/)
 *
 */
public class compress {

    // 我的解法：使用map计数 （不通过）
    public static int compress(char[] chars) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0;i<chars.length;i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
        }
        ArrayList<Character> list = new ArrayList<>();
        map.forEach((k, v) -> {
            if (v == 1) {
                list.add(k);
            } else {
                list.add(k);
                String count = String.valueOf(v);
                int idx = 0;
                while (idx < count.length()) {
                    list.add(v.toString().charAt(idx));
                    idx++;
                }
            }
        });
        for (int i = 0;i<list.size();i++) {
            chars[i] = list.get(i);
        }
        for (int i = list.size();i<chars.length;i++) {
            chars[i] = ' ';
        }
       return chars.length;
    }

    // 解法
    public static int compress2(char[] chars) {
        int n = chars.length;
        int write = 0, left = 0;
        for (int read = 0; read < n; read++) {
            if (read == n-1 || chars[read] != chars[read+1]) { // 如果是最后1个字符或者临近2个字符不相同
                // 代码到这一行，当前读的字符是read，后一个字符与当前的字符不相同
                chars[write++] = chars[read];
                int num = read - left + 1;
                if (num > 1) {
                    int anchor = write;
                    while (num > 0) {
                        chars[write++] = (char) (num % 10 + '0');  // 整数数字转char
                        num /= 10;
                    }
                    reverse(chars, anchor, write - 1);
                }
                left = read + 1;
            }
        }
        return write;
    }

    private static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','c','c','c'};
        char[] chars2 = {'a', 'b', 'b', 'b'};
        int ret = compress2(chars2);
        System.out.println(ret);
    }
}
