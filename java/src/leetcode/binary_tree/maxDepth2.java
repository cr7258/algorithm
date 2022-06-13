package leetcode.binary_tree;

/**
 * @author chengzw
 * @description N 叉树的最大深度
 * @since 2021/9/27
 */

/**
 * 和求二叉树的最大深度类似，化简问题求子树的最大深度 + 1
 */
public class maxDepth2 {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int childrenMaxDepth = 0;
        for (int i = 0; i < root.children.size(); i++) {
            int depth = maxDepth(root.children.get(i));
            if (depth > childrenMaxDepth) {
                childrenMaxDepth = depth;
            }
        }
        return childrenMaxDepth + 1;
    }
}
