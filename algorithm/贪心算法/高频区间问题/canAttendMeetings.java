package algorithm.贪心算法.高频区间问题;

import java.util.Arrays;

/**
 *
 * [252.会议室](https://leetcode.cn/problems/meeting-rooms/description/)
 *  给定一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，请你判断一个人是否能够参加这里面的全部会议。
 *
 *  示例 1:：
 * 输入: intervals = [[0,30],[15,20],[5,10]]
 * 解释: 存在重叠区间，一个人在同一时刻只能参加一个会议。
 *
 */
public class canAttendMeetings {

    // 将区间按照会议开始时间进行排序，然后遍历一边判断后面的会议开始的时候是否前面的会议还没有结束
    public boolean canAttendMeetings(int[][] intervals) {
        // 将区间按照会议开始实现升序排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        // 遍历会议，如果下一个会议在前一个会议结束之前就开始了，返回false
        for (int i=1;i<intervals.length;i++) {
            if (intervals[i][0] < intervals[i-1][1]) return false;
        }
        return true;
    }
}
