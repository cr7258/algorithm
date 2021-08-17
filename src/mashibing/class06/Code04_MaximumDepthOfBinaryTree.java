package mashibing.class06;

/**
 * @author 程治玮
 * @since 2021/1/19 10:37 下午
 * <p>
 * 求一颗二叉树的最大深度
 * 测试链接：https://leetcode.com/problems/maximum-depth-of-binary-tree
 */
public class Code04_MaximumDepthOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    //最大高度为左树和右树最大的高度+自己这层
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
