package algorithm.数组常见题.Leetcode;

public class replaceSpace {
    /**
     * 字符串替换空格
     *
     * 请实现一个函数，将一个字符串中的每个空格替换成"%20"。例如，当字符串为We Are Happy。
     * 则经过替换之后的字符串为We%20Are%20Happy
     *
     *
     *
     */
    public String replaceSpace(StringBuffer str) {
        String res = "";
        for (int i=0;i<str.length();i++) {
            char c = str.charAt(i);
            if (c == ' ') res += "%20";
            else res += c;
        }
        return res;
    }

    public String replaceSpace2(StringBuffer str) {
        if (str == null) return null;
        int numsOfblank = 0; // 空格数量
        int len = str.length();
        for (int i=0;i<len;i++) { // 计算空格数量
            if (str.charAt(i) == ' ') numsOfblank++;
        }
        str.setLength(len + 2 * numsOfblank);  // 设置长度
        int fast = len - 1; // 两个指针
        int slow = (len + 2 * numsOfblank) - 1;

        while (fast >= 0 && slow > fast) {
            char c = str.charAt(fast);
            if (c == ' ') {
                fast--;
                str.setCharAt(slow--, '0');
                str.setCharAt(slow--, '2');
                str.setCharAt(slow--, '%');
            } else {
                str.setCharAt(slow, c);
                fast--;
                slow--;
            }
        }
        return str.toString();
    }
}
