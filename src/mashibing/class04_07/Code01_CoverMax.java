package mashibing.class04_07;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Code01_CoverMax {
    //最大线段重合问题（用堆的实现）
//    给定很多线段，每个线段都有两个数[start, end]，
//    表示线段开始位置和结束位置，左右都是闭区间
//    规定：
//    1）线段的开始和结束位置一定都是整数值
//    2）线段重合区域的长度必须>=1
//    返回线段最多重合区域中，包含了几条线段

    //暴力方式：O(N^2)
//    public static int maxCover1(int[][] lines) {
//
//    }


    //用堆实现o(N*logN)
    public static int maxCover2(int[][] m) {
        //生成Line对象的数组
        Line[] lines = new Line[m.length];
        for (int i = 0; i < lines.length; i++) {
            lines[i] = new Line(m[i][0], m[i][1]);
        }
        //按照线的起点的值从小到大排序
        Arrays.sort(lines, new StartComparator());

        //小根堆，PriorityQueue默认是小根堆
        //每一根线终点如果 穿过参照的线的起点，则保留
        //否则弹出，最后将参照的线的终点加入小根堆
        //max记录此时最大穿过的线的数量
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int max = 0;
        for (int i = 0; i < lines.length; i++) {
            while (!heap.isEmpty() && heap.peek() <= lines[i].start) {
                heap.poll();
            }
            heap.add(lines[i].end);
            max = Math.max(max,heap.size());
        }
        return max;
    }


    //生成一组线段
    //N--线段数量最大值
    //L--线段起点最小值
    //R--线段终点最大值
    public static int[][] generateLines(int N, int L, int R) {
        int size = (int) (Math.random() * N) + 1;
        int[][] ans = new int[size][2];
        for (int i = 0; i < size; i++) {
            int a = L + (int) (Math.random() * (R - L + 1));
            int b = L + (int) (Math.random() * (R - L + 1));
            if (a == b) {
                b = a + 1;
            }
            ans[i][0] = Math.min(a, b);
            ans[i][1] = Math.max(a, b);
        }
        return ans;
    }

    public static class Line {
        private int start;
        private int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    //比较器
    //线段起点值按照从小到大顺序排序
    public static class StartComparator implements Comparator<Line> {
        @Override
        public int compare(Line o1, Line o2) {
            return o1.start - o2.start;
        }
    }
}
