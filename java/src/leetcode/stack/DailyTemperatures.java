package leetcode.stack;

import java.util.Stack;

/**
 * @author chengzw
 * @description 每日温度，https://leetcode-cn.com/problems/daily-temperatures/
 * <p>
 * 请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * @since 2021/9/6
 */
public class DailyTemperatures {

    /**
     * 思路1：当栈顶温度小于输入温度时，弹出栈顶温度，计算差值，最后压入输入温度
     * @param temperatures
     * @return
     */
    public static int[] solution1(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.empty() && temperatures[stack.peek()] < temperatures[i]) {
                int idx = stack.pop();
                result[idx] = i - idx;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = solution1(new int[]{30,40,50,60});
        for(int i:result){
            System.out.println(i);
        }
    }
}
