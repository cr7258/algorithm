package leetcode.binary_tree;

/**
 * @author chengzw
 * @description 105. 从前序与中序遍历序列构造二叉树
 * @link https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @since 2022/6/18
 */

import java.util.HashMap;
import java.util.Map;

/**
 给定两个整数数组 preorder 和 inorder，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。

 示例 1:
 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 输出: [3,9,20,null,null,15,7]

 示例 2:
 输入: preorder = [-1], inorder = [-1]
 输出: [-1]
 */

/**
 思路：
 前序遍历结果第一个就是根节点的值，然后再根据中序遍历结果确定左右子树的节点。
 题解链接：https://labuladong.github.io/algo/2/19/35/

 时间复杂度：O(n)，其中 n 是树中的节点个数。
 空间复杂度：O(n)，除去返回的答案需要的 O(n) 空间之外，我们还需要使用 O(n) 的空间存储哈希映射，以及 O(h)（其中 h 是树的高度）的空间表示递归时栈空间。
 这里 h<n，所以总空间复杂度为 O(n)。
 */
public class BuildTree {
    public Map<Integer, Integer> inorderIndex = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 根据中序遍历的数组构建哈希表，根据节点值快速找到对应的数组索引
        for(int i=0; i<inorder.length;i++){
            inorderIndex.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length -1 , inorder, 0, inorder.length -1);

    }

    // 构建二叉树
    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if(preStart > preEnd) return null;

        // root 节点对应的值就是前序遍历数组的第一个元素
        int rootVal = preorder[preStart];
        // rootVal 在中序遍历数组中的索引
        int index = inorderIndex.get(rootVal);
        int leftSize = index - inStart;

        // 先构造出当前根节点
        TreeNode root = new TreeNode(rootVal);
        // 递归构造左右子树
        root.left = build(preorder, preStart+1, preStart + leftSize, inorder, inStart, index-1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, index+1, inEnd);
        return root;
    }
}
