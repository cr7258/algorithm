package leetcode.recursion;

/**
 * @description 剑指 Offer 25. 合并两个排序的链表
 * @author chengzw
 * @since 2022/6/8
 * @link https://leetcode.cn/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 */

/**
输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

示例1：
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
*/

/**
思路：
递归解法，合并子链表，两个链表头部值较小的一个节点与剩下元素的 merge 操作结果合并。

时间复杂度：O(n+m)，其中 n 和 m 分别为两个链表的长度。
空间复杂度：O(n+m)，其中 n 和 m 分别为两个链表的长度。
*/
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if(l1 == null) return l2;
            if(l2 == null) return l1;

            if(l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            }else {
                l2.next = mergeTwoLists(l1,l2.next);
                return l2;
            }
        }
}
