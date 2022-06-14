package leetcode.binary_tree;

/**
 * @author chengzw
 * @description 面试题 17.12. BiNode
 * @link https://leetcode.cn/problems/binode-lcci/
 * @since 2022/6/15
 */

/**
 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。
 实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 返回转换后的单向链表的头节点。

 示例：
 输入： [4,2,5,1,3,null,6,0]
 输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
 */

/**
 思路：中序遍历，使用链表添加遍历的节点

 时间复杂度：O(n)
 空间复杂度：O(n)
 */
public class ConvertBiNode {
    // 虚拟头节点
    TreeNode newNode = new TreeNode();
    TreeNode tail = newNode;

    public TreeNode convertBiNode(TreeNode root) {
        inorder(root);
        return newNode.right;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);

        // 把遍历到的节点放入结果链表中
        tail.right = root;
        tail = root;
        tail.left = null;

        inorder(root.right);
    }
}
