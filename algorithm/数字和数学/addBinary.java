package algorithm.数字和数学;

/**
 *
 * [67. 二进制求和](https://leetcode.cn/problems/add-binary/description/)
 *
 */
public class addBinary {

    // 我的解法：
    public static String addBinary(String a, String b) {
        if (a == null || a.equals("0")) return b;
        if (b == null || b.equals("0")) return a;
        int add = 0;
        int ar = a.length() - 1, br = b.length() - 1;
        StringBuffer sb = new StringBuffer();
        while (ar >= 0 || br >= 0 || add != 0) {
            int aNum = ar >= 0 ? a.charAt(ar) - '0' : 0;
            int bNum = br >= 0 ? b.charAt(br) - '0' : 0;
            int res = aNum ^ bNum ^ add;
            add = (aNum & bNum) | (aNum & add) | (bNum & add);
            sb.append(res);
            ar--;
            br--;
        }
        return sb.reverse().toString();
    }

    // 别人的解法
    public String addBinary2(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for (int i=a.length()-1, j=b.length()-1;i>=0 || j>=0;i--,j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            ca = sum / 2;
        }
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }




    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
    }

}
