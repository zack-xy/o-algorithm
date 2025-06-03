package algorithm.贪心算法;

/**
 *
 * [55. 跳跃游戏](https://leetcode.cn/problems/jump-game/description/)
 *
 */
public class canJump {

    // 题目理解的不对，数组存储的数字不是固定跳这么多步，而是最大跳这么多步，可以少跳的
    public static boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        int i = 0;
        while (i < nums.length) {
            if (i == nums.length - 1) return true;
            if (nums[i] == 0 && i != nums.length - 1) return false;
            if (nums[i] <= nums.length - 1 - i) {
                i = i + nums[i];
            } else {
                return true;
            }
        }
        return true;
    }

    // 正确解法
    public boolean canJump2(int[] nums) {
        if (nums.length == 1) return true;
        // 覆盖范围，初始范围应该是0，因为下面迭代是从下标0开始的
        // cover表示可以覆盖的索引位置
        int cover = 0;
        // 在覆盖范围内更新最大的覆盖范围
        for (int i=0;i<=cover;i++) { // 注意这里是<=cover
            cover = Math.max(cover, i + nums[i]);  // cover取 覆盖最远的索引位置
            if (cover >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0};
        boolean canJump = canJump(nums);
        System.out.println(canJump);
    }

}
