package binary_tree

/**
 * @description 429. N 叉树的层序遍历
 * @author chengzw
 * @since 2022/6/12
 * @link https://leetcode.cn/problems/n-ary-tree-level-order-traversal/
 */

/**
定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。

示例 1：
输入：root = [1,null,3,2,4,null,5,6]
输出：[[1],[3,2,4],[5,6]]

示例 2：
输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
*/

/**
思路：
1.BFS 算法，通过一个 while 循环控制从上向下一层层遍历，for 循环控制每一层从左向右遍历
2.使用队列，在处理的时候用 size 记录要处理的个数，也就是这层的节点数，由一个一个处理转换成一层一层处理
3.将子节点添加到队列中，下一次层序遍历时使用

时间复杂度：O(n)，其中n 是树中包含的节点个数。在广度优先搜索的过程中，我们需要遍历每一个节点恰好一次。
空间复杂度：O(n)，即为队列需要使用的空间。在最坏的情况下，树只有两层，且最后一层有 n−1 个节点，此时就需要 O(n) 的空间。
*/
func levelOrder4(root *Node) [][]int {
	// 记录最终结果
	var ans [][]int
	// 特殊情况
	if root == nil {
		return ans
	}
	// 队列记录每层的结果
	var queue []*Node
	// 先将头节点加入队列
	queue = append(queue, root)

	// 外层循环从上往下按层遍历
	for len(queue) != 0 {
		// 每层结果
		var levelAns []int
		// 当前层节点数
		curLevelNum := len(queue)

		// 内层循环遍历每层节点
		for i := 0; i < curLevelNum; i++ {
			node := queue[0]
			queue = queue[1:]
			levelAns = append(levelAns, node.Val)
			// 将子节点添加到队列中，下一次层序遍历时使用
			if len(node.Children) != 0 {
				for _, child := range node.Children {
					queue = append(queue, child)
				}
			}
		}
		ans = append(ans, levelAns)
	}
	return ans
}
