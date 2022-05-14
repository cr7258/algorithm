package leetcode.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengzw
 * @description N 叉树的后序遍历，https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 * @since 2021/9/21
 */
public class Postorder {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        postorderR(root);
        return result;
    }

    public void postorderR(Node root) {
        if (root == null) return;
        for (int i = 0; i < root.children.size(); i++) {
            postorderR(root.children.get(i));
        }
        result.add(root.val);
    }
}
