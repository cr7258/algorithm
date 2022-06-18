package binary_tree

/**
 * @author chengzw
 * @description 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * @link https://leetcode.cn/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 * @since 2022/6/18
 */

/**
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。

参考以下这颗二叉搜索树：
5
/ \
2   6
/ \
1   3

示例 1：
输入: [1,6,3,2,5]
输出: false

示例 2：
输入: [1,3,2,6,5]
输出: true
*/

/**
思路：
1.寻找第一个大于根节点的节点，索引记为 m，可划分出左子树区间 [i,m−1] 、右子树区间 [m,j−1] 、根节点索引 j。
2.判断左右子树是否符合要求。

参考题解：https://leetcode.cn/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/mian-shi-ti-33-er-cha-sou-suo-shu-de-hou-xu-bian-6/

时间复杂度 O(n^2)： verify(i,j) 减去一个根节点，因此递归占用 O(n) ；最差情况下（即当树退化为链表）。每轮递归都需遍历树所有节点，占用 O(n) 。
空间复杂度 O(n) ： 最差情况下（即当树退化为链表），递归深度将达到 n。
*/
func verifyPostorder(postorder []int) bool {
	return verify(postorder, 0, len(postorder)-1)
}

func verify(postorder []int, i int, j int) bool {
	if i >= j {
		return true
	}

	// 寻找第一个大于根节点的节点，索引记为 m
	// 可划分出左子树区间 [i,m−1] 、右子树区间 [m,j−1] 、根节点索引 j
	p := i
	for postorder[p] < postorder[j] {
		p++
	}

	// 右子树区间的所有节点都应当大于 postorder[j]
	m := p
	for postorder[p] > postorder[j] {
		p++
	}

	// 判断此树是否正确。
	// 判断此树的左子树是否正确。
	// 判断此树的右子树是否正确。
	return p == j && verify(postorder, i, m-1) && verify(postorder, m, j-1)
}
