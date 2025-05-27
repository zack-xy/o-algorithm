package algorithm.字符串;

/**
 *
 * [709. 转换成小写字母](https://leetcode.cn/problems/to-lower-case/description/)
 *
 */
public class toLowerCase {

    /**
     *
     *  根据ASCII码表转换：
     *  a-z：97-122
     *  A-Z：65-90
     *  0-9: 48-57
     *
     *  遍历字符串，如果str[i]的值在A-Z之间，在原来的ASCII码上加32就可以转换为对应的小写
     *
     */
    public String toLowerCase(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        for (int i=0;i<n;++i) {
            if (chars[i] >= 65 && chars[i] <= 90) {
                chars[i] += 32;
            }
        }
        String str = new String(chars);
        return str;
    }

}
