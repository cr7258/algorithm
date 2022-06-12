package leetcode.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description 102. 二叉树的层序遍历
 * @author chengzw
 * @since 2022/6/11
 * @link https://leetcode.cn/problems/binary-tree-level-order-traversal/
 */

/**
给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。

示例 1：
输入：root = [3,9,20,null,null,15,7]
输出：[[3],[9,20],[15,7]]

示例 2：
输入：root = [1]
输出：[[1]]

示例 3：
输入：root = []
输出：[]
*/

/**
思路：
1.BFS 算法，通过一个 while 循环控制从上向下一层层遍历，for 循环控制每一层从左向右遍历
2.使用队列，在处理的时候用 size 记录要处理的个数，也就是这层的节点数，由一个一个处理转换成一层一层处理

时间复杂度：每个点进队出队各一次，故渐进时间复杂度为 O(n)。
空间复杂度：队列中元素的个数不超过 n 个，故渐进空间复杂度为 O(n)。
*/

public class LevelOrderMedium {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 存放最终结果
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 特殊情况
        if (root == null) {
            return ans;
        }
        // 队列存放每层的节点
        Queue<TreeNode> queue = new LinkedList<>();
        // 先将根节点加入队列
        queue.add(root);
        // while 循环从上往下按层处理
        while (!queue.isEmpty()) {
            // 存放每层的结果
            List<Integer> levelAns = new ArrayList<>();
            // for 循环处理每一层的节点
            int curlevelNum = queue.size();
            for (int i = 0; i < curlevelNum; i++) {
                TreeNode node = queue.poll();
                levelAns.add(node.val);
                // 将该层的子节点加入队列，下一轮层序遍历使用
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans.add(levelAns);
        }
        return ans;
    }
}
