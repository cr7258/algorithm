package leetcode.binary_tree;

/**
 * @author chengzw
 * @description 889. 根据前序和后序遍历构造二叉树
 * @link https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 * @since 2022/6/18
 */

/**
 给定两个整数数组，preorder 和 postorder ，其中 preorder 是一个具有无重复值的二叉树的前序遍历，postorder 是同一棵树的后序遍历，重构并返回二叉树。
 如果存在多个答案，您可以返回其中 任何 一个。

 示例 1：
 输入：preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
 输出：[1,2,3,4,5,6,7]

 示例 2:
 输入: preorder = [1], postorder = [1]
 输出: [1]
 */

import java.util.HashMap;
import java.util.Map;

/**
 思路：通过前序中序，或者后序中序遍历结果可以确定唯一一棵原始二叉树，但是通过前序后序遍历结果无法确定唯一的原始二叉树。
 1.首先把前序遍历结果的第一个元素或者后序遍历结果的最后一个元素确定为根节点的值。
 2.然后把前序遍历结果的第二个元素作为左子树的根节点的值。
 3.在后序遍历结果中寻找左子树根节点的值，从而确定了左子树的索引边界，进而确定右子树的索引边界，递归构造左右子树即可。

 参考题解：https://labuladong.github.io/algo/2/19/35/

 时间复杂度：O(n)
 空间复杂度：O(n)
 */
public class BuildTree3 {
    public Map<Integer, Integer> postorderIndex = new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        // 根据后序遍历数组构建哈希表
        for(int i=0; i< postorder.length;i++){
            postorderIndex.put(postorder[i], i);
        }

        return build(preorder, 0, preorder.length-1, postorder, 0, postorder.length-1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if(preStart > preEnd) return null;

        // 最后一个节点，直接构造返回，否则 preorder[preStart + 1] 会越界
        if(preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }
        // 构建根节点
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // 确定 preorder 和 postorder 中左右子树的元素区间
        int leftRootVal = preorder[preStart + 1];
        //  leftRootVal 在后序遍历数组中的索引
        int index = postorderIndex.get(leftRootVal);
        // 左子树的元素个数
        int leftSize = index - postStart + 1;

        // 根据左子树的根节点索引和元素个数推导左右子树的索引边界
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                postorder, postStart, index);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                postorder, index + 1, postEnd - 1);

        return root;
    }
}
