package leetcode.sort;

/**
 * @author chengzw
 * @description 对链表进行插入排序，https://leetcode-cn.com/problems/insertion-sort-list/
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * @since 2021/9/12
 */

/**
 * 思路：使用一个链表存储已经排序好的节点，p 指针遍历原链表，q 指针每次从新链表的头开始遍历，当 q.next.val <= p.val 在新链表中插入 p 节点
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        //存储已经排好序的节点
        ListNode newHead = new ListNode();
        ListNode p = head;
        while (p != null) {
            ListNode tmp = p.next;
            //寻找 p 节点插入的位置
            //初始化 q 位置，每次从虚拟节点头开始找
            ListNode q = newHead;
            while (q.next != null && q.next.val <= p.val) {
                q = q.next;
            }

            //插入 p 元素
            p.next = q.next;
            q.next = p;
            p = tmp;
        }
        return newHead.next;
    }
}
