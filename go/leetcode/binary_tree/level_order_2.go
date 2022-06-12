package binary_tree

/**
 * @description 102. 二叉树的层序遍历
 * @author chengzw
 * @since 2022/6/11
 * @link https://leetcode.cn/problems/binary-tree-level-order-traversal/
 */

/**
给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。

示例 1：
输入：root = [3,9,20,null,null,15,7]
输出：[[3],[9,20],[15,7]]

示例 2：
输入：root = [1]
输出：[[1]]

示例 3：
输入：root = []
输出：[]
*/

/**
思路：
1.BFS 算法，通过一个 while 循环控制从上向下一层层遍历，for 循环控制每一层从左向右遍历
2.使用队列，在处理的时候用 size 记录要处理的个数，也就是这层的节点数，由一个一个处理转换成一层一层处理

时间复杂度：每个点进队出队各一次，故渐进时间复杂度为 O(n)。
空间复杂度：队列中元素的个数不超过 n 个，故渐进空间复杂度为 O(n)。
*/
func levelOrderMedium(root *TreeNode) [][]int {
	// 存放最后的结果
	var ans [][]int
	// 特殊情况
	if root == nil {
		return ans
	}
	// 队列存放每层节点
	var queue []*TreeNode
	// 先将根节点加入队列
	queue = append(queue, root)
	// 外层循环控制从上向下一层层遍历
	for len(queue) != 0 {
		// 存放每层结果
		var levelAns []int
		// 该层的节点数
		curLevelNum := len(queue)
		// 内层循环控制每一层从左向右遍历
		for i := 0; i < curLevelNum; i++ {
			node := queue[0]
			levelAns = append(levelAns, node.Val)
			queue = queue[1:]
			// 将该层的子节点加入队列，在下一次层序遍历时使用
			if node.Left != nil {
				queue = append(queue, node.Left)
			}
			if node.Right != nil {
				queue = append(queue, node.Right)
			}
		}
		ans = append(ans, levelAns)
	}
	return ans
}
