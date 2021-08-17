package mashibing.class06;

/**
 * @author 程治玮
 * @since 2021/1/19 10:05 下午
 * <p>
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 测试链接：https://leetcode.com/problems/same-tree
 */
public class Code02_SameTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        //如果一个为空，一个不为空 (相同结果异或为false，不同结果异或为true)
        if (p == null ^ q == null) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        //节点值相等，并且左树和右树递归也满足
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
