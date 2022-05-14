package leetcode.binary_tree;

/**
 * @author chengzw
 * @description 二叉搜索树的第k大节点，https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 * <p>
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 *
 * @since 2021/10/6
 */

/**
 * 思路：借助⼆叉查找树中序遍历结果为有序序列的特点来解题
 * 1. 左-根-右 从⼩到⼤排列
 * 2. 右-根-左 从⼤到⼩排列
 * 这道题求第 k 大是从大到小排序
 */
public class KthLargest {
    //全局变量，result 保存最终的结果
    int result;
    //记录遍历到第几个节点了
    int count = 0;

    public int kthLargest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    public void inorder(TreeNode root, int k) {
        if (root == null) return;

        //按照右-根-左的顺序层序遍历，取第 k 个值
        inorder(root.right, k);
        //增加计数，只在遍历右节点的时候计数
        count++;

        //提前返回，剪枝
        if (count > k) return;

        //当遍历到第 k 个值时，记录下 result，后面提前返回，剪枝
        if (count == k) {
            result = root.val;
            return;
        }

        inorder(root.left, k);
    }
}
