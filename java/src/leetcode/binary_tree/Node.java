package leetcode.binary_tree;

import java.util.List;

/**
 * @author chengzw
 * @description N 叉树结构
 * @since 2021/9/21
 */


class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
