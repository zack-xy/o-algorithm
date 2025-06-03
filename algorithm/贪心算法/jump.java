package algorithm.贪心算法;

/**
 *
 * [45. 跳跃游戏 II](https://leetcode.cn/problems/jump-game-ii/description/)
 *
 * 要求跳跃到终点的最小跳跃步数
 *
 * 题目保证可以到达 nums[n-1]
 *
 */
public class jump {

    public int jump(int[] nums) {
        int right = 0;  // 表示当前步数能够覆盖到的最大范围
        int maxPosition = 0;  // 记录能到达的最远的索引位置
        int steps = 0;  // 记录到达当前位置的最小步数
        for (int left=0;left<nums.length-1;left++) { // left用来遍历数组
            // 找到跳的最远的
            maxPosition = Math.max(maxPosition, nums[left] + left);
            // 下面这一行，代表了什么？
            if (left == right) { // 遇到边界，就更新边界，并且步数加1
                right = maxPosition;
                // 为什么是++？走到right这里只需要1步么？
                // 为什么从left到right只需要1步？
                // 因为right表示的是当前步数能够覆盖到的最大范围
                // left表示的是当前位置，当前位置连续跳到下一个位置是1次跳跃
                // 注意可能里面包含了多次小跳，但是整体上是算1次跳跃的(可以认为1次可以跳很远)
                steps++;
            }
            // right指针到达末尾了
            if (right > nums.length - 1) {
                return steps;
            }
        }
        return steps;
    }

}
