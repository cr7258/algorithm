package leetcode.binary_tree;

import java.util.*;

/**
 * @author chengzw
 * @description 从上到下打印二叉树 III，https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 * <p>
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * 例如:
 * 给定二叉树:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * <p>
 * 返回其层次遍历结果：
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * @since 2021/9/27
 */
public class levelOrder3 {

    /**
     * 思路1：使用两个栈
     *
     * @param root
     * @return
     */
    public List<List<Integer>> solution1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        //使用两个栈来互相倒腾
        Stack<TreeNode>[] stacks = new Stack[2];
        for (int i = 0; i < 2; i++) {
            stacks[i] = new Stack<TreeNode>();
        }
        //轮次
        int turn = 0;
        stacks[turn].add(root);

        //终止条件，两个栈都空了
        while (!stacks[turn].isEmpty()) {
            //记录本层节点
            List<Integer> curLevelResult = new ArrayList<>();
            //遍历本轮的栈
            while (!stacks[turn].isEmpty()) {
                TreeNode node = stacks[turn].pop();
                curLevelResult.add(node.val);
                //左边的栈，按先左后右的顺序放子节点
                if (turn == 0) {
                    if (node.left != null) {
                        stacks[1].push(node.left);
                    }
                    if (node.right != null) {
                        stacks[1].push(node.right);
                    }
                }
                //右边的栈，按照先右后左的顺序放子节点
                else {
                    if (node.right != null) {
                        stacks[0].push(node.right);
                    }
                    if (node.left != null) {
                        stacks[0].push(node.left);
                    }
                }
            }
            //修改轮次，下一次遍历另一个栈
            turn = (turn + 1) % 2;
            result.add(curLevelResult);
        }
        return result;
    }


    /**
     * 思路2：正常层序遍历，在将每层的结果 curLevelResult 放入 result 时，判断一下：如果是 turn 是 1，翻转一下 curLevelResult 再存入 result
     *
     * @param root
     * @return
     */
    public List<List<Integer>> solution2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int turn = 0;
        while (!queue.isEmpty()) {
            List<Integer> curLevelResult = new ArrayList<>();
            int size = queue.size();
            //层序遍历
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                curLevelResult.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            //翻转列表
            if (turn == 1) {
                Collections.reverse(curLevelResult);
            }
            result.add(curLevelResult);
            turn = (turn + 1) % 2;
        }
        return result;
    }
}
