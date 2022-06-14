package binary_tree

/**
 * @description 面试题 04.06. 后继者
 * @author chengzw
 * @since 2022/6/15
 * @link https://leetcode.cn/problems/successor-lcci/
 */

/**
设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
如果指定节点没有对应的“下一个”节点，则返回null。

示例 1:
输入: root = [2,1,3], p = 1

  2
 / \
1   3

输出: 2

示例 2:
输入: root = [5,3,6,2,4,null,null,1], p = 6

      5
     / \
    3   6
   / \
  2   4
 /
1

输出: null
*/

/**
思路：中序遍历，使用 comming 记录下一个节点是否是中序后继

时间复杂度：O(n)，其中 n 是二叉搜索树的节点数。中序遍历最多需要访问二叉搜索树中的每个节点一次。
空间复杂度：O(n)，其中 n 是二叉搜索树的节点数。空间复杂度取决于栈深度，平均情况是O(logn)，最坏情况是 O(n)。
*/

// 判断下一个节点是否是后继
var coming bool

// 后继节点
var successor *TreeNode

func inorderSuccessor(root *TreeNode, p *TreeNode) *TreeNode {
	// 初始化全局变量
	coming = false
	successor = nil

	inorder(root, p)
	return successor
}

func inorder(root *TreeNode, p *TreeNode) {
	if root == nil {
		return
	}
	inorder(root.Left, p)
	// 已经找到后继，提前结束
	if successor != nil {
		return
	}
	// 该节点是后继，上一个节点是 p
	if coming {
		successor = root
	}

	if root == p {
		coming = true
	}

	inorder(root.Right, p)
}
