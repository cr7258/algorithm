package leetcode.binary_tree;

/**
 * @author chengzw
 * @description 面试题 04.03. 特定深度节点链表
 * @link https://leetcode.cn/problems/list-of-depth-lcci/
 * @since 2022/6/16
 */

/**
 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。

 示例：
 输入：[1,2,3,4,5,null,7,8]

 1
 /  \
 2    3
 / \    \
 4   5    7
 /
 8
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 思路：层序遍历，每层创建一个链表

 时间复杂度：O(n)
 空间复杂度：O(n)
 */
public class ListOfDepth {
    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        // 先把根节点加入队列
        queue.add(tree);
        while(!queue.isEmpty()){
            // 将每层的节点加入链表
            ListNode levelAns = new ListNode();
            ListNode tail = levelAns;
            int size = queue.size();
            for(int i=0; i < size;i++){
                TreeNode node = queue.poll();
                ListNode newNode = new ListNode(node.val);
                tail.next = newNode;
                tail = newNode;
                // 把子节点加入队列，准备下一轮层序遍历
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            ans.add(levelAns.next);
        }

        // 把 List 转换为数组
        ListNode[] result = new ListNode[ans.size()];
        for(int i=0; i < ans.size();i++){
            result[i] = ans.get(i);
        }
        return result;
    }
}
