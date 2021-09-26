package leetcode.binary_tree;

import sun.plugin.javascript.navig.Link;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author chengzw
 * @description 二叉树的层序遍历，https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * <p>
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 示例：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 返回其层序遍历结果：
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * @since 2021/9/21
 */

/**
 * 思路：使用队列，在处理的时候用 size 记录要处理的个数，也就是这层的节点数
 */
public class LevelOrderMedium {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //存放结果
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        //特殊情况
        if (root == null) return result;
        //队列
        Queue<TreeNode> queue = new LinkedList<>();
        //先把二叉树顶部的第一个元素入队
        queue.add(root);
        while (!queue.isEmpty()) {
            //获取当前层的节点数
            int curLevelNum = queue.size();
            //收集本层的结果
            List<Integer> levelResult = new ArrayList<>();

            //本次 for 循环只会遍历处理该层的节点
            //从队列中取出这一层的节点进行扩展
            for (int i = 0; i < curLevelNum; i++) {
                //处理左子树
                if (queue.peek().left != null) {
                    queue.add(queue.peek().left);
                }
                //处理右子树
                if (queue.peek().right != null) {
                    queue.add(queue.peek().right);
                }
                //将处理完的节点出队，并添加到该层结果数组中
                levelResult.add(queue.poll().val);
            }
            result.add(levelResult);
        }
        return result;
    }
}
