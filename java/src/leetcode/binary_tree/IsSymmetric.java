package leetcode.binary_tree;

/**
 * @author chengzw
 * @description 对称二叉树，https://leetcode-cn.com/problems/symmetric-tree/
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 * @since 2021/9/27
 */

/**
 * 思路：使用递归，判断左右子树是否是镜像对称的
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetricR(root.left,root.right);
    }

    public boolean isSymmetricR(TreeNode leftNode,TreeNode rightNode){
        if(leftNode == null && rightNode == null){
            return true;
        }
        //左右子树 val 要相等，并且左右子树的子树也要是镜像对称
        if(leftNode != null && rightNode !=null && leftNode.val == rightNode.val){
           return isSymmetricR(leftNode.right, rightNode.left) && isSymmetricR(leftNode.left, rightNode.right);
        }
        return false;
    }
}
