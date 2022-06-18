package leetcode.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

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
public class Connect {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            // 虚拟头节点
            Node tail =  new Node();
            for(int i=0; i < levelNum; i++){
                Node node = queue.poll();
                tail.next = node;
                tail = node;
                // 将子节点加入队列中，下一次层序遍历时使用
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};