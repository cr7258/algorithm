package binary_tree

/**
 * @description 剑指 Offer 32 - I. 从上到下打印二叉树
 * @author chengzw
 * @since 2022/6/11
 * @link https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 */

/**
从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

返回：
[3,9,20,15,7]
*/

/**
思路：二叉树的层序遍历使用队列
把元素加入队列，出队的时候，记录节点的值，然后把该节点的子节点入队

时间复杂度 O(n) ： n 为二叉树的节点数量，即 BFS 需循环 n 次。
空间复杂度 O(n) ： 最差情况下，即当树为平衡二叉树时，最多有 n/2 个树节点同时在 queue 中，使用 O(n) 大小的额外空间。
*/
func levelOrder(root *TreeNode) []int {
	if root == nil {
		return []int{}
	}
	var ans []int
	var queue []*TreeNode
	// 先把根节点加入队列
	queue = append(queue, root)
	for len(queue) != 0 {
		node := queue[0]
		queue = queue[1:]
		ans = append(ans, node.Val)
		// 把左右子节点加入队列
		if node.Left != nil {
			queue = append(queue, node.Left)
		}
		if node.Right != nil {
			queue = append(queue, node.Right)
		}
	}
	return ans
}
