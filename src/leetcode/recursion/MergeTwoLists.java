package leetcode.recursion;

/**
 * @author chengzw
 * @description 合并两个排序的链表，https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 *
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @since 2021/9/11
 */

/**
 * 思路1：递归解法，合并子链表
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val < l2.val){
            ListNode subNode =  mergeTwoLists(l1.next,l2);
            l1.next = subNode;
            return l1;
        }else{
            ListNode subNode = mergeTwoLists(l1,l2.next);
            l2.next = subNode;
            return l2;
        }
    }
}
