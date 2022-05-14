package leetcode.linkedlist;

/**
 * @author chengzw
 * @description 合并两个排序的链表，https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 * <p>
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * @since 2021/8/26
 */
public class MergeTwoLists {

    /**
     * 思路：用一个新的链表添加元素
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode solution1(ListNode l1, ListNode l2) {
        //创建一个新的链表来合并
        ListNode newNode = new ListNode();
        ListNode tail = newNode;

        //两个指针分别遍历两个链表
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                //新链表添加元素
                tail.next = l1;
                tail = l1;
                //原链表后移
                l1 = l1.next;
            } else {
                tail.next = l2;
                tail = l2;
                l2 = l2.next;
            }
        }
        //剩余的链表全部接到原链表后
        if (l1 == null) {
            tail.next = l2;
        } else {
            tail.next = l1;
        }
        return newNode.next;
    }
}
