package binary_tree

/**
 * @description 513. 找树左下角的值
 * @author chengzw
 * @since 2022/6/12
 * @link https://leetcode.cn/problems/find-bottom-left-tree-value/
 */

/**
给定一个二叉树的 根节点 root，请找出该二叉树的最底层最左边节点的值。
假设二叉树中至少有一个节点。

示例 1:
输入: root = [2,1,3]
输出: 1

示例 2:
输入: [1,2,3,4,null,5,6,null,null,7]
输出: 7
*/

/**
思路：
从右往左按层遍历，使用 ans 记录节点的 Val 值，最后的 Val 就是左下角节点的值

时间复杂度：O(n)
空间复杂度：O(n)
*/
func findBottomLeftValue(root *TreeNode) int {
	// 存放结果
	ans := 0
	// 存放每一层的节点
	var queue []*TreeNode
	// 将根节点添加到队列中
	queue = append(queue, root)
	// 外层循环控制从上往下按层遍历
	for len(queue) != 0 {
		curLevelNum := len(queue)
		// 内层循环遍历每层的节点
		for i := 0; i < curLevelNum; i++ {
			node := queue[0]
			queue = queue[1:]
			ans = node.Val
			// 从右往左按层遍历
			if node.Right != nil {
				queue = append(queue, node.Right)
			}
			if node.Left != nil {
				queue = append(queue, node.Left)
			}
		}
	}
	// 返回最后一个值
	return ans
}
