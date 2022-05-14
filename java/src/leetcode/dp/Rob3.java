package leetcode.dp;

/**
 * @author chengzw
 * @description 打家劫舍 III（树形 dp）
 * <p>
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。
 * 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 输出: 7
 * 解释:小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 *
 * @since 2021/10/25
 */

/**
 * 思路：
 * 1.从下往上推，子节点推导父节点的状态，基于后序遍历来实现。
 * 2.int money[2] 表示每个节点的状态，money[0] 表示选择不偷此节点，当下最大金额；money[1] 表示选择偷此节点，当下的最大金额。
 * 3.状态转移方程：
 * root.money[0] = Math.max(left.money[0],left.money[1]) + Math.max(right.money[0] + right.money[1])
 * root.money[1] = left.money[0] + right.money[0] + root.val
 *
 */
public class Rob3 {
    public int rob(TreeNode root) {
        int[] money = postOrder(root);
        return Math.max(money[0], money[1]);
    }

    public int[] postOrder(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        // 后序遍历
        int[] leftMoney = postOrder(node.left);
        int[] rightMoney = postOrder(node.right);

        int[] money = new int[2];
        // 不偷
        money[0] = Math.max(leftMoney[0], leftMoney[1]) + Math.max(rightMoney[0], rightMoney[1]);
        // 偷
        money[1] = leftMoney[0] + rightMoney[0] + node.val;
        return money;
    }
}
