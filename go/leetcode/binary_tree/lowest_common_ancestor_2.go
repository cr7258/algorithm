package binary_tree

/**
 * @author chengzw
 * @description 235. 二叉搜索树的最近公共祖先
 * @link https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * @since 2022/6/12
 */

/**
给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5]

示例 1:
输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
输出: 6
解释: 节点 2 和节点 8 的最近公共祖先是 6。

示例 2:
输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
输出: 2
解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
*/

/**
  思路： 递归实现
  如果在 BST 中寻找最近公共祖先，反而容易很多，主要利用 BST 左小右大（左子树所有节点都比当前节点小，右子树所有节点都比当前节点大）的特点即可。
  1.如果 p 和 q 都比当前节点小，那么显然 p 和 q 都在左子树，那么 LCA 在左子树。
  2.如果 p 和 q 都比当前节点大，那么显然 p 和 q 都在右子树，那么 LCA 在右子树。
  3.一旦发现 p 和 q 在当前节点的两侧，说明当前节点就是 LCA。

  时间复杂度：O(n)
  空间复杂度：O(n)
*/
func lowestCommonAncestor2(root, p, q *TreeNode) *TreeNode {
	if p == root || q == root ||
		p.Val > root.Val && q.Val < root.Val ||
		p.Val < root.Val && q.Val > root.Val {
		return root
	}
	if p.Val < root.Val {
		return lowestCommonAncestor(root.Left, p, q)
	} else {
		return lowestCommonAncestor(root.Right, p, q)
	}
}
