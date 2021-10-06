package leetcode.binary_tree;

/**
 * @author chengzw
 * @description 验证二叉搜索树，https://leetcode-cn.com/problems/validate-binary-search-tree/
 * <p>
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效二叉搜索树定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * @since 2021/10/6
 */

/**
 * 思路：
 * 1.返回值并非要求解的值
 * 2.要求解的值放在全局变量中 isValid
 * 3.使用递归，如果左子树的最大值大于等于当前节点或者右子树的最小值小于等于当前节点，修改 isValid 为 false，然后提前归
 */
public class IsValidBST {
    //全局变量
    public boolean isValid = true;

    public boolean isValidBST(TreeNode root) {
        //特殊情况
        if (root == null) return true;
        dfs(root);
        return isValid;
    }

    public int[] dfs(TreeNode root) {
        int min = root.val;
        int max = root.val;

        if (root.left != null) {
            int[] leftMinMax = dfs(root.left);
            //提前返回
            if (isValid == false) return null;
            //如果左子树的最大值大于等于当前节点的值
            if (leftMinMax[1] >= root.val) {
                isValid = false;
                return null;
            }
            min = leftMinMax[0];
        }


        if (root.right != null) {
            int[] rightMinMax = dfs(root.right);
            //提前返回
            if (isValid == false) return null;
            //如果右子树的最小值小于等于当前节点的值
            if (rightMinMax[0] <= root.val) {
                isValid = false;
                return null;
            }
            max = rightMinMax[1];
        }
        return new int[]{min, max};
    }
}
