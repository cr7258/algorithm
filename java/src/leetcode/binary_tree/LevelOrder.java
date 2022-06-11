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
 思路：二叉树的层序遍历使用队列
 把元素加入队列，出队的时候，记录节点的值，然后把该节点的子节点入队

 时间复杂度 O(n) ： n 为二叉树的节点数量，即 BFS 需循环 n 次。
 空间复杂度 O(n) ： 最差情况下，即当树为平衡二叉树时，最多有 n/2 个树节点同时在 queue 中，使用 O(n) 大小的额外空间。
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

