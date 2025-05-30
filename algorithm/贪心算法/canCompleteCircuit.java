package algorithm.贪心算法;

/**
 *
 * [134. 加油站](https://leetcode.cn/problems/gas-station/description/)
 *
 *  完了，第一遍还是没看懂题目
 *
 *  看懂了，就是gas存的是每个加油站的汽油数
 *  对应的cost存的是从这个加油站出发去下一个加油站需要消耗的汽油数
 *
 *  必须要按顺序绕环路行驶一周，也就是每个加油站必须停，必须加油
 *
 */
public class canCompleteCircuit {

    // 我的想法就是模拟这个过程呗
    // 先找到出发的加油站，如果循环一周ok，返回就行了
    // 如果加油站遍历到头了，没有，就返回-1
    // 暴力解法
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        // 这个一站的汽油是gas[i],到下一站需要花费的汽油是cost[i]
        for (int i=0;i<gas.length;i++) {
            if (gas[i] >= cost[i]) {
                if (check(i, gas, cost)) return i;
            }
        }
        return -1;
    }

    public static boolean check(int i, int[] gas, int[] cost) {
        int gasCount = gas[i] - cost[i];
        int runIdx = (i + 1) % gas.length;
        while (runIdx != i) {
            gasCount+=gas[runIdx];
            if (gasCount < cost[runIdx]) return false;
            gasCount-=cost[runIdx];
            runIdx = (runIdx + 1) % gas.length;
        }
        return true;
    }

    // 贪心
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int start = 0;
        for (int i=0;i<gas.length;i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] -cost[i];
            // 当前累加rest[i]和curSum一旦小于0
            if (curSum < 0) {
                // 更新起始位置为i+1
                start = i + 1;
                // curSum从0开始
                curSum = 0;
            }
        }
        // 说明怎么走都不可能跑一圈了
        if (totalSum < 0) return -1;
        return start;
    }

    public static void main(String[] args) {
        int[] gas = {2};
        int[] cost = {2};
        int ret = canCompleteCircuit(gas, cost);
        System.out.println(ret);
    }

}
