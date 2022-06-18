package binary_tree

/**
 * @author chengzw
 * @description 116. 填充每个节点的下一个右侧节点指针
 * @link https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/
 * @since 2022/6/18
 */

/**
给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：

struct Node {
int val;
Node *left;
Node *right;
Node *next;
}

填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
初始状态下，所有 next 指针都被设置为 NULL。
*/

/**
思路：层序遍历，在层次遍历的过程中连接每个节点

时间复杂度：O(n)。每个节点会被访问一次且只会被访问一次，即从队列中弹出，并建立 next 指针。
空间复杂度：O(n)。这是一棵完美二叉树，它的最后一个层级包含 n/2 个节点。广度优先遍历的复杂度取决于一个层级上的最大元素数量。这种情况下空间复杂度为 O(n)。
*/

type Node struct {
	Val   int
	Left  *Node
	Right *Node
	Next  *Node
}

func connect(root *Node) *Node {
	if root == nil {
		return nil
	}

	var queue []*Node
	queue = append(queue, root)

	for len(queue) != 0 {
		levelNum := len(queue)
		// 虚拟头节点
		tail := new(Node)
		for i := 0; i < levelNum; i++ {
			node := queue[0]
			queue = queue[1:]
			tail.Next = node
			tail = node

			// 将子节点添加到队列中，下一轮层序遍历使用
			if node.Left != nil {
				queue = append(queue, node.Left)
			}
			if node.Right != nil {
				queue = append(queue, node.Right)
			}
		}
	}
	return root
}
