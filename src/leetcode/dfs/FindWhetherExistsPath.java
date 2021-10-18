package leetcode.dfs;

/**
 * @author chengzw
 * @description 节点间通路，https://leetcode-cn.com/problems/route-between-nodes-lcci/
 * <p>
 * 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
 * 输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
 * 输出：true
 * @since 2021/10/18
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 思路：
 * 1.将题目给定的数组转换成邻接表（或者邻接矩阵）
 * 2.然后用标准的 dfs 来处理
 */
public class FindWhetherExistsPath {
    //判断是否找到，如果找到提前结束
    private boolean found = false;
    //邻接表
    private HashSet<Integer>[] adj;
    //是否走到过这个点，visited 不需要重置，因为走到这个点如果下个点不通，那么这个点继续判断可以走其他点
    //如果这个点最终走死路了，那么其他路线走到这个点依然是不通的，在这个点之前就会决策到其他点了
    private boolean[] visited;

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        visited = new boolean[n];
        adj = new HashSet[n];
        //构建邻接表，节点放在数组中
        for (int i = 0; i < n; i++) {
            adj[i] = new HashSet<>();
        }
        //节点连接的点接在 adj[i] 后面
        for (int i = 0; i < n; i++) {
            if (!adj[graph[i][0]].contains(graph[i][1])) {
                adj[graph[i][0]].add(graph[i][1]);
            }
        }
        dfs(start, target);
        return found;
    }

    public void dfs(int cur, int target) {
        //如果找到，提前结束
        if (found) return;

        //找到
        if (cur == target) {
            found = true;
            return;
        }

        //已经走到过这个点了
        visited[cur] = true;
        //dfs 这个节点
        for (Integer next : adj[cur]) {
            if (!visited[next]) {
                dfs(next, target);
            }
        }
    }
}
