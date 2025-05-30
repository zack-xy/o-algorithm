package algorithm.贪心算法.高频区间问题;

import java.util.Arrays;

/**
 *
 * [57. 插入区间](https://leetcode.cn/problems/insert-interval/description/)
 *
 */
public class insert {

//    ❌错误解法
//    public int[][] insert(int[][] intervals, int[] newInterval) {
//        int[][] newIntervals = new int[intervals.length][2];
//        newIntervals[0] = intervals[0];
//        int newIdx = -1;
//        for (int i=1;i<intervals.length;i++) {
//            if (newInterval[0] < intervals[i][1]) {
//                // 区间落入intervals中
//                int[] combineInterval = new int[2];
//                combineInterval[0] = Math.min(newInterval[0], intervals[i][0]);
//                combineInterval[1] = Math.max(newInterval[1], intervals[i][1]);
//                newIntervals[++newIdx] = combineInterval;
//            }
//        }
//        return Arrays.copyOf(newIntervals, newIdx + 1);
//    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] res = new int[intervals.length+1][2];  // 为什么+1，因为都不重叠的时候，需要插入newInterval
        int idx = 0;
        // 遍历区间列表
        // 首先将新区间左边且相离的区间加入结果集
        int i = 0;
        // 区间的末尾比新区间的开始还要小
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res[idx++] = intervals[i++];
        }
        // 判断当前区间是否与新区间重叠，重叠的话就进行合并，直到遍历到当前区间在新区间的右边且相离
        // 将最终合并后的新区间加入结果集
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        res[idx++] = newInterval;
        // 代码到这里，区间的开始 > newInterval的结束，说明整个区间是相离的，在右侧
        // 最后将新区间右边且相离的区间加入结果集
        while (i < intervals.length) {
            res[idx++] = intervals[i++];
        }

        return Arrays.copyOf(res, idx);
    }

}
