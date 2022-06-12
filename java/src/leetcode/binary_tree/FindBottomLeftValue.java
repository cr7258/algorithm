package leetcode.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description 513. 找树左下角的值
 * @author chengzw
 * @since 2022/6/12
 * @link https://leetcode.cn/problems/find-bottom-left-tree-value/
 */

/**
给定一个二叉树的 根节点 root，请找出该二叉树的最底层最左边节点的值。
假设二叉树中至少有一个节点。

示例 1:
输入: root = [2,1,3]
输出: 1

示例 2:
输入: [1,2,3,4,null,5,6,null,null,7]
输出: 7
*/

/**
思路：
从右往左按层遍历，使用 ans 记录节点的 Val 值，最后的 Val 就是左下角节点的值

时间复杂度：O(n)
空间复杂度：O(n)
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
