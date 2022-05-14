package leetcode.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chengzw
 * @description 找树左下角的值，https://leetcode-cn.com/problems/find-bottom-left-tree-value/
 * <p>
 * 给定一个二叉树的 根节点 root，请找出该二叉树的最底层最左边节点的值。
 * 假设二叉树中至少有一个节点。
 * <p>
 * 输入: root = [2,1,3]
 * 输出: 1
 * @since 2021/9/27
 */

/**
 * 思路：从右往左层序遍历，使用队列
 */
public class FindBottomLeftValue {
    public int findBottomLeftValue(TreeNode root) {
        int result = -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result = node.val;
            //要找最左边的，从右往左层序遍历
            if (node.right != null) {
                queue.add(node.right);
            }
            if (node.left != null) {
                queue.add(node.left);
            }
        }
        return result;
    }
}
