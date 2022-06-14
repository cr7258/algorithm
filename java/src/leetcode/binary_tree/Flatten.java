package leetcode.binary_tree;

/**
 * @author chengzw
 * @description 114. 二叉树展开为链表
 * @link https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
 * @since 2022/6/14
 */

/**
 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 展开后的单链表应该与二叉树先序遍历顺序相同。


 示例 1：
 输入：root = [1,2,5,3,4,null,6]
 输出：[1,null,2,null,3,null,4,null,5,null,6]

 示例 2：
 输入：root = []
 输出：[]

 示例 3：
 输入：root = [0]
 输出：[0]
 */

/**
 思路：
 前序遍历，使用链表添加遍历的节点

 时间复杂度：O(n)
 空间复杂度：O(n)
 */
public class Flatten {
    // 虚拟头节点
    TreeNode newNode = new TreeNode();
    TreeNode tail = newNode;
    public void flatten(TreeNode root) {
        preorder(root);
    }
    public void preorder(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 把遍历到的节点放入结果链表中
        tail.right = root;
        tail = root;
        tail.left = null;

        preorder(left);
        preorder(right);
    }
}
