package leetcode.binary_tree;

/**
 * @author chengzw
 * @description 剑指 Offer 36. 二叉搜索树与双向链表
 * @link https://leetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 * @since 2022/6/16
 */

/**
 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
 */

/**
 思路：中序遍历，遍历到的节点放到结果链表中

 时间复杂度：O(n)
 空间复杂度：O(n)
 */
public class TreeToDoublyList {
    // 虚拟头节点
    Node2 newNode = new Node2();
    Node2 tail = newNode;

    public Node2 treeToDoublyList(Node2 root) {
        if(root == null) return null;
        inorder(root);
        // 连接头尾两个节点
        tail.right = newNode.right;
        newNode.right.left= tail;
        return newNode.right;
    }

    public void inorder(Node2 root){
        if(root == null) return;

        inorder(root.left);

        // 把遍历到的节点放到结果链表中
        tail.right = root;
        root.left = tail;
        tail = root;

        inorder(root.right);
    }
}
