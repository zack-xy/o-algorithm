package algorithm.数字和数学;

/**
 *
 * [7. 整数反转](https://leetcode.cn/problems/reverse-integer/description/)
 *
 */
public class reverse {

    // 第一种写法：标准写法
    public static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            // 获得末尾数字
            int tmp = x % 10;
            // 判断是否大于最大32位整数，也可以使用Integer.MAX_VALUE/10来代替214748364
            if (res > 214748364 || (res == 214748364 && tmp > 7)) return 0;
            // 判断是否小于最下的32位整数
            if (res<-214748364 || (res == -214748364 && tmp < -8)) return 0;
            res = res * 10 + tmp;
            x /= 10;
        }
        return res;
    }


    // 最大正整数：2147483647  == /10 ==> 214748364
    // 最小负整数：-2147483648 == /10 ==> -214748364

    // 第二种写法：
    // ⚠️⚠️为什么上面的代码里(res == 214748364 && tmp > 7)和(res == -214748364 && tmp < -8)删掉也是对的

    // 因为，如果输入的数字位数小于【最大数字的位数】，那么一定是不会溢出的
    // 拿463847412举例翻转之后是214748364是9位数字，这个数正好是【最大正整数的10分之一】
    // 翻转前8位的时候，都比【最大正整数的10分之一】要小，因为【最大正整数的10分之一】是9位数字
    // 剩下最后1位数字的时候，x/=10就是0了，退出了循环
    // 也就是说，无论最后1位是多少，因为位数小于【最大数字的位数】，不等到res == Integer.MAX_VALUE/10这个判断就已经退出循环了

    // 如果输入数字位数大于等于【最大数字的位数】
    // 先看大于的情况，是不存在大于的情况的，因为输入数字就溢出了，显然是不可能的
    // 那么只有位数等于的情况
    // 当 前9位正好等于214748364时，最后1位不可能为7
    // 因为 214748364是反转得来的，10位的输入数字，要想不溢出，高位必须是1或者2，不可能为7
    // 同理，也不需要判断 -8
    public static int reverse2(int x) {
        int res = 0;
        while (x != 0) {
            int tmp = x % 10;
            if (res > Integer.MAX_VALUE/10 || res < Integer.MIN_VALUE/10) return 0;
            res = res * 10 + tmp;
            x /= 10;
        }
        return res;
    }



    public static void main(String[] args) {
    }

}
