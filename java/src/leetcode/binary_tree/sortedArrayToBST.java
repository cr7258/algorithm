package leetcode.binary_tree;

/**
 * @description 108. 将有序数组转换为二叉搜索树
 * @author chengzw
 * @link https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/
 * <p>
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * <p>
 * 二分搜索树（英语：Binary Search Tree），也称为 二叉查找树 、二叉搜索树 、有序二叉树或排序二叉树。满足以下几个条件：
 * 若它的左子树不为空，左子树上所有节点的值都小于它的根节点。
 * 若它的右子树不为空，右子树上所有的节点的值都大于它的根节点。
 * @since 2022/5/25
 * <p>
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * <p>
 * 二分搜索树（英语：Binary Search Tree），也称为 二叉查找树 、二叉搜索树 、有序二叉树或排序二叉树。满足以下几个条件：
 * 若它的左子树不为空，左子树上所有节点的值都小于它的根节点。
 * 若它的右子树不为空，右子树上所有的节点的值都大于它的根节点。
 * <p>
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * <p>
 * 二分搜索树（英语：Binary Search Tree），也称为 二叉查找树 、二叉搜索树 、有序二叉树或排序二叉树。满足以下几个条件：
 * 若它的左子树不为空，左子树上所有节点的值都小于它的根节点。
 * 若它的右子树不为空，右子树上所有的节点的值都大于它的根节点。
 */

/**
 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。

 二分搜索树（英语：Binary Search Tree），也称为 二叉查找树 、二叉搜索树 、有序二叉树或排序二叉树。满足以下几个条件：
 若它的左子树不为空，左子树上所有节点的值都小于它的根节点。
 若它的右子树不为空，右子树上所有的节点的值都大于它的根节点。
 */

/**
 * 思路：
 * 1.中序遍历，总是选择中间位置左边的数字作为根节点
 *
 * 时间复杂度：O(n)，其中 n 是数组的长度，每个数字只访问一次
 * 空间复杂度：O(logn)，其中 n 是数组的长度，空间复杂度不考虑返回值，因此空间复杂度主要取决于递归栈的深度，递归栈深度是 O(logn)
 */
public class sortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
}
