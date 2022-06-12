package binary_tree

/**
 * @description 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * @author chengzw
 * @since 2022/6/12
 * @link https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 */

/**
请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：
[
  [3],
  [20,9],
  [15,7]
]
*/

/**
思路：
1.BFS 算法，通过一个 while 循环控制从上向下一层层遍历，for 循环控制每一层从左向右遍历
2.使用队列，在处理的时候用 size 记录要处理的个数，也就是这层的节点数，由一个一个处理转换成一层一层处理
3.当 turn 是奇数时，翻转 levelAns 后再加入 ans

时间复杂度：每个点进队出队各一次，故渐进时间复杂度为 O(n)。
空间复杂度：队列中元素的个数不超过 n 个，故渐进空间复杂度为 O(n)。
*/

func levelOrderHard(root *TreeNode) [][]int {
	// 存放最终结果
	var ans [][]int
	// 特殊情况
	if root == nil {
		return ans
	}
	// 队列存放每层结果
	var queue []*TreeNode
	// 先将根节点加入队列
	queue = append(queue, root)
	// 轮次，如果是 0，从左到右打印，如果是 1，翻转果 levelAns 后，再加入 ans
	turn := 0
	// 外层循环控制从上往下按层遍历
	for len(queue) != 0 {
		// 存放每层结果
		var levelAns []int
		curLevelNum := len(queue)
		// 内层循环控制每层从左往右遍历
		for i := 0; i < curLevelNum; i++ {
			node := queue[0]
			levelAns = append(levelAns, node.Val)
			queue = queue[1:]
			if node.Left != nil {
				queue = append(queue, node.Left)
			}
			if node.Right != nil {
				queue = append(queue, node.Right)
			}
		}
		// 如果是 turn 是 1，翻转 levelAns
		if turn == 1 {
			for i, j := 0, len(levelAns)-1; i < j; i++ {
				levelAns[i], levelAns[j] = levelAns[j], levelAns[i]
				j--
			}
		}
		turn = (turn + 1) % 2
		ans = append(ans, levelAns)
	}
	return ans
}
