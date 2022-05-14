package leetcode.linkedlist;

/**
 * @author chengzw
 * @description 移除链表元素，https://leetcode-cn.com/problems/remove-linked-list-elements/
 *
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *
 * @since 2021/8/25
 */
public class RemoveElements {

    /**
     * 思路1：从原链表头部开始，遇到值等于val的节点就跳过
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode solution1(ListNode head, int val) {
        //如果头节点为空
        if (head == null) return null;

        //遍历链表
        ListNode prev = head;
        while (prev.next != null) {
            //如果等于 val 跳过
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }

        //如果头节点的值等于 val，跳过
        if (head.val == val) {
            head = head.next;
        }

        return head;
    }

    /**
     * 思路：使用新链表，遇到值不等于val的节点就将该节点添加到新链表中
     * @param head
     * @param val
     * @return
     */
    public ListNode solution2(ListNode head, int val) {

        //新的链表添加不等于 val 的元素，新链表头节点
        ListNode newNode = new ListNode();
        //新链表移动指针
        ListNode tail = newNode;

        //遍历原链表
        ListNode p = head;
        while (p != null) {
            ListNode tmp = p.next;
            if (p.val != val) {
                //原链表去掉节点
                p.next = null;
                //新链表添加节点
                tail.next = p;
                tail = p;
            }
            p = tmp;
        }
        return newNode.next;
    }

}
