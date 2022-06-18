package leetcode.binary_tree;

/**
 * @author chengzw
 * @description 剑指 Offer 34. 二叉树中和为某一值的路径
 * @link https://leetcode.cn/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 * @since 2022/6/18
 */

/**
 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 叶子节点 是指没有子节点的节点。

 示例 1：
 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 输出：[[5,4,11,2],[5,8,4,5]]

 示例 2：
 输入：root = [1,2,3], targetSum = 5
 输出：[]

 示例 3：
 输入：root = [1,2], targetSum = 0
 输出：[]
 */

import java.util.ArrayList;
import java.util.List;

/**
 思路：深度优先搜索
 枚举每一条从根节点到叶子节点的路径。当我们遍历到叶子节点，且此时路径和恰为目标和时，我们就找到了一条满足条件的路径。

 时间复杂度：O(n^2)，其中 n 是树的节点数。在最坏情况下，树的上半部分为链状，下半部分为完全二叉树，并且从根节点到每一个叶子节点的路径都符合题目要求。
 此时，路径的数目为 O(n)，并且每一条路径的节点个数也为 O(n)，因此要将这些路径全部添加进答案中，时间复杂度为 O(n^2)。
 空间复杂度：O(n)，其中 n 是树的节点数。空间复杂度主要取决于栈空间的开销，栈中的元素个数不会超过树的节点数。
 */
public class PathSum {
    public List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return ans;
    }

    public void dfs(TreeNode root, int target){
        if(root == null) return;

        path.add(root.val);
        target -= root.val;
        // 如果是叶子节点并且累加值等于 target，将 path 加入结果
        if(root.left == null && root.right == null && target == 0) {
            ans.add(new ArrayList<>(path));
        }
        // 递归左右子树
        dfs(root.left, target);
        dfs(root.right, target);

        // 撤销选择
        path.remove(path.size()-1);
    }
}
