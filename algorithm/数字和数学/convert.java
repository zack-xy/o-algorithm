package algorithm.数字和数学;

/**
 *
 * 给定一个十进制数M，以及需要转换的进制数N，将十进制数M转化为N进制数，M是32位整数，2<=N<=16
 *
 *
 */

// TODO 通用进制转换
public class convert {

    public static final String[] F = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

    public String convert(int M, int N) {
        Boolean flag = false;
        if (M < 0) {
            flag = true;
            M*=-1;
        }
        StringBuffer sb = new StringBuffer();
        int temp;
        while (M!=0) {
            temp=M%N;
            // 技巧一：通过数组F[]解决了大量繁琐的不同进制之间映射的问题
            sb.append(F[temp]);
            M=M/M;
        }
        // 技巧二：使用StringBuffer的reverse()方法
        sb.reverse();
        // 技巧三：最后处理正负
        return (flag? "-":"") + sb.toString();
    }

}
