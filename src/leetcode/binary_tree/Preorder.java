package leetcode.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengzw
 * @description N 叉树的前序遍历，https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 * @since 2021/9/21
 */
public class Preorder {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        preorderR(root);
        return result;
    }

    public void preorderR(Node root) {
        if (root == null) return;
        result.add(root.val);
        for (int i = 0; i < root.children.size(); i++) {
            preorderR(root.children.get(i));
        }
    }
}
