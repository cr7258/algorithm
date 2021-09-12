package leetcode.sort;


import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chengzw
 * @description 会议室，https://leetcode-cn.com/problems/meeting-rooms/
 * <p>
 * 给定一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，请你判断一个人是否能够参加这里面的全部会议。
 * <p>
 * 输入：intervals = [[0,30],[5,10],[15,20]]
 * 输出：false
 * <p>
 * 输入：intervals = [[7,10],[2,4]]
 * 输出：true
 * @since 2021/9/12
 */

/**
 * 思路：先根据会议开始时间排序，判断如果会议结束时间大于下一场会议的开始直接，返回 false
 */
public class CanAttendMeetings {
    public boolean canAttendMeetings(int[][] intervals) {
        //根据会议开始时间进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] i1, int[] i2) {
                return i1[0] - i2[0];
            }
        });

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) return false;
        }
        return true;
    }
}
