package leetcode.binary_tree;

/**
 * @author chengzw
 * @description 把二叉搜索树转换为累加树，https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 * <p>
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
 * 使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 * <p>
 * 提醒一下，二叉搜索树满足下列约束条件：
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 * @since 2021/10/6
 */

/**
 * 思路：使用递归，中序遍历，按照右-根-左的顺序遍历，root.val = sum
 */
public class ConvertBST {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        inorder(root);
        return root;
    }

    public int inorder(TreeNode root) {
        if (root == null) return 0;
        inorder(root.right);
        //sum + 要放在右节点遍历之后
        sum += root.val;
        root.val = sum;
        inorder(root.left);
        return sum;
    }
}
