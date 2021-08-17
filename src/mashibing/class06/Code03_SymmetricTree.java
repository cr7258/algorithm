package mashibing.class06;

/**
 * @author 程治玮
 * @since 2021/1/19 10:31 下午
 * <p>
 * 判断一颗二叉树是否为镜面树
 * 测试连接：https://leetcode.com/problems/symmetric-tree/submissions/
 */
public class Code03_SymmetricTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public static boolean isMirror(TreeNode h1, TreeNode h2) {
        if (h1 == null ^ h2 == null) {
            return false;
        }
        if (h1 == null && h2 == null) {
            return true;
        }
        return h1.val == h2.val && isMirror(h1.left, h2.right) && isMirror(h1.right, h2.left);
    }
}
