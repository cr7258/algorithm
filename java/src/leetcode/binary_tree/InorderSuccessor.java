package leetcode.binary_tree;

/**
 * @author chengzw
 * @description 后继者，https://leetcode-cn.com/problems/successor-lcci/
 * <p>
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 * @since 2021/10/6
 */

/**
 * 思路：中序遍历，使用 comming 记录下一个节点是否是中序后继
 */
public class InorderSuccessor {
    TreeNode successor;
    //判断下一个是节点是否是中序后继
    boolean comming = false;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inorder(root, p);
        return successor;
    }

    public void inorder(TreeNode root, TreeNode p) {
        if (root == null) return;
        inorder(root.left, p);
        //提前退出条件
        if (successor != null) return;
        //如果下一个节点是中序后继
        if (comming == true) {
            successor = root;
        }
        if (root == p) {
            comming = true;
        }
        inorder(root.right, p);
    }
}
