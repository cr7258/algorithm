package mashibing.class06;

import java.util.HashMap;

/**
 * @author 程治玮
 * @since 2021/1/19 11:35 下午
 * <p>
 * 根据两个数组，先序遍历和中序遍历，返回这颗树的头节点
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * 返回：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 时间复杂度O(N)，一共有N个节点，g调了n次，每次执行g里的代码都是O(1)
 * 测试代码：https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class Code05_ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // 有一棵树，先序结果是pre[L1...R1]，中序结果是in[L2...R2]
    public static TreeNode buildTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }

        //保存中序遍历的索引和值
        HashMap<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            valueIndexMap.put(in[i], i);
        }
        return g(pre, 0, pre.length - 1, in, 0, in.length - 1, valueIndexMap);
    }

    //传入
    public static TreeNode g(int[] pre, int L1, int R1, int[] in, int L2, int R2, HashMap<Integer, Integer> valueIndexMap) {
        //当左树或者右树不存在时
        if (L1 > R1) {
            return null;
        }


        TreeNode head = new TreeNode(pre[L1]);
        //当只有一个节点时
        if (L1 == R1) {
            return head;
        }

        //先序遍历的L1 和 中序中相等的值的索引为find，例如下面find为3
        // 1 2 4 5 4 6 7
        // 4 2 5 1 6 3 7
        int find = valueIndexMap.get(pre[L1]);

        //左树
        head.left = g(pre, L1 + 1, find - L2 + L1, in, L2, find - 1, valueIndexMap);
        //右树
        head.right = g(pre, find - L2 + L1 + 1, R1, in, find + 1, R2, valueIndexMap);
        return head;

    }
}
