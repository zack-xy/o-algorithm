package algorithm.数字和数学;

/**
 *
 * [1822. 数组元素积的符号](https://leetcode.cn/problems/sign-of-the-product-of-an-array/description/)
 *
 */
public class arraySign {

    // 我的解法
    public int arraySign(int[] nums) {
        int negativeNum = 0;
        for (int num : nums) {
            if (num == 0) return 0;
            if (num < 0) negativeNum++;
        }
        if (negativeNum % 2 == 0) return 1;
        else return -1;
    }

    // 别人的解法
    public int arraySign2(int[] nums) {
        int prod = 1;
        for (int i=0;i<nums.length;++i) {
            if (nums[i] == 0) {
                return 0;
            } else if (nums[i] < 0) {
                prod = -prod;
            }
        }
        return prod;
    }

}
