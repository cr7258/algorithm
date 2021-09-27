package leetcode.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author chengzw
 * @description N 叉树的层序遍历，https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 * <p>
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[[1],[3,2,4],[5,6]]
 * @since 2021/9/26
 */
public class levelOrderXNode {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int curLevelNum = queue.size();
            //保存本层的结果
            List<Integer> curLevelResult = new ArrayList<>();
            for (int i = 0; i < curLevelNum; i++) {
                Node node = queue.poll();
                curLevelResult.add(node.val);
                int childSize = node.children.size();
                //将该节点的子节点入队
                for (int j = 0; j < childSize; j++) {
                    queue.add(node.children.get(j));
                }
            }
            result.add(curLevelResult);
        }
        return result;
    }
}
