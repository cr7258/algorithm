package leetcode.binary_tree;

/**
 * @author chengzw
 * @description 从上到下打印二叉树，https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 *
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * 例如，给定二叉树:
 *   3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回：
 * [3,9,20,15,7]
 *
 * @since 2021/9/21
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 思路：用队列
 * 把元素加入队列，出队的时候，记录节点的值，然后把该节点的子节点入队
 */
public class LevelOrder {
    public int[] levelOrder(TreeNode root) {
        //特殊情况
        if(root == null) return new int[0];
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            result.add(node.val);
            if(node.left != null){
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        int[] resultArray = new int[result.size()];
        for(int i = 0;i< result.size();i++){
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }
}

